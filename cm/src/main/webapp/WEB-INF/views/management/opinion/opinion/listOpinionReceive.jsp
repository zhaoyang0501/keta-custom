<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<dwz:paginationForm action="${contextPath }/management/opinion/opinion/listOpinionReceive" page="${page }">
	<input type="hidden" name="search_LIKE_title" value="${param.search_LIKE_title}"/>
</dwz:paginationForm>

<form method="post" action="${contextPath }/management/opinion/opinion/listOpinionReceive" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>问题来源：</label>
				<dwz:dic themeName="问题来源" paramName="search_EQ_pubopinion.paramBacseid" selectedValue="${param.search_EQ_pubopinion.paramBacseid}">
					<option value="">--请选择--</option>
				</dwz:dic>			
				</li>
				<%-- <li>
					<label>案件内容：</label>
					<input type="text" name="search_LIKE_conts" value="${param.search_LIKE_conts}" style="width: 200px;"/>		
				
				</li> --%>
			</ul>
			<%-- <ul class="searchContent">
				<li>
					<label>案件大类：</label>
				<dwz:dic themeName="案件大类" paramName="search_LIKE_title" className="combox"
					ref="w_combox_child"
					refUrl="${contextPath }/management/system/dictionary/parent_{value}">
					<option value="">--请选择--</option>
				</dwz:dic>			
				</li>
				<li>
					<label>案件小类：</label>
				<dwz:dic themeName="市政公用设施" paramName="search_LIKE_title" id="w_combox_child">
					<option value="">--请选择--</option>
				</dwz:dic>			
				</li>
			</ul> --%>
		
		
			<div class="subBar">
				<ul>						
					<li><div class="button"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
				</ul>
			</div>
		</div>
	</div>
</form>

<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<shiro:hasPermission name="Mainopinion:view">
				<li><a iconClass="magnifier" target="dialog" mask="true" width="800" height="500" rel="Mainopinion_view" href="${contextPath }/management/mainopinion/mainopinion/view/{slt_uid}"><span>查看详情</span></a></li>
			</shiro:hasPermission>		
		</ul>
	</div>
	
	<table class="table" layoutH="162" width="100%">
		<thead>
			<tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th width="11%">案件编号</th>
				<th width="7%">问题来源</th>
				<th width="40%">案件内容</th>
				<th width="11%">反映时间</th>
				<th width="11%">状态更新时间</th>
				<th>剩余时间</th>
				<th width="7%">案件状态</th>
				<th width="7%">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${opinions}">
			<tr target="slt_uid" rel="${item.id}">
				<td><input name="ids" value="${item.id}" type="checkbox"></td>
				<td>${item.id}</td>
				<td><dwz:dic themeName="问题来源" paramName="" toName="${item.pubopinion.paramBacseid}"></dwz:dic></td>
				<td width="45%">${item.pubopinion.conts}</td>
				<td><fmt:formatDate value="${item.acceptTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><fmt:formatDate value="${item.reportTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td></td>
				<td><dwz:dic themeName="案件状态" paramName="" toName="${item.opinionStatus}"></dwz:dic></td>
				<td>
					<a iconClass="application_view_detail" href="${contextPath }/management/opinion/opinion/view?id=${item.id}" target="dialog" width="800" height="500" title="详情"></a>
					<a href="${contextPath }/management/opinion/opinion/receive?id=${item.id}" target="dialog" width="800" height="500" >接受</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<dwz:pagination page="${page }"/>
</div>