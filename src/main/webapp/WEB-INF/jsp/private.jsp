<%@ include file = "common/header.jspf" %>

<div class="container">
    <div class="row">
        <h1>Welomce to the Private Page!</h1>
        <h4>You have successfully logged in.</h4>
        <p>User: ${user.capitalizedUsername}</p>
        <p>Role: ${user.role.toUpperCase()}</p>
    </div>
</div>
<%@ include file = "common/footer.jspf" %>
