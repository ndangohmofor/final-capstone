<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/headerAdmin.jspf" %>

<body>
<div>

    <h2>Workout Log</h2>
<c:url var="workoutLogAdminUrl" value="/workoutAdminSearch"/>
    <div>
        <form action="${workoutLogAdminUrl}" method="GET">
            <div>
                <label for="input">Search Member</label>
                <input type="text" placeholder="Search By Last Name" class="form-control" id="input" name="input"/>
            </div>
            <div>
                <input type="submit" placeholder="Search"/>
            </div>
        </form>
    </div>

<%--    <c:out value="${message}"/>--%>

    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Machine</th>
            <th scope="col">Date</th>
            <th scope="col">Duration</th>
            <th scope="col">Weight</th>
            <th scope="col">Reps</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="displayLog" items="${log}">
            <tr>
                <td><c:out value="${displayLog.capitalizedMachineName}"/></td>
                <td><c:out value="${displayLog.date}"/></td>
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