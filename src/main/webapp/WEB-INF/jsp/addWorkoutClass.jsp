<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file = "common/headerAdmin.jspf" %>

<c:url var="addWorkoutClassUrl" value="/addWorkoutClass"/>
<form:form action="${addWorkoutClassUrl}" method="POST" modelAttribute="workout">
    <div class="form-group">
        <label for="className">Workout Class Name</label>
        <form:input class="form-control" path="className" placeholder="Class Name"/>
        <form:errors path="className" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="date">Class Time</label>
        <form:input type="datetime-local" class="form-control" path="date"/>
        <form:errors path="date" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="instructor">Instructor Name</label>
        <form:input class="form-control" path="instructor"/>
        <form:errors path="instructor" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="instructor">Description</label>
        <form:textarea cols="10" rows="15" maxlength="250" class="form-control" path="description"/>
        <form:errors path="description" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="durationMinutes">Duration (Minutes)</label>
        <form:input type="number" class="form-control" path="durationMinutes"/>
        <form:errors path="durationMinutes" cssClass="bg-danger"/>
    </div>
    <button type="submit" class="btn btn-default">Save</button>
</form:form>

<%@ include file = "common/footer.jspf" %>