<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<table border="2" width="70%" cellpadding="2">
<tr><th>id</th><th>firstName</th><th>lastName</th><th>email</th></tr>
   <tr>
   <td>${employee.id}</td>
   <td>${employee.firstName}</td>
   <td>${employee.lastName}</td>
   <td>${employee.email}</td>
   </tr>

   </table>
   <tr>
       <td><a href="index.jsp">Home</a>
       </td>
   </tr>