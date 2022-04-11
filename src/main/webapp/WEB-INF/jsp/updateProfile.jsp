<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>

<c:url var="updateProfileUrl" value="/updateProfile"/>
<form:form action="${updateProfileUrl}" method="POST"  modelAttribute="profile">
    <div class="form-group">
        <label for="firstName">First Name</label>
        <form:input class="form-control" path="firstName"/>
        <form:errors path="firstName" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="lastName">Last Name</label>
        <form:input class="form-control" path="lastName"/>
        <form:errors path="lastName" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <form:input type="text" class="form-control" path="email" value="${profile.email}"/>
        <form:errors path="email" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="goal">Update Goals</label>
        <form:textarea class="form-control" rows="10" path="goal" id="goal" value="${profile.goal}"/>
        <form:errors path="goal" cssClass="bg-danger"/>
    </div>

    <button type="submit" class="btn btn-default">Update Profile</button>
</form:form>

<%@ include file = "common/footer.jspf" %>


<%--<html>
<body>
<c:url var="updateProfileUrl" value="/updateProfile"/>
<form:form action="${updateProfileUrl}" method="POST"  modelAttribute="profile">
    <h2>Update profile</h2>
    <p>Please fill out all sections</p>
    <div class="mb-3">
        <label for="firstName">First Name</label>
        <form:input type="text" class="form-control" path="firstName" id="firstName"/>
        <form:errors path="firstName" cssClass="bg-danger"/>
    </div>
    <div class="mb-3">
        <label for="lastName">Last Name</label>
        <form:input type="text" class="form-control" path="lastName" id="lastName"/>
        <form:errors path="lastName" cssClass="bg-danger"/>
    </div>
    <div class="mb-3">
        <label for="email">Email</label>
        <form:input type="email" class="form-control" path="email" id="email"/>
        <form:errors path="email" cssClass="bg-danger"/>
    </div>
    <div class="mb-3">
        <label for="goal">Update Goals</label>
        <textarea class="form-control" rows="10" name="goal" id="goal">${profile.goal}</textarea>
    </div>
    <div class="mb-3">
        <input type="submit" value="Save Changes">
    </div>
</form:form>

</body>
</html>--%>


<%@ include file="common/footer.jspf" %>