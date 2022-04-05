<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>

<html>
<body>
<c:url var="updateProfile" value="/updateProfile"/>
<form action="${updateProfile}" method="POST">
    <h2>Update profile</h2>
    <p>Please fill out all sections</p>
    <%--    <div>--%>
    <%--        <label for="userId">Member ID</label>--%>
    <%--        <input type="text" name="userId" id="userId">--%>
    <%--    </div>--%>
    <div>
        <label for="firstName">First Name</label>
        <input type="text" name="firstName" id="firstName" value="${profile.firstName}">
    </div>
    <div>
        <label for="lastName">Last Name</label>
        <input type="text" name="lastName" id="lastName" value="${profile.lastName}">
    </div>
    <div>
        <label for="email">Email</label>
        <input type="text" name="email" id="email" value="${profile.email}">
    </div>
    <div>
        <label for="goal">Update Goals</label>
        <textarea cols="50" rows="5" type="text" name="goal" id="goal">
            ${profile.goal}
        </textarea>
    </div>
    <div>
        <input type="submit" value="Save Changes">
    </div>
</form>

</body>
</html>
