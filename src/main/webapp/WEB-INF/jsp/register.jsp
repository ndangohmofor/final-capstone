<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file = "common/header.jspf" %>

<c:url var="registerUrl" value="/register"/>
<body class="register">
<div class="centerRegister">
    <h1>Register</h1>
<form:form action="${registerUrl}" method="POST" modelAttribute="user">
    <div class="form-group">
        <label for="username">Username</label>
        <form:input class="form-control" path="username" placeholder="Username"/>
        <form:errors path="username" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <form:password class="form-control" path="password" placeholder="New Password"/>
        <form:errors path="password" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="confirmPassword">Confirm Password</label>
        <form:password class="form-control" path="confirmPassword" placeholder="Confirm Password"/>
        <form:errors path="passwordMatching" cssClass="bg-danger"/>
    </div>
    <fieldset  style="display: none">
        <legend>Role</legend>
        <form:errors path="role" cssClass="bg-danger"/>
        <div class="radio">
            <label>
                <form:radiobutton path="role" value="user" checked="checked" />
                User
            </label>
        </div>
    </fieldset>
    <div class="text-center btnDiv">
    <button type="submit" class="registerbtn btn-default">Save User</button>
    </div>
        </form:form>
</div>
</body>
<%@ include file = "common/footer.jspf" %>