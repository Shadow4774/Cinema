<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="ControlServlet?op=addSala">
	<input type="hidden" name="op" value="addSala">
        <div>
          <input type="text" name="id"> ID sala
        </div>
        <div>
          <input type="number" name="posti"> Posti massimi
        </div>
         <br>
        <input type="submit" value="Crea">
        
      </form>

</body>
</html>