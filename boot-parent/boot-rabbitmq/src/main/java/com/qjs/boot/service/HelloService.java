package com.qjs.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qjs.boot.encache.CacheService;
import com.qjs.boot.model.Actor;
import com.qjs.boot.model.City;

@Service
public class HelloService {
	@Autowired
	private CacheService cacheService;

	public City getCity(Short id) {
		return cacheService.getCity(id);
	}

	public City updateCityById(City c) {
		return cacheService.updateCity(c);
	}

	public int deleteCityById(Short id) {
		return cacheService.deleteActivityInfo(id);
	}

	public Actor getActor(Short id) {
		return cacheService.getActor(id);
	}

	public int deleteActor(Short id) {
		return cacheService.deleteActor(id);
	}
}
