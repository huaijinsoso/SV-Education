$(function(){

	initUserGrid();

	$("#lbtn_userClose").click(function(){
		$('#win_user_add').window('close');
	});

	$("#lbtn_search").click(function(){
		$("#grid_user").datagrid("load",{"cityName":$("#userName").val()});
	});

	$("#lbtn_reset").click(function(){
		$("#userName").val("");
		$("#grid_user").datagrid("load",{"cityName":$("#userName").val()});
	});

	$("#lbtn_userSave").click(function(){
		if(!$("#form_user").form("validate")){
			$.messager.alert('提示','将信息填写完整','error');
			return;
		}

		$.AppUtil.showShade();
		$.ajax({
			type: "POST",
			url:"/cityController/optCity",
		    data: $("#form_user").serialize(),
			success: function(msg){
				$.messager.progress("close");
			     if(msg.state){
			    	 $.messager.alert('提示',msg.msg,'info');
			     } else {
			    	 $.messager.alert('提示',msg.msg,'error');
			     }
			     $('#win_user_add').window('close');
			     $("#grid_user").datagrid('reload');
		    }


		})


	});


})


function initUserGrid(){
	var toolbar = [{
		text:'新增',
		iconCls:'icon-add',
		handler:function(){
			userOPtion("新增用户信息",'icon-add',"");
		}
	},'-',{
		text:'修改',
		iconCls:'icon-edit',
		handler:function(){
			if($("#grid_user").datagrid('getSelections').length != 1){
				$.messager.alert('提示','请选择需要修改的用户信息！','info');
			}else{
				var row = $("#grid_user").datagrid("getSelected");
				userOPtion("修改用户信息",'icon-edit',row.userId);
			}
		}
	},'-',{
		text:'删除',
		iconCls:'icon-remove',
		handler:function(){
			if($("#grid_user").datagrid('getSelections').length != 1){
				$.messager.alert('提示',"请选择一条需要删除的数据！",'error');
			}else{
				$.messager.confirm("提示","确定删除该用户？", function (c) {
					if(c){
						$.ajax({
							type: "POST",
							url : "/cityController/delCity",
							data : 'cityId='+$("#grid_user").datagrid('getSelected').userId,
							dataType : 'json',
							success:function(data){
								if(data.state == true){
									$.messager.alert('提示',data.msg,'info');
								}else{
									$.messager.alert('提示',data.msg,'error');
								}
							 	$("#grid_user").datagrid('reload');
							}
						});
					}
				});
			}
		}
	}];
	return $("#grid_user").datagrid({
        iconCls:'icon-standard-application-view-tile',
        fit : true,
        method: "post",
        url: "/coopeerationController/list",
        idField: 'id',
        border : false,
        pagination : true,	//分页工具栏
        rownumbers : true,
        singleSelect : true,
        remoteSort: false,
        striped:true,
        toolbar : toolbar,
        pageSize:10,
        pageList:[10,20,30,50,100],
        columns: [[
            { field: 'cooperationId', title: '用户ID',width:150},
            { field: 'schoolId', title: '用户名',width:150,align:'center'},
            { field: 'baseNum', title: '用户名',width:150,align:'center'},
            { field: 'industryNum', title: '用户名',width:150,align:'center'},
        ]],
        enableHeaderClickMenu: true,
        enableHeaderContextMenu: true,
        enableRowContextMenu: true,         //此属性开启表头列名称右键点击菜单
        pagingMenu: { submenu: true},      //开启行右键菜单的翻页功能，此属性可丰富配置，详情见 API 文档
        moveMenu: true,                     //开始行右键菜单的移动列功能，此属性可丰富配置，详情见 API 文档
        offset: { width: -250, height: -150},
        autoBindDblClickRow: false,
        onDblClickRow :function(rowIndex,rowData){
        	userOPtion('修改用户信息','icon-edit');
        }
    });


}

function userOPtion(title,icon,id){
	$('#win_user_add').dialog({
		 title: title,
 		 iconCls:icon,
		 width: 350,
		 height: 200,
		 autoVCenter:true,
		 autoHCenter:true,
		 autoCloseOnEsc:true,
		 inContainer:true,
		 modal: true,
		 onOpen: function(){
		 	$('#form_user').form('clear');//清除之前操作数据
		 	if(id != ""){
			 	$.AppUtil.showShade();
				$.ajax({
						type: "POST",
						url: "/cityController/goEdit?cityId="+id,
						dataType: "json",
						success:function(data){
							$.messager.progress("close");
							$("#form_user").form('load',data);
						}
				});
			} else {
				$('#userId').val("0");
			}
		}
	});
}