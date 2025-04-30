<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css" />
</head>
<body>

  <!-- Page Context Section -->
  <div class="page-context">
    <h1>Welcome Back!</h1>
    <p>Please log in to access your account. If you’re new here, feel free to register and join us.</p>
  </div>

  <!-- Login Form Section -->
  <div class="login-form">
    <h1>Login</h1>
    <div class="container">
      <div class="main">
        <div class="content">
          <h2>Log In</h2>
          <form action="" method="post">
            <input type="text" name="email" placeholder="User name" required autofocus>
            <input type="password" name="password" placeholder="User password" required>
            <button type="submit">Login</button>
          </form>
          <p class="account">Don't Have An Account? <a href="${pageContext.request.contextPath}/register">Register</a></p>
        </div>
        <div class="form-img">
          <img src="${pageContext.request.contextPath}/image/login.png" alt="Login Image">
        </div>
      </div>
    </div>
  </div>

</body>
</html>





