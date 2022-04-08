
<%@ include file="common/header.jspf" %>

<section>
    <div class="col-lg-12">
        <%-- <img class="welcomeImg img-fluid" src="${pageContext.request.contextPath}/img/welcome.jpg"
              alt="Workout Planner Logo">--%>
        <%--Carousel--%>
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1" class=""></li>
                <li data-target="#myCarousel" data-slide-to="2" class=""></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img class="first-slide" src="${pageContext.request.contextPath}/img/carousel.png" alt="First slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Example headline.</h1>
                            <p>Note: If you're viewing this page via a <code>file://</code> URL, the "next" and "previous" Glyphicon buttons on the left and right might not load/display properly due to web browser security rules.</p>
                            <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="second-slide" src="${pageContext.request.contextPath}/img/stationarybike.png" alt="Second slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Another example headline.</h1>
                            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                            <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="third-slide" src="${pageContext.request.contextPath}/img/rowingmachine.png" alt="Third slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>One more for good measure.</h1>
                            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                            <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
                        </div>
                    </div>
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <%--Carousel--%>

    </div>
</section>


<div class="container">

<%--Beginning of classes--%>

    <div class="col-lg-12">
        <aside class="workoutSchedules">
            <section>
                <h4 class="workout-header">Upcoming Workout Classes</h4>
                <table class="table table-striped">
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

<div class="row container">
    <div class="col-sm-3 col-md-3">
        <div class="thumbnail">
            <img class="thumbnail-pic" src="${pageContext.request.contextPath}/img/bikess.png" alt="...">
            <div class="caption">
                <h3>Cardio</h3>
                <p>...</p>
                <p><a href="register" class="btn btn-primary" role="button">Sign Up</a> <a href="about" class="btn btn-default" role="button">Learn more</a></p>
            </div>
        </div>
    </div>
    <div class="col-sm-3 col-md-3">
        <div class="thumbnail">
            <c:url var="runner" value="/img/runner.png"/>
            <img class="thumbnail-pic2" src="${runner}" alt="...">
            <div class="caption">
                <h3>Aerobics</h3>
                <p>...</p>

                <p><a href="register" class="btn btn-primary" role="button">Sign Up</a> <a href="about" class="btn btn-default" role="button">Learn more</a></p>
            </div>
        </div>
    </div>
    <div class="col-sm-3 col-md-3">
        <div class="thumbnail">
            <img class="thumbnail-pic" src="${pageContext.request.contextPath}/img/lifting.png" alt="...">
            <div class="caption">
                <h3>Weights</h3>
                <p>...</p>
                <p><a href="register" class="btn btn-primary" role="button">Sign Up</a> <a href="about" class="btn btn-default" role="button">Learn more</a></p>
            </div>
        </div>
    </div>
    <div class="col-sm-3 col-md-3">
        <div class="thumbnail">
            <c:url var="yoga" value="/img/yoga.jpg"/>
            <img class="thumbnail-pic2" src="${yoga}" alt="...">
            <div class="caption">
                <h3>Weights</h3>
                <p>...</p>
                <p><a href="register" class="btn btn-primary" role="button">Sign Up</a> <a href="about" class="btn btn-default" role="button">Learn more</a></p>
            </div>
        </div>
    </div>
</div>


<%@ include file="common/footer.jspf" %>