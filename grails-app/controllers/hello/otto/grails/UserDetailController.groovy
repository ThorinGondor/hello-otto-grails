package hello.otto.grails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class UserDetailController {

    UserDetailService userDetailService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond userDetailService.list(params), model:[userDetailCount: userDetailService.count()]
    }

    def show(Long id) {
        respond userDetailService.get(id)
    }

    def create() {
        respond new UserDetail(params)
    }

    def save(UserDetail userDetail) {
        if (userDetail == null) {
            notFound()
            return
        }

        try {
            userDetailService.save(userDetail)
        } catch (ValidationException e) {
            respond userDetail.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: '200', default: 'UserDetail'), userDetail.id])
                redirect userDetail
            }
            '*' { respond userDetail, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond userDetailService.get(id)
    }

    def update(UserDetail userDetail) {
        if (userDetail == null) {
            notFound()
            return
        }

        try {
            userDetailService.save(userDetail)
        } catch (ValidationException e) {
            respond userDetail.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: '200', default: 'UserDetail'), userDetail.id])
                redirect userDetail
            }
            '*'{ respond userDetail, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        userDetailService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: '200', default: 'UserDetail'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: '200', default: 'UserDetail'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
