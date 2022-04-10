<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>

<body>
<div>

    <h2>Workout Log</h2>

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
                <td><c:out value="${displayLog.weight}"/></td>git push
                <td><c:out value="${displayLog.reps}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <c:url var="exerciseInputUrl" value="/exerciseInput"/>
    <form action="${exerciseInputUrl}" method="get">
        <button class="btn btn-primary" type="submit"><a href="${exerciseInputUrl}"></a>Add WorkOut</button>
    </form>
</div>
</body>


<%@ include file="common/footer.jspf" %>

