package com.handikang.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("insert into t1 values(1,1,1,1,'1')")
    void insertOne();
}
