<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>新增用户</title>
</head>
<body>
  <form:form  commandName="user" action="${url}" >
    <table>
	    <tr>
	       <td>用户名：</td>
	       <td><form:input path="userName" /></td>
	    </tr>
	    <tr>
	     <td>密码：</td>
	       <td><form:password path="password"  /></td>
	    </tr>
	    <tr>
	     <td>姓名：</td>
	       <td><form:input path="realName" /></td>
	    </tr>
	    <tr>
	     <td>生日：</td>
	       <td><form:input path="birthday" /></td>
	    </tr>
	    <tr>
	     <td>工资：</td>
	       <td><form:input path="salary" /></td>
	    </tr>
	    <tr>
	     <td colspan="2"><input type="submit" name="提交"/></td>
	    </tr>	    
    </table>
  </form:form>
</body>
</html>