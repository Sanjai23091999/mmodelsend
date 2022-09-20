<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<body>
   <form:form id="displayByIdForm" modelAttribute="employee" action="displayByIdEmployee" method="post" >
       <table align="center">
       <tr>
         <td>
             <form:label path="id">Id</form:label>
         </td>
          <td>
             <form:input path="id" name="id" id="id" />
          </td>
          </tr>
           <tr>
               <td>
                   <form:button id="SHOW" name="SHOW">SHOW</form:button>
               </td>
           </tr>
           <tr></tr>
       </table>
   </form:form>
</body>
</html>