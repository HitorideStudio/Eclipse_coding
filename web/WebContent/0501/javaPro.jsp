<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>유효성 검사</h1>

<jsp:useBean id="vo" class="test.ex.validate.TestVo"/>
<jsp:setProperty property="*" name="vo"/>

<h2>id: <jsp:getProperty property="id" name="vo"/></h2>
<h2>age: <jsp:getProperty property="age" name="vo"/></h2>