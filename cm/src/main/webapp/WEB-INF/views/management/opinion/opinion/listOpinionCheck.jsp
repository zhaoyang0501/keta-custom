<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<dwz:paginationForm action="${contextPath }/management/opinion/opinion/listOpinionCheck" page="${page }">
	<input type="hidden" name="search_LIKE_title" value="${param.search_LIKE_title}"/>
</dwz:paginationForm>

<form method="post" action="${contextPath }/management/opinion/opinion/listOpinionCheck" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<div class="subBar">
				<font color="red">表格中要求反馈时间-受理时间=时限，要求反馈时间-当前时间=剩余时间， 当剩余时间小于时限1/3时显示黄灯，剩余时间为0时，显示红灯，绿色表示暂时不会过期。白色背景色则表示该案件暂无操作。 
				</font>
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
				<th >剩余时间</th>
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
				<c:choose>
					<c:when test="${item.opinionStatus=='706'}">
						<a href="${contextPath }/management/opinion/opinion/check?id=${item.id}" target="dialog" >立案</a>
					</c:when>
					<c:otherwise>
						<a href="${contextPath }/management/opinion/opinion/check?id=${item.id}" target="dialog" >结案</a>
					</c:otherwise>
				</c:choose>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<dwz:pagination page="${page }"/>
</div>