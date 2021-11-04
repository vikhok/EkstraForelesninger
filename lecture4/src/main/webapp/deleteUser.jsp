<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1>Delete user from the database by providing email:</h1>
<form action='ServletDeleteUser' method='POST'>
    <input type='email' name='email' placeholder='Email'/>
    <input type='submit'/>
</form>
</body>
</html>
