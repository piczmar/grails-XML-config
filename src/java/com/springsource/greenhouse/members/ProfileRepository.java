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

public interface ProfileRepository {

	/**
	 * Find a profile by it is id.
	 * The id may be the member's public username or their internal account id if no username is set.
	 */
	User findById(String profileId);

	/**
	 * Find a profile by the member's internal account identifier.
	 */
	User findByAccountId(Long accountId);


}