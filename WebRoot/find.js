Ext.onReady(function(){

	var tb=new Ext.Toolbar();
	tb.render('toolbar');
    tb.add('编号：');
    tb.add(new Ext.form.TextField({
        name: 'id'
    }));
    tb.add('姓名：');
    tb.add(new Ext.form.TextField({
        name: 'name'
    }));
    tb.add('日期框：');
    tb.add(new Ext.form.DateField({
        name: 'date'
    }));
	tb.add('->');
    tb.add({
    	text:'查询',
    	width:100,
    	handler:function(){
    	   	   var name=Ext.getCmp('name').getValue();
               var id=Ext.getCmp('id').getValue();
  			   var date=Ext.getCmp('date').getValue();
             
               Ext.Ajax.request({
                method:'post',
               	url:'http://localhost:8080/XDManager/servlet/LoginServlet',
               	success:function(response){
   					store.load();
              		
               },
               failure:function(response){
      
                
               },
               
               params:{id:id,name:name}
               
               });
    	}
    })
    tb.doLayout();


	var columns = [
        {header:'编号',dataIndex:'id'},
        {header:'姓名',dataIndex:'name'},
        {header:'日期',dataIndex:'descn'}
    ];

//    var data = [
//        ['1','name1','1992-10-1'],
//        ['2','name2','1993-10-1'],
//        ['3','name3','1942-10-1'],
//        ['4','name4','1292-10-1'],
//        ['5','name5','1492-10-1'],
//        ['6','name6','1492-10-1']
//    
//    ];
	  var store=new Ext.data.JsonStore({
	  	url:''
	  })
//    var store = new Ext.data.ArrayStore({
//		data: data,
//		fields: [
//            {name: 'id'},
//            {name: 'name'},
//            {name: 'descn'}
//        ]
//    });

    var grid = new Ext.grid.GridPanel({
        renderTo: 'grid',
        forceFit:'true',
       // autoHeight: true,
        store: store,
        columns: columns,
        bbar: new Ext.PagingToolbar({
            pageSize: 10,
            store: store,
            displayInfo: true,
            displayMsg: '显示第 {0} 条到 {1} 条记录，一共 {2} 条',
            emptyMsg: "没有记录"
        })
    });
		//    store.load();

});
