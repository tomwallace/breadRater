package com.tomwallace.breadrater



import org.junit.*
import grails.test.mixin.*

@TestFor(LoafController)
@Mock(Loaf)
class LoafControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/loaf/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.loafInstanceList.size() == 0
        assert model.loafInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.loafInstance != null
    }

    void testSave() {
        controller.save()

        assert model.loafInstance != null
        assert view == '/loaf/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/loaf/show/1'
        assert controller.flash.message != null
        assert Loaf.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/loaf/list'


        populateValidParams(params)
        def loaf = new Loaf(params)

        assert loaf.save() != null

        params.id = loaf.id

        def model = controller.show()

        assert model.loafInstance == loaf
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/loaf/list'


        populateValidParams(params)
        def loaf = new Loaf(params)

        assert loaf.save() != null

        params.id = loaf.id

        def model = controller.edit()

        assert model.loafInstance == loaf
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/loaf/list'

        response.reset()


        populateValidParams(params)
        def loaf = new Loaf(params)

        assert loaf.save() != null

        // test invalid parameters in update
        params.id = loaf.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/loaf/edit"
        assert model.loafInstance != null

        loaf.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/loaf/show/$loaf.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        loaf.clearErrors()

        populateValidParams(params)
        params.id = loaf.id
        params.version = -1
        controller.update()

        assert view == "/loaf/edit"
        assert model.loafInstance != null
        assert model.loafInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/loaf/list'

        response.reset()

        populateValidParams(params)
        def loaf = new Loaf(params)

        assert loaf.save() != null
        assert Loaf.count() == 1

        params.id = loaf.id

        controller.delete()

        assert Loaf.count() == 0
        assert Loaf.get(loaf.id) == null
        assert response.redirectedUrl == '/loaf/list'
    }
}
