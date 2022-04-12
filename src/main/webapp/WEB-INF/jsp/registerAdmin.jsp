<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/headerAdmin.jspf" %>

<c:url var="registerUrl" value="/registerAdmin"/>
<body class="register">
<div class="centerRegisterAdmin">
    <h1>Register Users</h1>
    <form:form action="${registerUrl}" method="POST" modelAttribute="user">
        <div class="registerForm-group">
            <label for="username">Username</label>
            <form:input class="form-control" path="username" placeholder="Username"/>
            <form:errors path="username" cssClass="bg-danger"/>
        </div>
        <div class="registerForm-group">
            <label for="password">Password</label>
            <form:password class="form-control" path="password"/>
            <form:errors path="password" cssClass="bg-danger"/>
        </div>
        <div class="registerForm-group">
            <label for="confirmPassword">Confirm Password</label>
            <form:password class="form-control" path="confirmPassword"/>
            <form:errors path="passwordMatching" cssClass="bg-danger"/>
        </div>
        <fieldset>
            <legend>Role</legend>
            <form:errors path="role" cssClass="bg-danger"/>
            <div class="radio">
                <label>
                    <form:radiobutton path="role" value="user"/>
                    Gym User
                </label>
            </div>
            <div class="radio">
                <label>
                    <form:radiobutton path="role" value="admin"/>
                    Gym Admin
                </label>
            </div>
            <div class="radio">
                <label>
                    <form:radiobutton path="role" value="employee" checked="checked"/>
                    Gym Employee
                </label>
            </div>
        </fieldset>
        <div class="text-center btnDiv">
            <button type="submit" class="registerbtn btn-default">Save User</button>
        </div>
    </form:form>
</div>
</body>

<%@ include file="common/footer.jspf" %>