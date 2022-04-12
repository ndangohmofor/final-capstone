
<%@ include file="common/header.jspf" %>

<div id="homeBackground">

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
                    <img class="first-slide" src="${pageContext.request.contextPath}/img/gymsocial.jpg" alt="First slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <c:url var="about" value="/about"/>
                            <h1 class="carouselTitle">About Us</h1>
                            <h4 class="carouselText">Learn more about our mission to increase productivity in the gym.</h4>
                            <p><a class="btn btn-lg btn-success" href="${about}" role="button">Learn More</a></p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="second-slide" src="${pageContext.request.contextPath}/img/stationarybike.png" alt="Second slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <c:url value="/register" var="register"/>
                            <h1 class="carouselTitle">Join the fun</h1>
                            <h4 class="carouselText">Sign up today and start your workout journey with us!</h4>
                            <p><a class="btn btn-lg btn-success " href="${register}" role="button">Register</a></p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="third-slide" src="${pageContext.request.contextPath}/img/gyms-with-turf-social.jpg" alt="Third slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1 class="carouselTitle">Meet with a trainer today.</h1>
                            <h4 class="carouselText">Get a free training session when you inquire about our training options. We guarantee to find a plan that works for you!</h4>
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

    <div class="col-lg-12"  id="calendar">
        <aside class="workoutSchedules">
            <section>
                <a name="upcomingClasses"></a>
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
                            <td><c:out value="${workout.date.toLocalDate()} ${workout.date.toLocalTime()}" /></td>
                            <td><c:out value="${workout.durationMinutes} mins" /></td>
                            <td><a href="workoutDetails?workoutId=${workout.id}">Further Details</a></td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <th scope="row" rowspan="4"><a href="allWorkoutClasses">View all classes</a></th>
                    </tr>
                    </tbody>
                </table>
            </section>
        </aside>
    </div>
</div>

<div id="features">
<h1 class="h1index">Features</h1>

<div class="row container">
    <div class="col-sm-3 col-md-3">
        <div class="thumbnail">
            <img class="thumbnail-pic" src="${pageContext.request.contextPath}/img/bikess.png" alt="...">
            <div class="caption">
                <c:url value="/checkin" var="checkin"/>
                <h3>Easy Tracking</h3>
                <p class="thumbnailboxsize">Record your workout session through our easy one-click checkin and checkout process.</p>
                <p><a href="${checkin}" class="btn btn-success" role="button">Checkin</a></p>
            </div>
        </div>
    </div>
    <div class="col-sm-3 col-md-3">
        <div class="thumbnail">
            <c:url var="runner" value="/img/runner.png"/>
            <img class="thumbnail-pic2" src="${runner}" alt="...">
            <div class="caption">
                <c:url var="workoutlog" value="/exerciseLog"/>
                <h3>Endurance</h3>
                <p class="thumbnailboxsize">Keep track of your goals by using our workout log.</p>
                <p><a href="${workoutlog}" class="btn btn-success" role="button">Log your workout</a></p>
            </div>
        </div>
    </div>
    <div class="col-sm-3 col-md-3">
        <div class="thumbnail">
            <img class="thumbnail-pic" src="${pageContext.request.contextPath}/img/lifting.png" alt="...">
            <div class="caption">
                <c:url value="/viewMachineInfo" var="machineInfo"/>
                <h3>Companion</h3>
                <p class="thumbnailboxsize">We offer training on our workout machines to guide you through the proper techniques on perfecting your form. </p>
                <p><a href="${machineInfo}" class="btn btn-success" role="button">Machine Guides</a></p>
            </div>
        </div>
    </div>
    <div class="col-sm-3 col-md-3">
        <div class="thumbnail">
            <c:url var="yoga" value="/img/yoga.jpg"/>
            <img class="thumbnail-pic2" src="${yoga}" alt="...">
            <div class="caption">
                <h3>Classes</h3>
                <p class="thumbnailboxsize">Try any class you want, then another . . . and another. All classes are complimentary to you.</p>
                <c:url var="viewAllClassesUrl" value="/allWorkoutClasses"/>
                <p><a href="${viewAllClassesUrl}" class="btn btn-success" role="button">View Classes</a></p>
            </div>
        </div>
    </div>
</div>

    <br/>
    <br/>

    <div id="amenities">
        <h1 class="h1index">Amenities</h1>
    <div class="media amenitymedia amenityrightmargin">
        <div class="media-left">
                <img class="amenitiespics" src="${pageContext.request.contextPath}/img/amenityyoga.jpg" alt="Picture of lady doing yoga.">
        </div>
        <div class="media-body mediacolor">
            <h4 class="media-heading">Yoga Retreats</h4>
            <p class="amenitytext">Find your zen through our annual Yoga retreat in the Himalayas led by John C.<br/>
            Many of our attendees describe the experience as eye opening and attend every year.<br/>
            </p>
        </div>
    </div>
        <div class="media amenitymedia amenityrightmargin">
            <div class="media-body mediacolor">
                <h4 class="media-heading">Personal Training</h4>
                <p class="amenitytext">Meeting with our world-class trainers to help you meet your personal fitness goals.<br/>
                <br/>
                </p>
            </div>
            <div class="media-right">
                <img class="amenitiespics" src="${pageContext.request.contextPath}/img/personaltrainer-carousel.jpg" alt="Picture of personal trainer.">
            </div>
        </div>
        <div class="media amenitymedia amenityrightmargin">
            <div class="media-left">
                <img class="amenitiespics" src="${pageContext.request.contextPath}/img/water-sport.jpg" alt="Picture of swimmer in swimming pool.">
            </div>
            <div class="media-body mediacolor">
                <h4 class="media-heading">Olympics Size Pool</h4>
                <p class="amenitytext">Get your cardio in by swimming in our olympics size pool.We also have varying diving board heights.<br/>
                At the end of your swim, rinse off and then relax in our sauna rooms.<br/>
                </p>
            </div>
        </div>
        <div class="media amenitymedia amenityrightmargin">
            <div class="media-body mediacolor">
                <h4 class="media-heading">Modern Facilities</h4>
                <p class="amenitytext">Say goodbye to the old gym changing room experience. Our modern rooms will make you feel like you are at a 5-star hotel.<br/>
                <br/>
                </p>
            </div>
            <div class="media-right">
                <img class="amenitiespics" src="${pageContext.request.contextPath}/img/gym-changing-room.jpg" alt="Picture of personal trainer.">
            </div>
        </div>
    </div>


</div>

</div>
<%@ include file="common/footer.jspf" %>