package com.project.restapi;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.project.restapi.repository")
@Configuration
public class Config {}
