<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>

	</head>
	<body>
    <g:link url="j_spring_security_logout" >Logout</g:link>
    <form action="j_spring_security_check" method="post">
        <label for="j_username" >Login </label><input id="j_username" name="j_username" size="20" maxlength="50" type="text" /><br/>
        <label for="j_password" >Password </label><input id="j_password" name="j_password" size="20" maxlength="50" type="password" /><br/>
        <label for="_spring_security_remember_me" >Remember me?</label><input id="_spring_security_remember_me" name="_spring_security_remember_me" type="checkbox" value="true"/><br/>
        <input type="submit" value="Login" />
        <p>Some test user/password pairs you may use are:</p>
        <ul>
            <li>habuma/freebirds</li>
            <li>kdonald/melbourne</li>
            <li>rclarkson/atlanta</li>
        </ul>

        <p>Or you can <a href="<c:url value="/signup"/>">signup</a> with a new account.</p>
    </form>

    <h3>Sign in via a provider:</h3>
    <p>(Uses SocialAuthenticationFilter)</p>

    <!-- TWITTER SIGNIN -->
    <p><a href="<c:url value="/auth/twitter"/>"><img src="<c:url value="/resources/social/twitter/sign-in-with-twitter-d.png"/>" border="0"/></a></p>

    <!-- FACEBOOK SIGNIN -->
    <p><a href="<c:url value="/auth/facebook"/>"><img src="<c:url value="/resources/social/facebook/sign-in-with-facebook.png"/>" border="0"/></a><br/></p>

    <!-- LINKEDIN SIGNIN -->
    <p><a href="<c:url value="/auth/linkedin"/>">Sign In with LinkedIn</a><br/></p>

    </body>
</html>
