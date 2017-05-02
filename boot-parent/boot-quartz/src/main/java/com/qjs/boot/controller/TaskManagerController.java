package com.qjs.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qjs.boot.config.ServiceException;
import com.qjs.boot.dto.ResultInfo;
import com.qjs.boot.dto.TaskInfo;
import com.qjs.boot.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskManagerController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TaskService taskService;

	/**
	 * Index.jsp 2016年10月8日下午6:39:15
	 */
	@RequestMapping("/index")
	public String info() {
		return "task.html";
	}

	/**
	 * 任务列表
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public Map<String, Object> list() {
		logger.info("listJob");
		Map<String, Object> map = new HashMap<>();
		List<TaskInfo> infos = taskService.list();
		map.put("page", infos);
		map.put("total", infos.size());
		return map;
	}

	/**
	 * 保存定时任务
	 * 
	 */
	// , produces = "application/json; charset=UTF-8"

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public ResultInfo save(@RequestBody TaskInfo info) {
		logger.info("saveJob");
		try {
			if (info.getId() == 0) {
				taskService.addJob(info);
			} else {
				taskService.edit(info);
			}
		} catch (ServiceException e) {
			return new ResultInfo<String>(-1, e.getMessage());
		}
		return new ResultInfo(1, null);
	}

	/**
	 * 删除定时任务
	 * 
	 * @param jobName
	 * @param jobGroup
	 *            2016年10月9日下午1:52:20
	 */
	@ResponseBody
	@RequestMapping(value = "delete")
	public ResultInfo delete(@RequestParam String jobName, @RequestParam String jobGroup) {
		try {
			taskService.delete(jobName, jobGroup);
		} catch (ServiceException e) {
			return new ResultInfo<String>(-1, e.getMessage());
		}
		return new ResultInfo(1, null);
	}

	/**
	 * 暂停定时任务
	 * 
	 * @param jobName
	 * @param jobGroup
	 *            2016年10月10日上午9:41:25
	 */
	@ResponseBody
	@RequestMapping(value = "pause")
	public ResultInfo pause(@RequestParam String jobName, @RequestParam String jobGroup) {
		try {
			taskService.pause(jobName, jobGroup);
		} catch (ServiceException e) {
			return new ResultInfo<String>(-1, e.getMessage());
		}
		return new ResultInfo(1, null);
	}

	/**
	 * 重新开始定时任务
	 * 
	 * @param jobName
	 * @param jobGroup
	 *            2016年10月10日上午9:41:40
	 */
	@ResponseBody
	@RequestMapping(value = "resume")
	public ResultInfo resume(@RequestParam String jobName, @RequestParam String jobGroup) {
		try {
			taskService.resume(jobName, jobGroup);
		} catch (ServiceException e) {
			return new ResultInfo<String>(-1, e.getMessage());
		}
		return new ResultInfo(1, null);
	}
}
