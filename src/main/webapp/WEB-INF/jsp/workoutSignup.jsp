<%@ include file="common/header.jspf" %>


<div class="container">
    <h4>Please Confirm Your SignUp for this Workout</h4>
    <div class="col-lg-6">
        <aside class="workoutSchedules">
            <section>
                <h4 class="workout-header">Class Details</h4>
                <table class="table confirmationTable table-striped">
                    <thead>
                    <tr>
                        <th scope="rowgroup">Class Name:</th>
                        <th scope="row"><c:out value="${workout.className}"/></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="rowgroup">Date & Time:</th>
                        <th scope="row"><c:out value="${workout.date.toLocalDate()} ${workout.date.toLocalTime()}"/></th>
                    </tr>
                    <tr>
                        <th scope="rowgroup">Class Duration:</th>
                        <th scope="row"><c:out value="${workout.durationMinutes} mins"/></th>
                    </tr>
                    <tr>
                        <th scope="rowgroup">Instructor:</th>
                        <th scope="row"><c:out value="${workout.instructor}"/></th>
                    </tr>
                    <tr>
                        <th>
                            <c:url value="/workoutSignUpProcess?workoutId=${workout.id}" var="signUpUrl"/>
                            <form action="${signUpUrl}" method="POST">
                                <button type="submit" name="workoutId" class="btn btn-primary">Sign Up</button>
                            </form>
                        </th>
                        <td><form>
                            <a href="workoutDetails?workoutId=${workout.id}" name="cancel" class="btn btn-primary">Cancel</a>
                        </form></td>
                    </tr>
                    </tbody>
                </table>
            </section>
        </aside>
    </div>
</div>

<%@ include file="common/footer.jspf" %>