package com.xuyong.study.mapper.test1;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.xuyong.study.domain.Greeting;

public interface User1Mapper {

    @Select("SELECT id, name FROM databus")
    @Results({
        @Result(property = "id",  column = "id"),
        @Result(property = "content", column = "name")
    })
    List<Greeting> getAll();
	
}
