<%@ page language="java" pageEncoding="UTF-8"%>
<html>
 <head>
    <title>用户注册页面</title>
 </head>
 
 <body>
  <h2>用户注册</h2>
  <hr>
    <form action="manage/userOpt!regist.action" method="post">
    <table border="1">
         <tr>
             <td>用户名：</td>
             <td><input type="text" name="userName"/></td>
         </tr>
         <tr>
             <td>密码：</td>
             <td><input type="password" name="password"/></td>
         </tr>
         <tr>
             <td colspan="2">
                 <input type="submit" value=" 注册 "/>
             </td>
         </tr>
    </table>
    </form>
 </body>
</html>