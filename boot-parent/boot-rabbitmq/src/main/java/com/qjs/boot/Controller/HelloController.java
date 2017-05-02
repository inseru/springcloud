package com.qjs.boot.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qjs.boot.model.Actor;
import com.qjs.boot.model.City;
import com.qjs.boot.rmq.send.Sender;
import com.qjs.boot.service.HelloService;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private Sender sender;

	@Autowired
	private HelloService helloService;

	@RequestMapping(value = "/h1/{id}", method = RequestMethod.GET)
	public String hello(@PathVariable(value = "id") String id) throws InterruptedException {
		System.out.println("id" + id);
		long a = System.currentTimeMillis();
		Thread t = Thread.currentThread();
		t.sleep(3000);
		System.out.println(System.currentTimeMillis() - a);
		// sender.send(id);
		return id;
	}

	@RequestMapping(value = "/h2/{id}", method = RequestMethod.GET)
	public String hello2(@PathVariable(value = "id") String id) throws InterruptedException {
		System.out.println("id" + id);
		sender.send(id);
		return id;
	}

	@RequestMapping(value = "/h3/{id}", method = RequestMethod.GET)
	public City hello3(@PathVariable(value = "id") Integer id) {
		System.out.println("id" + id);
		if (id == 1) {
			return helloService.getCity((short) 1);
		} else if (id == 2) {
			City c = new City();
			c.setCity("A Corua (La Corua)");
			c.setCityId((short) 1);
			c.setCountryId((short) 87);
			c.setLastUpdate(new Date());
			return helloService.updateCityById(c);
		} else {
			helloService.deleteCityById((short) 1);
			return null;
		}

	}

	@RequestMapping(value = "/h4/{id}", method = RequestMethod.GET)
	public Actor hello4(@PathVariable(value = "id") Integer id) {
		System.out.println("id" + id);
		if (id == 1) {
			return helloService.getActor((short) 2);
		} else {
			helloService.deleteActor((short) 2);
			return null;
		}

	}
}
