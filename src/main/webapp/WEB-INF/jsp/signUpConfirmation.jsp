<%@ include file="common/header.jspf" %>



    <div class="jumbotron text-center">
        <h2 class="display-3">Your spot has been booked!!</h2>
        <p class="lead">Congratulations <strong><c:out value="${user.capitalizedUsername}" />,</strong> on holding your spot for <strong><c:out value="${workout.className}" />!</strong> We look forward to seeing you for the workout on <strong><c:out value="${workout.date.toLocalDate()}" /> </strong> at <strong><c:out value="${workout.date.toLocalTime()}" /> </strong>.</p>
        <p class="lead"><a class="btn btn-primary btn-sm" href="index">Continue to homepage</a></p>
    </div>


<%@ include file="common/footer.jspf" %>