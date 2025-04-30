<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css" />
</head>
<body>

<div class="form-container">
    <form action="register" method="post" class="registration-form">

        <h2>Registration Form</h2>

        <input type="text" name="name" placeholder="Name" required>

        <input type="email" name="email" placeholder="Email Address" required>

        <input type="text" name="country" placeholder="Country">

        <input type="text" name="phone" placeholder="Phone" required>

        <input type="password" name="password" placeholder="Password" required>

        <div class="checkbox-container">
            <input type="checkbox" required>
            <span>I agree to the terms and conditions</span>
        </div>

        <button type="submit">Create Account</button>

        <p class="signin-text">Already have an account? <a href="login.jsp">Sign in</a></p>
    </form>
</div>

</body>
</html>
    