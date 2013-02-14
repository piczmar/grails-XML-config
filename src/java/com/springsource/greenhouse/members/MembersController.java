/*
 * Copyright 2010 the original author or authors.
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
package com.springsource.greenhouse.members;

import grails.custom.security.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

/**
 * UI Controllers for managing public member profiles.
 * @author Keith Donald
 * @author Craig Walls
 */
@Controller
@RequestMapping("/members")
public class MembersController {
	
	private final ProfileRepository profileRepository;

	@Inject
	public MembersController(ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}

	/**
	 * Write the currently signed-in member's profile to the response as JSON.
	 */
	@RequestMapping(value="/@self.dispatch", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody User profile(User account) {
		return profileRepository.findByAccountId(account.getId());
	}


}
