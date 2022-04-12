<%@ include file="common/header.jspf" %>

<c:url var="loginUrl" value="/login"/>
<%--<form action="${loginUrl}" method="POST">
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" class="form-control" id="username" name="username" placeholder="Username">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password">
    </div>
    <button type="submit" class="btn btn-default">Login</button>
</form>--%>

<body class="login">
<div class="center">
    <h1>Login</h1>
    <form action="${loginUrl}" method="post">
        <div class="text-field">
            <input type="text" id="username" name="username">
            <span></span>
            <label for="username">Username</label>
        </div>
        <div class="text-field">
            <input type="password" id="password" name="password">
            <span></span>
            <label for="password">Password</label>
        </div>
        <div class="text-center btnDiv">
            <button type="submit" class="loginbtn btn-primary">Login</button>
        </div>
    </form>
</div>
</body>


<%@ include file="common/footer.jspf" %>