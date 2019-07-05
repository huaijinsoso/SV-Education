package com.education.demo.dao;

import com.education.demo.entity.CityUser;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface CityUserDao {
    @Delete("delete from city_user where cuserId = #{cuserId}")
    int deleteByPrimaryKey(@Param("cuserId") int cuserId);

    @Insert("insert into city_user(cityId,cuserName,cPassword) values(#{cityId},#{cuserName},#{cPassword})")
    @Options(useGeneratedKeys = true, keyProperty = "cuserId")
    int insert(CityUser record);

    @Select("select * from city_user where cuserId = #{cuserId}")
    CityUser selectByPrimaryKey(@Param("cuserId") int cuserId);

    @Update("update city_user set cuserName = #{cuserName},cPassword = #{cPassword} where cuserId = #{cuserId}")
    int updateByPrimaryKey(CityUser record);

    @Select("<script>select * from city_user where 1 = 1 <when test='cuserName!=null'> and cuserName like CONCAT('%','${cuserName}','%' ) </when> limit ${first},${rows}</script>")
    List<CityUser> selectByPage(CityUser record);

    @Select("select count(*) from city_user")
    int selectCityUserCount();
}
