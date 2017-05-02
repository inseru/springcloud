package com.qjs.boot.task.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScheduledJob implements Job {
	private final Logger logger = LoggerFactory.getLogger(ScheduledJob.class);

	public ScheduledJob() {
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		JobDataMap dataMap = arg0.getJobDetail().getJobDataMap();
		System.out.println(dataMap.getString("url"));
	}
}
