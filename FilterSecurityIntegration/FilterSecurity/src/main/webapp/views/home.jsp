<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <style>
        body { font-family: Arial; margin: 50px; background: #f5f5f5; }
        .container { max-width: 600px; margin: 0 auto; background: white; padding: 30px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }
        h1 { color: #333; }
        a { display: inline-block; margin: 10px 5px; padding: 10px 20px; background: #007bff; color: white; text-decoration: none; border-radius: 4px; }
        a:hover { background: #0056b3; }
    </style>
</head>
<body>
    <div class="container">
        <h1>🏠 Welcome to Home Page</h1>
        <p>This page is <strong>publicly accessible</strong> - no login required!</p>
        <div>
            <a href="${pageContext.request.contextPath}/login">Login</a>
            <a href="${pageContext.request.contextPath}/user/profile">User Profile (Protected)</a>
            <a href="${pageContext.request.contextPath}/admin/dashboard">Admin Dashboard (Protected)</a>
        </div>
    </div>
</body>
</html>