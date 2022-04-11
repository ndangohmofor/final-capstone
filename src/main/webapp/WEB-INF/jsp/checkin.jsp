<%@ include file = "common/header.jspf" %>


<div class="container">
    <div class="form-container">
<h2>Checkin to your workout session:</h2>
<c:url value="/checkin" var="checkin"/>
<form action="${checkin}" method="post">
    <input type="submit" id="checkin" name="checkin" value="Check In">
</form>
    </div>
<br/>
<br/>
<br/>
<br/>
<h3>Visit Metrics:</h3>
<div class="container">
    <%--<c:forEach items="${checkinLog}" var="item">
        <span><c:out value="${item.id}"/></span>
        <span><c:out value="${item.checkIn}"/></span>
        <span><c:out value="${item.checkOut}"/></span>
        <span><c:out value="${item.userId}"/></span>
        <br/>
    </c:forEach>--%>
    <c:out value="Time since you first joined: ${checkinLog.years} years, ${checkinLog.months} months, and ${checkinLog.days} days!"/>
        <br/>
<%--        <c:choose>
            <c:when test="${checkinLog < 365}">
                <span><c:out value="days!"/></span>
            </c:when>
            <c:otherwise>
                <span><c:out value="years!"/></span>
            </c:otherwise>
        </c:choose>--%>
        <c:out value="Average workout: ${avgTime}! "/>
</div>
</div>
<%@ include file = "common/footer.jspf" %>