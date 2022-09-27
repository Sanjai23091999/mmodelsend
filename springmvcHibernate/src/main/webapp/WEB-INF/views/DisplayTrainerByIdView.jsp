<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>Name</th><th>Email</th><th>Mobile</th></tr>
   <tr>
         <td>${trainer.employeeId}</td>
         <td>${trainer.employeeName}</td>
         <td>${trainer.employeeEmail}</td>
         <td>${trainer.employeeMobileNumber}</td>
         <td>${trainer.employeeDateOfJoin}</td>

   </table>
   <tr>
       <td><a href="index.jsp">Home</a>
       </td>
   </tr>