<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: sans-serif;
        }
    </style>
</head>
<body>
<p>Hi, please enter a GitHub user name.</p>

<form action="details" method="GET">

    <input type="text" required="required" name="username"/>
    <input type="submit" value="Submit">

</form>
</body>
</html>
