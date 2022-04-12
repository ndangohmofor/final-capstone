<%@ include file="common/headerAdmin.jspf" %>


<div class="container">
    <h4>Confirm cancellation of this class</h4>
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
                            <c:url value="/workoutCancelProcess?workoutId=${workout.id}" var="cancelUrl"/>
                            <form action="${cancelUrl}" method="POST">
                                <button type="submit" name="workoutId" class="btn btn-danger">Cancel Workout</button>
                            </form>
                        </th>
                        <td><form>
                            <a href="scheduleClassAdmin" name="cancel" class="btn btn-primary">Return</a>
                        </form></td>
                    </tr>
                    </tbody>
                </table>
            </section>
        </aside>
    </div>
</div>

<%@ include file="common/footer.jspf" %>