<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>

<%--<script>
    function changeType() {
        var status = document.getElementById("machineType");
        if (status.value === "option") {
            document.getElementById("weightType").style.visibility = "hidden";
            document.getElementById("cardioType").style.visibility = "hidden";
        }

        if (status.value === "cardio") {
            document.getElementById("cardioType").style.visibility = "visible";
        } else {
            document.getElementById("cardioType").style.visibility = "hidden";
        }
        if (status.value === "weights") {
            document.getElementById("weightType").style.visibility = "visible";
        } else {
            document.getElementById("weightType").style.visibility = "hidden";
        }
    }
</script>--%>

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
<%--    <div class="mb-3">
        <label for="date">Date</label>
        <input class="form-control" type="date" name="date" id="date">
    </div>--%>
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
        <input type="text" name="duration" id="duration" placeholder="if applicable" class="form-control">
    </div>
    <div class="mb-3">
        <label for="weight">Weight</label>
        <input type="text" name="weight" id="weight" placeholder="if applicable" class="form-control">
    </div>
    <div class="mb-3">
        <label for="reps">Reps</label>
        <input type="text" name="reps" id="reps" placeholder="if applicable" class="form-control">
    </div>
    <%--<div id="weightType" style="visibility: hidden">
        <div>
            <label for="weights">Machines</label>
            <select id="weights">
                <option value="leg press">Leg Press</option>
                <option value="chest press">Chest Press</option>
                <option value="smith">Smith Machine</option>
                <option value="leg curl">Leg Curl</option>
                <option value="bench press">Bench Press</option>
            </select>
        </div>
        <div>
            <label for="weight">Weight</label>
            <input type="text" name="weight" id="weight">
        </div>
        <div>
            <label for="reps"></label>
            <input type="text" name="reps" id="reps">
        </div>
        <div>
            <label for=""></label>
            <input type="text" name="" id="">
        </div>
    </div>--%>
    <input type="submit" placeholder="Submit Exercise">
</form>


</body>

