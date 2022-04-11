<%@ include file = "common/header.jspf" %>

<div class="container">
<h2>Checkin to your workout session:</h2>
<c:url value="/checkin" var="checkin"/>
<form action="${checkin}" method="post">
    <input type="submit" id="checkin" name="checkin" value="Check In">
</form>
<br/>
<br/>
<br/>
<br/>
<h3>Visit Metrics:</h3>
<div>
    <%--<c:forEach items="${checkinLog}" var="item">
        <span><c:out value="${item.id}"/></span>
        <span><c:out value="${item.checkIn}"/></span>
        <span><c:out value="${item.checkOut}"/></span>
        <span><c:out value="${item.userId}"/></span>
        <br/>
    </c:forEach>--%>
    <c:out value="Time since you first joined: ${checkinLog} "/>
        <c:choose>
            <c:when test="${checkinLog < 365}">
                <span><c:out value="days!"/></span>
            </c:when>
            <c:otherwise>
                <span><c:out value="years!"/></span>
            </c:otherwise>
        </c:choose>
</div>
</div>
<%@ include file = "common/footer.jspf" %>