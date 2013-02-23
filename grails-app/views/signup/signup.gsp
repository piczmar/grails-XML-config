<!doctype html>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>

	</head>
	<body>


    <h3>Sign Up</h3>

    <g:if test="${message}">
        <div>${message}</div>
    </g:if>

    <c:url value="/signup" var="signupUrl" />
    <form:form id="signup" action="${signupUrl}" method="post" modelAttribute="signupForm">


        <fieldset>
            <form:label path="firstName">First Name <form:errors path="firstName" cssClass="error" /></form:label>
            <form:input path="firstName" />
            <form:label path="lastName">Last Name <form:errors path="lastName" cssClass="error" /></form:label>
            <form:input path="lastName" />
            <form:label path="username">Username <form:errors path="username" cssClass="error" /></form:label>
            <form:input path="username" />
            <form:label path="password">Password (at least 6 characters) <form:errors path="password" cssClass="error" /></form:label>
            <form:password path="password" />
        </fieldset>
        <p><button type="submit">Sign Up</button></p>
    </form:form>
    </body>
</html>
