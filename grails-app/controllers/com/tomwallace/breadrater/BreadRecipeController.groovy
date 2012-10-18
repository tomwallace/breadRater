package com.tomwallace.breadrater

class BreadRecipeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [breadRecipeInstanceList: BreadRecipe.list(params), breadRecipeInstanceTotal: BreadRecipe.count()]
    }

    def create = {
        def breadRecipeInstance = new BreadRecipe()
        breadRecipeInstance.properties = params
        return [breadRecipeInstance: breadRecipeInstance]
    }

    def save = {
        def breadRecipeInstance = new BreadRecipe(params)
        if (breadRecipeInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'breadRecipe.label', default: 'BreadRecipe'), breadRecipeInstance.id])}"
            redirect(action: "show", id: breadRecipeInstance.id)
        }
        else {
            render(view: "create", model: [breadRecipeInstance: breadRecipeInstance])
        }
    }

    def show = {
        def breadRecipeInstance = BreadRecipe.get(params.id)
        if (!breadRecipeInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'breadRecipe.label', default: 'BreadRecipe'), params.id])}"
            redirect(action: "list")
        }
        else {
            [breadRecipeInstance: breadRecipeInstance]
        }
    }

    def edit = {
        def breadRecipeInstance = BreadRecipe.get(params.id)
        if (!breadRecipeInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'breadRecipe.label', default: 'BreadRecipe'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [breadRecipeInstance: breadRecipeInstance]
        }
    }

    def update = {
        def breadRecipeInstance = BreadRecipe.get(params.id)
        if (breadRecipeInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (breadRecipeInstance.version > version) {
                    
                    breadRecipeInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'breadRecipe.label', default: 'BreadRecipe')] as Object[], "Another user has updated this BreadRecipe while you were editing")
                    render(view: "edit", model: [breadRecipeInstance: breadRecipeInstance])
                    return
                }
            }
            breadRecipeInstance.properties = params
            if (!breadRecipeInstance.hasErrors() && breadRecipeInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'breadRecipe.label', default: 'BreadRecipe'), breadRecipeInstance.id])}"
                redirect(action: "show", id: breadRecipeInstance.id)
            }
            else {
                render(view: "edit", model: [breadRecipeInstance: breadRecipeInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'breadRecipe.label', default: 'BreadRecipe'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def breadRecipeInstance = BreadRecipe.get(params.id)
        if (breadRecipeInstance) {
            try {
                breadRecipeInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'breadRecipe.label', default: 'BreadRecipe'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'breadRecipe.label', default: 'BreadRecipe'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'breadRecipe.label', default: 'BreadRecipe'), params.id])}"
            redirect(action: "list")
        }
    }
}
