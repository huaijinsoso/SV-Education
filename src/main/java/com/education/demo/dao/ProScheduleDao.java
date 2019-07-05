package com.education.demo.dao;

import com.education.demo.entity.ProSchedule;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProScheduleDao {
    @Delete("delete from pro_schedule where schId = #{schId}")
    int deleteByPrimaryKey(@Param("schId") int schId);

    @Insert("INSERT INTO pro_schedule(projectId,schAddress,checkWait,checkResult) VALUES (#{projectId},#{schAddress},0,0)")
    @Options(useGeneratedKeys = true, keyProperty = "schId")
    int insert(ProSchedule record);

    @Select("select * from pro_schedule where schId = #{schId}")
    ProSchedule selectByPrimaryKey(@Param("schId") int schId);

    @Update("update pro_schedule set checkResult = #{checkResult} where schId = #{schId}")
    int updateByPrimaryKey(ProSchedule record);

    @Select("<script>select *  from pro_schedule where 1 = 1 <when test='projectId!=null'> and projectId like CONCAT('%','${projectId}','%' ) </when> limit ${first},${rows}</script>")
    List<ProSchedule> selectByPage(ProSchedule record);

    @Select("select count(*) from pro_schedule")
    int selectProScheduleCount();
}
