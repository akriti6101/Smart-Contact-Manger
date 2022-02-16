<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Contacts </title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<c:url value="/css/ShowContacts.css" />" />

<style>
  
td
{text-align:center;
	background-color:white;color:blue;
	height:25px;
}
.a{ margin-left:0px;
display:inline;
}
.td1
{
text-align:left;
margin-left:10px;
}
.div211
{
	margin-left:200px;
	margin-top:60px;

}
.a2
{

padding-right:10px;
display:inline;
}
</style>
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
         <p class="p11" >CONTACTS LIST</p>
     
            
        <div class="div211">
     
             <table>
                <tr>
                      <th>Name</th>
                      <th>Email</th>
                      <th>Contact Number</th>
                      <th>Work Experience</th>
                      <th>Action</th>
                </tr>
                  
                  <c:forEach var="l" items="${list}" >
                      <tr>
                      <td class="td1"  ><a href="${pageContext.request.contextPath}/showContactProfile/${l.phone}/${username}" class="a2" ><img src="<c:url value="/images/${l.filename}"  />" style="width:20px;margin-right:4px;" /></a>${l.name}</td>
                      <td class="td" >${l.email}</td>
                      <td class="td" >${l.phone}</td>
                      <td class="td" >${l.work}</td>
                      <td class="td" >
                      <a class="a"  href="${pageContext.request.contextPath}/ProfileDel/${l.phone}/${username}"><i class="fa fa-trash-o" style="color:red;"></i></a>
                      <a class="a" href="${pageContext.request.contextPath}/editContacts/${l.phone}/${username}">
                      <i class="fa fa-edit" style="color:green;margin-left:5px;"></i></a>
                      
                      </td>
                </tr>
                  </c:forEach>
                
             </table>
           </div>
     
        
        
          
        
</div>

</body>
</html>