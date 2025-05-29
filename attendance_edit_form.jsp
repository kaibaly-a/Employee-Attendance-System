<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Edit Attendance</title>
</head>
<body>
    <h1 style="color:blue">Edit Attendance</h1>

    <form method="POST" action="${pageContext.request.contextPath}/edit">
    
        <input type="hidden" name="id" value="${attendance.id}"/>

        <table>
            <tr>
                <td>Employee Name:</td>
                <td>
                    <input type="text" name="employeeName" placeholder="Enter employee name" value="${attendance.employeeName}" required/>
                </td>
            </tr>

            <tr>
                <td>Department:</td>
                <td>
                    <input type="text" name="department" placeholder="Enter department" value="${attendance.department}" required/>
                </td>
            </tr>

            <tr>
                <td>Date:</td>
                <td>
                    <input type="datetime-local" name="attendanceDate" value="${attendance.attendanceDate}" required/>
                </td>
            </tr>

            <tr>
                <td>Status:</td>
                <td>
                    <select name="status" required>
                        <option value="">-- Select Status --</option>
                        <option value="Present" ${attendance.status == 'Present' ? 'selected' : ''}>Present</option>
                        <option value="Absent" ${attendance.status == 'Absent' ? 'selected' : ''}>Absent</option>
                        <option value="Leave" ${attendance.status == 'Leave' ? 'selected' : ''}>Leave</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="submit" value="Update Attendance"/>
                </td>
            </tr>
        </table>
    </form>

    <br/>
    <a href="${pageContext.request.contextPath}/">Home</a>
</body>
</html>
