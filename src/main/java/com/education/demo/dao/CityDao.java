package com.education.demo.dao;

import com.education.demo.entity.City;

import org.apache.ibatis.annotations.*;
import java.util.List;


@Mapper
public interface CityDao {

    @Delete("delete from city where cityId = #{cityId}")
    int deleteByPrimaryKey(@Param("cityId") int cityId);

    @Insert("INSERT INTO city(cityName) VALUES (#{cityName})")
    @Options(useGeneratedKeys = true, keyProperty = "cityId")
    int insert(City record);

    @Select("select * from city where cityId = #{cityId}")
    City selectByPrimaryKey(@Param("cityId") int cityId);

    @Update("update city set cityName = #{cityName} where cityId = #{cityId}")
    int updateByPrimaryKey(City record);

    @Select("<script>select *  from city where 1 = 1 <when test='cityName!=null'> and cityName like CONCAT('%','${cityName}','%' ) </when> limit ${first},${rows}</script>")
    List<City> selectByPage(City record);

    @Select("select count(*) from city")
    int selectCityCount();

}
