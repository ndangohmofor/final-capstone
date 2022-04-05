<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>

<html>
<body>
<div>

    <h2>Profile</h2>

    <div>
        <div>
            <span></span>:
            <c:url var="photoUrl" value="/img/${profile.photo}"/>
            <img src="<c:url value="/img/mbj.png"/>"/>
        </div>
        <div>
            <span>First Name</span>:
            <c:out value="${profile.firstName}" />
        </div>
        <div>
            <span>Last Name</span>:
            <c:out value="${profile.lastName}" />
        </div>
        <div>
            <span>Email</span>:
            <c:out value="${profile.email}" />
        </div>
        <div>
            <span>Goal</span>:
            <c:out value="${profile.goal}" />
        </div>
    </div>

    <div>
        <c:url var="updateProfile" value="/updateProfile"/>
        <li><a href="${updateProfile}"/>Update Profile</li>
    </div>

</div>
</body>
</html>
