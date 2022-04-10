<%@ include file="common/headerAdmin.jspf" %>


<c:url var="workOutMetricsOfEmpUrl" value="/workOutMetricsOfEmp"/>
<form action="${workOutMetricsOfEmpUrl}" method="POST">
    <div class="form-group">
        <label for="userName">UserName</label>
        <input type="text" class="form-control" id="username" name="username" placeholder="Username">
    </div>

    <button type="submit" class="btn btn-default">Get User Workout Metrics</button>
</form>


<div>

    <h2>Workout Metrics</h2>

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
                <td><c:out value="${displayLog.machineName}"/></td>
                <td><c:out value="${displayLog.date}"/></td>
                <td><c:out value="${displayLog.duration}"/></td>
                <td><c:out value="${displayLog.weight}"/></td>
                <td><c:out value="${displayLog.reps}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


</div>

    <%@ include file="common/footer.jspf" %>