import cosa.grails.DatoController

class UrlMappings {

	static mappings = {

		"/"(controller: "dato", action: "list")
        "/create"(controller: "dato", action: "create")
        "/list"(controller: "dato", action: "list")
        "/jsonList"(controller: "dato", action: "jsonList")
		"500"(view:'/error')
	}
}
