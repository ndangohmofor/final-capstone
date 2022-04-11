<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>

<body>
<h2 class="profile-header">Update Profile Information</h2>

<c:url var="updateProfileUrl" value="/updateProfile"/>
<form:form action="${updateProfileUrl}" method="POST" modelAttribute="profile">
    <div class="container">
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
    </div>
</form:form>
</body>

<%@ include file="common/footer.jspf" %>


