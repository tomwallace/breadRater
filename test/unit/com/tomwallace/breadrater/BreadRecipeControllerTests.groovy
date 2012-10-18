package com.tomwallace.breadrater



import org.junit.*
import grails.test.mixin.*

@TestFor(BreadRecipeController)
@Mock(BreadRecipe)
class BreadRecipeControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/breadRecipe/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.breadRecipeInstanceList.size() == 0
        assert model.breadRecipeInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.breadRecipeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.breadRecipeInstance != null
        assert view == '/breadRecipe/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/breadRecipe/show/1'
        assert controller.flash.message != null
        assert BreadRecipe.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/breadRecipe/list'


        populateValidParams(params)
        def breadRecipe = new BreadRecipe(params)

        assert breadRecipe.save() != null

        params.id = breadRecipe.id

        def model = controller.show()

        assert model.breadRecipeInstance == breadRecipe
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/breadRecipe/list'


        populateValidParams(params)
        def breadRecipe = new BreadRecipe(params)

        assert breadRecipe.save() != null

        params.id = breadRecipe.id

        def model = controller.edit()

        assert model.breadRecipeInstance == breadRecipe
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/breadRecipe/list'

        response.reset()


        populateValidParams(params)
        def breadRecipe = new BreadRecipe(params)

        assert breadRecipe.save() != null

        // test invalid parameters in update
        params.id = breadRecipe.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/breadRecipe/edit"
        assert model.breadRecipeInstance != null

        breadRecipe.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/breadRecipe/show/$breadRecipe.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        breadRecipe.clearErrors()

        populateValidParams(params)
        params.id = breadRecipe.id
        params.version = -1
        controller.update()

        assert view == "/breadRecipe/edit"
        assert model.breadRecipeInstance != null
        assert model.breadRecipeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/breadRecipe/list'

        response.reset()

        populateValidParams(params)
        def breadRecipe = new BreadRecipe(params)

        assert breadRecipe.save() != null
        assert BreadRecipe.count() == 1

        params.id = breadRecipe.id

        controller.delete()

        assert BreadRecipe.count() == 0
        assert BreadRecipe.get(breadRecipe.id) == null
        assert response.redirectedUrl == '/breadRecipe/list'
    }
}
