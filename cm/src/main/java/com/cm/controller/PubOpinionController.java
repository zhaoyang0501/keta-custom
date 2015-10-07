/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.cm.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cm.entity.Opinion;
import com.cm.entity.OpinionBusiness;
import com.cm.entity.PubOpinion;
import com.cm.service.OpinionBusinessService;
import com.cm.service.OpinionService;
import com.cm.service.PubOpinionService;
import com.ketayao.ketacustom.log.Log;
import com.ketayao.ketacustom.log.LogMessageObject;
import com.ketayao.ketacustom.log.impl.LogUitls;
import com.ketayao.ketacustom.shiro.ShiroUser;
import com.ketayao.ketacustom.util.dwz.AjaxObject;
import com.ketayao.ketacustom.util.dwz.Page;
import com.ketayao.ketacustom.util.persistence.DynamicSpecifications;
import com.ketayao.ketacustom.util.persistence.SearchFilter;
import com.ketayao.ketacustom.util.persistence.SearchFilter.Operator;
import com.ketayao.utils.SecurityUtils;

@Controller
@RequestMapping("/management/pubOpinion/pubOpinion")
public class PubOpinionController {

	@Autowired
	private PubOpinionService pubOpinionService;

	@Autowired
	private OpinionService mainOpinionService;

	@Autowired
	private OpinionBusinessService opinionBusinessService;

	private static final String CREATE = "management/pubOpinion/pubOpinion/create";
	private static final String UPDATE = "management/pubOpinion/pubOpinion/update";
	private static final String LIST = "management/pubOpinion/pubOpinion/list";
	private static final String VIEW = "management/pubOpinion/pubOpinion/view";
	private static final String ACCEPT = "management/pubOpinion/pubOpinion/accept";

	@InitBinder
	public void dataBinder(WebDataBinder dataBinder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
	}

	@RequiresPermissions("PubOpinion:save")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String preCreate(Map<String, Object> map) {
		return CREATE;
	}

