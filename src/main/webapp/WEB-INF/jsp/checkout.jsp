<%@ include file = "common/header.jspf" %>

<c:url value="" var="checkout"/>
<form action="${checkout}" method="GET">
    <input type="submit" id="checkout" name="checkout" value="Check Out">
</form>

<%@ include file = "common/footer.jspf" %>