package com.education.demo.dao;

import com.education.demo.entity.SchoolUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SchoolUserDao {
    @Delete("delete from school_user where suserId = #{suserId}")
    int deleteByPrimaryKey(@Param("suserId") int suserId);

    @Insert("INSERT INTO school_user(schoolId,suserName,sPassword) VALUES (#{suserId},#{suserName},#{sPassword})")
    @Options(useGeneratedKeys = true, keyProperty = "suserId")
    int insert(SchoolUser record);

    @Select("select * from school_user where suserId = #{suserId}")
    SchoolUser selectByPrimaryKey(@Param("suserId") int suserId);

    @Update("update school_user set suserName = #{suserName},sPassword = #{sPassword} where suserId = #{suserId}")
    int updateByPrimaryKey(SchoolUser record);

    @Select("<script>select * from school_user where 1 = 1 <when test='suserName!=null'> and suserName like CONCAT('%','${suserName}','%' ) </when> limit ${first},${rows}</script>")
    List<SchoolUser> selectByPage(SchoolUser record);

    @Select("select count(*) from school_user")
    int selectSchoolUserCount();
}
