package com.education.demo.dao;

import com.education.demo.entity.Specialty;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SpecialtyDao {
    @Delete("delete from specialty_construction where speConId = #{speConId}")
    int deleteByPrimaryKey(@Param("specialtyId") int specialtyId);

    @Insert("INSERT INTO specialty_construction(schoolId,disNum,keyDisNum,importDisNum,specialDisNum,courseNum,checkWait,checkResult) " +
            "VALUES (#{schoolId},#{disNum},#{keyDisNum},#{importDisNum},#{specialDisNum},#{courseNum},0,0)")
    @Options(useGeneratedKeys = true, keyProperty = "specialtyId")
    int insert(Specialty record);

    @Select("select * from specialty_construction where speConId = #{speConId}")
    Specialty selectByPrimaryKey(@Param("speConId") int speConId);

    @Update("update specialty_construction set checkResult = #{checkResult} where speConId = #{speConId}")
    int updateByPrimaryKey(Specialty record);

    @Select("<script>select *  from specialty_construction where 1 = 1 <when test='speConId!=null'> and speConId like CONCAT('%','${speConId}','%' ) </when> limit ${first},${rows}</script>")
    List<Specialty> selectByPage(Specialty record);

    @Select("select count(*) from specialty_construction")
    int selectSpecialtyCount();
}
