package hello.otto.dto

class OttoResponse<T> {

    Integer code
    String message
    T data

    OttoResponse(Integer code, String msg) {
        this.code = code
        this.message = msg
    }

    OttoResponse(T data) {
        this.code = 200
        this.message = "成功"
        this.data = data
    }

    static constraints = {
        code nullable: false
        message nullable: false
    }
}
