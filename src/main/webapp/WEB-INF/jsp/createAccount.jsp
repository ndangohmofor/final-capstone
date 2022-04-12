<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>

<c:url var="createAccountUrl" value="/createAccount"/>
<body class="createAccount">
<div class="centerAccount">
<form:form action="${createAccountUrl}" method="POST" modelAttribute="account"  enctype="multipart/form-data">

    <h1>Profile Information</h1>
    <div class="infoform-group">
        <label for="firstName">FirstName</label>
        <form:input class="form-control" path="firstName" placeholder="First Name"/>
        <form:errors path="firstName" cssClass="bg-danger"/>
    </div>
    <div class="infoform-group">
        <label for="lastName">LastName</label>
        <form:input class="form-control" path="lastName" placeholder="Last Name"/>
        <form:errors path="lastName" cssClass="bg-danger"/>
    </div>
    <div class="infoform-group">
        <label for="email">Email</label>
        <form:input class="form-control" path="email" placeholder="Email"/>
        <form:errors path="email" cssClass="bg-danger"/>
    </div>
    <div class="infoform-group">
        <label for="photoContainer">Photo</label>
        <input type="file" class="form-control" id="photoContainer" name="photoContainer" />
    </div>
    <div class="infoform-group">
        <label for="goal" class="goalLabel">Goal</label>
        <form:textarea class="form-control" rows="10" path="goal" placeholder="Tell us more about your workout goals..."></form:textarea>
    </div>


<div class="text-center btnDiv">
    <button type="submit" class="infobtn btn-default">Create Profile</button>
</div>
</form:form>
</div>
</body>
<%@ include file="common/footer.jspf" %>