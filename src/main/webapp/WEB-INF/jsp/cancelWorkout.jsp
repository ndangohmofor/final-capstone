<%@ include file="common/header.jspf" %>


<div class="container">
    <h2>You Are About to Cancel You Workout Reservation!</h2>
    <h4>You will lose your spot and will need to do another reservation again (subject to availability) if you change your mind</h4>
    <div class="col-lg-12">
        <aside class="workoutSchedules">
            <section>
                <h4 class="workout-header">Class Details</h4>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">Class Name</th>
                        <th scope="col">Date / Time</th>
                        <th scope="col">Instructor</th>
                        <th scope="col">Duration</th>
                        <th scope="col">Details</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row"><c:out value="${workout.className}"/></th>
                        <td><c:out value="${workout.date.toLocalDate()} ${workout.date.toLocalTime()}"/></td>
                        <td><c:out value="${workout.instructor}"/></td>
                        <td><c:out value="${workout.durationMinutes} mins"/></td>
                        <td><a href="workoutDelete?workoutId=${workout.id}" class="btn btn-danger">Cancel My Reservation</a></td>
                    </tr>
                    <tr>
                        <th>Description:</th>
                        <td colspan="4"><c:out value="${workout.description}" /></td>
                    </tr>
                    </tbody>
                </table>
                <a href="index" name="cancel" class="btn btn-primary">Return</a>
            </section>
        </aside>
    </div>
</div>

<%@ include file="common/footer.jspf" %>