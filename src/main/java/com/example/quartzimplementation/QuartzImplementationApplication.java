package com.example.quartzimplementation;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuartzImplementationApplication {


	public static void main(String[] args) throws SchedulerException {
		SpringApplication.run(QuartzImplementationApplication.class, args);

		try {

			StdSchedulerFactory factory = new StdSchedulerFactory();
			Scheduler scheduler = factory.getScheduler();

			JobDetail jobDetail = JobBuilder.newJob()
					.ofType(JobExample.class)
					.withIdentity("example-job-101")
					.build();

			SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
					.withIdentity("example-job=101")
					.forJob(jobDetail)
					.withSchedule(SimpleScheduleBuilder
							.simpleSchedule()
							.withIntervalInSeconds(1)
							.withRepeatCount(5))
					.build();

			scheduler.scheduleJob(jobDetail, simpleTrigger);
			scheduler.start();
		} catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
}