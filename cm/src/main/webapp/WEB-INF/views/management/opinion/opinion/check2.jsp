<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${contextPath}/management/opinion/opinion/check2"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, dialogReloadNavTab);">
		<input type="hidden" name="id" value="${opinion.id}" />
		<div class="pageFormContent" layoutH="58">
			<p class="nowrap">
				<label>处理反馈：</label>
				<textarea name="handleResult" maxlength="4000"
					class="input-medium required validate[required]">
					已处理完毕
				</textarea>
			</p>
			<p class="nowrap">
				<label>附件上传：</label>
				<input type="file">
			</p>
			
		</div>

		<div class="formBar">
			<ul>
				<li><div class="button">
						<div class="buttonContent">
							<button type="submit">处理</button>
						</div>
					</div></li>
				<li><div class="button">
						<div class="buttonContent">
							<button type="button" class="close">关闭</button>
						</div>
					</div></li>
			</ul>
		</div>
	</form>
</div>
