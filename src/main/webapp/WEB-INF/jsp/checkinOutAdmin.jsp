<%@ include file = "common/header.jspf" %>

<c:url value="/checkinOutAdmin" var="adminCheckInOut"/>
<form action="${adminCheckInOut}" method="POST">
    <label for="username">Type the EXACT username</label>
    <input type="text" id="username" name="username">
    <br/>
    <label for="checktype">Check In or Out?</label>
    <select id="checktype" name="checktype">
        <option value="">--Please choose an option--</option>
        <option value="checkin">Check In</option>
        <option value="checkout">Check Out</option>
    </select>
    <input type="submit" value="Submit">
</form>

<%@ include file = "common/footer.jspf" %>