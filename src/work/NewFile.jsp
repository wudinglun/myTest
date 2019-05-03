<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">

/**
 * 下拉框赋值
 */
 function collztn_dataset_custAcct_beforeOpen(dropDown,dropDownDataset){
	dropDown.cache=false;
	var custId=collztn_dataset.getValue("custId");
	dropDownDataset.setParameter("custId",cusId);
	dropDownDataset.setParameter("flg",1);//这里传送给下拉框去后台搜索
}

/**
  *dataset上设置字段
 
<Field id="custAcct" desc="客户账号" xpath="/custAcct" datasource="CQ1:com.ruimin.ifb.com.dataset.CQCustAcct"
   fieldmap="custAcct=acctNo custAcctName=acctNo" viewfield="acctNo,orgName" edittype="combogrid" datatype="string" init="true"/>
   
   
  *datasoure 对应的dataset
 <Define flowid="com.ruimin.ifb.common.comp.CQCustAction:queryCustAcctInf"/>
 //这里搜索的答案就是显示的结果。其中入参QueryParamBean是前面dropDownDataset  set进去的值 ,返回值也是PageResult. viewfield是显示项目
 <fields>
    <field   id="custId"/>
    <field   id="acctNo"/>
    <field   id="bkId"  xpath="/bkId"/>
    //这里method的入参是是搜索返回值中xpath的值作为key 整体的搜索返回值以ServletRequest 传入。返回值为String类型为显示值
    <field   id="orgName"  method="com.ruimin.ifb.common.process.service.TranService.queryBkNmById" xpath="/bkId"   />
 </fields>
  
 public Static String queryBkNmById(FieldBean bean,String key,ServletRequest request)throws SnowException{
	 return xxx;
 }
 
 <Field id="custId" desc="客户名称" edittype="combodialog" xpath="/custId" fieldmap="custId=id;custIdName=custNm"
     url="/pages/common/cqCustEntp.jsp" init="true"/>
 
 
*/   
//下拉框得到搜索页面的值床给 field id="custId"
function dropDown_onGetRecord(){
	return cqCustEntp_dataset.record;
}



//按钮点击完的确认弹框
function successId_onClickCheck(btn,commit){
	$.confirm("是否确认提交？",function(){
		commit();
	},function(){});
}

//弹窗完成功提交后,param是返回的参数
function successId_postSubmit(btn,param){
	$.success(param.res,function(){
		drftInfo_dataset.flushData(drftInfo_dataset.pageIndex);
		overPldg_dataset.clearData();
	})
}





</script>
<body>

</body>
</html>