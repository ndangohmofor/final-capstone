<%@ include file = "common/headerAdmin.jspf" %>

<div class="container">
    <h2 class="profile-header">Upcoming Workout Classes</h2>
    <div class="col-lg-12">
        <aside class="workoutSchedules">
            <section>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">Class Name</th>
                        <th scope="col">Date / Time</th>
                        <th scope="col">Instructor</th>
                        <th scope="col">Duration</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="workout" items="${workouts}">
                    <tr>
                        <th scope="row"><a class="btn-default btn" href="workoutClassMembers?workoutId=${workout.id}"><c:out value="${workout.className}"/></a></th>
                        <td><c:out value="${workout.date.toLocalDate()} ${workout.date.toLocalTime()}"/></td>
                        <td><c:out value="${workout.instructor}"/></td>
                        <td><c:out value="${workout.durationMinutes} mins"/></td>
                        <td><a href="workoutCancel?workoutId=${workout.id}" type="button" class="btn btn-danger">Cancel Class</a></td>
                    </tr>
                    <tr>
                        <th>Description:</th>
                        <td colspan="4"><c:out value="${workout.description}" /></td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <a href="index" name="cancel" class="btn btn-primary" style="margin: 5px">Return</a>
            </section>
            <a href="addWorkoutClass" name="addWorkoutClass" class="btn btn-primary"  style="margin: 5px">Add Workout Class</a>
        </aside>
    </div>
</div>

<%@ include file = "common/footer.jspf" %>