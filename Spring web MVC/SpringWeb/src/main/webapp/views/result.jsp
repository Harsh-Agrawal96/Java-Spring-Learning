<%@page language="java" isELIgnored="false" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    </body>

        <!-- JSP (only use session when you are using session on the controller to pass the data -->
        <!-- <h2>Result is: <%= session.getAttribute("result") %> </h2> -->

        <!-- JSP Standard Library(JSTL) -->
        <!-- <h2>Result is: ${result} </h2> -->

        <h2> Welcome to platform </h2>
        <h2> Result is : ${alienData} </h2>

        <p> Welcome to the ${course} world </p>

    </body>
</html>