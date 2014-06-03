<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="result" scope="request" class="beans.Result"></jsp:useBean>
{"success": <jsp:getProperty property="success" name="result"/>,
 "message": "<jsp:getProperty property="message" name="result"/>",
 "event": "<jsp:getProperty property="event" name="result"/>",
 "wuerfelZahl" : "${wuerfelZahl}"
}