<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Test Form</title>
    <style>
        .error {
            color: #ff0000;
            font-weight: bold;
        }
    </style>
</head>
<body>

<form:form method="post" modelAttribute="testBean">
    <form:errors path="*" cssClass="error"/>
    <table>
        <tr>
            <td>field1</td>
            <td><form:input path="field1"/></td>
            <td><form:errors path="field1" cssClass="error"/></td>
        </tr>
        <tr>
            <td>field2</td>
            <td><form:input path="field2"/></td>
            <td><form:errors path="field2" cssClass="error"/></td>
        </tr>
        <tr>
            <td>field3</td>
            <td><form:input path="field3"/></td>
            <td><form:errors path="field3" cssClass="error"/></td>
        </tr>
        <tr>
            <td>field4</td>
            <td><form:input path="field4.field1"/></td>
            <td><form:errors path="field4.field1" cssClass="error"/></td>
        </tr>
        <tr>
            <td>field4</td>
            <td><form:input path="field4.field2"/></td>
            <td><form:errors path="field4.field2" cssClass="error"/></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit"/></td>
        </tr>
    </table>
</form:form>



</body>
</html>
