<%@ include file = "common/header.jspf" %>


<div class="container">
    <div id="checkin-container">
<h2>Checkin to your workout session:</h2>
<c:url value="/checkin" var="checkin"/>
<form action="${checkin}" method="post">
    <input type="submit" id="checkin" name="checkin" value="Check In">
</form>
    </div>
<br/>
<br/>
<br/>
<br/>
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
</div>

<%@ include file = "common/footer.jspf" %>