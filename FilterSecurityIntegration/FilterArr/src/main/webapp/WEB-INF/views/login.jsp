<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        body { font-family: Arial; margin: 50px; background: #f5f5f5; }
        .container { max-width: 400px; margin: 0 auto; background: white; padding: 30px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }
        input { width: 100%; padding: 12px; margin: 10px 0; border: 1px solid #ddd; border-radius: 4px; box-sizing: border-box; }
        button { width: 100%; padding: 12px; background: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; }
        button:hover { background: #0056b3; }
        .error { color: red; background: #ffe6e6; padding: 10px; border-radius: 4px; margin-bottom: 10px; }
        .test-creds { background: #e7f3ff; padding: 15px; border-radius: 4px; margin-top: 15px; font-size: 14px; }
        a { color: #007bff; text-decoration: none; }
    </style>
</head>
<body>
    <div class="container">
        <h2>🔐 Login</h2>
        <% if (request.getAttribute("error") != null) { %>
            <div class="error">${error}</div>
        <% } %>
        <form method="post" action="${pageContext.request.contextPath}/login">
            <input type="text" name="username" placeholder="Username" required />
            <input type="password" name="password" placeholder="Password" required />
            <button type="submit">Login</button>
        </form>
        <div class="test-creds">
            <strong>Test Credentials:</strong><br/>
            👤 User: user1 / password123<br/>
            👨‍💼 Admin: admin1 / admin123
        </div>
        <p style="text-align: center; margin-top: 20px;">
            <a href="${pageContext.request.contextPath}/">← Back to Home</a>
        </p>
    </div>
</body>
</html>