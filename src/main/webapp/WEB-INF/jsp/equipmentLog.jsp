<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>

<body>
<div>

    <h2>Equipment Log</h2>

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
        <c:forEach var="displayLog" items="log">
            <tr>
                <td>${log.machineName}</td>
                <td>${log.date}</td>
                <td>${log.duration}</td>
                <td>${log.weight}</td>
                <td>${log.rep}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>

