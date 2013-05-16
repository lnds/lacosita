import cosa.grails.DatoController

class UrlMappings {

	static mappings = {

		"/"(controller: "dato", action: "create")
        "/create"(controller: "dato", action: "create")
		"500"(view:'/error')
	}
}
