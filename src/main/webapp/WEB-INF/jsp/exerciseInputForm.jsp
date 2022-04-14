<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>

<body>
<h2 class="profile-header">Workout Log</h2>

<c:url var="exerciseFormUrl" value="/exerciseInputForm"/>
<form:form action="${exerciseFormUrl}" method="POST" modelAttribute="log">
    <div class="container">
        <div class="form-group">
            <label for="machineId">Machines</label>
            <form:select id="machineId" path="machineId" class="form-control">
                <option value="1">TreadMill</option>
                <option value="2">Stationary Bike</option>
                <option value="3">Row Machine</option>
                <option value="4">Elliptical</option>
                <option value="5">Stairmaster</option>
                <option value="6">Leg Press</option>
                <option value="7">Chest Press</option>
                <option value="8">Smith Machine</option>
                <option value="9">Leg Curl</option>
                <option value="10">Bench Press</option>
            </form:select>
            <form:errors path="machineId" cssClass="bg-danger"/>
        </div>
        <div class="form-group">
            <label for="duration">Duration (min)</label>
            <form:input type="text" path="duration" id="duration" value="0" class="form-control"/>
            <form:errors path="duration" cssClass="bg-danger"/>
        </div>
        <div class="form-group">
            <label for="weight">Weight (lbs)</label>
            <form:input type="text" path="weight" id="weight" value="0" class="form-control"/>
            <form:errors path="weight" cssClass="bg-danger"/>
        </div>
        <div class="form-group">
            <label for="reps">Reps</label>
            <form:input type="text" path="reps" id="reps" value="0" class="form-control"/>
            <form:errors path="reps" cssClass="bg-danger"/>
        </div>
        <button type="submit" class="btn btn-primary">Add Workout</button>
    </div>
</form:form>


</body>


<%@ include file="common/footer.jspf" %>

