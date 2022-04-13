<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file = "common/headerAdmin.jspf" %>

<h1>Machine Metrics</h1>
<div class="container">
    <div class="row">
    <c:url var="viewMachineUrl" value="/viewMachines"/>
    <form action="${viewMachineUrl}" method="GET">
        <label for="machineName">Search by Name:</label>
        <input id="machineName" name="machineName">
        <input type="submit">
    </form>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Machine Name</th>
            <th>Machine Type</th>
            <th>Machine Usage(minutes)</th>
        </tr>
        </thead>
    <tbody>
    <c:forEach var="machine" items="${machines}">
        <tr>
            <td>${machine.id}</td>
            <td>${machine.machineName}</td>
            <td>${machine.machineType}</td>
            <td>${machine.machineUsage}</td>

        </tr>
    </c:forEach>
    </tbody>
    </table>
    <a href="addMachine" class="btn btn-primary" name="addMachine" id="addMachine">Add Machine</a>
    </div>
</div>
















<%@ include file = "common/footer.jspf" %>