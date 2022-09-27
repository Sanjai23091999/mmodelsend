<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<table border="2" width="70%" cellpadding="2">
<tr><th>id</th><th>name</th><th>email</th><th>mobile</th><th>Date Of Join</th></tr>
   <c:forEach var="trainer" items="${trainers}">
   <tr>
   <td>${trainer.employeeId}</td>
      <td>${trainer.employeeName}</td>
      <td>${trainer.employeeEmail}</td>
      <td>${trainer.employeeMobileNumber}</td>
      <td>${trainer.employeeDateOfJoin}</td>
   </tr>

   </c:forEach>
   </table>
   <tr>
       <td><a href="AssociateTrainee">ASSOCIATE TRAINEE</a><br>
       </td>
   </tr>
   <tr>
       <td><a href="index.jsp">Home</a>
       </td>
   </tr>