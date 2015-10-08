<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="${contextPath}/management/pubOpinion/pubOpinion/accept" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<input type="hidden" name="id" value="${pubOpinion.id}"/>
	<div class="pageFormContent" layoutH="58">
		<p class="nowrap">
				<label>问题/案件内容：</label>
				<textarea name="conts" maxlength="4000"
					class="textInput required validate[required]">
					${pubOpinion.conts}
				</textarea>
			</p>
			<p class="nowrap">
				<label>受理/回退意见：</label>
				<textarea name="replyConts" maxlength="4000"
					class="textInput required validate[required]">
					${pubOpinion.replyConts}
				</textarea>
			</p>		
	</div>
			
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="submit">受理</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="submit">回退</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>
