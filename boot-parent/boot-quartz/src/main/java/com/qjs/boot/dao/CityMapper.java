package com.qjs.boot.dao;

import com.qjs.boot.model.City;
import com.qjs.boot.model.CityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface CityMapper extends Mapper<City> {
    int countByExample(CityExample example);

    int deleteByExample(CityExample example);

    List<City> selectByExample(CityExample example);

    int updateByExampleSelective(@Param("record") City record, @Param("example") CityExample example);

    int updateByExample(@Param("record") City record, @Param("example") CityExample example);
}