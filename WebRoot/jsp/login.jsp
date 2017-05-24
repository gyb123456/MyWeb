<%@ page language="java" pageEncoding="UTF-8"%>
<html>
 <head>
    <title>用户登录页面</title>
 </head>
 
 <body>
  <h2>用户入口</h2>
  <hr>
  
  	 <form action="FirstController/login" method="post">
  	 	 springMVC的  FirstController/login方法接收
  		 <br/>
        用户名：<input type="text" name="userName"/><br/>  
        密码：<input type="password" name="password"/><br/>  
        <input type="submit" value="提交"/>  
    </form>
  
  
    <form action="manage/userLogin.action" method="post"><!-- manage/userOpt!login.action -->
     	strtus2 配置的LoginAction类的login方法接收
     	<br/>
     	因为这个项目用了SpringMVC框架，就不能用struts框架，所以把web.xml中关于struts的配置注释了，这个form就不能用了
    	<br/>
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
                 <input type="submit" value=" 确定 "/>
             </td>
         </tr>
    </table>
    </form>
    
    <form action="login" > <!-- method="post" -->
    	FirstServlet类的doGet会拦截
    	<br/>
	     username:<input type="text" name="username"><br>
	     password:<input type="password" name="password"><br>
   		 <input type="submit">
    </form>
    
    
    
 </body>
</html>