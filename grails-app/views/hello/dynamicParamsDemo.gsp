<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>wind demo</title>
    </head>
    <body>
    <!-- 取 controller 函数输出的参数 -->
    <h3 style="color: #7abaff">${p_name}-${p_age}</h3>
    <br/>
    <!-- 当然，您也可以直接从 params 运行环境中取值-->
    <h3 style="color: #8fd19e">${params.name}-${params.age}</h3>
    </body>
</html>
