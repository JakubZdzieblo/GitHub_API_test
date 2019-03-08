<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
    <style>
        body {
            font-family: sans-serif;
        }
        table, td, th {
            border: 1px solid #ddd;
            text-align: left;
        }

        table {
            border-collapse: collapse;
            width: 30%;
        }

        th, td {
            padding: 15px;
        }
    </style>
</head>

<body>

<h3>${owner.name}'s details:</h3>
<b>user name: </b>${owner.login}<br>
<b>email: </b>${owner.email}<br>

<h4>Language stats:</h4>
<table>
    <tr>
        <th>Language</th>
        <th>Count</th>
    </tr>
<c:forEach var="entry" items="${stats}">
    <tr>
        <td>
            <b><c:out value="${entry.key}"/></b>
        </td>
        <td>
            <c:out value="${entry.value}"/>
        </td>
    </tr>
</c:forEach>
</table>

<ul>
    <h4>Repositories list:</h4>
    <c:forEach items="${list}" var="repo">
        <li>
            <b>${repo.name}</b>, in ${repo.language}.<BR>
                ${repo.description}
        </li>
    </c:forEach>
</ul>

    <BR><BR>
    <a href="\">Go back</a>

</body>
</html>