	@Log(message = "添加了id={0}任务。")
	@RequiresPermissions("PubOpinion:save")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody String create(@Valid PubOpinion pubOpinion) {
		pubOpinion.setCreateTime(new Date());
		pubOpinion.setCreateUserid("bbb");
		pubOpinionService.saveOrUpdate(pubOpinion);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[] { pubOpinion.getId() }));
		return AjaxObject.newOk("任务添加成功！").toString();
	}

	@ModelAttribute("preloadPubopinion")
	public PubOpinion preload(@RequestParam(value = "id", required = false) Long id) {
		if (id != null) {
			PubOpinion pubOpinion = pubOpinionService.get(id);
			return pubOpinion;
		}
		return null;
	}

	@RequiresPermissions("PubOpinion:edit")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String preUpdate(@PathVariable Long id, Map<String, Object> map) {
		PubOpinion pubOpinion = pubOpinionService.get(id);
		map.put("pubOpinion", pubOpinion);
		return UPDATE;
	}

	@Log(message = "修改了id={0}任务的信息。")
	@RequiresPermissions("PubOpinion:edit")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody String update(@Valid @ModelAttribute("preloadPubopinion") PubOpinion pubOpinion) {
		pubOpinionService.saveOrUpdate(pubOpinion);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[] { pubOpinion.getId() }));
		return AjaxObject.newOk("任务修改成功！").toString();
	}

	@Log(message = "删除了id={0}任务。")
	@RequiresPermissions("PubOpinion:delete")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public @ResponseBody String delete(@PathVariable Long id) {
		pubOpinionService.delete(id);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[] { id }));
		return AjaxObject.newOk("任务删除成功！").setCallbackType("").toString();
	}

	@Log(message = "批量删除了id={0}任务。")
	@RequiresPermissions("PubOpinion:delete")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody String deleteMany(Long[] ids) {
		for (int i = 0; i < ids.length; i++) {
			PubOpinion pubOpinion = pubOpinionService.get(ids[i]);
			pubOpinionService.delete(pubOpinion.getId());
		}

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[] { Arrays.toString(ids) }));
		return AjaxObject.newOk("任务删除成功！").setCallbackType("").toString();
	}

	@RequiresPermissions("PubOpinion:view")
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(ServletRequest request, Page page, Map<String, Object> map) {
		String status = "404";
		Specification<PubOpinion> specification = DynamicSpecifications.bySearchFilter(request, PubOpinion.class,
				new SearchFilter("status", Operator.EQ, status));
		List<PubOpinion> pubopinions = pubOpinionService.findByExample(specification, page);

		map.put("page", page);
		map.put("pubopinions", pubopinions);

		return LIST;
	}

	@RequiresPermissions("PubOpinion:view")
	@RequestMapping(value = "/view", method = { RequestMethod.GET })
	public String view(Long id, Map<String, Object> map) {
		PubOpinion pubOpinion = pubOpinionService.get(id);
		List<OpinionBusiness> opinionBusiness=opinionBusinessService.findByMainOpinionId(String.valueOf(id));
		map.put("pubOpinion", pubOpinion);
		map.put("opinionBusiness", opinionBusiness);
		return VIEW;
	}

	@RequiresPermissions("PubOpinion:view")
	@RequestMapping(value = "/accept", method = { RequestMethod.GET })
	public String accept(Long id, Map<String, Object> map) {
		PubOpinion pubOpinion = pubOpinionService.get(id);
		map.put("pubOpinion", pubOpinion);
		return ACCEPT;
	}

	/**
	 * 信息处置员受理
	 * 
	 * @param pubOpinion
	 * @return
	 */
	@Log(message = "添加了id={0}任务。")
	@RequiresPermissions("PubOpinion:save")
	@RequestMapping(value = "/accept", method = RequestMethod.POST)
	public @ResponseBody String accept(@Valid @ModelAttribute("preloadPubopinion") PubOpinion pubOpinion) {
		pubOpinion.setReplyTime(new Date());
		pubOpinion.setConts(pubOpinion.getConts());
		ShiroUser shiroUser = SecurityUtils.getShiroUser();
		pubOpinion.setStatus("406");
		pubOpinion.setReplyUserid(shiroUser.getUser().getUsername());
		pubOpinionService.saveOrUpdate(pubOpinion);

		Opinion opinion = mainOpinionService.findByPubopinionId(pubOpinion.getId());
		if (opinion == null) {
			Opinion mainopinion = new Opinion();
			mainopinion.setId(UUID.randomUUID().toString().replace("-", ""));
			mainopinion.setAcceptUserid(shiroUser.getUser().getUsername());
			mainopinion.setOpinionStatus("706");
			mainopinion.setPubopinion(pubOpinion);
			mainOpinionService.saveOrUpdate(mainopinion);
		} else {
			opinion.setOpinionStatus("706");
			mainOpinionService.saveOrUpdate(opinion);
		}

		OpinionBusiness opinionBusiness = new OpinionBusiness();
		opinionBusiness.setActionUserid(shiroUser.getUser().getUsername());
		if (opinion != null) {
			opinionBusiness.setActionName("再次受理");
		} else {
			opinionBusiness.setActionName("已受理");
		}
		opinionBusiness.setActionConts(pubOpinion.getConts());
		opinionBusiness.setMainOpinionId(String.valueOf(pubOpinion.getId()));
		opinionBusiness.setCreateTime(new Date());
		opinionBusinessService.saveOrUpdate(opinionBusiness);
		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[] { pubOpinion.getId() }));
		return AjaxObject.newOk("操作成功！").toString();
	}

	/**
	 * 信息处置员回退
	 * 
	 * @param pubOpinion
	 * @return
	 */
	@Log(message = "添加了id={0}任务。")
	@RequiresPermissions("PubOpinion:save")
	@RequestMapping(value = "/doBack", method = RequestMethod.POST)
	public @ResponseBody String doBack(@Valid @ModelAttribute("preloadPubopinion") PubOpinion pubOpinion) {
		pubOpinion.setReplyTime(new Date());
		pubOpinion.setConts(pubOpinion.getConts());
		ShiroUser shiroUser = SecurityUtils.getShiroUser();
		pubOpinion.setStatus("408");
		pubOpinion.setReplyUserid(shiroUser.getUser().getUsername());
		pubOpinionService.saveOrUpdate(pubOpinion);

		OpinionBusiness opinionBusiness = new OpinionBusiness();
		opinionBusiness.setActionUserid(shiroUser.getUser().getUsername());
		opinionBusiness.setActionName("回退");
		opinionBusiness.setActionConts(pubOpinion.getConts());
		opinionBusiness.setMainOpinionId(String.valueOf(pubOpinion.getId()));
		opinionBusiness.setCreateTime(new Date());
		opinionBusinessService.saveOrUpdate(opinionBusiness);
		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[] { pubOpinion.getId() }));
		return AjaxObject.newOk("操作成功！").toString();
	}
}
