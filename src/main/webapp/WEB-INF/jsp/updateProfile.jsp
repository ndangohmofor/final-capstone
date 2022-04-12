<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>

<body>
<h2 class="profile-header">Update Profile Information</h2>
<div class="form-container">
    <c:url var="updateProfileUrl" value="/updateProfile"/>
    <form:form action="${updateProfileUrl}" method="POST" modelAttribute="profile" enctype="multipart/form-data">
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
                <label for="photoContainer">Photo</label>
                <input type="file" class="form-control" id="photoContainer" name="photoContainer" />
            </div>
            <div class="form-group">
                <label for="goal">Update Goals</label>
                <form:textarea class="form-control" rows="10" path="goal" id="goal" value="${profile.goal}"/>
                <form:errors path="goal" cssClass="bg-danger"/>
            </div>

            <button type="submit" class="btn btn-success">Update Profile</button>
        </div>
    </form:form>
</div>
</body>

<%@ include file="common/footer.jspf" %>


