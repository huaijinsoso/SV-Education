package com.education.demo.dao;

import com.education.demo.entity.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoticeDao {
    @Delete("delete from notice where noticeId = #{noticeId}")
    int deleteByPrimaryKey(@Param("noticeId") int noticeId);

    @Insert("INSERT INTO notice(cuserId,noticeName,valTime,message,noticeType) " +
            "VALUES (#{cuserId},#{noticeName},#{valTime},#{message},#{noticeType})")
    @Options(useGeneratedKeys = true, keyProperty = "noticeId")
    int insert(Notice record);

    @Select("select * from notice where noticeId = #{noticeId}")
    Notice selectByPrimaryKey(@Param("noticeId") int noticeId);

    @Update("update notice set cuserId = #{cuserId},noticeName = #{noticeName},valTime = #{valTime},message = #{message},noticeType = #{noticeType} where noticeId = #{noticeId}")
    int updateByPrimaryKey(Notice record);

    @Select("<script>select * from notice where 1 = 1 limit ${first},${rows}</script>")
    List<Notice> selectByPage(Notice record);

    @Select("select count(*) from notice")
    int selectNoticeCount();
}
