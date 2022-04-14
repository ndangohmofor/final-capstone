<%@ include file = "common/headerAdmin.jspf" %>

<div class="container">
<h2 class="profile-header">Member Checkin/Checkout</h2>
<br/>

<c:url var="viewUser" value="/checkinOutAdmin"/>
<form action="${viewUser}" method="GET">
    <label for="userName">Search by Username:</label>
    <input id="userName" name="userName">
    <input type="submit" class="btn btn-sm">
</form>


<table class="table table-striped">
    <thead>
    <tr>
        <th>Username</th>
        <th>Checkin/Checkout</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <c:if test="${user.role.equals('user')}">
        <tr>
            <td>${user.username}</td>
            <c:url value="/checkinOutAdmin" var="adminCheckInOut"/>
            <td>
                <c:choose>
                    <c:when test="${checkins.contains(user.id)}">
                        <form action="${adminCheckInOut}" method="POST">
                            <input type="submit" id="checkout" name="checkout" value="checkout" class="btn btn-sm">
                            <input type="hidden" name="username" value="${user.username}">
                            <input type="hidden" name="checktype" value="checkout">
                        </form>
                    </c:when>
                    <c:when test="${!checkins.contains(user.id)}">
                        <form action="${adminCheckInOut}" method="POST">
                            <input type="submit" id="checkin" name="checkin" value="checkin" class="btn loginbtn">
                            <input type="hidden" name="username" value="${user.username}">
                            <input type="hidden" name="checktype" value="checkin">
                        </form>
                    </c:when>
                </c:choose>
            </td>
        </tr>
        </c:if>
    </c:forEach>
    </tbody>
</table>
</div>


<%@ include file = "common/footer.jspf" %>