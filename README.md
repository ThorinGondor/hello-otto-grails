# Grails 使用指南
### 需要先启动 postgresql 服务，使用命令：
    service postgresql start
### 查看服务启动状态
    service postgresql status
### 欲使用 grails 命令，在 terminal 输入：
    source /etc/profile
### 创建一个 controller 控制器：
    grails create-controller hello
### 运行 grails 应用：
    grails run-app -port=7950
### 创建模型：
    grails create-domain-class Person
### 创建一个拦截器：
    grails create-interceptor OttoInterceptor
### postgresql 目前正在监听 192.168.0.107 如果您启动发现无法访问数据库那么一定是ip变了，请按照该链接修改数据库的 config
    https://www.easck.com/cos/2022/0528/956985.shtml