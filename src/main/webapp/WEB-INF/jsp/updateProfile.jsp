<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>

<html>
<body>
<c:url var="updateProfileUrl" value="/updateProfile"/>
<form:form action="${updateProfileUrl}" method="POST"  modelAttribute="profile" enctype="multipart/form-data">
    <h2>Update profile</h2>
    <p>Please fill out all sections</p>
    <div class="mb-3">
        <label for="firstName">First Name</label>
        <form:input type="text" class="form-control" path="firstName" id="firstName" value="${profile.firstName}"/>
        <form:errors path="firstName" cssClass="bg-danger"/>
    </div>
    <div class="mb-3">
        <label for="lastName">Last Name</label>
        <form:input type="text" class="form-control" path="lastName" id="lastName" value="${profile.lastName}"/>
        <form:errors path="lastName" cssClass="bg-danger"/>
    </div>
    <div class="mb-3">
        <label for="email">Email</label>
        <form:input type="email" class="form-control" path="email" id="email" value="${profile.email}"/>
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
</html>


<%@ include file="common/footer.jspf" %>