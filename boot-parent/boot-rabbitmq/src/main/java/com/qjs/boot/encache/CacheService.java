package com.qjs.boot.encache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.qjs.boot.dao.ActorMapper;
import com.qjs.boot.dao.CityMapper;
import com.qjs.boot.model.Actor;
import com.qjs.boot.model.City;

@Component
public class CacheService {

	@Autowired
	private CityMapper cityMapper;
	@Autowired
	private ActorMapper actorMapper;

	// unless为true时，不执行缓存策略
	@Cacheable(value = "oneCity", key = "#id", unless = "#result == null")
	public City getCity(Short id) {
		City c = cityMapper.selectByPrimaryKey(id);
		return c;
	}

	@CachePut(value = "oneCity", key = "#city.getCityId()")
	public City updateCity(City city) {
		int t = cityMapper.updateByPrimaryKey(city);
		return city;
	}

	@CacheEvict(value = "oneCity", key = "#id") // 这是清除缓存
	public int deleteActivityInfo(Short id) {
		int i = cityMapper.deleteByPrimaryKey(id);
		return i;
	}

	// unless为true时，不执行缓存策略
	@Cacheable(value = "oneActor", key = "#id", unless = "#result == null")
	public Actor getActor(Short id) {
		Actor c = actorMapper.selectByPrimaryKey(id);
		return c;
	}

	@CacheEvict(value = "oneActor", key = "#id") // 这是清除缓存
	public int deleteActor(Short id) {
		int i = actorMapper.deleteByPrimaryKey(id);
		return i;
	}
}
