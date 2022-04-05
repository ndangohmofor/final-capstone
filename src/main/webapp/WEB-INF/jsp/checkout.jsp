<%@ include file = "common/header.jspf" %>

<c:url value="/checkout" var="checkout"/>
<form action="${checkout}" method="POST">
    <input type="submit" id="checkout" name="checkout" value="Check Out">
    <input type="hidden" id="checkinID" name="checkinID" value="${checkin.id}">
</form>

<%@ include file = "common/footer.jspf" %>