package com.education.demo.dao;

import com.education.demo.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentDao {
    @Delete("delete from student where studentId = #{studentId}")
    int deleteByPrimaryKey(@Param("studentId") int studentId);

    @Insert("INSERT INTO student(schoolId,stuNum,stuClassNum,stuDoucertNum,stuNationNum,stuProNum,stuLocalNum,stuIntNum,checkWait,checkResult) " +
            "VALUES (#{schoolId},#{stuNum},#{stuClassNum},#{stuDoucertNum},#{stuNationNum},#{stuProNum},#{stuLocalNum},#{stuIntNum},0,0)")
    @Options(useGeneratedKeys = true, keyProperty = "studentId")
    int insert(Student record);

    @Select("select * from student where studentId = #{studentId}")
    Student selectByPrimaryKey(@Param("studentId") int studentId);

    @Update("update student set checkResult = #{checkResult} where studentId = #{studentId}")
    int updateByPrimaryKey(Student record);

    @Select("<script>select *  from student where 1 = 1 limit ${first},${rows}</script>")
    List<Student> selectByPage(Student record);

    @Select("select count(*) from student")
    int selectStudentCount();
}
