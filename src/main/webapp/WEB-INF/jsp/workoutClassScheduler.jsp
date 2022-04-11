<%@ include file = "common/headerAdmin.jspf" %>

<div class="container">
    <h2>Upcoming Workout Classes</h2>
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
                        <th scope="row"><c:out value="${workout.className}"/></th>
                        <td><c:out value="${workout.date.toLocalDate()} ${workout.date.toLocalTime()}"/></td>
                        <td><c:out value="${workout.instructor}"/></td>
                        <td><c:out value="${workout.durationMinutes} mins"/></td>
                        <td><a href="workoutCancel?workoutId=${workout.id}">Cancel Class</a></td>
                    </tr>
                    <tr>
                        <th>Description:</th>
                        <td colspan="4"><c:out value="${workout.description}" /></td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <a href="index" name="cancel" class="btn btn-primary">Return</a>
            </section>
            <a href="addWorkoutClass" name="addWorkoutClass" class="btn btn-primary">Add Workout Class</a>
        </aside>
    </div>
</div>

<%@ include file = "common/footer.jspf" %>