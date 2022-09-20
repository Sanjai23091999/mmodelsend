<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<body>
   <form:form id="saveForm" modelAttribute="employee" action="saveEmployee" method="post" >

       <table align="center">
       <tr>
         <td>
             <form:label path="id">employeeId</form:label>
         </td>
          <td>
             <form:input path="id" name="id" id="id" />
          </td>
          </tr>
          <tr>
               <td>
                   <form:label path="firstName">FirstName</form:label>
               </td>
               <td>
                   <form:input path="firstName" name="firstName" id="firstName" />
               </td>
           </tr>

           <tr>
               <td>
                   <form:label path="lastName">LastName</form:label>
               </td>
               <td>
                   <form:input  path="lastName" name="lastName" id="lastName" />
               </td>
           </tr>
           <tr>
               <td>
                   <form:label path="email">Email</form:label>
               </td>
               <td>
                   <form:input path="email" name="email" id="email" />
               </td>
           </tr>

           <tr>
               <td>
                   <form:button id="SAVE" name="SAVE">SAVE</form:button>
               </td>
           </tr>
           <tr></tr>
       </table>
   </form:form>
</body>
</html>