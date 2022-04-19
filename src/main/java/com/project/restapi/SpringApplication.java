package com.project.restapi;

import com.project.restapi.entities.Note;
import com.project.restapi.repository.NotesRepository;
import com.project.restapi.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication // It enables auto config + ComponentScanning
public class SpringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
//		Test tt = context.getBean(Test.class);
//		tt.run();
	}
}
