<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="<c:url value="/css/loginPageStyle.css" />" />
<title>Insert title here</title>
</head>

<body style=" background-image :url('<c:url value="/images/pic.jpg"/>');background-repeat:no-repeat;background-size:cover">
      <form  action="${action}" method="post" >
      <div class="div1"  >
      <p style="color:black">${status}</p>
         <p style="color:red;font-size:15px;">${info}</p>
         <div class="div2" >
             <h3>UserName :<input placeholder="Enter username.." name="username">
             <div style="color:white;font-size:12px;margin-left:100px;">
                <form:errors path="user.username" />
                </div></h3>
            
              <h3>Password :<input placeholder="Enter password.." name="password" >
              <div style="color:white;font-size:12px;margin-left:100px;">
                <form:errors path="user.password"/></div>
                </h3>
           <button type="submit" >${statusButton}</button>
           </div><br/>
           <hr/>
           
           
            <a  class="p1" href="${pageContext.request.contextPath}/create ">Create a new account</a>
            <a  class="p2" href="${pageContext.request.contextPath}/forgotPassword ">Forgot password ? !!!</a>
            </div>
            </form>
</body>
</html>