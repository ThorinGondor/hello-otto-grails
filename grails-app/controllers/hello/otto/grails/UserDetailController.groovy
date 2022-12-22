package hello.otto.grails

import grails.validation.ValidationException

import javax.validation.constraints.NotNull

import static org.springframework.http.HttpStatus.*

class UserDetailController {

    UserDetailService userDetailService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond userDetailService.list(params), model:[userDetailCount: userDetailService.count()]
    }

    // http://localhost:port/userDetail/show?id=2
    def show(Long id) {
        List<UserDetail> list = findAllByTeam("Warriors")
        list.forEach {instance -> {
            println("instance.userId: " + instance.userId)
        }}
        respond userDetailService.get(id)
    }

    // http://localhost:port/userDetail/findAllByTeam?team=Warriors
    def findAllByTeam(String team) {
        println("findAllByTeam ===> ${team}" )
        return UserDetail.findAllByTeam(team)
    }

    // http://localhost:7950/userDetail/findByWhere?teamParam=Warriors
    // where 条件查询 非常灵活
    def findByWhere(String teamParam) {
        println("findByWhere ===> ${teamParam}" )
        def query = UserDetail.where {
            team == teamParam
        }
        UserDetail result = query.find()
        println("findByWhere result ===> ${result.profession} ${result.district}" )

        query = UserDetail.where {
            year(insertTime) == 2021
        }
        respond query.find()
    }

    // http://localhost:port/userDetail/findByCriteria?team=Ferrari&profession=Driver&idMin=0&idMax=100
    // 标准查询 criteria 重点
    def findByCriteria(@NotNull String team, @NotNull String profession, @NotNull Long idMin, @NotNull Long idMax) {
        def criteria = UserDetail.createCriteria()
        def results = criteria {
            between("id", idMin, idMax)
            eq("team", team)
            eq("profession", profession)
            maxResults(10)
            order("insertTime", "desc")
        }
        respond results
    }

    // 自定义 HQL 重要
    def myUpdate(Long id, String team) {
        Integer affectedRows = userDetailService.myUpdate(id, team)
        println("my update ===> ${affectedRows}")
        respond affectedRows
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
