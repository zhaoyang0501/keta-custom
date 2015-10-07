<%@ page language="java" contentType="text/html; charset=UTF-8"
	trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<style type="text/css">

.unit {width: 520px;
}
</style>
<div class="pageContent">
	<div class="pageFormContent" layoutH="58">
		<p>
			<label>案件编号:</label> <span class="unit">${opinion.id}</span>
		</p>
		<p>
			<label>上报人姓名:</label> <span class="unit">${opinion.pubopinion.createUserid}</span>
		</p>
		<p>
			<label>上报时间:</label> <span class="unit">${opinion.pubopinion.createTime}</span>
		</p>
		<p>
			<label>案件内容:</label> <span class="unit">${opinion.pubopinion.conts}</span>
		</p>
		<p>
			<label>问题来源:</label> <span class="unit"><dwz:dic themeName="问题来源" paramName="" toName="${opinion.pubopinion.paramBacseid}"></dwz:dic></span>
		</p>
		<p>
			<label>案件大类/小类:</label> <span class="unit"><dwz:dic themeName="案件大类" paramName="" toName="${opinion.pubopinion.paramTypeB}"></dwz:dic>/${opinion.pubopinion.paramTypeS}</span>
		</p>
		<p>
			<label>所属中队:</label> <span class="unit"><dwz:dic themeName="城市管理监察大队" paramName="" toName="${opinion.pubopinion.paramOrgId}"></dwz:dic></span>
		</p>
		<p>
			<label>详细位置</label> <span class="unit">${opinion.pubopinion.address}</span>
		</p>
		<p>
			<%-- <label>案件图片/录音:</label> <span class="unit">${opinion.pubopinion.aId}</span> --%>
		</p>
		<c:choose>
			<c:when test="${opinion.opinionStatus>713 && opinion.pubopinion.paramBacseid!='289'}">
				<p>
					<label>核查信息</label>
				</p>
				<p>
					<label>核查结果:</label> <span class="unit">${opinion.checkResult}</span>
				</p>
				<p>
					<label>核查备注:</label> <span class="unit">${opinion.checkRmk}</span>
				</p>
				<p>
					<label>核查照片:</label> <span class="unit">${opinion.checkAId}</span>
				</p>
			</c:when>
		</c:choose>

		<p>
			<label>操作历史:</label> 
			<c:forEach items="${opinionBusiness }" var="business" varStatus="status">
				<div>${status.index+1 }.${business.actionUserid}-${business.actionName},时间：${business.createTime},备注：${business.actionConts}</div>
			</c:forEach>
		</p>
	</div>

	<div class="formBar">
		<ul>
			<li><div class="button">
					<div class="buttonContent">
						<button type="button" class="close">关闭</button>
					</div>
				</div></li>
		</ul>
	</div>
</div>