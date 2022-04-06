<%@ include file="common/header.jspf" %>


<div class="container">
    <h2>Welcome to the Workout Planner!</h2>
    <div class="col-lg-8">
        <img class="welcomeImg img-fluid" src="${pageContext.request.contextPath}/img/welcome.jpg"
             alt="Workout Planner Logo">
    </div>
    <div class="col-lg-4">
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
                            <th scope="row"><c:out value="${workout.className}" /></th>
                            <td><c:out value="${workout.date}" /></td>
                            <td><c:out value="${workout.instructor}" /></td>
                            <td><c:out value="${workout.duration_minutes}" /></td>
                            <td><a href="/workoutDetails">Further Details</a></td>
                        </tr>
                    </tbody>
                </table>
            </section>
        </aside>
    </div>
</div>

<%@ include file="common/footer.jspf" %>