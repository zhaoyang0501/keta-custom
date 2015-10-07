<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${contextPath}/management/opinion/opinion/self"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, dialogReloadNavTab);">
		<input type="hidden" name="id" value="${opinion.id}" />
		<div class="pageFormContent" layoutH="58">
			<p class="nowrap">
				<label>反映时间：</label> <input type="text"
					value="${opinion.pubopinion.createTime }" readonly="readonly">
			</p>
			<p class="nowrap">
				<label>要求反映时间：</label> <input type="text" name="date10"
					class="date textInput readonly" datefmt="yyyy-MM-dd HH:mm:ss"
					readonly="true"> <a class="inputDateButton"
					href="javascript:;">选择</a>
				<dwz:dic themeName="延期时长" paramName="name">
					<option value="">--请选择--</option>
				</dwz:dic>
				(小时)
			</p>
			<p class="nowrap">
				<label>单位类型：</label> 
				<select name="guildTypeId">
					<option value="263">职能部门（单位）</option>
				</select>
			</p>
			<p class="nowrap">
				<label>处理单位：</label>
				<select name="guildUnitId">
					<option value="">--请选择--</option>
					<c:forEach var="company" items="${companyList}">
						<option value="${company.id}">${company.companyName }</option>
					</c:forEach>
				</select>
			</p>
			<p class="nowrap">
				<label>案件大类：</label>
				<dwz:dic themeName="案件大类" paramName="opinion.pubopinion.paramTypeB "
					selectedValue="${opinion.pubopinion.paramTypeB }"
					className="combox" ref="w_combox_subcase"
					refUrl="${contextPath }/management/system/dictionary/parent_{value}">
					<option value="">--请选择--</option>
				</dwz:dic>
			</p>
			<p class="nowrap">
				<label>案件小类：</label>
				<dwz:dic themeName="案件小类" paramName="opinion.pubopinion.paramTypeS"
					selectedValue="${opinion.pubopinion.paramTypeS }"
					id="w_combox_subcase" className="combox">
					<option value="">--请选择--</option>
				</dwz:dic>
			</p>
			<p class="nowrap">
				<label>备注：</label>
				<textarea name="rmks" maxlength="4000"
					class="input-medium required validate[required]">
					请按时限处理
				</textarea>
			</p>
			<p class="nowrap">
				<label>短信内容：</label>
				<textarea name="replyConts" maxlength="4000" cols="80" rows="2"
					class="input-medium required validate[required]">
					案件【】请速按规定时限处理并反馈，中心将派员核查
				</textarea>
			</p>
			<p class="nowrap">
				<label>责任人短信通知 ：</label> <input type="checkbox">全选
				<c:forEach var="company" items="${companyList}">
					<input type="checkbox" value="${company.mobile }">${company.contactsname }
					<input type="checkbox" value="${company.telephone }">${company.orgCode }
					<input type="checkbox" value="${company.portraiture }">${company.companyPerson }
				</c:forEach>
			</p>
		</div>

		<div class="formBar">
			<ul>
				<li><div class="button">
						<div class="buttonContent">
							<button type="submit">派遣</button>
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
