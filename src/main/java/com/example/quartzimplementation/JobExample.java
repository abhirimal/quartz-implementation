package com.example.quartzimplementation;

import org.quartz.*;

public class JobExample implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Hello from the Moon!"+ jobExecutionContext.getRefireCount());
    }
}

