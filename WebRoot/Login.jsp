<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   
    
     
    <title>欢迎</title>
    
 	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page"> 

 <link href="resources/extjs/resources/css/ext-all-neptune.css" rel="stylesheet" type="text/css" />
 	<!--  <script type="text/javascript" src="resources/extjs/ext-all.js"></script> -->
     <script type="text/javascript" src="resources/extjs/ext-all-dev.js"></script>

 	 <script type="text/javascript">
	
	
 	Ext.onReady(function(){

    Ext.QuickTips.init();


	var panel=new Ext.Panel({
	
	title:'欢迎',
	//bodyStyle:"background-image:url('localhost：8080/XDManager/WebRoot/resources/imgs/Hearthstone Screenshot 04-02-16 20.52.48.png');padding:55px 5px 0",
	
	viewConfig: {forceFit: true}, 
    items: [
		{     
		style:'margin-left:1700;margin-top:30',
        buttonAlign:'center',
    	xtype:'button',
    	name:'register',
    	text:'注册新用户',
    	width:'100',
    	handler:function(){
    		window.location="http://localhost:8080/XDManager/Register.jsp";
    	}
    	},
		{	
    	style:'margin-left:700;margin-top:300;',
        xtype: 'container',
        name: 'field',
        items:[{
         	xtype:'textfield',
     		labelWidth:50,
         	width:'400',
        	name: 'name',
        	id:'name',
   			fieldLabel: '用户名',
        	allowBlank:false,
        	blankText:'用户名不能为空'
        
        },{
        	xtype:'textfield',
        	inputType:'password',
        	labelWidth:50,
         	width:'400',
        	name: 'password',
        	id:'password',
   			fieldLabel: '密码',
        	allowBlank:false,
        	blankText:'密码不能为空'
        
        }
        
        ]},
        {
        style:'margin-left:900;margin-top:30',
        buttonAlign:'center',
    	xtype:'button',
    	name:'enter',
    	text:'确认',
    	width:'100',
    	scale:'large',
        handler: function() {
               var name=Ext.getCmp('name').getValue();
               var password=Ext.getCmp('password').getValue();
               if(name==""||password==""){Ext.Msg.alert("错误","用户名和密码不能为空");}
             else{
               Ext.Ajax.request({
                method:'GET',
               	url:'http://localhost:8080/XDManager/servlet/LoginServlet',
               	success:function(response){
           		window.location="http://localhost:8080/XDManager/QueryPage.jsp"
              		
               },
               failure:function(response){
              	 Ext.Msg.alert('登录失败',"用户名或密码错误")
               	window.location="http://localhost:8080/XDManager/Login.jsp"
                
               },
               
               params:{name:name,password:password}
               
               });}
            }
    	
    }]
 	
 	})
	

	
	
	var viewport=new Ext.Viewport({
 	layout:'fit',
 	title:'welcome',
 	//renderTo:Ext.getBody(),
 	//items:[{region:'center'},panel]
 	items:[panel]
 	});
 	
 	//String s_name=(String)request.getAttribute("name");
	

	})
	
	
	
	

	
	
    </script>

  </head>
  
  <body>


  </body>
</html>
