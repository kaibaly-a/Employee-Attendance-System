<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Mark Attendance</title>
</head>
<body>
    <h1 style="color:blue">Mark Attendance</h1>

    <form method="POST" action="mark">
        <table>
            <tr>
                <td>Employee Name:</td>
                <td><input type="text" name="employeeName" required/></td>
            </tr>
            <tr>
                <td>Department:</td>
                <td><input type="text" name="department" required/></td>
            </tr>
            <tr>
                <td>Date:</td>
                <td><input type="datetime-local" name="attendanceDate" required/></td>
            </tr>
            <tr>
                <td>Status:</td>
                <td>
                    <select name="status" required>
                        <option value="Present">Present</option>
                        <option value="Absent">Absent</option>
                        <option value="Leave">Leave</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Mark Attendance"/>
                </td>
            </tr>
        </table>
    </form>

    <br/>
    <a href="./">Home</a>
</body>
</html>

