<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>
<style>
    .form-container{
        margin:0px 300px;
    }
</style>

<h2 class="profile-header">Create Profile Information</h2>
<div class="form-container">
    <c:url var="createAccountUrl" value="/createAccount"/>
    <form:form action="${createAccountUrl}" method="POST" modelAttribute="account"  enctype="multipart/form-data">
        <div class="container">
            <div class="form-group">
                <label for="firstName">FirstName</label>
                <form:input class="form-control" path="firstName" placeholder="First Name"/>
                <form:errors path="firstName" cssClass="bg-danger"/>
            </div>
            <div class="form-group">
                <label for="lastName">LastName</label>
                <form:input class="form-control" path="lastName" placeholder="Last Name"/>
                <form:errors path="lastName" cssClass="bg-danger"/>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <form:input class="form-control" path="email" placeholder="Email"/>
                <form:errors path="email" cssClass="bg-danger"/>
            </div>
            <div class="form-group">
                <label for="photoContainer">Photo</label>
                <input type="file" class="form-control" id="photoContainer" name="photoContainer" />
            </div>
            <div class="form-group">
                <label for="goal">Goal</label>
                <form:textarea class="form-control" rows="10" path="goal" placeholder="Tell us more about your workout goals..."></form:textarea>
            </div>

            <button type="submit" class="btn btn-success">Create Profile</button>
        </div>
    </form:form>
</div>

<%@ include file="common/footer.jspf" %>