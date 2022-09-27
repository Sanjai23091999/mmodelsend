<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
   <form action="Associate">
   ENTER THE TRAINEE ID <input type="text" name ="traineeId" /><br>
   ENTER THE TRAINER ID <input type="text" name = "trainerId" /><br>
   <button>ASSOCIATE</button>
   </form>
</body>
</html>