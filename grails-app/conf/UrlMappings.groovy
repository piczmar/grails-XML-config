class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')

        "/my/test"(uri:"/my/test.dispatch")
        "/mvc/test"(uri:"/mvc/test.dispatch")
        "/mvc/testJson"(uri:"/mvc/testJson.dispatch")

        "/test"(controller: "test", action: "index")
        "/signin"(view:'/signin')

        '/members/@self'(controller: 'members',action: 'profile')
//        '/members/@self'(uri: "/members/@self.dispatch")

        "/oauth/token"(uri:"/oauth/token.dispatch")
        "/oauth/authorize"(uri:"/oauth/authorize.dispatch")
        "/oauth/confirm_access"(uri:"/oauth/confirm_access.dispatch")
        "/oauth/error"(uri:"/oauth/error.dispatch")


	}
}
