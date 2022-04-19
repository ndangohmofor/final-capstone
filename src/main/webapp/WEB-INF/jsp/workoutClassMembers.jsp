<%@ include file="common/header.jspf" %>


<div class="container">
    <h2 style="text-align: center">Enrolled Users for <strong>${workout.className}</strong></h2>
    <div class="col-lg-12">
        <aside class="workoutSchedules">
            <section>
                <h5 class="workout-header">Enrolled Users</h5>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">UserName</th>
                        <%--<th scope="col">Date / Time</th>
                        <th scope="col">Instructor</th>
                        <th scope="col">Duration</th>
                        <th scope="col">Details</th>--%>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${users}" var="user">
                    <tr>
                        <th scope="row"><c:out value="${user.capitalizedUsername}"/></th>
<%--                        <td><c:out value="${workout.date.toLocalDate()} ${workout.date.toLocalTime()}"/></td>
                        <td><c:out value="${workout.instructor}"/></td>
                        <td><c:out value="${workout.durationMinutes} mins"/></td>
                        <td><a href="workoutSignUp?workoutId=${workout.id}" class="btn btn-primary">Sign Me Up</a></td>--%>
                    </tr>
                    </c:forEach>
<%--                    <tr>
                        <th>Description:</th>
                        <td colspan="4"><c:out value="${workout.description}" /></td>
                    </tr>--%>
                    </tbody>
                </table>
                <a href="scheduleClassAdmin" name="cancel" class="btn btn-primary">Return</a>
            </section>
        </aside>
    </div>
</div>

<%@ include file="common/footer.jspf" %>