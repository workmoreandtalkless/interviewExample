package org.example.interview.interviewexample;

import org.springframework.boot.SpringApplication;

public class TestInterviewExampleApplication {

    public static void main(String[] args) {
        SpringApplication.from(InterviewExampleApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
