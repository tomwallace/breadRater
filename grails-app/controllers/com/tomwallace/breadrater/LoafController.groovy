package com.tomwallace.breadrater

class LoafController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [loafInstanceList: Loaf.list(params), loafInstanceTotal: Loaf.count()]
    }

    def create = {
        def loafInstance = new Loaf()
        loafInstance.properties = params
        return [loafInstance: loafInstance]
    }

    def save = {
        def loafInstance = new Loaf(params)
        if (loafInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'loaf.label', default: 'Loaf'), loafInstance.id])}"
            redirect(action: "show", id: loafInstance.id)
        }
        else {
            render(view: "create", model: [loafInstance: loafInstance])
        }
    }

    def show = {
        def loafInstance = Loaf.get(params.id)
        if (!loafInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'loaf.label', default: 'Loaf'), params.id])}"
            redirect(action: "list")
        }
        else {
            [loafInstance: loafInstance]
        }
    }

    def edit = {
        def loafInstance = Loaf.get(params.id)
        if (!loafInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'loaf.label', default: 'Loaf'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [loafInstance: loafInstance]
        }
    }

    def update = {
        def loafInstance = Loaf.get(params.id)
        if (loafInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (loafInstance.version > version) {
                    
                    loafInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'loaf.label', default: 'Loaf')] as Object[], "Another user has updated this Loaf while you were editing")
                    render(view: "edit", model: [loafInstance: loafInstance])
                    return
                }
            }
            loafInstance.properties = params
            if (!loafInstance.hasErrors() && loafInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'loaf.label', default: 'Loaf'), loafInstance.id])}"
                redirect(action: "show", id: loafInstance.id)
            }
            else {
                render(view: "edit", model: [loafInstance: loafInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'loaf.label', default: 'Loaf'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def loafInstance = Loaf.get(params.id)
        if (loafInstance) {
            try {
                loafInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'loaf.label', default: 'Loaf'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'loaf.label', default: 'Loaf'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'loaf.label', default: 'Loaf'), params.id])}"
            redirect(action: "list")
        }
    }
}
