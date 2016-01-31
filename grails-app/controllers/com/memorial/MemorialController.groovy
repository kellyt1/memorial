package com.memorial

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MemorialController {
    static scaffold = Memorial
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Memorial.list(params), model:[memorialCount: Memorial.count()]
    }

    def show(Memorial memorial) {
        respond memorial
    }

    def create() {
        respond new Memorial(params)
    }

    @Transactional
    def save(Memorial memorial) {
        if (memorial == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (memorial.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond memorial.errors, view:'create'
            return
        }

        memorial.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'memorial.label', default: 'Memorial'), memorial.id])
                redirect memorial
            }
            '*' { respond memorial, [status: CREATED] }
        }
    }

    def edit(Memorial memorial) {
        respond memorial
    }

    @Transactional
    def update(Memorial memorial) {
        if (memorial == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (memorial.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond memorial.errors, view:'edit'
            return
        }

        memorial.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'memorial.label', default: 'Memorial'), memorial.id])
                redirect memorial
            }
            '*'{ respond memorial, [status: OK] }
        }
    }

    @Transactional
    def delete(Memorial memorial) {

        if (memorial == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        memorial.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'memorial.label', default: 'Memorial'), memorial.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'memorial.label', default: 'Memorial'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
