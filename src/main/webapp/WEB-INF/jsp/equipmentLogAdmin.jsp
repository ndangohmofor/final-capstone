<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/headerAdmin.jspf" %>

<body>
<div class="container">

    <h2 class="profile-header">Workout Log</h2>
<c:url var="workoutLogAdminUrl" value="/workoutAdminSearch"/>
    <div>
        <form action="${workoutLogAdminUrl}" method="GET">
            <div>
                <label for="input">Search Username</label>
                <input type="text" placeholder="Search By Username" class="form-control" id="input" name="input"/>
            </div>
            <br>
            <div>
                <button type="submit" class="btn btn-primary">Search</button>
            </div>
        </form>
    </div>
    <br>

    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Machine</th>
            <th scope="col">Date</th>
            <th scope="col">Time</th>
            <th scope="col">Duration (min)</th>
            <th scope="col">Weight (lbs)</th>
            <th scope="col">Reps</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="displayLog" items="${log}">
            <tr>
                <td><c:out value="${displayLog.capitalizedMachineName}"/></td>
                <td><c:out value="${displayLog.date.toLocalDate()}"/></td>
                <td><c:out value="${displayLog.date.toLocalTime().withSecond(0).withNano(0)}"/></td>
                <td><c:out value="${displayLog.duration}"/></td>
                <td><c:out value="${displayLog.weight}"/></td>
                <td><c:out value="${displayLog.reps}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>


<%@ include file="common/footer.jspf" %>