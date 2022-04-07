<%@ include file = "common/header.jspf" %>

<h2>Member Checkin/Checkout (for employee use only)</h2>
<br/>
<c:url value="/checkinOutAdmin" var="adminCheckInOut"/>
<form action="${adminCheckInOut}" method="POST">
    <label for="username">Member Username</label>
    <select id="username" name="username">
        <option value="">--Please choose a member--</option>
        <c:forEach items="${users}" var="user">
            <option value="${user.username}">${user.username}</option>
        </c:forEach>
    </select>
    <br/>
    <label for="checktype">Check In or Out?</label>
    <select id="checktype" name="checktype">
        <option value="">--Please choose an option--</option>
        <option value="checkin">Check In</option>
        <option value="checkout">Check Out</option>
    </select>
    <input type="submit" value="Submit">
</form>

<table>
    <thead>
    <tr>
        <th>Username</th>
        <th>Checkin</th>
        <th>Checkout</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.username}</td>
            <c:url value="/checkinOutAdmin" var="adminCheckInOut"/>
            <td>
                <form action="${adminCheckInOut}" method="POST">
                    <input type="submit" id="checkin" name="checkin" value="checkin">
                    <input type="hidden" name="username" value="${user.username}">
                    <input type="hidden" name="checktype" value="checkin">
                </form>
            </td>
            <td>
                <form action="${adminCheckInOut}" method="POST">
                    <input type="submit" id="checkout" name="checkout" value="checkout">
                    <input type="hidden" name="username" value="${user.username}">
                    <input type="hidden" name="checktype" value="checkout">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>



<%@ include file = "common/footer.jspf" %>