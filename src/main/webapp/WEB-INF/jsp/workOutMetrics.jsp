<%@ include file="common/header.jspf" %>

<div>

    <h2>Workout Metrics</h2>

    <c:forEach var="displayLog" items="${log}">
    <div style="width:90%;margin:auto;" >
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Date: <c:out value="${displayLog.workOutDate}"/></th>
                <th scope="col">Check In: <c:out value="${displayLog.gym_checkin.toLocalDate()} ${displayLog.gym_checkin.toLocalTime().withNano(0)}"/></th>
                <th scope="col">Check Out: <c:out value="${displayLog.gym_checkout.toLocalDate()} ${displayLog.gym_checkout.toLocalTime().withNano(0)}"/></th>
            </tr>
            </thead>
        </table>
    </div>
        <div style="width:80%;margin:auto;" class="form-container">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Machine</th>
                    <th>Weight</th>
                    <th>Reps</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="displayEquipments" items="${displayLog.equipments}">
                    <tr>
                        <td><c:out value="${displayEquipments.capitalizedMachineName}"/></td>
                        <td><c:out value="${displayEquipments.weight}"/></td>
                        <td><c:out value="${displayEquipments.reps}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <br>
    </c:forEach>

</div>

<%@ include file="common/footer.jspf" %>