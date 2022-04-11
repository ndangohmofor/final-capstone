<%@ include file="common/header.jspf" %>

<div>

    <h2>Workout Metrics</h2>

    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Check In</th>
            <th scope="col">Check Out</th>
            <th scope="col">Machine</th>
            <th scope="col">Weight</th>
            <th scope="col">Reps</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="displayLog" items="${log}">
            <tr>
                <td><c:out value="${displayLog.checkIn}"/></td>
                <td><c:out value="${displayLog.checkOut}"/></td>
                <td><c:out value="${displayLog.machineName}"/></td>
                <td><c:out value="${displayLog.weight}"/></td>
                <td><c:out value="${displayLog.reps}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    </form>
</div>

<%@ include file="common/footer.jspf" %>