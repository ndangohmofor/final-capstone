<%@ include file="common/header.jspf" %>


<div class="container">
    <div class="col-lg-12">
        <aside class="workoutSchedules">
            <section>
                <h5 class="workout-header">Users enrolled in <c:out value="${workout.className}" />:</h5>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">UserName</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <th scope="row"><c:out value="${user.capitalizedUsername}"/></th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <a href="scheduleClassAdmin" class="btn btn-primary">Return</a>
                <a href="workoutCancelConfirmation?workoutId=${workout.id}" class="btn btn-primary">Proceed</a>
            </section>
        </aside>
    </div>
</div>

<%@ include file="common/footer.jspf" %>