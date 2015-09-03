<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<div class="pageContent">
	<div class="pageFormContent" layoutH="58">
		<p>
		<label>id*****：</label>
		<span class="unit">${mainopinion.id}</span>
	</p>
	<p>
		<label>问题来源：</label>
		<span class="unit">${mainopinion.problemSource}</span>
	</p>
	<p>
		<label>姓名：</label>
		<span class="unit">${mainopinion.name}</span>
	</p>
	<p>
		<label>地址：</label>
		<span class="unit">${mainopinion.address}</span>
	</p>
	<p>
		<label>手机：</label>
		<span class="unit">${mainopinion.phone}</span>
	</p>
	<p>
		<label>状态更新时间*****：</label>
		<span class="unit">${mainopinion.reportTime}</span>
	</p>
	<p>
		<label>要求反馈时间（必填）*****：</label>
		<span class="unit">${mainopinion.feedbackTime}</span>
	</p>
	<p>
		<label>受理时间（系统时间）*****：</label>
		<span class="unit">${mainopinion.acceptTime}</span>
	</p>
	<p>
		<label>E-MAIL：</label>
		<span class="unit">${mainopinion.email}</span>
	</p>
	<p>
		<label>范围（必填）：</label>
		<span class="unit">${mainopinion.scope}</span>
	</p>
	<p>
		<label>行业类型ID（必填）下拉列表选择*****：</label>
		<span class="unit">${mainopinion.guildTypeId}</span>
	</p>
	<p>
		<label>业务单位ID（必填）下拉列表选择*****：</label>
		<span class="unit">${mainopinion.guildUnitId}</span>
	</p>
	<p>
		<label>反应内容（必填）：</label>
		<span class="unit">${mainopinion.reportConts}</span>
	</p>
	<p>
		<label>备注：</label>
		<span class="unit">${mainopinion.rmks}</span>
	</p>
	<p>
		<label>受理员（必填）*****：</label>
		<span class="unit">${mainopinion.acceptUserid}</span>
	</p>
	<p>
		<label>处理时限=受理时间-要求反馈时间(小时)(暂未使用)*****：</label>
		<span class="unit">${mainopinion.handleTime}</span>
	</p>
	<p>
		<label>单位处理反馈人id***：</label>
		<span class="unit">${mainopinion.unitUserid}</span>
	</p>
	<p>
		<label>值班长立案id*******：</label>
		<span class="unit">${mainopinion.doingUserid}</span>
	</p>
	<p>
		<label>是否重新派单（1：是，0不是）****：</label>
		<span class="unit">${mainopinion.essayFirst}</span>
	</p>
	<p>
		<label>舆情级别(一级到四级)下拉列表选择*****：</label>
		<span class="unit">${mainopinion.opinionRank}</span>
	</p>
	<p>
		<label>当前状态(已派单:1； 已驳回:2；正常受理:3；超时受理:4；无效：0)*****：</label>
		<span class="unit">${mainopinion.opinionStatus}</span>
	</p>
	<p>
		<label>111：</label>
		<span class="unit">${mainopinion.createTime}</span>
	</p>
	
	<p>
		<label>核查附件id：</label>
		<span class="unit">${mainopinion.checkAId}</span>
	</p>
	<p>
		<label>核查备注****：</label>
		<span class="unit">${mainopinion.checkRmk}</span>
	</p>
	<p>
		<label>核查结果****：</label>
		<span class="unit">${mainopinion.checkResult}</span>
	</p>
	<p>
		<label>核查人员id*****：</label>
		<span class="unit">${mainopinion.checkUserid}</span>
	</p>
	<p>
		<label>单位处理附件id***：</label>
		<span class="unit">${mainopinion.handleAId}</span>
	</p>
	<p>
		<label>单位处理结果*****：</label>
		<span class="unit">${mainopinion.handleResult}</span>
	</p>
	</div>
	
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</div>