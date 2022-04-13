<%@ include file="common/headerAdmin.jspf" %>


<div class="jumbotron container-fluid">
    <h1 class="display-4">Welcome to the Workout Planner Admin Site!</h1>
    <p class="lead">This site is for Admin and Employees only. </p>
    <hr class="my-4">
    <p>Checkin members, view member logs and metrics, view machine metrics, schedule classes, and register users.</p>
</div>

<div class="container-fluid">

    <div class="col-lg-6">
        <img class="welcomeImg img-fluid thumbnail" src="${pageContext.request.contextPath}/img/welcome.jpg"
             alt="Workout Planner Logo">
    </div>

    <div class="col-lg-5">
        <aside>
            <section>

                <div class="media">
                    <h2>Admin Options:</h2>
                    <br/>
                    <div class="media-left media-middle">
                        <a href="#" class="btn btn-success btn-sm adminButtonMenu" role="button" aria-disabled="true">Member Checkin</a>
                    </div>
                    <div class="media-right">
                        <p>Check members in and out of their workout</p>
                    </div>
                    <br/>
                    <div class="media-left media-middle">
                        <a href="#" class="btn btn-success btn-sm adminButtonMenu" role="button" aria-disabled="true">Workout Metrics</a>
                    </div>
                    <div class="media-right">
                        <p>View member workouts per session</p>
                    </div>
                    <br/>
                    <div class="media-left media-middle">
                        <a href="#" class="btn btn-success btn-sm adminButtonMenu" role="button" aria-disabled="true">Workout Log</a>
                    </div>
                    <div class="media-right">
                        <p>View equipment log history for member</p>
                    </div>
                    <br/>
                    <div class="media-left media-middle">
                        <a href="#" class="btn btn-success btn-sm adminButtonMenu" role="button" aria-disabled="true">Schedule a Class</a>
                    </div>
                    <div class="media-right">
                        <p>Schedule or cancel classes</p>
                    </div>
                    <br/>
                    <div class="media-left media-middle">
                        <a href="#" class="btn btn-success btn-sm adminButtonMenu" role="button" aria-disabled="true">Machine Metrics</a>
                    </div>
                    <div class="media-right">
                        <p>Monitor machine usage and add new machines.</p>
                    </div>
                    <br/>
                    <div class="media-left media-middle">
                        <a href="#" class="btn btn-success btn-sm adminButtonMenu" role="button" aria-disabled="true">Register Users</a>
                    </div>
                    <div class="media-right">
                        <p>Register new users.</p>
                    </div>
                    <br/>
                </div>


               <%-- <h4 class="workout-header">Upcoming Workout Classes</h4>
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
                            <td><c:out value="${workout.durationMinutes} mins" /></td>
                            <td><a href="workoutDetails?workoutId=${workout.id}">Further Details</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>--%>
            </section>
        </aside>
    </div>
</div>

<%@ include file="common/footer.jspf" %>