<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<body>
   <form:form id="updateForm" modelAttribute="employee" action="updateEmployee" method="put" >

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
                   <form:label path="email">Email</form:label>
               </td>
               <td>
                   <form:input path="email" name="email" id="email" />
               </td>
           </tr>

           <tr>
               <td>
                   <form:button id="UPDATE" name="UPDATE">UPDATE</form:button>
               </td>
           </tr>
           <tr></tr>
       </table>
   </form:form>
</body>
</html>