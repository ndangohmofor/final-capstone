<%@ include file = "common/header.jspf" %>

<c:url value="/checkin" var="checkin"/>
<form action="${checkin}" method="post">
    <input type="submit" id="checkin" name="checkin" value="Check In">
</form>

<%@ include file = "common/footer.jspf" %>