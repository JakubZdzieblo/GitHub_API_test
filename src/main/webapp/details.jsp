<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body>
<h3>${owner.name}'s details:</h3>
user name: ${owner.login}<br>
email: ${owner.email}<br>
<ul>
    <h4>Repositories list:</h4>
    <c:forEach items="${list}" var="repo">
        <li>
            <b>${repo.name}</b>, in ${repo.language}.<BR>
            ${repo.description}
        </li>
    </c:forEach>
</ul>
<ul>
<h4>Language stats:</h4>
<c:forEach var="entry" items="${stats}">
    <li>
    Language: <b><c:out value="${entry.key}"/></b>, Usage: <c:out value="${entry.value}"/>
    </li>
</c:forEach>
</ul>
</body>
</html>
