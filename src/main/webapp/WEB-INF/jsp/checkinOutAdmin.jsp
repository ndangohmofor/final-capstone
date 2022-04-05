<%@ include file = "common/header.jspf" %>

<c:url value="/checkinOutAdmin" var="adminCheckInOut"/>
<form action="${adminCheckInOut}" method="POST">
    <input type="text" id="username" name="username">
    <input type="datetime-local" id="checkin" name="checkin">
    <input type="datetime-local" id="checkout" name="checkout">
    <input type="submit" value="Submit">
</form>

<%@ include file = "common/footer.jspf" %>