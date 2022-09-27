<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<table border="2" width="70%" cellpadding="2">
<tr><th>id</th><th>Name</th><th>email</th><th>mobile</th><th>Date Of Join</th></tr>
   <c:forEach var="trainee" items="${trainees}">
   <tr>
   <td>${trainee.employeeId}</td>
   <td>${trainee.employeeName}</td>
   <td>${trainee.employeeEmail}</td>
   <td>${trainee.employeeMobileNumber}</td>
   <td>${trainee.employeeDateOfJoin}</td>
   </tr>

   </c:forEach>
   </table>
    <tr>
        <td><a href="DisplayAllTrainers">ASSOCIATE</a><br>
        </td>
   </tr>
   <tr>
       <td><a href="index.jsp">Home</a>
       </td>
   </tr>
