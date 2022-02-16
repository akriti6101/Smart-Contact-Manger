<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Add Contact</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<c:url value="/css/AddContact.css"/>" />
</head>
<body>
    
<div class="div0" >
    <h2 class="h21">Smart Contact Manager</h2>
    <div class="div01" >
        <a class="h22" href="${pageContext.request.contextPath}/home/${username}">HOME</a>
        <p class="p1"><img src="<c:url value="/images/profile.png"/>"/>${username}</p>
        <a class="h22" href="${pageContext.request.contextPath}/Login">LOGOUT</a>
</div>
</div>
 <div class="div1">
     <div class="div2" >
       <i class='fa fa-address-card-o' style="font-size:45px;color:black;margin-top:50px;margin-left:100px;"></i>
       <div class="div3"> <a href="${pageContext.request.contextPath}/Profile/${username}" ><i class="fa fa-user"   style="font-size:18px;color:white;"></i> Profile</a></div><br/>
       <div class="div3"> <a href="${pageContext.request.contextPath}/showContacts/${username}" ><i class="fa fa-address-book"   style="font-size:18px;color:white;"></i> Show Contacts</a></div><br/>
       <div class="div3"> <a href="${pageContext.request.contextPath}/addContact/${username}" ><i class="fa fa-address-book-o"   style="font-size:18px;color:white;"></i> Add Contacts</a></div><br/>
       <div class="div3"> <a href="${pageContext.request.contextPath}/Login"  ><i class="fa fa-arrow-left"   style="font-size:18px;color:white;"></i> Exit</a></div><br/>
    </div>
 </div>
 
 <div class="div21" >
       <p class="p11" >EDIT CONTACTS</p>
       <form action="${pageContext.request.contextPath}/ContactUpdate/${c.phone}/${username}"  enctype="multipart/form-data" method="post" >
        <div class="div211">
     
           <p class="p23" style=" position:absolute;top:30px; left:430px;color:green;font-family:cursive;height:30px;">${msg}
           </p>
         
        <h6><i class="fa fa-plus" style="font-size:18px;margin-right:6px;color:grey" ></i>
            <input placeholder="Enter Contact Name"  type="text"name="name" class="inp"  value="${c.name}"/><br/>
            <form:errors path="contact.name" style="color:red;font-size:15px;text-align:left;font-weight:60" ></form:errors>
         </h6>
        
        <h6><i class="fa solid fa-envelope" style="font-size:18px;margin-right:6px;color:grey"></i>
           <input placeholder="Enter Email Address" name="email"  type="text"  class="inp"   value="${c.email}" /><br/>
           <form:errors path="contact.email" style="color:red;font-size:15px;text-align:left;font-weight:60" ></form:errors>
        </h6>
      
         <h6><i class="fa fa-phone" style="font-size:18px;margin-right:6px;color:grey"></i>
           <input placeholder="Enter Contact Number" name="phone"  type="text"  class="inp"  value="${c.phone}" /><br/>
           <form:errors path="contact.phone" style="color:red;font-size:15px;text-align:left;font-weight:60" ></form:errors>
        </h6>
        
         <h6><i class="fa fa-briefcase" style="font-size:18px;margin-right:6px;color:grey"></i>
           <input placeholder="Enter Work Experience" name="work"  type="text"  class="inp"  value="${c.work}" />
        </h6>
         
         <h6><i class="fa fa-user-circle-o" style="font-size:18px;margin-right:6px;color:grey"></i>
           <input  name="img1"  type="file"  class="inp" />
        </h6>
           <button type="submit">SUBMIT</button>
           </div>
        </form>
        
        <div class="div22">
          <i class="fa fa-book" style="font-size:180px;color:grey"></i><br/>
          <i class='fa fa-pencil' style="font-size:80px;position:absolute;top:118px;left:125px;color:grey"></i></div>
        
        </div>
</body>
</html>