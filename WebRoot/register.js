
 	Ext.onReady(function(){

    Ext.QuickTips.init();


	var panel=new Ext.Panel({
	
	title:'注册',
	
	
	viewConfig: {forceFit: true}, 
    items: [
		{     
		style:'margin-left:1700;margin-top:30',
        buttonAlign:'center',
    	xtype:'button',
    	name:'register',
    	text:'返回登录页',
    	width:'100',
    	handler:function(){
    		window.location="http://localhost:8080/XDManager/Login.jsp";
    	}
    	},
		{	
    	style:'margin-left:700;margin-top:100',
        xtype: 'container',
        name: 'field',
        items:[{
         	xtype:'textfield',
     		labelWidth:100,
     		labelStyle:'font-size:20px', 
         	width:'400',
        	name: 'name',
        	id:'name',
   			fieldLabel: '姓名',
        	allowBlank:false,
        	blankText:'姓名不能为空'
        
        },{
        	style:'margin-top:60',
        	xtype:'textfield',
        	inputType:'password',
        	labelWidth:100,
        	labelStyle:'font-size:20px', 
         	width:'400',
         	height:'20px',
        	name: 'password',
        	id:'password',
   			fieldLabel: '密码',
        	allowBlank:false,
        	blankText:'密码不能为空'
        
        },{
        	style:'margin-top:60',
        	xtype:'textfield',
        	labelStyle:'font-size:20px', 
        	inputType:'password',
        	labelWidth:100,
        	width:'400',
        	name:'password2',
        	id:'password2',
        	fieldLabel:'确认密码',
        	allowBlank:false,
        	blankText:'密码不能为空'
        }
        
        ]},
        {
        style:'margin-left:900;margin-top:100',
        buttonAlign:'center',
    	xtype:'button',
    	name:'enter',
    	text:'确认',
    	width:'100',
    	scale:'large',
        handler: function() {
               var name=Ext.getCmp('name').getValue();
               var password=Ext.getCmp('password').getValue();
               var password2=Ext.getCmp('password2').getValue();
               if(name==""||password==""||password2==""){Ext.Msg.alert("错误","用户名和密码不能为空");}
               else if(password!=password2){Ext.Msg.alert("错误","两次密码不相同");}
             else{
               Ext.Ajax.request({
                method:'GET',
               	url:'http://localhost:8080/XDManager/servlet/RegisterServlet',
               	success:function(response){
               	Ext.Msg.alert('成功',"返回登录页面",4000);
           		window.location="http://localhost:8080/XDManager/Login.jsp"
              		
               },
               failure:function(response){
              	 Ext.Msg.alert('错误',"用户存在，请直接登录",function(){   	window.location="http://localhost:8080/XDManager/Login.jsp"});
           
                
               },
               
               params:{name:name,password:password}
               
               });}
            }
    	
    }]
 	
 	})
	

	
	
	var viewport=new Ext.Viewport({
 	layout:'fit',
 	title:'welcome',

 	items:[panel]
 	});
 	

	})
	
	
	