<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="common/header.jspf" %>

<body>
<div>

    <h2 class="profile-header">Workout Log</h2>

    <div class="form-container">
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
                    <td><c:out value="${displayLog.date.toLocalDate()} ${displayLog.date.toLocalTime().withNano(0)}"/></td>
                    <td><c:out value="${displayLog.duration}"/></td>
                    <td><c:out value="${displayLog.weight}"/></td>
                    <td><c:out value="${displayLog.reps}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <c:url var="exerciseInputUrl" value="/exerciseInputForm"/>
    <form action="${exerciseInputUrl}" method="get">
        <button class="btn btn-success" type="submit"><a href="${exerciseInputUrl}"></a>Add WorkOut</button>
    </form>
</div>

</body>


<%@ include file="common/footer.jspf" %>

