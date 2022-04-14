<%@ include file="common/headerAdmin.jspf" %>

<div class="container-fluid">
    <!-- Heading Row-->
    <div class="row gx-4 gx-lg-5 align-items-center my-5 checkin-button jumbotron">

        <div>
            <div class="col-lg-5"><img class="img-fluid rounded mb-4 mb-lg-0 adminLogo row" src="${pageContext.request.contextPath}/img/Logo.png" alt="Treadmill Image" /></div>
            <h1 class="font-weight-light">Workout Planner Admin Site</h1>
            <p>Welcome to the Workout Planner Admin Site! This site is for Admin and Employees only. Checkin members, view member logs and metrics, view machine metrics, schedule classes, and register users.</p>
        </div>
    </div>
    <br/>
    <!-- Call to Action-->
    <hr class="border border-primary"/>
    <br/>
    <!-- Content Row-->
    <div class="row gx-4 gx-lg-5">
        <div class="col-lg-2 mb-5">
            <div class="card h-100">
                <div class="card-body adminCard">
                    <h2 class="card-title">Member Checkin/Checkout</h2>
                    <p class="card-text">Check members in and out of their workout</p>
                </div>
                <c:url value="/checkinOutAdmin" var="checkin"/>
                <div class="card-footer"><a class="btn btn-primary btn-sm" href="${checkin}">Click Here</a></div>
            </div>
        </div>
        <div class="col-lg-2 mb-5">
            <div class="card h-100">
                <div class="card-body adminCard">
                    <h2 class="card-title">Workout Metrics</h2>
                    <p class="card-text">View member workouts per session</p>
                </div>
                <c:url var="metrics" value="/workOutMetricsOfEmp"/>
                <div class="card-footer"><a class="btn btn-primary btn-sm" href="${metrics}">Click Here</a></div>
            </div>
        </div>
        <div class="col-lg-2 mb-5 ">
            <div class="card h-100">
                <div class="card-body adminCard">
                    <h2 class="card-title">Workout Log</h2>
                    <p class="card-text">View equipment log history for member</p>
                </div>
                <c:url value="/workoutAdmin" var="workoutLog"/>
                <div class="card-footer"><a class="btn btn-primary btn-sm" href="${workoutLog}">Click Here</a></div>
            </div>
        </div>
        <div class="col-lg-2 mb-5">
            <div class="card h-100">
                <div class="card-body adminCard">
                    <h2 class="card-title">Schedule a Class</h2>
                    <p class="card-text">Schedule or cancel classes</p>
                </div>
                <c:url var="classes" value="/scheduleClassAdmin"/>
                <div class="card-footer"><a class="btn btn-primary btn-sm" href="${classes}">Click Here</a></div>
            </div>
        </div>
        <div class="col-lg-2 mb-5">
            <div class="card h-100">
                <div class="card-body adminCard">
                    <h2 class="card-title">Machine Metrics</h2>
                    <p class="card-text">Monitor machine usage and add new machines.</p>
                </div>
                <c:url value="/viewMachines" var="machines"/>
                <div class="card-footer"><a class="btn btn-primary btn-sm" href="${machines}">Click Here</a></div>
            </div>
        </div>
        <div class="col-lg-2 mb-5">
            <div class="card h-100">
                <div class="card-body adminCard">
                    <h2 class="card-title">Register Users</h2>
                    <p class="card-text">Register new users.</p>
                </div>
                <c:url value="/registerAdmin"  var="register"/>
                <div class="card-footer"><a class="btn btn-primary btn-sm" href="${register}">Click Here</a></div>
            </div>
        </div>
    </div>
</div>

<%@ include file="common/footer.jspf" %>