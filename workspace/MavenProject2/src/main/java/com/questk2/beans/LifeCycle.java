package com.questk2.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Service;

	@Service
	public class LifeCycle {

	    public void BeanLifeCycle() {
	        System.out.println("️MyServiceImpl Bean is created.");
	    }

	    @PostConstruct
	    public void init() {
	        System.out.println("MyServiceImpl Bean is initialized (PostConstruct).");
	    }

	    
	    public void serve() {
	        System.out.println("MyServiceImpl is serving...");
	    }

	    @PreDestroy
	    public void destroy() {
	        System.out.println("MyServiceImpl Bean is being destroyed (PreDestroy).");
	    }
	}


