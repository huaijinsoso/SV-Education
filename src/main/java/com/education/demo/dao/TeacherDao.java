package com.education.demo.dao;

import com.education.demo.entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherDao {
    @Delete("delete from teacher where teacherId = #{teacherId}")
    int deleteByPrimaryKey(@Param("teacherId") int teacherId);

    @Insert("INSERT INTO teacher(schoolId,tNum,tFulltimeNum,tExternalNum,tPsyNum,tTitleNum,tBackboneNum,tOffprovNum,tNationalNum,tAbroadNum,checkWait,checkResult) " +
            "VALUES (#{schoolId},#{tNum},#{tFulltimeNum},#{tExternalNum},#{tPsyNum},#{tTitleNum},#{tBackboneNum},#{tOffprovNum},#{tNationalNum},#{tAbroadNum},0,0")
    @Options(useGeneratedKeys = true, keyProperty = "teacherId")
    int insert(Teacher record);

    @Select("select * from teacher where teacherId = #{teacherId}")
    Teacher selectByPrimaryKey(@Param("teacherId") int teacherId);

    @Update("update teacher set checkResult = #{checkResult} where teacherId = #{teacherId}")
    int updateByPrimaryKey(Teacher record);

    @Select("<script>select *  from teacher where 1 = 1 <when test='schoolId!=null'> and schoolId like CONCAT('%','${schoolId}','%' ) </when> limit ${first},${rows}</script>")
    List<Teacher> selectByPage(Teacher record);

    @Select("select count(*) from teacher")
    int selectTeacherCount();
}
