/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.showcase.signup;

import com.visitinfo.security.User;
import org.apache.log4j.Logger;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.showcase.account.AccountService;
import org.springframework.social.showcase.account.UsernameAlreadyInUseException;
import org.springframework.social.showcase.signin.SignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller
public class SignupController {
    @Inject
	public AccountService accountService;

    private static Logger logger = Logger.getLogger(SignupController.class);

	@RequestMapping(value="/signup.dispatch", method=RequestMethod.GET)
	public ModelAndView signupForm(WebRequest request) {
        System.out.println("SIGNUP(GET): request= "+request);
        logger.debug("SIGNUP(GET): request= "+request);
		Connection<?> connection = ProviderSignInUtils.getConnection(request);
        System.out.println("SIGNUP(GET): connection= "+connection);
        logger.debug("SIGNUP(GET): connection= "+connection);
		if (connection != null) {
			request.setAttribute("message","Your " + StringUtils.capitalize(connection.getKey().getProviderId()) + " account is not associated with a Spring Social Showcase account. If you're new, please sign up.", WebRequest.SCOPE_REQUEST);
			return new ModelAndView("/signup/signup","signupForm",SignupForm.fromProviderUser(connection.fetchUserProfile()));
		} else {
			return new ModelAndView("/signup/signup","signupForm",new SignupForm());
		}
	}

	@RequestMapping(value="/signup.dispatch", method=RequestMethod.POST)
	public String signup(@Valid SignupForm form, BindingResult formBinding, WebRequest request) {
        System.out.println("SIGNUP(POST)");
        logger.debug("SIGNUP(POST)");
		if (formBinding.hasErrors()) {
			return null;
		}
		User account = createAccount(form, formBinding);
		if (account != null) {
			SignInUtils.signin(account.getUsername());
			ProviderSignInUtils.handlePostSignUp(account.getUsername(), request);
			return "redirect:/";
		}
		return null;
	}

	// internal helpers
	
	private User createAccount(SignupForm form, BindingResult formBinding) {
		try {
            User account = new User();
            account.setUsername(form.getUsername());
            account.setPassword("DUMMY_NOT_BLANK");
            accountService.createAccount(account);
            return account;
		} catch (UsernameAlreadyInUseException e) {
			formBinding.rejectValue("username", "user.duplicateUsername", "already in use");
			return null;
		}
	}

}
