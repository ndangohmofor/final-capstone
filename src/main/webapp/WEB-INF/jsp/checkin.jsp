<%@ include file = "common/header.jspf" %>

<h2>Checkin to your workout session:</h2>
<c:url value="/checkin" var="checkin"/>
<form action="${checkin}" method="post">
    <input type="submit" id="checkin" name="checkin" value="Check In">
</form>

<%@ include file = "common/footer.jspf" %>