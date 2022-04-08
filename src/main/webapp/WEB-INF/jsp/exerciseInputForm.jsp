<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>

<body>
<h2>Workout Log</h2>

<c:url var="exerciseFormUrl" value="/exerciseInput"/>
<form action="${exerciseFormUrl}" method="POST">
    <div class="mb-3">
        <label for=machineType>Workout Type</label>
        <select id="machineType" class="form-control" name="machineType">
            <option value="option" selected>Please Select workout type</option>
            <option value="cardio">Cardio</option>
            <option value="weights">Weights</option>
        </select>
    </div>
    <div class="mb-3">
        <label for="machineId">Machines</label>
        <select id="machineId" name="machineId" class="form-control">
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
        </select>
    </div>
    <div class="mb-3">
        <label for="duration">Duration</label>
        <input type="text" name="duration" id="duration" value="0" class="form-control">
    </div>
    <div class="mb-3">
        <label for="weight">Weight</label>
        <input type="text" name="weight" id="weight" value="0" class="form-control">
    </div>
    <div class="mb-3">
        <label for="reps">Reps</label>
        <input type="text" name="reps" id="reps" value="0" class="form-control">
    </div>

    <input type="submit" placeholder="Submit Exercise">
</form>


</body>


<%@ include file="common/footer.jspf" %>

