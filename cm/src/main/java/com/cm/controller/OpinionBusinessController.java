/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.cm.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletRequest;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ketayao.ketacustom.util.dwz.AjaxObject;
import com.ketayao.ketacustom.util.dwz.Page;
import com.ketayao.ketacustom.util.persistence.DynamicSpecifications;
import com.ketayao.ketacustom.log.Log;
import com.ketayao.ketacustom.log.LogMessageObject;
import com.ketayao.ketacustom.log.impl.LogUitls;
import com.cm.entity.OpinionBusiness;
import com.cm.service.OpinionBusinessService;

@Controller
@RequestMapping("/management/opinionBusiness/opinionBusiness")
public class OpinionBusinessController {

	@Autowired
	private OpinionBusinessService opinionBusinessService;
	
	private static final String CREATE = "management/opinionBusiness/opinionBusiness/create";
	private static final String UPDATE = "management/opinionBusiness/opinionBusiness/update";
	private static final String LIST = "management/opinionBusiness/opinionBusiness/list";
	private static final String VIEW = "management/opinionBusiness/opinionBusiness/view";
	
	@InitBinder
	public void dataBinder(WebDataBinder dataBinder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		dataBinder.registerCustomEditor(Date.class, 
				new CustomDateEditor(df, true));
	}
	
	@RequiresPermissions("OpinionBusiness:save")
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String preCreate(Map<String, Object> map) {
		return CREATE;
	}
	
	@Log(message="添加了id={0}任务。")
	@RequiresPermissions("OpinionBusiness:save")
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public @ResponseBody String create(@Valid OpinionBusiness opinionBusiness) {
		opinionBusinessService.saveOrUpdate(opinionBusiness);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{opinionBusiness.getId()}));
		return AjaxObject.newOk("任务添加成功！").toString();
	}
	
	@ModelAttribute("preloadOpinionBusiness")
	public OpinionBusiness preload(@RequestParam(value = "id", required = false) Long id) {
		if (id != null) {
			OpinionBusiness opinionBusiness = opinionBusinessService.get(id);
			return opinionBusiness;
		}
		return null;
	}
	
	@RequiresPermissions("OpinionBusiness:edit")
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String preUpdate(@PathVariable Long id, Map<String, Object> map) {
		OpinionBusiness opinionBusiness = opinionBusinessService.get(id);
		map.put("opinionBusiness", opinionBusiness);
		return UPDATE;
	}
	
	@Log(message="修改了id={0}任务的信息。")
	@RequiresPermissions("OpinionBusiness:edit")
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public @ResponseBody String update(@Valid @ModelAttribute("preloadOpinionBusiness")OpinionBusiness opinionBusiness) {
		opinionBusinessService.saveOrUpdate(opinionBusiness);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{opinionBusiness.getId()}));
		return AjaxObject.newOk("任务修改成功！").toString();
	}

	@Log(message="删除了id={0}任务。")
	@RequiresPermissions("OpinionBusiness:delete")
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public @ResponseBody String delete(@PathVariable Long id) {
		opinionBusinessService.delete(id);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{id}));
		return AjaxObject.newOk("任务删除成功！").setCallbackType("").toString();
	}
	
	@Log(message="批量删除了id={0}任务。")
	@RequiresPermissions("OpinionBusiness:delete")
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody String deleteMany(Long[] ids) {
		for (int i = 0; i < ids.length; i++) {
			OpinionBusiness opinionBusiness = opinionBusinessService.get(ids[i]);
			opinionBusinessService.delete(opinionBusiness.getId());
		}
		
		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{Arrays.toString(ids)}));
		return AjaxObject.newOk("任务删除成功！").setCallbackType("").toString();
	}

	@RequiresPermissions("OpinionBusiness:view")
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(ServletRequest request, Page page, Map<String, Object> map) {
		Specification<OpinionBusiness> specification = DynamicSpecifications.bySearchFilter(request, OpinionBusiness.class);
		List<OpinionBusiness> opinionBusinesss = opinionBusinessService.findByExample(specification, page);
		
		map.put("page", page);
		map.put("opinionBusinesss", opinionBusinesss);

		return LIST;
	}
	
	@RequiresPermissions("OpinionBusiness:view")
	@RequestMapping(value="/view/{id}", method={RequestMethod.GET})
	public String view(@PathVariable Long id, Map<String, Object> map) {
		OpinionBusiness opinionBusiness = opinionBusinessService.get(id);
		map.put("opinionBusiness", opinionBusiness);
		return VIEW;
	}
}
