<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<dwz:paginationForm action="${contextPath }/management/mainopinion/mainopinion/list" page="${page }">
	<input type="hidden" name="search_LIKE_title" value="${param.search_LIKE_title}"/>
</dwz:paginationForm>

<form method="post" action="${contextPath }/management/mainopinion/mainopinion/list" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					<label>案件编号：</label> <input type="text" name="search_LIKE_id" value="${param.search_LIKE_id}"/>		
				</td>
				<td>
				<label>问题来源：</label>
					<select class="combox" name="province">
						<option value="">所有省市</option>
						<option value="北京">北京</option>
						<option value="上海">上海</option>
						<option value="天津">天津</option>
						<option value="重庆">重庆</option>
						<option value="广东">广东</option>
					</select>
				</td>
				<td>
				<label>案件状态：</label>
					<select class="combox" name="province">
						<option value="">所有省市</option>
						<option value="北京">北京</option>
						<option value="上海">上海</option>
						<option value="天津">天津</option>
						<option value="重庆">重庆</option>
						<option value="广东">广东</option>
					</select>
				</td>
				<td>
				<label>案件大类：</label>
					<select class="combox" name="province">
						<option value="">所有省市</option>
						<option value="北京">北京</option>
						<option value="上海">上海</option>
						<option value="天津">天津</option>
						<option value="重庆">重庆</option>
						<option value="广东">广东</option>
					</select>
				</td>
				<td>
				<label>案件小类：</label>
					<select class="combox" name="province">
						<option value="">所有省市</option>
						<option value="北京">北京</option>
						<option value="上海">上海</option>
						<option value="天津">天津</option>
						<option value="重庆">重庆</option>
						<option value="广东">广东</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="4">
				<label>案件内容：</label>
					<input type="text" name="search_LIKE_111" value="${param.search_LIKE_id}" style="width: 200px;"/>		
				</td>
			</tr>
		</table>
		
		
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
				<li><a iconClass="magnifier" target="dialog" mask="true" width="530" height="250" rel="Mainopinion_view" href="${contextPath }/management/mainopinion/mainopinion/view/{slt_uid}"><span>查看详情</span></a></li>
			</shiro:hasPermission>		
		</ul>
	</div>
	
	<table class="table" layoutH="137" width="100%">
		<thead>
			<tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>案件编号</th>
				<th>问题来源</th>
				<th>案件内容</th>
				<th>反映时间</th>
				<th>状态更新时间</th>
				<th>剩余时间</th>
				<th>案件状态</th>
				<th>详情</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${mainopinions}">
			<tr target="slt_uid" rel="${item.id}">
				<td><input name="ids" value="${item.id}" type="checkbox"></td>
				<td>${item.id}</td>
				<td>${item.pubopinion.paramBacseid}</td>
				<td>${item.pubopinion.conts}</td>
				<td><fmt:formatDate value="${item.acceptTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><fmt:formatDate value="${item.reportTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td></td>
				<td>${item.opinionStatus}</td>
				<td></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<dwz:pagination page="${page }"/>
</div>