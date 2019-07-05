package com.education.demo.dao;

import com.education.demo.entity.Cooperation;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface CooperationDao {
    @Delete("delete from cooperation where cooperationId = #{cooperationId}")
    int deleteByPrimaryKey(@Param("cooperationId") int cooperationId);

    @Insert("INSERT INTO cooperation(schoolId ,baseNum ,industryNum ,disNum ,tNum ,totalFunds ,equipValue ,stuTrainNum ,stuWorkNum ,rdCenterNum ,courseNum ,checkWait ,checkResult ) " +
            "VALUES (#{schoolId},#{baseNum},#{industryNum},#{disNum},#{tNum},#{totalFunds},#{equipValue},#{stuTrainNum},#{stuWorkNum},#{rdCenterNum},#{courseNum},#{checkWait},#{checkResult})")
    @Options(useGeneratedKeys = true, keyProperty = "cooperationId")
    int insert(Cooperation record);

    @Select("select * from cooperation where cooperationId = #{cooperationId}")
    Cooperation selectByPrimaryKey(@Param("cooperationId") int cooperationId);

    @Update("update cooperation set baseNum = #{baseNum},industryNum = #{industryNum},disNum = #{disNum},tNum = #{tNum},totalFunds = #{totalFunds},equipValue = #{equipValue}," +
            "stuTrainNum = #{stuTrainNum},stuWorkNum = #{stuWorkNum},rdCenterNum = #{rdCenterNum},courseNum = #{courseNum},checkWait = #{checkWait},checkResult = #{checkResult}" +
            " where cooperationId = #{cooperationId}")
    int updateByPrimaryKey(Cooperation record);

    @Select("<script>select * from cooperation where 1 = 1 limit ${first},${rows}</script>")
    List<Cooperation> selectByPage(Cooperation record);

    @Select("select count(*) from cooperation")
    int selectCooperationCount();
}
