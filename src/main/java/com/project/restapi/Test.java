package com.project.restapi;

import com.project.restapi.entities.Note;
import com.project.restapi.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class Test {

	@Autowired
	NoteService ns;

	public void run() {
		Note temp = new Note();
		temp.setDetail("Bar");
		temp.setTitle("foo");

		temp = ns.saveNote(temp);
		System.out.print("Inside UI thread");

		ExecutorService es = Executors.newFixedThreadPool(3);

		Note finalTemp = temp;
		es.execute(() -> {
			Note get1 = ns.getNoteById(finalTemp.getId());
			get1.setTitle("changed by thread 1");

			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}

			try {
				ns.updateNote(get1, get1.getId());
			}
			catch (Exception e) {
				System.out.println(e);
			}
		});

		es.execute(() -> {
			System.out.print("Inside thread 2");

			Note get2 = ns.getNoteById(finalTemp.getId());
			get2.setTitle("Modified by thread 2");
			ns.updateNote(get2, get2.getId());
		});

		es.shutdown();
		try {
			es.awaitTermination(10, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
