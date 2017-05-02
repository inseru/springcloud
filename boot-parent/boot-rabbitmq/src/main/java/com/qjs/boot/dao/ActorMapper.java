package com.qjs.boot.dao;

import com.qjs.boot.model.Actor;
import com.qjs.boot.model.ActorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface ActorMapper extends Mapper<Actor> {
    int countByExample(ActorExample example);

    int deleteByExample(ActorExample example);

    List<Actor> selectByExample(ActorExample example);

    int updateByExampleSelective(@Param("record") Actor record, @Param("example") ActorExample example);

    int updateByExample(@Param("record") Actor record, @Param("example") ActorExample example);
}