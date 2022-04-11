<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="common/headerAdmin.jspf" %>


<div class="container">
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Machine Name</th>
                <th>Machine Type</th>
                <th>Machine Usage</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="types" items="${machines}">
                <tr>
                    <td>${machine.id}</td>
                    <td>${machine.machineName}</td>
                    <td>${machine.machineType}</td>
                    <td>${machine.machineUsage}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div>
        <form name="addMachine" method="POST" action="${addMachineURL}">
            <div class="form-group">
                <label for="machineName">Machine Name</label>
                <input type="text" name="machineName" class="form-control" id="machineName" placeholder="Machine Name">
            </div>
            <div class="form-group">
                <label for="machineType">Type of Machine</label>
                <select class="form-control" id="machineType" name="machineType">
                    <option name="cardio">Cardio</option>
                    <option name="weights">Weights</option>
                    <option name="benches">Benches</option>
                    <option name="Bars">Bars</option>
                    <option name="Balance">Balance Equipment</option>
                    <option name="Barbells">Barbells</option>
                    <option name="Dumbbells">Dumbbells</option>
                    <option name="Resistance">Resistance</option>
                    <option name="Strength">Strength</option>
                    <option name="Stretch">Stretching and Warmup</option>
                    <option name="squats">Squats</option>
                </select>
            </div>
            <div>
                <label for="machineReference">Reference</label>
                <input type="file" name="machineReference" class="form-control" id="machineReference">
            </div>
            <div>
                <button type="submit" class="btn btn-success" style="margin: 5px; float: right">Add Machine</button>
            </div>
        </form>
    </div>
</div>


<%@ include file="common/footer.jspf" %>