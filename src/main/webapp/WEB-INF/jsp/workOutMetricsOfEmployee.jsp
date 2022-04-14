<%@ include file="common/headerAdmin.jspf" %>

<div class="container">
<h2 class="profile-header">Workout Metrics</h2>

<c:url var="workOutMetricsOfEmpUrl" value="/workOutMetricsOfEmp"/>
<form action="${workOutMetricsOfEmpUrl}" method="POST">
    <div class="form-group">
        <label for="userName">Search Username</label>
        <input type="text" class="form-control" id="username" name="username" placeholder="Search By Username" />
    </div>
    <div>
        <button type="submit" class="btn btn-primary">Search</button>
    </div>
</form>
<br>
<div id="accordion">
    <c:forEach var="displayLog" items="${log}" varStatus="loop">
        <div class="card, form-container" style="margin:0px">
            <div class="card-header" id="headingOne">
                <div class="btn btn-link" data-toggle="collapse" data-target="#collapse_${loop.count}" aria-expanded="true" aria-controls="collapseOne">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th scope="col">Date: <c:out value="${displayLog.workOutDate}"/></th>
                            <th scope="col">Check In: <c:out value="${displayLog.gym_checkin.toLocalDate()} ${displayLog.gym_checkin.toLocalTime().withSecond(0).withNano(0)}"/></th>
                            <th scope="col">Check Out: <c:out value="${displayLog.gym_checkout.toLocalDate()} ${displayLog.gym_checkout.toLocalTime().withSecond(0).withNano(0)}"/></th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
            <div id="collapse_${loop.count}" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
                <div class="card-body">
                    <div>
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>Machine</th>
                                <th>Duration (min)</th>
                                <th>Weight (lbs)</th>
                                <th>Reps</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="displayEquipments" items="${displayLog.equipments}">
                                <tr>
                                    <td><c:out value="${displayEquipments.capitalizedMachineName}"/></td>
                                    <td><c:out value="${displayEquipments.duration}"/></td>
                                    <td><c:out value="${displayEquipments.weight}"/></td>
                                    <td><c:out value="${displayEquipments.reps}"/></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <br>
    </c:forEach>
</div>
</div>
    <%@ include file="common/footer.jspf" %>