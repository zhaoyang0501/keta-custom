<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${contextPath}/management/opinion/opinion/check"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, dialogReloadNavTab);">
		<input type="hidden" name="id" value="${opinion.id}" />
		<div class="pageFormContent" layoutH="58">
			<p class="nowrap">
				<label>结案内容：</label>
				<textarea name="rmks" maxlength="1000"
					class="input-medium required validate[required]">
				</textarea>
			</p>
		</div>

		<div class="formBar">
			<ul>
				<li><div class="button">
						<div class="buttonContent">
							<button type="submit">结案</button>
						</div>
					</div></li>
				<li><div class="button">
						<div class="buttonContent">
							<button type="submit">重新派遣</button>
						</div>
					</div></li>
				<li><div class="button">
						<div class="buttonContent">
							<button type="submit">重新核查</button>
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
