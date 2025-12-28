<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Access Denied</title>
    <style>
        body { font-family: Arial; margin: 50px; background: #f5f5f5; }
        .container { max-width: 600px; margin: 0 auto; background: white; padding: 30px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); text-align: center; }
        .error-box { background: #f8d7da; color: #721c24; padding: 20px; border-radius: 4px; margin: 20px 0; border-left: 4px solid #dc3545; }
        a { display: inline-block; margin: 10px; padding: 10px 20px; background: #007bff; color: white; text-decoration: none; border-radius: 4px; }
        a:hover { background: #0056b3; }
    </style>
</head>
<body>
    <div class="container">
        <h2>🚫 Access Denied</h2>
        <div class="error-box">
            <h3>You don't have permission to access this page!</h3>
            <p>This page requires different user privileges.</p>
        </div>
        <a href="${pageContext.request.contextPath}/">Back to Home</a>
    </div>
</body>
</html>