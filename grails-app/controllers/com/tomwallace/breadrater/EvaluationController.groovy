package com.tomwallace.breadrater

class EvaluationController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [evaluationInstanceList: Evaluation.list(params), evaluationInstanceTotal: Evaluation.count()]
    }

    def create = {
        def evaluationInstance = new Evaluation()
        evaluationInstance.properties = params
        return [evaluationInstance: evaluationInstance]
    }

    def save = {
        def evaluationInstance = new Evaluation(params)
        if (evaluationInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'evaluation.label', default: 'Evaluation'), evaluationInstance.id])}"
            redirect(action: "show", id: evaluationInstance.id)
        }
        else {
            render(view: "create", model: [evaluationInstance: evaluationInstance])
        }
    }

    def show = {
        def evaluationInstance = Evaluation.get(params.id)
        if (!evaluationInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'evaluation.label', default: 'Evaluation'), params.id])}"
            redirect(action: "list")
        }
        else {
            [evaluationInstance: evaluationInstance]
        }
    }

    def edit = {
        def evaluationInstance = Evaluation.get(params.id)
        if (!evaluationInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'evaluation.label', default: 'Evaluation'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [evaluationInstance: evaluationInstance]
        }
    }

    def update = {
        def evaluationInstance = Evaluation.get(params.id)
        if (evaluationInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (evaluationInstance.version > version) {
                    
                    evaluationInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'evaluation.label', default: 'Evaluation')] as Object[], "Another user has updated this Evaluation while you were editing")
                    render(view: "edit", model: [evaluationInstance: evaluationInstance])
                    return
                }
            }
            evaluationInstance.properties = params
            if (!evaluationInstance.hasErrors() && evaluationInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'evaluation.label', default: 'Evaluation'), evaluationInstance.id])}"
                redirect(action: "show", id: evaluationInstance.id)
            }
            else {
                render(view: "edit", model: [evaluationInstance: evaluationInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'evaluation.label', default: 'Evaluation'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def evaluationInstance = Evaluation.get(params.id)
        if (evaluationInstance) {
            try {
                evaluationInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'evaluation.label', default: 'Evaluation'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'evaluation.label', default: 'Evaluation'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'evaluation.label', default: 'Evaluation'), params.id])}"
            redirect(action: "list")
        }
    }
}
