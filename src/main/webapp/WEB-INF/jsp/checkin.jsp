<%@ include file = "common/header.jspf" %>

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
    <c:forEach items="${checkinLog}" var="item">
        <span><c:out value="${item.id}"/></span>
        <span><c:out value="${item.checkIn}"/></span>
        <span><c:out value="${item.checkOut}"/></span>
        <span><c:out value="${item.userId}"/></span>
        <br/>
    </c:forEach>
</div>

<%@ include file = "common/footer.jspf" %>