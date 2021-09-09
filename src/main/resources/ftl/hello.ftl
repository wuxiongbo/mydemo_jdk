<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <title>FreeMarker示例</title>
    <#-- include包含指令 -->
    <#include "header.ftl"/>

    <meta name="Copyright" content="All Rights Reserved"/>
</head>

<body>

    <h1>${name},你好。${message}!</h1>

<#-- assign变量指令 -->
<#assign linkman="周先生"/>
联系人：${linkman}

<#assign info={"mobile":"15914264552",'address':'广州市天河区珠吉村'}/>
电话：${info.mobile}  地址：${info.address}

<#-- if条件指令 -->
<#if success>
    你已通过实名认证
<#else>
    你未通过实名认证
</#if>

<#-- list迭代指令 -->
<table border="1" width="300px">
    <tr>
        <th>索引号</th>
        <th>姓名</th>
        <th>年龄</th>
    </tr>
    <#list users as user>
        <tr>
            <td>${user_index + 1}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
        </tr>
    </#list>
</table>


</body>

</html>