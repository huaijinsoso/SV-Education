package com.education.demo.service;

import com.education.demo.entity.Notice;
import com.education.demo.entity.Page;

import java.util.List;

public interface NoticeService {
    List<Notice> queryNotice(Notice notice);

    Notice queryNoticeById(int id);

    boolean operationNotice(Notice notice);

    boolean deleteNotice(int id);

    Page findNotice4Page(Notice notice , Page page);
}
