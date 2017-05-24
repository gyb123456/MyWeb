/**
 * 
 */
$(function(){
	initClipboard();
    initHighcharts();
});
//初始化粘贴板
function initClipboard(){
	var clipboard = new Clipboard('.btn');
    clipboard.on('success', function(e) {
        console.log(e);
        alert("copy success");
    });
    clipboard.on('error', function(e) {
        console.log(e);
        alert("copy error");
    });
}
/*设置复制文本框的内容*/
function setText()
{
	//$('#copy_text').val('sadsd');
}
/*预览PDF文件*/
function preViewPDF(){
	var pdfName = "09.pdf";
	if(PDFObject.supportsPDFs){
		   alert("您的浏览器支持PDFObject预览功能");
		   PDFObject.embed("./files/"+pdfName, "#pdfDiv");
	} else {
		var browserType = getOs();
		if(browserType=="Firefox"){
			  alert("火狐浏览器支持PDFObject预览功能");
			  PDFObject.embed("./files/"+pdfName, "#pdfDiv");
		}else{
			alert("此浏览器不兼容PDFObject，我们调用下面这个按钮的功能，用PDFjs来做,但只能识别PDF");
			pdfjs(pdfName);
		}
	}
	//PDFObject.embed("./files/jsp.pdf", "#pdfDiv");
	//PDFObject.embed("files/1468383501520.jpg", "#pdfDiv");
	//var success = new PDFObject({ url: "files/jsp.pdf" }).embed("pdf");
}
//获取浏览器类型
function getOs()  
{  
   if(navigator.userAgent.indexOf("MSIE")>0) {  
        return "IE";  
   }  
   if(isFirefox=navigator.userAgent.indexOf("Firefox")>0){  
        return "Firefox";  
   }  
   if(isSafari=navigator.userAgent.indexOf("Safari")>0) {  
        return "Safari";  
   }   
   if(isCamino=navigator.userAgent.indexOf("Camino")>0){  
        return "Camino";  
   }  
   if(isMozilla=navigator.userAgent.indexOf("Gecko/")>0){  
        return "Gecko";  
   }  
     
}  
//用pdf.js解析pdf文件
function pdfjs(pdfName){
//	pdfName ="09.pdf"; 
//	pdfName ="jsp.pdf";
	pdfName = "excel.pdf";
	
	/*
	 * 这个路径是相对于/MyWeb/WebRoot/plugin/PDFJS/web/viewer.js文件的，
	*所以为了调用WebRoot目录下的files文件夹里的pdf文件，用了../../../
	*/
	
	var pdfPath = "../../../files/"+pdfName;
//	var pdfPath = "../doc/"+pdfName;
//	var pdfPath = pdfName;
    /*若想显示自定义pdf，
	需要把viewer.js文件里的DEFAULT_URL设置为空，
	然后路径上加上参数file='你的pdf名称'即可*/ 
	
//	window.open('PDFJS/viewer.html?file='+pdfPath);
//	window.open('plugin/PDFJS/web/viewer.html?file='+'D:/testPic/excel.pdf');
	window.open('plugin/PDFJS/web/viewer.html?file='+pdfPath);
}

function sss(){
	//定义一个新的复制对象
	var clip = new ZeroClipboard( document.getElementById("d_clip_button"), {
	  moviePath: "plugin/ZeroClipboard/ZeroClipboard.swf"
	} );
	// 复制内容到剪贴板成功后的操作
	clip.on( 'complete', function(client, args) {
	   alert("复制成功，复制内容为："+ args.text);
	} );
}

function getString(){
	$.post("FirstController/getString",{},function(data){
		alert(data);
	});
}

function getMap(){
	$.post("FirstController/getMap",{},function(data){
		alert(data);
	});
}
//初始化Highcharts
function initHighcharts(){
	 $('#container').highcharts({
         chart: {
             type: 'column'
         },
         title: {
             text: '水果数目柱状图'
         },
         xAxis: {
             categories: ['苹果', '香蕉', '橙子']   //指定x轴分组
         },
         yAxis: {
             title: {
                 text: '个数'
             }
         },
          series: [{                               	 //指定数据列
             name: '小明',                        //数据列名
             data: [1, 7, 4]                       //数据
         }, {
             name: '小红',
             data: [5,4, 9]
         }]
     });
}