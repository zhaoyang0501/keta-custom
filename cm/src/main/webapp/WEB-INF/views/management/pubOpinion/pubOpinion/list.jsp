<%@ page language="java" contentType="text/html; charset=UTF-8"
	trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<dwz:paginationForm
	action="${contextPath }/management/pubOpinion/pubOpinion/list"
	page="${page }">
	<input type="hidden" name="search_LIKE_title"
		value="${param.search_LIKE_title}" />
</dwz:paginationForm>

<form method="post"
	action="${contextPath }/management/pubOpinion/pubOpinion/list"
	onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li><label style="width: 100px;">创建开始时间：</label> <input
					type="text" class="date textInput readonly valid"
					name="search_GTE_createTime" value="${param.search_GTE_createTime}"
					readonly="readonly" style="float: left;" /> <a
					class="inputDateButton" href="javascript:;" style="float: left;">选择</a>
				</li>
				<li><label>问题状态：</label> <dwz:dic themeName="问题状态"
						paramName="search_EQ_status"
						selectedValue="${param.search_EQ_status}">
						<option value="">--请选择--</option>
					</dwz:dic></li>
			</ul>
			<ul class="searchContent">
				<li><label style="width: 100px;">结束时间：</label> <input
					type="text" class="date textInput readonly valid"
					name="search_LTE_createTime" value="${param.search_LTE_createTime}"
					readonly="readonly" style="float: left;" /> <a
					class="inputDateButton" href="javascript:;" style="float: left;">选择</a>
				</li>
				<li><label>问题内容：</label> <input type="text"
					name="search_LIKE_conts" value="${param.search_LIKE_conts}" /></li>
			</ul>
			<div class="subBar">
				<ul>
					<li><div class="button">
							<div class="buttonContent">
								<button type="submit">搜索</button>
							</div>
							<button id="btnReset" type="button" class="btn default">
								重置 <i class="fa fa-undo"></i>
							</button>
						</div></li>
				</ul>
			</div>
		</div>
	</div>
</form>

<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<shiro:hasPermission name="Pubopinion:view">
				<li><a iconClass="magnifier" target="dialog" mask="true"
					width="530" height="250" rel="Pubopinion_view"
					href="${contextPath }/management/pubOpinion/pubOpinion/view/{slt_uid}"><span>查看任务</span></a></li>
			</shiro:hasPermission>
			<%-- <shiro:hasPermission name="Pubopinion:save">
				<li><a class="add" target="navTab" mask="true" width="530"
					height="250" rel="Pubopinion_save"
					href="${contextPath }/management/pubOpinion/pubOpinion/create"><span>添加任务</span></a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="Pubopinion:edit">
				<li><a class="edit" target="dialog" mask="true" width="530"
					height="250" rel="Pubopinion_edit"
					href="${contextPath }/management/pubOpinion/pubOpinion/update/{slt_uid}"><span>编辑任务</span></a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="Pubopinion:delete">
				<li><a class="delete" target="selectedTodo" rel="ids"
					href="${contextPath }/management/pubOpinion/pubOpinion/delete"
					title="确认要删除选定任务?"><span>删除任务</span></a></li>
			</shiro:hasPermission> --%>
		</ul>
	</div>

	<table class="table" layoutH="162" width="100%">
		<thead>
			<tr>
				<th width="22"><input type="checkbox" group="ids"
					class="checkboxCtrl"></th>
				<th>问题编号</th>
				<th>问题内容</th>
				<th>反馈人</th>
				<th>问题状态</th>
				<th>问题来源</th>
				<th>案件大类<!-- /案件小类 --></th>
				<th>所属中队</th>
				<th>创建时间</th>
				<th>剩余时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${pubopinions}">
				<tr target="slt_uid" rel="${item.id}">
					<td><input name="ids" value="${item.id}" type="checkbox"></td>
					<td>${item.id}</td>
					<td width="45%">${item.conts}</td>
					<td>${item.createUserid}</td>
					<td><dwz:dic themeName="问题状态" paramName=""
							toName="${item.status}"></dwz:dic></td>
					<td><dwz:dic themeName="问题来源" paramName=""
							toName="${item.paramBacseid}"></dwz:dic></td>
					<td><dwz:dic themeName="案件大类" paramName=""
							toName="${item.paramTypeB}"></dwz:dic><%-- /<dwz:dic themeName="案件小类"
							paramName="" toName="${item.paramTypeS}"></dwz:dic> --%></td>
					<td><dwz:dic themeName="城市管理监察大队" paramName=""
							toName="${item.paramOrgId}"></dwz:dic></td>
					<td>${item.createTime}</td>
					<td></td>
					<td>
					<a iconClass="application_view_detail" href="${contextPath }/management/pubOpinion/pubOpinion/view?id=${item.id}" target="dialog" width="800" height="500" title="详情"></a>
					<c:choose>
							<c:when test="${item.status == '404' }">
								<a target="dialog" width="800" height="500"
									href="${contextPath }/management/pubOpinion/pubOpinion/accept?id=${item.id}">受理</a>
							</c:when>
							<c:otherwise>已受理</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<dwz:pagination page="${page }" />
</div>