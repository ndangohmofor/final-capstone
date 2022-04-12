<%@ include file = "common/header.jspf" %>

<div class="container">
<div id="checkin-container">
<h3>Check out of your workout session: </h3>
<h4>You are currently checked into a workout session. Please click the below button to check out.</h4>
<c:url value="/checkout" var="checkout"/>
<form action="${checkout}" method="POST" class="checkin-button">
    <input type="submit" id="checkout" name="checkout" value="Check Out" class="btn btn-success">
    <input type="hidden" id="checkinID" name="checkinID" value="${checkin.id}">
    <input type="hidden" id="checkin" name="checkin" value="${checkin}">
</form>
    <h4 class="checkin-filler"></h4>
</div>
<section id="visit-metrics-section">
    <h3 id="visit-metrics-heading">Visit Metrics:</h3>
    <div id="first-joined">
        <div class="time-since">
            <c:out value="Time since your first session: ${checkinLog.years} years, ${checkinLog.months} months, and ${checkinLog.days} days!"/>
            <br/>
        </div>
    </div>
    <div id="avg-workout">
        <h4 class="avg-workout-header">Average Workout:</h4>
        <span><h3 class="text-success"><c:out value="${hours}"/></h3><c:out value=" hour(s)."/></span><br/>
        <span><h3 class="text-success"><c:out value="${minutes}"/></h3><c:out value=" minutes(s)."/></span>
    </div>
</section>
</div>
<%@ include file = "common/footer.jspf" %>