package com.education.demo.controller;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.education.demo.entity.Page;

public abstract class BaseController {
    
    private final Logger logger = Logger.getLogger("BaseController");
    
    private HttpServletRequest servletRequest;
    
    private HttpServletResponse servletResponse;
    
    private HttpSession session;
    
    @ModelAttribute
    public void setReqOrRes(HttpServletRequest req, HttpServletResponse res) {
        try {
            this.servletRequest = req;
            this.servletResponse = res;
            this.session = req.getSession();
            this.servletRequest.setCharacterEncoding("UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    
    private static String[] parsePatterns = { "yyyy-MM-dd",
                                             "yyyy-MM-dd HH24:mm:ss",
                                             "yyyy-MM-dd HH24:mm",
                                             "yyyy/MM/dd",
                                             "yyyy/MM/dd HH24:mm:ss",
                                             "yyyy/MM/dd HH24:mm" };
    
    /**
     * 添加Model消息
     */
    protected void addMessage(Model model, String... messages) {
        StringBuilder sb = new StringBuilder();
        for (String message : messages) {
            sb.append(message).append(messages.length > 1 ? "<br/>" : "");
        }
        model.addAttribute("_msg", sb.toString());
    }
    



    
    public String arrayToString(String[] ids) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ids.length; i++) {
            sb.append("," + ids[i]);
        }
        return sb.toString().replaceFirst(",", "");
    }
    
    /**
     * Description:[初始化列表的分页对象Page]<br>
     * 适用场景：[在列表展示和查询等数据量大时分页处理时]<br>
     */
    protected Page getPage() {
        Page page = new Page();
        String str_p = this.servletRequest.getParameter("page");
        String str_ps = this.servletRequest.getParameter("pageSize");
        Integer p = StringUtils.isNotEmpty(str_p) ? Integer.parseInt(str_p)
                                                 : Integer.parseInt("1");
        Integer ps = StringUtils.isNotEmpty(str_ps) ? Integer.parseInt(str_ps)
                                                   : Integer.parseInt("10");
        page.setPage(p);
        page.setRows(ps);
        return page;
    }
    
    /**
     * Description:[设置响应处理结果的消息体，�?过添加到map中统�?��换成JSON返回给前端]<br>
     * 
     * @author:
     * @update: 2015�?�?1�? * @param state 结果状�?
     * @param msg
     *            消息内容
     * @return 消息map对象
     */
    protected Map<String, Object> setResultMessage(Boolean state, String msg) {
        Map<String, Object> resultMsg = new HashMap<String, Object>();
        resultMsg.put("state", state);
        resultMsg.put("msg", msg);
        return resultMsg;
    }
    
    protected Map<String, Object> setSucceedResultMessage(String msg) {
        Map<String, Object> resultMsg = new HashMap<String, Object>();
        resultMsg.put("state", Boolean.TRUE);
        resultMsg.put("msg", msg);
        return resultMsg;
    }
    
    protected Map<String, Object> setSucceedResultMessage(String msg,
                                                          Object data) {
        Map<String, Object> resultMsg = new HashMap<String, Object>();
        resultMsg.put("state", Boolean.TRUE);
        resultMsg.put("data", data);
        resultMsg.put("msg", msg);
        return resultMsg;
    }
    
    protected Map<String, Object> setFailedResultMessage(String msg) {
        Map<String, Object> resultMsg = new HashMap<String, Object>();
        resultMsg.put("state", Boolean.FALSE);
        resultMsg.put("msg", msg);
        return resultMsg;
    }
    
    /**
     * Description:[设置响应处理结果的数据信息，通过添加到map中统�?��换成JSON返回给前端]<br>
     * 
     * @author:luojl
     * @update: 2015�?�?1�? * @param total 数据总数
     * @param rows
     *            返回的行数据
     * @return 结果数据map
     */
    protected Map<String, Object> setResultData(int i, Object rows) {
        Map<String, Object> resultMsg = new HashMap<String, Object>();
        resultMsg.put("total", i);
        resultMsg.put("rows", rows);
        return resultMsg;
    }
    
    public HttpServletRequest getServletRequest() {
        return servletRequest;
    }
    
    public HttpServletResponse getServletResponse() {
        return servletResponse;
    }
}
