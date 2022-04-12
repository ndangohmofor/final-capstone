<%@ include file = "common/header.jspf" %>

<section>
<h2>Check out of your workout session: </h2>
<h4>You are currently checked into a workout session. Please click the below button to check out.</h4>
<c:url value="/checkout" var="checkout"/>
<form action="${checkout}" method="POST">
    <input type="submit" id="checkout" name="checkout" value="Check Out">
    <input type="hidden" id="checkinID" name="checkinID" value="${checkin.id}">
    <input type="hidden" id="checkin" name="checkin" value="${checkin}">
</form>
</section>
<section id="visit-metrics-section">
    <h3 id="visit-metrics-heading">Visit Metrics:</h3>
    <div id="first-joined">
        <div>
            <c:out value="Time since you first joined: ${checkinLog.years} years, ${checkinLog.months} months, and ${checkinLog.days} days!"/>
            <br/>
        </div>
    </div>
    <div id="avg-workout">
        <span><h3 class="text-success"><c:out value="${hours}"/></h3><c:out value=" hour(s)."/></span><br/>
        <span><h3 class="text-success"><c:out value="${minutes}"/></h3><c:out value=" minutes(s)."/></span>
    </div>
</section>

<%@ include file = "common/footer.jspf" %>