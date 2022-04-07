<%@ include file = "common/header.jspf" %>

<h2>Check out of your workout session: </h2>
<h4>You are currently checked into a workout session. Please click the below button to check out.</h4>
<c:url value="/checkout" var="checkout"/>
<form action="${checkout}" method="POST">
    <input type="submit" id="checkout" name="checkout" value="Check Out">
    <input type="hidden" id="checkinID" name="checkinID" value="${checkin.id}">
    <input type="hidden" id="checkin" name="checkin" value="${checkin}">
</form>


<%@ include file = "common/footer.jspf" %>