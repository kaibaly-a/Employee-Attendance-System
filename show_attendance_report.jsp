<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Attendance Report</title>
</head>
<body>
    <h1 style="color:blue">Employee Attendance Report</h1>

    <c:if test="${not empty resultMsg}">
        <h3 style="color:green">${resultMsg}</h3>
    </c:if>

    <table border="1" cellpadding="5">
        <tr style="background-color: #ddd;">
            
            <th>Employee Name</th>
            <th>Department</th>
            <th>Date</th>
            <th>Status</th>
            <th>Created By</th>
            <th>Updated By</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="att" items="${listRecords}">
            <tr>
                
                <td>${att.employeeName}</td>
                <td>${att.department}</td>
                <td>${att.attendanceDate}</td>
                <td>${att.status}</td>
                <td>${att.createdBy}</td>
                <td>${att.updatedBy}</td>
                <td>
                    <a href="edit?id=${att.id}">Edit</a> | 
                    <a href="delete?id=${att.id}" onclick="return confirm('Confirm delete?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <a href="mark">Mark New Attendance</a> | <a href="./">Home</a>
</body>
</html>