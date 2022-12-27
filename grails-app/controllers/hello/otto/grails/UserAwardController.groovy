package hello.otto.grails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class UserAwardController {

    UserAwardService userAwardService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond userAwardService.list(params), model:[userAwardCount: userAwardService.count()]
    }

    def show(Long id) {
        respond userAwardService.get(id)
    }

    def create() {
        respond new UserAward(params)
    }

    def save(UserAward userAward) {
        if (userAward == null) {
            notFound()
            return
        }

        try {
            userAwardService.save(userAward)
        } catch (ValidationException e) {
            respond userAward.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'userAward.label', default: 'UserAward'), userAward.id])
                redirect userAward
            }
            '*' { respond userAward, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond userAwardService.get(id)
    }

    def update(UserAward userAward) {
        if (userAward == null) {
            notFound()
            return
        }

        try {
            userAwardService.save(userAward)
        } catch (ValidationException e) {
            respond userAward.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'userAward.label', default: 'UserAward'), userAward.id])
                redirect userAward
            }
            '*'{ respond userAward, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        userAwardService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'userAward.label', default: 'UserAward'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'userAward.label', default: 'UserAward'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
