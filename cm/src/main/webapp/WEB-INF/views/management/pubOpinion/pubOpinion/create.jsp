<%@ page language="java" contentType="text/html; charset=UTF-8"
	trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
	<form method="post"
		action="${contextPath }/management/pubOpinion/pubOpinion/create"
		class="required-validate pageForm"
		onsubmit="return validateCallback(this, dialogReloadNavTab);">
		<div class="pageFormContent" layoutH="58">
			<p>
				<label>问题来源：</label>
				<dwz:dic themeName="问题来源" paramName="paramBacseid"
					className="required validate[required]">
					<option value="">--请选择问题来源--</option>
				</dwz:dic>
			</p>
			<p>
				<label>案件大类：</label>
				<dwz:dic themeName="案件大类" paramName="paramTypeB" className="combox"
					ref="w_combox_child"
					refUrl="${contextPath }/management/system/dictionary/parent_{value}">
					<option value="">--请选择案件大类--</option>
				</dwz:dic>
			</p>
			<p>
				<label>案件小类：</label>
				<dwz:dic themeName="市政公用设施" paramName="paramTypeS" id="w_combox_child">
					<option value="">--请选择案件小类--</option>
				</dwz:dic>
			</p>
			<p>
				<label>所属区域：</label>
				<dwz:dic themeName="所属区域" paramName="paramOrgId"
					className="required validate[required]">
					<option value="">--请选择城市管理监察大队--</option>
				</dwz:dic>
			</p>
			<p>
				<label>现场图片：</label> <input type="file" name="aId" maxlength="100"
					class="input-medium" />
			</p>
			<p>
				<label>地址：</label> <input type="text" name="address" maxlength="100"
					class="input-medium">
			</p>
			<div class="pageFormContent">
				<input id="file_upload" type="file"
					uploaderOption="{
        'auto':false,
        'successTimeout':300,
        'swf':'${contextPath}/styles/uploadify/scripts/uploadify.swf',
        'overrideEvents' : ['onDialogClose'],
        'queueID':'fileQueue',
        'fileObjName':'files',
        'uploader':'${contextPath}/management/component/resource/upload;jsessionid=<%=session.getId()%>?storeType=${storeType }',
        'buttonImage':'${contextPath}/styles/uploadify/img/add.jpg',
		'buttonClass':'my-uploadify-button',
        'width':'102',
        'height':'28',
        'removeComplete': false,
        'fileTypeDesc':'支持的格式：',
        'fileSizeLimit':'1MB',
        'queueSizeLimit' : 10,
        'onSelectError':function(file, errorCode, errorMsg){
            switch(errorCode) {
                case -100:
                    alert('上传的文件数量已经超出系统限制的'+$('#file_upload').uploadify('settings','queueSizeLimit')+'个文件！');
                    break;
                case -110:
                    alert('文件 ['+file.name+'] 大小超出系统限制的'+$('#file_upload').uploadify('settings','fileSizeLimit')+'大小！');
                    break;
                case -120:
                    alert('文件 ['+file.name+'] 大小异常！');
                    break;
                case -130:
                    alert('文件 ['+file.name+'] 类型不正确！');
                    break;
            }
        },
        'onFallback':function(){
            alert('您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。');
        },
        'onUploadError' : function(file, errorCode, errorMsg, errorString) {
        	if (errorCode == 403) {
        		forbidden();
        	}
            alert(file.name + '上传失败: ' + errorMsg + errorString);
        }
	}" />

				<div id="fileQueue" class="fileQueue"></div>
				<input type="image"
					src="${contextPath}/styles/uploadify/img/upload.jpg"
					onclick="$('#file_upload').uploadify('upload', '*');" /> <input
					type="image" src="${contextPath}/styles/uploadify/img/cancel.jpg"
					onclick="$('#file_upload').uploadify('cancel', '*');" />
			</div>
			<p>
				<label>问题内容：</label>
				<textarea name="conts" maxlength="4000"
					class="input-medium required validate[required]" />
			</p>
		</div>

		<div class="formBar">
			<ul>
				<li><div class="button">
						<div class="buttonContent">
							<button type="submit">确定</button>
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