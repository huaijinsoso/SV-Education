package com.education.demo.dao;

import com.education.demo.entity.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectDao {
    @Delete("delete from project where projectId = #{projectId}")
    int deleteByPrimaryKey(@Param("projectId") int projectId);

    @Insert("INSERT INTO project(schoolId,proName,proAddress,proClass,fund,applyTime,proProgress,checkWait,checkResult) " +
            "VALUES (#{schoolId},#{proName},#{proAddress},#{proClass},#{fund},#{applyTime},#{proProgress},0,0)")
    @Options(useGeneratedKeys = true, keyProperty = "projectId")
    int insert(Project record);

    @Select("select * from project where projectId = #{projectId}")
    Project selectByPrimaryKey(@Param("projectId") int projectId);

    @Update("update project set checkResult = #{checkResult} where projectId = #{projectId}")
    int updateByPrimaryKey(Project record);

    @Select("<script>select *  from project where 1 = 1 <when test='projectName!=null'> and projectName like CONCAT('%','${projectName}','%' ) </when> limit ${first},${rows}</script>")
    List<Project> selectByPage(Project record);

    @Select("select count(*) from project")
    int selectProjectCount();
}
