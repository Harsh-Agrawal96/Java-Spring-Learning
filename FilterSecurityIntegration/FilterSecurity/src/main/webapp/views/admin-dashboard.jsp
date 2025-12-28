<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body { font-family: Arial; margin: 50px; background: #f5f5f5; }
        .container { max-width: 600px; margin: 0 auto; background: white; padding: 30px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }
        .info-box { background: #d4edda; padding: 15px; border-radius: 4px; margin: 15px 0; border-left: 4px solid #28a745; }
        a { display: inline-block; margin: 10px 5px; padding: 10px 20px; background: #007bff; color: white; text-decoration: none; border-radius: 4px; }
        a:hover { background: #0056b3; }
        .logout { background: #dc3545; }
        .logout:hover { background: #c82333; }
    </style>
</head>
<body>
    <div class="container">
        <h2>👨‍💼 Admin Dashboard</h2>
        <div class="info-box">
            <p><strong>Username:</strong> ${user.username}</p>
            <p><strong>Role:</strong> ${user.role}</p>
            <p>✅ You have <strong>ADMIN</strong> privileges.</p>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/">Home</a>
            <a href="${pageContext.request.contextPath}/logout" class="logout">Logout</a>
        </div>
    </div>
</body>
</html>