<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 
	<link rel="stylesheet" href="plugin/bootstrap/css/bootstrap.min.css"/> 
	<link rel="stylesheet" href="plugin/Highcharts/highcharts.css"/> 
 
	
	<script type="text/javascript" src="plugin/jquery.min.js"></script>
	
	<script type="text/javascript" src="plugin/bootstrap/js/bootstrap.min.js"></script>
	<!-- pdf预览 -->
	<script type="text/javascript" src="plugin/PDFObject/pdfobject.js"></script>
	<!-- 复制 -->
	<script type="text/javascript" src="plugin/ZeroClipboard/ZeroClipboard.js"></script>
	<!-- 复制 -->
	<script type="text/javascript" src="plugin/clipboard.js/clipboard.js"></script>
	<!-- Highcharts图表-->
 	<script type="text/javascript" src="plugin/Highcharts/highcharts.js"></script>
 	
 	
 	<script type="text/javascript" src="index.js"></script>
 
	<style>
		.pdfobject-container { height: 500px;}
		.pdfobject { border: 1px solid #666; }
	</style>
  </head>
  
  <body>
	<div  class="alert alert-info" align="center" role="alert">
	   <h2>Welcome GYB Website</h2>
	</div>
	<!-- 
	<hr style="height:2px;border:none;border-top:2px groove skyblue;" />
	<hr style="height:5px;border:none;border-top:5px ridge green;" />
	<hr style=" height:2px;border:none;border-top:2px dotted #185598;" />
	 -->
	<!-- 
		height:2px;是hr的高度
		border:none;是没有边框
		border-top:2px dotted #185598;是设置横线的样式
		dotted  虚线  #185598  颜色
	 -->
	 <!-- 
	 <hr style="height:3px;border:none;border-top:3px double red;" />
	 <hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
	 <hr style="height:1px;border:none;border-top:1px solid #555555;" /> 
	 -->
    <div class="container-fluid">
	    <button class="btn btn-primary" onclick="preViewPDF()">用PDFObject预览PDF</button>
		<div id="pdfDiv"></div>
		<p class="bg-danger">
			说明：一般用PDFObject来解析pdf文件（还可预览pic、txt文件）。但是当浏览器不兼容时（如：IE、猎豹），它会调用下面这个按钮的功能<br/>
			下面的这个按钮可以兼容各种浏览器（但是只能解析PDF文件）
			<a target="_blank" href="http://blog.csdn.net/gyb_csdn/article/details/52598375">用法网址-我的博客</a>
		</p>
		<button class="btn btn-primary" onclick="pdfjs()">直接用PDFJs预览PDF</button>
	</div>
	<hr style="height:4px;border:none;border-top:4px groove #0066CC;" />
	
	
	<div class="container-fluid">
		<textarea id="copy_text" cols="30" rows="2">输入需要复制的内容...</textarea>
		<button class="btn btn-primary" onclick="setText()" data-clipboard-action="copy" data-clipboard-target="#copy_text">clipboard.js复制</button>
	 	<p class="bg-danger">经过我的实践发现clipboard.js最好用，方便快捷，兼容性好.
	 		<a target="_blank" href="https://clipboardjs.com/">官网 https://clipboardjs.com/</a>
		 	<br/>
		 	也可以用plugin/ZeroClipboard/ZeroClipboard.js，这个还得引入swf文件，因为它用到了flash
		</p>
	 </div>
	 <hr style="height:4px;border:none;border-top:4px groove #0066CC;" />
	 <button class="btn btn-primary" onclick="getString()">异步获取String</button>
	 <button class="btn btn-primary" onclick="getMap()">异步获取Map</button>
	 <hr style="height:4px;border:none;border-top:4px groove #0066CC;" />
	 
	 <p class="navbar-text">Highcharts的使用</p>
	 <div id="container" style="min-width:800px;height:400px;"></div>
	
	
  </body>
  
</html>

