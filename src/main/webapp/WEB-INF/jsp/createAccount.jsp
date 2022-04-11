<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>

<c:url var="createAccountUrl" value="/createAccount"/>
<form:form action="${createAccountUrl}" method="POST" modelAttribute="account"  enctype="multipart/form-data">
    <div class="form-group">
        <label for="firstName">FirstName</label>
        <form:input class="form-control" path="firstName" placeholder="firstName"/>
        <form:errors path="firstName" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="lastName">LastName</label>
        <form:input class="form-control" path="lastName" placeholder="lastName"/>
        <form:errors path="lastName" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <form:input class="form-control" path="email" placeholder="email"/>
        <form:errors path="email" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="photoContainer">Photo</label>
        <input type="file" class="form-control" id="photoContainer" name="photoContainer" />
    </div>
    <div class="form-group">
        <label for="goal">Goal</label>
        <form:textarea class="form-control" rows="10" path="goal" placeholder="goal"></form:textarea>
    </div>



    <button type="submit" class="btn btn-default">Create Profile</button>
</form:form>

<%@ include file="common/footer.jspf" %>