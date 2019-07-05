package com.education.demo.service.impl;

import com.education.demo.dao.NoticeDao;
import com.education.demo.entity.Notice;
import com.education.demo.entity.Page;
import com.education.demo.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;
    @Override
    public List<Notice> queryNotice(Notice notice) {
        return (List<Notice>)noticeDao.selectByPage(notice);
    }

    @Override
    public Notice queryNoticeById(int id) {
        return noticeDao.selectByPrimaryKey(id);
    }

    @Override
    public boolean operationNotice(Notice notice) {
        if(0 == notice.getNoticeId()){
            return noticeDao.insert(notice) > 0 ? true : false;
        } else {
            return noticeDao.updateByPrimaryKey(notice) > 0 ? true : false;
        }
    }

    @Override
    public boolean deleteNotice(int id) {
        return noticeDao.deleteByPrimaryKey(id)> 0 ? true : false;
    }

    @Override
    public Page findNotice4Page(Notice notice, Page page) {
        notice.setPage(page.getPage());
        notice.setRows(page.getRows());
        page.setRecords(noticeDao.selectNoticeCount());
        page.setGridObjectData(noticeDao.selectByPage(notice));
        return page;
    }
}
