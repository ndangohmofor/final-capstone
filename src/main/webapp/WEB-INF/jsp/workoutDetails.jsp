<%@ include file="common/header.jspf" %>


<div class="container">
    <h2>Welcome to the Workout Planner!</h2>
    <div class="col-lg-12">
        <aside class="workoutSchedules">
            <section>
                <h4 class="workout-header">Class Details</h4>
                <table class="table">
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
                        <td><c:out value="${workout.date}"/></td>
                        <td><c:out value="${workout.instructor}"/></td>
                        <td><c:out value="${workout.duration_minutes} mins"/></td>
                        <td><a href="workoutSignUp?workoutId=${workout.id}">Sign Me Up</a></td>
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