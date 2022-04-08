<%@ include file="common/header.jspf" %>


<c:url var="workOUtMetricsOfEmpUrl" value="/workOutMetricsOfEmp"/>
<form:form action="${workOUtMetricsOfEmpUrl}" method="POST">
    <div class="form-group">
        <label for="userId">UserId</label>
        <form:input class="form-control" id="userId" path="userId" placeholder="userId"/>
        <form:errors path="userId" cssClass="bg-danger"/>
    </div>

    <button type="submit" class="btn btn-default">Get User Workout Metrics</button>

</form:form>

    <%@ include file="common/footer.jspf" %>