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
				<label>案件大类：</label>
				<dwz:dic themeName="案件大类"  paramName="opinion.pubopinion.paramTypeB" selectedValue="${opinion.pubopinion.paramTypeB }"
					className="combox" ref="w_combox_subcase"
					refUrl="${contextPath }/management/system/dictionary/parent_{value}">
					<option value="">--请选择--</option>
				</dwz:dic>
			</p>
			<p class="nowrap">
				<label>案件小类：</label>
				<dwz:dic themeName="案件小类" paramName="opinion.pubopinion.paramTypeS" selectedValue="${opinion.pubopinion.paramTypeS }"
					id="w_combox_subcase">
					<option value="">--请选择--</option>
				</dwz:dic>
			</p>
			<p class="nowrap">
				<label>案件内容：</label>
				<textarea name="conts" maxlength="4000"
					class="textInput">
					${opinion.pubopinion.conts}
				</textarea>
			</p>
			<p class="nowrap">
				<label>建议：</label>
				<textarea name="replyConts" maxlength="4000"
					class="input-medium required validate[required]">
					同意立案
				</textarea>
			</p>
		</div>

		<div class="formBar">
			<ul>
				<li><div class="button">
						<div class="buttonContent">
							<button type="submit">立案</button>
						</div>
					</div></li>
				<li><div class="button">
						<div class="buttonContent">
							<button type="submit">回退</button>
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
