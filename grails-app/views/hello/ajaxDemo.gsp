<!DOCTYPE html>

<html>
    <head>
        <meta name="layout" content="main" />
        <title>ajax demo</title>
        <style>
        .us {
            display: none;
            position: absolute;
            top: 30px;
            left: 30px;
            padding: 10px 20px;
            width: 100px;
            background: #B8E8D2;
            color: #333;
            border-radius: 4px;
            border: 1px solid #333;
            text-align: left;
        }
        </style>
    </head>
    <body>
        <div id="hint"><h4 style="color: #bd2130; line-height: 2em; padding: 5px">HINT</h4></div>
        <div class="us">提示内容！提示内容！提示内容！</div>
        <h4 style="color: #e83e8c; line-height: 2em; padding: 5px">n1: ${params.n1}</h4>
        <h4 style="color: #e83e8c; line-height: 2em; padding: 5px">n2: ${params.n2}</h4>
        <button onclick="synReq()" style="padding: 5px">request</button><br/>
        <h4 id="result" style="color: royalblue; line-height: 2em; padding: 5px"></h4>
        <script>
            // ajax 异步请求
            jQuery.get("${createLink(controller: "hello", action: "ajaxRequest", params: [p1: params.n1, p2: params.n2])}", function (data) {
                jQuery("#result").html(data)
            })

            function synReq() {
                jQuery.get("${createLink(controller: "hello", action: "ajaxRequest2", params: [p1: params.n1, p2: params.n2])}", function (data) {
                    jQuery("#result").html(data)
                })
            }

            $("#hint").mouseover(function () {
                $(".us").show();
            })
            $('#hint').mouseout(function () {
                $(".us").hide();
            })
        </script>
    </body>
</html>
