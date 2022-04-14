<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>

<html>
<body class="profile-body">
<div class="container-lg">

    <div class="main-profile">
        <div class="row">
            <div class="col-md-3 mt-1">
                <div class="card-profile text-center sidebar">
                    <div class="card-body">
                        <c:url var="photoUrl" value="/profile/image?id=${profile.id}"/>
                        <img src="${photoUrl}" class="rounded-circle" width="300"/>
                    </div>
                    <div class="mt-3">
                        <h3>Hello! ${profile.firstName}</h3>
                    </div>
                </div>
            </div>

            <div class="col-md-8 mt-1">
                <div class="card-profile mb-3 content">
                    <h2 class="m-3 pt-3 profile-header">Profile</h2>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-3">
                                <h5>First Name</h5>
                            </div>
                            <div class="col-md-9 text-secondary">
                                <c:out value="${profile.firstName}"/>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-md-3">
                                <h5>Last Name</h5>
                            </div>
                            <div class="col-md-9 text-secondary">
                                <c:out value="${profile.lastName}"/>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-md-3">
                                <h5>Email</h5>
                            </div>
                            <div class="col-md-9 text-secondary">
                                <c:out value="${profile.email}"/>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-md-3">
                                <h5>Goal</h5>
                            </div>
                            <div class="col-md-9 text-secondary">
                                <c:out value="${profile.goal}"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-profile mb-3 content">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-3">
                                <c:url var="updateProfile" value="/updateProfile"/>
                                <li class="profile-link"><a href="${updateProfile}"/>Update Profile</li>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<%@ include file="common/footer.jspf" %>