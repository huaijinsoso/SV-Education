package com.education.demo.dao;

import com.education.demo.entity.Condition;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ConditionDao {
    @Delete("delete from school_condition where schoolConId = #{schoolConId}")
    int deleteByPrimaryKey(@Param("schoolConId") int schoolConId);

    @Insert("INSERT INTO school_condition(schoolId,diningNum,libraryBookNum,eBookNum,rdroomNum,eRdroomNum,desktopNum,eduFund,liabilitie,loans,equipValue,equipmentNum,checkWait,checkResult) " +
            "VALUES (#{schoolId},#{diningNum},#{libraryBookNum},#{eBookNum},#{rdroomNum},#{eRdroomNum},#{desktopNum},#{eduFund},#{liabilitie},#{loans},#{equipValue},#{equipmentNum},0,0)")
    @Options(useGeneratedKeys = true, keyProperty = "schoolConId")
    int insert(Condition record);

    @Select("select * from school_condition where schoolConId = #{schoolConId}")
    Condition selectByPrimaryKey(@Param("schoolConId") int schoolConId);

    @Update("update school_condition set checkResult = #{checkResult} where schoolConId = #{schoolConId}")
    int updateByPrimaryKey(Condition record);

    @Select("<script>select *  from school_condition where 1 = 1 limit ${first},${rows}</script>")
    List<Condition> selectByPage(Condition record);

    @Select("select count(*) from school_condition")
    int selectConditionCount();
}
