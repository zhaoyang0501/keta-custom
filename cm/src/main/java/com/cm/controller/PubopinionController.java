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
import com.cm.entity.Pubopinion;
import com.cm.service.PubopinionService;

@Controller
@RequestMapping("/management/pubopinion/pubopinion")
public class PubopinionController {

	@Autowired
	private PubopinionService pubopinionService;
	
	private static final String CREATE = "management/pubopinion/pubopinion/create";
	private static final String UPDATE = "management/pubopinion/pubopinion/update";
	private static final String LIST = "management/pubopinion/pubopinion/list";
	private static final String VIEW = "management/pubopinion/pubopinion/view";
	
	
	@InitBinder
	public void dataBinder(WebDataBinder dataBinder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		dataBinder.registerCustomEditor(Date.class, 
				new CustomDateEditor(df, true));
	}
	
	@RequiresPermissions("Pubopinion:save")
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String preCreate(Map<String, Object> map) {
		return CREATE;
	}
	
	@Log(message="添加了id={0}任务。")
	@RequiresPermissions("Pubopinion:save")
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public @ResponseBody String create(@Valid Pubopinion pubopinion) {
		pubopinionService.saveOrUpdate(pubopinion);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{pubopinion.getId()}));
		return AjaxObject.newOk("任务添加成功！").toString();
	}
	
	@ModelAttribute("preloadPubopinion")
	public Pubopinion preload(@RequestParam(value = "id", required = false) Long id) {
		if (id != null) {
			Pubopinion pubopinion = pubopinionService.get(id);
			return pubopinion;
		}
		return null;
	}
	
	@RequiresPermissions("Pubopinion:edit")
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String preUpdate(@PathVariable Long id, Map<String, Object> map) {
		Pubopinion pubopinion = pubopinionService.get(id);
		map.put("pubopinion", pubopinion);
		return UPDATE;
	}
	
	@Log(message="修改了id={0}任务的信息。")
	@RequiresPermissions("Pubopinion:edit")
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public @ResponseBody String update(@Valid @ModelAttribute("preloadPubopinion")Pubopinion pubopinion) {
		pubopinionService.saveOrUpdate(pubopinion);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{pubopinion.getId()}));
		return AjaxObject.newOk("任务修改成功！").toString();
	}

	@Log(message="删除了id={0}任务。")
	@RequiresPermissions("Pubopinion:delete")
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public @ResponseBody String delete(@PathVariable Long id) {
		pubopinionService.delete(id);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{id}));
		return AjaxObject.newOk("任务删除成功！").setCallbackType("").toString();
	}
	
	@Log(message="批量删除了id={0}任务。")
	@RequiresPermissions("Pubopinion:delete")
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody String deleteMany(Long[] ids) {
		for (int i = 0; i < ids.length; i++) {
			Pubopinion pubopinion = pubopinionService.get(ids[i]);
			pubopinionService.delete(pubopinion.getId());
		}
		
		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{Arrays.toString(ids)}));
		return AjaxObject.newOk("任务删除成功！").setCallbackType("").toString();
	}

	@RequiresPermissions("Pubopinion:view")
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(ServletRequest request, Page page, Map<String, Object> map) {
		Specification<Pubopinion> specification = DynamicSpecifications.bySearchFilter(request, Pubopinion.class);
		List<Pubopinion> pubopinions = pubopinionService.findByExample(specification, page);
		
		map.put("page", page);
		map.put("pubopinions", pubopinions);

		return LIST;
	}
	
	@RequiresPermissions("Pubopinion:view")
	@RequestMapping(value="/view/{id}", method={RequestMethod.GET})
	public String view(@PathVariable Long id, Map<String, Object> map) {
		Pubopinion pubopinion = pubopinionService.get(id);
		map.put("pubopinion", pubopinion);
		return VIEW;
	}
}
