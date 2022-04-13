<%@ include file = "common/header.jspf" %>

<div class="container">
    <h2>My Classes:</h2>
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
                            <td><a href="cancelWorkout?workoutId=${workout.id}" class="btn btn-danger">Cancel Reservation</a></td>
                        </tr>
                        <tr>
                            <th>Description:</th>
                            <td colspan="4"><c:out value="${workout.description}" /></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <a href="allWorkoutClasses" name="cancel" class="btn btn-primary">Return</a>
            </section>
        </aside>
    </div>
</div>

<%@ include file = "common/footer.jspf" %>