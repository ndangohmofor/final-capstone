<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>

<script>
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
</script>

<body>
<h2>Workout Log</h2>

<c:url var="exerciseFormUrl" value="/exerciseInput"/>
<form action="${exerciseFormUrl}" method="POST">
            <label for=machineType>Workout Type</label>
            <select id="machineType" onchange="changeType()">
                <option value="option" selected>Please Select workout type</option>
                <option value="cardio">Cardio</option>
                <option value="weights">Weights</option>
            </select>
        </td>
    </tr>
    <tr id="cardioType" style="visibility: hidden" \>
        <td>
            <label for="cardio">Machines</label>
            <select id="cardio">
                <option value="treadmill">TreadMill</option>
                <option value="stationary bike">Stationary Bike</option>
                <option value="row machine">Row Machine</option>
                <option value="elliptical">Elliptical</option>
                <option value="stairmaster">Stairmaster</option>
            </select>
        </td>
    </tr>
    <tr id="weightType" style="visibility: hidden">
        <td>
            <label for="weights">Machines</label>
            <select id="weights">
                <option value="leg press">Leg Press</option>
                <option value="chest press">Chest Press</option>
                <option value="smith">Smith Machine</option>
                <option value="leg curl">Leg Curl</option>
                <option value="bench press">Bench Press</option>
            </select>
</form>


</body>

