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
    <h4 class="checkin-filler">Previous Visits:</h4>
    <div class="visit-div">
    <table class="visits-table table table-striped">
        <tbody>
        <c:forEach var="date" items="${dates}">
            <tr>
                <td>
                <c:out value="${date}"/><br/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
</div>
<section id="visit-metrics-section">
    <h3 id="visit-metrics-heading">Visit Metrics:</h3>
    <div id="first-joined">
        <div class="avg-workout">
            <h4 class="avg-workout-header">Time Since First Visit:</h4>
            <br/>
            <h4><span class="text-success h3"><c:out value="${checkinLog.years}"/></span><span class="text-muted"><c:out value=" year(s)."/></span></h4>
            <h4><span class="text-success h3"><c:out value="${checkinLog.months}"/></span><span class="text-muted"><c:out value=" month(s)."/></span></h4>
            <h4><span class="text-success h3"><c:out value="${checkinLog.days}"/></span><span class="text-muted"><c:out value=" day(s)."/></span></h4>
            <br/>
        </div>
    </div>
    <div class="avg-workout">
        <h4 class="avg-workout-header">Average Workout:</h4>
        <br/>
        <h4><span class="text-success h3"><c:out value="${hours}"/></span><span class="text-muted"><c:out value=" hour(s)."/></span></h4>
        <h4><span class="text-success h3"><c:out value="${minutes}"/></span><span class="text-muted"><c:out value=" minute(s)."/></span></h4>
    </div>
</section>
</div>
<%@ include file = "common/footer.jspf" %>