<html>
<head>
    <title>Welcome!</title>
    <meta charset="UTF-8"/>
    <meta http-equiv="Content-Type" content="no-cache, no-store, must-revalidate"/>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no"/>

    <style type="text/css">
        @page {
            @top-center {
                content: element(header)
            }      /* Header */
            @bottom-center {
                content: element(footer)
            }   /* Enpied */
        }

        #header {
            position: running(header);
        }

        #footer {
            position: running(footer);
        }

        #pagenumber:before {
            content: counter(page);
        }

        #pagecount:before {
            content: counter(pages);
        }
    </style>
</head>


<body>

<div id="header">YOUR HEADER HERE</div>
<h3>基本信息</h3>
<table border="1">
    <tr>
        <td><b>姓名</b></td>
        <td>${name}</td>
    </tr>
    <tr>
        <td><b>age</b></td>
        <td>${age}</td>
    </tr>
    <tr>
        <td><b>birthday</b></td>
        <td>${(birthday?string("yyyy-MM-dd HH:mm:ss"))!}</td>
    </tr>
    <tr>
        <td><b>amount</b></td>
        <td>${amount}</td>
    </tr>
</table>

<h3>分数信息</h3>
<table border="1" cellspacing="0" cellpadding="0">
    <tr>
        <th>科目</th>
        <th>分数</th>
    </tr>
    <#list courseList as course>
        <tr>
            <td>${course.courseName}</td>
            <td>${course.score}</td>
        </tr>
    </#list>
</table>


<div id="footer">Page <span id="pagenumber"/> / <span id="pagecount"/></div>

</body>
</html>