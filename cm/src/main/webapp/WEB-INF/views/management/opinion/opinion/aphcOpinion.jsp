<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${contextPath}/management/opinion/opinion/aphcOpinion"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, dialogReloadNavTab);">
		<input type="hidden" name="id" value="${opinion.id}" />
		<div class="pageFormContent" layoutH="58">
			<p class="nowrap">
				<label>核查人员：</label>
				<select name="checkUserid">
					<option value="">--请选择--</option>
					<%-- <c:forEach var="company" items="${companyList}">
						<option value="${company.companyName}">${company.companyName }</option>
					</c:forEach> --%>
				</select>
			</p>
			<p class="nowrap">
				<label>备注：</label>
				<textarea name="rmks" maxlength="4000"
					class="input-medium required validate[required]">
					请核查
				</textarea>
			</p>
		</div>

		<div class="formBar">
			<ul>
				<li><div class="button">
						<div class="buttonContent">
							<button type="submit">安排检查</button>
						</div>
					</div></li>
					<li><div class="button">
						<div class="buttonContent">
							<button type="submit">申请结案</button>
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
