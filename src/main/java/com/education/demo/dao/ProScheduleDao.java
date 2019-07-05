package com.education.demo.dao;

import com.education.demo.entity.ProSchedule;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProScheduleDao {
    @Delete("delete from pro_schedule where schIdId = #{schIdId}")
    int deleteByPrimaryKey(@Param("schIdId") int schIdId);

    @Insert("INSERT INTO pro_schedule(cuserId,schIdName,valTime,message,schIdType) " +
            "VALUES (#{cuserId},#{schIdName},#{valTime},#{message},#{schIdType})")
    @Options(useGeneratedKeys = true, keyProperty = "schIdId")
    int insert(ProSchedule record);

    @Select("select * from pro_schedule where schIdId = #{schIdId}")
    ProSchedule selectByPrimaryKey(@Param("schIdId") int schIdId);

    @Update("update pro_schedule set cuserId = #{cuserId},schIdName = #{schIdName},valTime = #{valTime},message = #{message},schIdType = #{schIdType} where schIdId = #{schIdId}")
    int updateByPrimaryKey(ProSchedule record);

    @Select("<script>select * from pro_schedule where 1 = 1 limit ${first},${rows}</script>")
    List<ProSchedule> selectByPage(ProSchedule record);

    @Select("select count(*) from pro_schedule")
    int selectProScheduleCount();
}
