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
import com.cm.entity.Mainopinion;
import com.cm.service.MainopinionService;

@Controller
@RequestMapping("/management/mainopinion/mainopinion")
public class MainopinionController {

	@Autowired
	private MainopinionService mainopinionService;
	
	private static final String CREATE = "management/mainopinion/mainopinion/create";
	private static final String UPDATE = "management/mainopinion/mainopinion/update";
	private static final String LIST = "management/mainopinion/mainopinion/list";
	private static final String VIEW = "management/mainopinion/mainopinion/view";
	
	@InitBinder
	public void dataBinder(WebDataBinder dataBinder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		dataBinder.registerCustomEditor(Date.class, 
				new CustomDateEditor(df, true));
	}
	
	@RequiresPermissions("Mainopinion:save")
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String preCreate(Map<String, Object> map) {
		return CREATE;
	}
	
	@Log(message="添加了id={0}任务。")
	@RequiresPermissions("Mainopinion:save")
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public @ResponseBody String create(@Valid Mainopinion mainopinion) {
		mainopinionService.saveOrUpdate(mainopinion);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{mainopinion.getId()}));
		return AjaxObject.newOk("任务添加成功！").toString();
	}
	
	@ModelAttribute("preloadMainopinion")
	public Mainopinion preload(@RequestParam(value = "id", required = false) String id) {
		if (id != null) {
			Mainopinion mainopinion = mainopinionService.get(id);
			return mainopinion;
		}
		return null;
	}
	
	@RequiresPermissions("Mainopinion:edit")
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String preUpdate(@PathVariable String id, Map<String, Object> map) {
		Mainopinion mainopinion = mainopinionService.get(id);
		map.put("mainopinion", mainopinion);
		return UPDATE;
	}
	
	@Log(message="修改了id={0}任务的信息。")
	@RequiresPermissions("Mainopinion:edit")
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public @ResponseBody String update(@Valid @ModelAttribute("preloadMainopinion")Mainopinion mainopinion) {
		mainopinionService.saveOrUpdate(mainopinion);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{mainopinion.getId()}));
		return AjaxObject.newOk("任务修改成功！").toString();
	}

	@Log(message="删除了id={0}任务。")
	@RequiresPermissions("Mainopinion:delete")
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public @ResponseBody String delete(@PathVariable String id) {
		mainopinionService.delete(id);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{id}));
		return AjaxObject.newOk("任务删除成功！").setCallbackType("").toString();
	}
	
	@Log(message="批量删除了id={0}任务。")
	@RequiresPermissions("Mainopinion:delete")
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody String deleteMany(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			Mainopinion mainopinion = mainopinionService.get(ids[i]);
			mainopinionService.delete(mainopinion.getId());
		}
		
		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{Arrays.toString(ids)}));
		return AjaxObject.newOk("任务删除成功！").setCallbackType("").toString();
	}

	
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(ServletRequest request, Page page, Map<String, Object> map) {
		Specification<Mainopinion> specification = DynamicSpecifications.bySearchFilter(request, Mainopinion.class);
		List<Mainopinion> mainopinions = mainopinionService.findByExample(specification, page);
		
		map.put("page", page);
		map.put("mainopinions", mainopinions);

		return LIST;
	}
	
	@RequiresPermissions("Mainopinion:view")
	@RequestMapping(value="/view/{id}", method={RequestMethod.GET})
	public String view(@PathVariable String id, Map<String, Object> map) {
		Mainopinion mainopinion = mainopinionService.get(id);
		map.put("mainopinion", mainopinion);
		return VIEW;
	}
}
