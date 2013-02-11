class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')

        "/mvc/test"(uri:"/mvc/test.dispatch")
        "/test"(controller: "test", action: "index")
        "/login"(view:'/login')
	}
}
