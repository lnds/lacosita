package cosa.grails



import org.junit.*
import grails.test.mixin.*

@TestFor(DatoController)
@Mock(Dato)
class DatoControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testCreate() {
        def model = controller.create()

        assert model.datoInstance != null
    }

}
