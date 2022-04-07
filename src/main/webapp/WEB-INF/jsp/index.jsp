
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
<%--<div id="carousel">
    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="..." class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="..." class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="..." class="d-block w-100" alt="...">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>--%>

<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active" >
            <svg width="100%" height="100%" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
            <image href="${pageContext.request.contextPath}/img/benchpress.png" width="100%" height="100%" aria-hidden="true">
<%--            <div class="carousel-caption">
                ...
            </div>--%>
            </svg>
        </div>
        <div class="item">
            <svg width="100%" height="100%" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
            <image href ="${pageContext.request.contextPath}/img/rowingmachine.png" width="100%" height="100%" aria-hidden="true">
<%--            <div class="carousel-caption">
                ...
            </div>--%>
            </svg>
        </div>
        ...
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<%@ include file="common/footer.jspf" %>