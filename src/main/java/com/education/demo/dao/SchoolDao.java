package com.education.demo.dao;

import com.education.demo.entity.School;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SchoolDao {
    @Delete("delete from school where schoolId = #{schoolId}")
    int deleteByPrimaryKey(@Param("schoolId") int schoolId);

    @Insert("INSERT INTO school(schoolId,cityId,schoolName) VALUES (#{schoolId},#{cityId},#{schoolName})")
    @Options(useGeneratedKeys = true, keyProperty = "schoolId")
    int insert(School record);

    @Select("select * from school where schoolId = #{schoolId}")
    School selectByPrimaryKey(@Param("schoolId") int schoolId);

    @Update("update school set schoolName = #{schoolName} where schoolId = #{schoolId}")
    int updateByPrimaryKey(School record);

    @Select("<script>select *  from school where 1 = 1 <when test='schoolName!=null'> and schoolName like CONCAT('%','${schoolName}','%' ) </when> limit ${first},${rows}</script>")
    List<School> selectByPage(School record);

    @Select("select count(*) from school")
    int selectSchoolCount();
}
