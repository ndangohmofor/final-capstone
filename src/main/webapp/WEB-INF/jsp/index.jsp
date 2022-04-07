<%@ include file="common/header.jspf" %>


<div class="container">
    <h2>Welcome to the Workout Planner!</h2>
    <div class="col-lg-7">
        <img class="welcomeImg img-fluid" src="${pageContext.request.contextPath}/img/welcome.jpg"
             alt="Workout Planner Logo">
    </div>
    <div class="col-lg-5">
        <aside class="workoutSchedules">
            <section>
                <h4 class="workout-header">Upcoming Workout Classes</h4>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Date / Time</th>
                        <th scope="col">Duration</th>
                        <th scope="col">Details</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="workout" items="${workouts}">
                        <tr>
                            <th scope="row"><c:out value="${workout.className}" /></th>
                            <td><c:out value="${workout.date}" /></td>
                            <td><c:out value="${workout.duration_minutes} mins" /></td>
                            <td><a href="workoutDetails?workoutId=${workout.id}">Further Details</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </section>
        </aside>
    </div>
</div>

<%@ include file="common/footer.jspf" %>