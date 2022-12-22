package hello.otto.grails

import grails.gorm.DetachedCriteria

class UserDetail {

    Long id
    Long userId
    String team
    String district
    String language
    String profession
    Date insertTime
    Date update_time
    Boolean isDeleted

    static constraints = {
        id nullable: false
        userId nullable: false
        isDeleted nullable: false
    }

    // GORM 支持模型中为事件注册处理方法
    def onLoad() {
        println("Loading User id = ${id}")
    }

    def afterLoad() {
        println("User id = ${id} is loaded")
    }
}
