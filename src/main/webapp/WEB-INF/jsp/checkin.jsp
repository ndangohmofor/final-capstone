<%@ include file = "common/header.jspf" %>


<div class="container">
    <div id="checkin-container">
<h3>Checkin to your workout session:</h3>
<c:url value="/checkin" var="checkin"/>
<form action="${checkin}" method="post" class="checkin-button">
    <input type="submit" id="checkin" name="checkin" value="Check In" class="btn btn-success">
</form>
        <h4 class="checkin-filler">Note: By clicking the check in button above you are agreeing to the collection of your workout data. Your data will not be shared for non-business purposes.</h4>
    </div>
    <section id="visit-metrics-section">
<h3 id="visit-metrics-heading">Visit Metrics:</h3>
<div id="first-joined">
    <div>
    <c:out value="Time since you first joined: ${checkinLog.years} years, ${checkinLog.months} months, and ${checkinLog.days} days!"/>
        <br/>
    </div>
</div>
        <div id="avg-workout">
            <h4 class="avg-workout-header">Average Workout:</h4>
    <span><h3 class="text-success"><c:out value="${hours}"/></h3><c:out value=" hour(s)."/></span><br/>
        <span><h3 class="text-success"><c:out value="${minutes}"/></h3><c:out value=" minute(s)."/></span>
        </div>
    </section>
</div>

<%@ include file = "common/footer.jspf" %>