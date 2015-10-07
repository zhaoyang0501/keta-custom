<%@ page language="java" contentType="text/html; charset=UTF-8"
	trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
	<div class="pageFormContent" layoutH="58">
		<p>
			<label>上报人姓名:</label> <span class="unit">${pubOpinion.createUserid}</span>
		</p>
		<p>
			<label>上报时间:</label> <span class="unit">${pubOpinion.createTime}</span>
		</p>
		<p>
			<label>问题内容:</label> <span class="unit">${pubOpinion.conts}</span>
		</p>
		<p>
			<label>受理状态:</label> <span class="unit"><dwz:dic themeName="受理状态" paramName="" toName="${pubOpinion.status}"></dwz:dic></span>
		</p>
		<p>
			<label>问题来源:</label> <span class="unit"><dwz:dic themeName="问题来源" paramName="" toName="${pubOpinion.paramBacseid}"></dwz:dic></span>
		</p>
		<p>
			<label>案件大类/小类:</label> <span class="unit"><dwz:dic themeName="案件大类" paramName="" toName="${pubOpinion.paramTypeB}"></dwz:dic>/${pubOpinion.paramTypeS}</span>
		</p>
		<p>
			<label>所属中队:</label> <span class="unit"><dwz:dic themeName="城市管理监察大队" paramName="" toName="${pubOpinion.paramOrgId}"></dwz:dic></span>
		</p>
		<p>
			<label>详细位置</label> <span class="unit">${pubOpinion.address}</span>
		</p>
		<p>
			<%-- <label>案件图片/录音:</label> <span class="unit">${pubOpinion.aId}</span> --%>
		</p>
		<p>
			<label>操作历史:</label>
			<c:forEach items="${opinionBusiness }" var="business"
				varStatus="status">
				<div>${status.index+1 }.${business.actionUserid}-${business.actionName},时间：${business.createTime},备注：${business.actionConts}</div>
			</c:forEach>
			</span>
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