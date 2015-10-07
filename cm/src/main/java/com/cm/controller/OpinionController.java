/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.cm.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

import com.cm.entity.Company;
import com.cm.entity.Opinion;
import com.cm.entity.OpinionBusiness;
import com.cm.service.CompanyService;
import com.cm.service.OpinionBusinessService;
import com.cm.service.OpinionService;
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
@RequestMapping("/management/opinion/opinion")
public class OpinionController {

	@Autowired
	private OpinionService opinionService;

	@Autowired
	private OpinionBusinessService opinionBusinessService;
	
	@Autowired
	private CompanyService companyService;

	private static final String CREATE = "management/opinion/opinion/create";
	private static final String UPDATE = "management/opinion/opinion/update";
	private static final String LIST = "management/opinion/opinion/list";
	private static final String VIEW = "management/opinion/opinion/view";
	private static final String LISTOPINIONCHECK = "management/opinion/opinion/listOpinionCheck";
	private static final String CHECK = "management/opinion/opinion/check";
	private static final String JAQR = "management/opinion/opinion/jaqr";
	private static final String LISTOPINIONSELF = "management/opinion/opinion/listOpinionSelf";
	private static final String SELF = "management/opinion/opinion/self";
	private static final String LISTOPINIONRECEIVE = "management/opinion/opinion/listOpinionReceive";
	private static final String RECEIVE = "management/opinion/opinion/receive";
	private static final String LISTOPINIONCHECK2 = "management/opinion/opinion/listOpinionCheck2";
	private static final String CHECK2 = "management/opinion/opinion/check2";
	private static final String LISTOPINIONOVER2 = "management/opinion/opinion/listOpinionOver2";
	private static final String APHCOPINION = "management/opinion/opinion/aphcOpinion";

	@InitBinder
	public void dataBinder(WebDataBinder dataBinder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
	}

	@RequiresPermissions("opinion:save")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String preCreate(Map<String, Object> map) {
		return CREATE;
	}

	@Log(message = "添加了id={0}任务。")
	@RequiresPermissions("opinion:save")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody String create(@Valid Opinion opinion) {
		opinionService.saveOrUpdate(opinion);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[] { opinion.getId() }));
		return AjaxObject.newOk("任务添加成功！").toString();
	}

	@ModelAttribute("preloadopinion")
	public Opinion preload(@RequestParam(value = "id", required = false) String id) {
		if (id != null) {
			Opinion opinion = opinionService.get(id);
			return opinion;
		}
		return null;
	}

	@RequiresPermissions("opinion:edit")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String preUpdate(@PathVariable String id, Map<String, Object> map) {
		Opinion opinion = opinionService.get(id);
		map.put("opinion", opinion);
		return UPDATE;
	}

	@Log(message = "修改了id={0}任务的信息。")
	@RequiresPermissions("opinion:edit")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody String update(@Valid @ModelAttribute("preloadopinion") Opinion opinion) {
		opinionService.saveOrUpdate(opinion);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[] { opinion.getId() }));
		return AjaxObject.newOk("任务修改成功！").toString();
	}

	@Log(message = "删除了id={0}任务。")
	@RequiresPermissions("opinion:delete")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public @ResponseBody String delete(@PathVariable String id) {
		opinionService.delete(id);

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[] { id }));
		return AjaxObject.newOk("任务删除成功！").setCallbackType("").toString();
	}

	@Log(message = "批量删除了id={0}任务。")
	@RequiresPermissions("opinion:delete")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody String deleteMany(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			Opinion opinion = opinionService.get(ids[i]);
			opinionService.delete(opinion.getId());
		}

		LogUitls.putArgs(LogMessageObject.newWrite().setObjects(new Object[] { Arrays.toString(ids) }));
		return AjaxObject.newOk("任务删除成功！").setCallbackType("").toString();
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(ServletRequest request, Page page, Map<String, Object> map) {
		Specification<Opinion> specification = DynamicSpecifications.bySearchFilter(request, Opinion.class);
		List<Opinion> opinions = opinionService.findByExample(specification, page);

		map.put("page", page);
		map.put("opinions", opinions);

		return LIST;
	}

	@RequiresPermissions("opinion:view")
	@RequestMapping(value = "/view", method = { RequestMethod.GET })
	public String view(String id, Map<String, Object> map) {
		Opinion opinion = opinionService.get(id);
		List<OpinionBusiness> opinionBusiness=opinionBusinessService.findByMainOpinionId(String.valueOf(opinion.getPubopinion().getId()));
		map.put("opinion", opinion);
		map.put("opinionBusiness", opinionBusiness);
		return VIEW;
	}

	/**
	 * 中心值班长list
	 */
	@RequestMapping(value = "/listOpinionCheck", method = { RequestMethod.GET, RequestMethod.POST })
	public String listOpinionCheck(ServletRequest request, Page page, Map<String, Object> map) {
		List<String> opinionStatus =new ArrayList<String>();
		opinionStatus.add("706");
		opinionStatus.add("714");
		Specification<Opinion> specification = DynamicSpecifications.bySearchFilter(request, Opinion.class,
				new SearchFilter("opinionStatus", Operator.IN, opinionStatus));
		List<Opinion> opinions = opinionService.findByExample(specification, page);

		map.put("page", page);
		map.put("opinions", opinions);

		return LISTOPINIONCHECK;
	}

	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public String check(String id, Map<String, Object> map) {
		Opinion opinion = opinionService.get(id);
		map.put("opinion", opinion);
		return CHECK;
	}

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public @ResponseBody String check(@Valid @ModelAttribute("preloadopinion") Opinion opinion) {
		ShiroUser shiroUser = SecurityUtils.getShiroUser();
		opinion.setOpinionStatus("708");

		opinion.setDoingUserid(shiroUser.getUser().getUsername());
		opinion.setEssayFirst("0");
		opinion.setReportTime(new Date());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 30);
		opinion.setFeedbackTime(cal.getTime());

		opinionService.saveOrUpdate(opinion);

		OpinionBusiness opinionBusiness = new OpinionBusiness();
		opinionBusiness.setActionUserid(shiroUser.getUser().getUsername());
		opinionBusiness.setActionName("立案");
		opinionBusiness.setActionConts("同意立案");
		opinionBusiness.setMainOpinionId(String.valueOf(opinion.getPubopinion().getId()));
		opinionBusiness.setCreateTime(new Date());
		opinionBusinessService.saveOrUpdate(opinionBusiness);
		return AjaxObject.newOk("操作成功！").toString();
	}

	@RequestMapping(value = "/jaqr", method = RequestMethod.GET)
	public String jaqr(String id, Map<String, Object> map) {
		Opinion opinion = opinionService.get(id);
		map.put("opinion", opinion);
		return JAQR;
	}

	@RequestMapping(value = "/jaqr", method = RequestMethod.POST)
	public @ResponseBody String jaqr(@Valid @ModelAttribute("preloadopinion") Opinion opinion) {
		ShiroUser shiroUser = SecurityUtils.getShiroUser();
		opinion.setOpinionStatus("716");

		opinion.setReportTime(new Date());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 30);
		opinion.setFeedbackTime(cal.getTime());

		opinionService.saveOrUpdate(opinion);

		OpinionBusiness opinionBusiness = new OpinionBusiness();
		opinionBusiness.setActionUserid(shiroUser.getUser().getUsername());
		opinionBusiness.setActionName("结案");
		opinionBusiness.setActionConts(opinion.getRmks());
		opinionBusiness.setMainOpinionId(String.valueOf(opinion.getPubopinion().getId()));
		opinionBusiness.setCreateTime(new Date());
		opinionBusinessService.saveOrUpdate(opinionBusiness);
		return AjaxObject.newOk("操作成功！").toString();
	}
	
	/**
	 * 信息处置员待处理案件
	 */
	@RequestMapping(value = "/listOpinionSelf", method = { RequestMethod.GET, RequestMethod.POST })
	public String listOpinionSelf(ServletRequest request, Page page, Map<String, Object> map) {
		List<String> opinionStatus =new ArrayList<String>();
		opinionStatus.add("708");
		opinionStatus.add("707");
		opinionStatus.add("712");
		Specification<Opinion> specification = DynamicSpecifications.bySearchFilter(request, Opinion.class,
				new SearchFilter("opinionStatus", Operator.IN, opinionStatus));
		List<Opinion> opinions = opinionService.findByExample(specification, page);

		map.put("page", page);
		map.put("opinions", opinions);
		return LISTOPINIONSELF;
	}
	
	/**
	 * 信息处置员派遣
	 */
	@RequestMapping(value = "/self", method = RequestMethod.GET)
	public String self(String id, Map<String, Object> map) {
		Opinion opinion = opinionService.get(id);
		List<Company> companyList=companyService.findAllByCompanyType("263");
		map.put("opinion", opinion);
		map.put("companyList", companyList);
		return SELF;
	}

	@RequestMapping(value = "/self", method = RequestMethod.POST)
	public @ResponseBody String self(@Valid @ModelAttribute("preloadopinion") Opinion opinion) {
		ShiroUser shiroUser = SecurityUtils.getShiroUser();
		opinion.setOpinionStatus("710");

		opinion.setReportTime(new Date());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 30);
		opinion.setFeedbackTime(cal.getTime());
//		opinion.setGuildTypeId(guildTypeId);
//		opinion.setGuildUnitId(guildUnitId);
		
		opinionService.saveOrUpdate(opinion);

		OpinionBusiness opinionBusiness = new OpinionBusiness();
		opinionBusiness.setActionUserid(shiroUser.getUser().getUsername());
		opinionBusiness.setActionName("派遣");
		opinionBusiness.setActionConts(opinion.getRmks()+":"+cal.getTime()+",派遣单位："+opinion.getGuildUnitId());
		opinionBusiness.setMainOpinionId(String.valueOf(opinion.getPubopinion().getId()));
		opinionBusiness.setCreateTime(new Date());
		opinionBusinessService.saveOrUpdate(opinionBusiness);
		return AjaxObject.newOk("操作成功！").toString();
	}
	
	/**
	 * 信息处置员安排检查
	 */
	@RequestMapping(value = "/aphcOpinion", method = RequestMethod.GET)
	public String aphcOpinion(String id, Map<String, Object> map) {
		Opinion opinion = opinionService.get(id);
		map.put("opinion", opinion);
		return APHCOPINION;
	}

	@RequestMapping(value = "/aphcOpinion", method = RequestMethod.POST)
	public @ResponseBody String aphcOpinion(@Valid @ModelAttribute("preloadopinion") Opinion opinion) {
		ShiroUser shiroUser = SecurityUtils.getShiroUser();
		opinion.setOpinionStatus("713");

		opinion.setReportTime(new Date());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 30);
		opinion.setFeedbackTime(cal.getTime());
//		opinion.setGuildTypeId(guildTypeId);
//		opinion.setGuildUnitId(guildUnitId);
//		opinion.setCheckUserid(checkUserid);
		opinionService.saveOrUpdate(opinion);

		OpinionBusiness opinionBusiness = new OpinionBusiness();
		opinionBusiness.setActionUserid(shiroUser.getUser().getUsername());
		opinionBusiness.setActionName("安排核查");
		opinionBusiness.setActionConts(opinion.getHandleResult());
		opinionBusiness.setMainOpinionId(String.valueOf(opinion.getPubopinion().getId()));
		opinionBusiness.setCreateTime(new Date());
		opinionBusinessService.saveOrUpdate(opinionBusiness);
		return AjaxObject.newOk("操作成功！").toString();
	}
	
	/**
	 * 	职能单位待接收案件
	 */
	@RequestMapping(value = "/listOpinionReceive", method = { RequestMethod.GET, RequestMethod.POST })
	public String listOpinionReceive(ServletRequest request, Page page, Map<String, Object> map) {
		String opinionStatus = "710";
		String guildUnitId=SecurityUtils.getLoginUser().getOrganization().getId().toString();
		Specification<Opinion> specification = DynamicSpecifications.bySearchFilter(request, Opinion.class,
				new SearchFilter("opinionStatus", Operator.EQ, opinionStatus),
				new SearchFilter("guildUnitId", Operator.EQ, guildUnitId));
		List<Opinion> opinions = opinionService.findByExample(specification, page);

		map.put("page", page);
		map.put("opinions", opinions);
		return LISTOPINIONRECEIVE;
	}
	
	@RequestMapping(value = "/receive", method = RequestMethod.GET)
	public String receive(String id, Map<String, Object> map) {
		Opinion opinion = opinionService.get(id);
		map.put("opinion", opinion);
		return RECEIVE;
	}

	@RequestMapping(value = "/receive", method = RequestMethod.POST)
	public @ResponseBody String receive(@Valid @ModelAttribute("preloadopinion") Opinion opinion) {
		ShiroUser shiroUser = SecurityUtils.getShiroUser();
		opinion.setOpinionStatus("782");

		opinion.setReportTime(new Date());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 30);
		opinion.setFeedbackTime(cal.getTime());
//		opinion.setGuildTypeId(guildTypeId);
//		opinion.setGuildUnitId(guildUnitId);
		opinion.setUnitUserid(shiroUser.getUser().getUsername());
//		opinion.setHandleResult(handleResult);
		opinionService.saveOrUpdate(opinion);

		OpinionBusiness opinionBusiness = new OpinionBusiness();
		opinionBusiness.setActionUserid(shiroUser.getUser().getUsername());
		opinionBusiness.setActionName("单位接受");
		opinionBusiness.setActionConts(opinion.getHandleResult());
		opinionBusiness.setMainOpinionId(String.valueOf(opinion.getPubopinion().getId()));
		opinionBusiness.setCreateTime(new Date());
		opinionBusinessService.saveOrUpdate(opinionBusiness);
		return AjaxObject.newOk("操作成功！").toString();
	}
	
	
	/**
	 * 职能单位待处理案件
	 */
	@RequestMapping(value = "/listOpinionCheck2", method = { RequestMethod.GET, RequestMethod.POST })
	public String listOpinionCheck2(ServletRequest request, Page page, Map<String, Object> map) {
		String opinionStatus = "782";
		String guildUnitId=SecurityUtils.getShiroUser().getUser().getOrganization().getId().toString();
		Specification<Opinion> specification = DynamicSpecifications.bySearchFilter(request, Opinion.class,
				new SearchFilter("opinionStatus", Operator.EQ, opinionStatus),
				new SearchFilter("guildUnitId", Operator.EQ, guildUnitId));
		List<Opinion> opinions = opinionService.findByExample(specification, page);

		map.put("page", page);
		map.put("opinions", opinions);
		return LISTOPINIONCHECK2;
	}
	
	@RequestMapping(value = "/check2", method = RequestMethod.GET)
	public String check2(String id, Map<String, Object> map) {
		Opinion opinion = opinionService.get(id);
		map.put("opinion", opinion);
		return CHECK2;
	}

	@RequestMapping(value = "/check2", method = RequestMethod.POST)
	public @ResponseBody String check2(@Valid @ModelAttribute("preloadopinion") Opinion opinion) {
		ShiroUser shiroUser = SecurityUtils.getShiroUser();
		opinion.setOpinionStatus("712");

		opinion.setReportTime(new Date());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 30);
		opinion.setFeedbackTime(cal.getTime());
//		opinion.setHandleResult(handleResult);
		opinionService.saveOrUpdate(opinion);

		OpinionBusiness opinionBusiness = new OpinionBusiness();
		opinionBusiness.setActionUserid(shiroUser.getUser().getUsername());
		opinionBusiness.setActionName("处理反馈");
		opinionBusiness.setActionConts(opinion.getHandleResult());
		opinionBusiness.setMainOpinionId(String.valueOf(opinion.getPubopinion().getId()));
		opinionBusiness.setCreateTime(new Date());
		opinionBusinessService.saveOrUpdate(opinionBusiness);
		return AjaxObject.newOk("操作成功！").toString();
	}
	
	/**
	 *  职能单位回退案件
	 */
	@RequestMapping(value = "/check2back", method = RequestMethod.GET)
	public String check2back(String id, Map<String, Object> map) {
		Opinion opinion = opinionService.get(id);
		map.put("opinion", opinion);
		return CHECK2;
	}

	@RequestMapping(value = "/check2back", method = RequestMethod.POST)
	public @ResponseBody String check2back(@Valid @ModelAttribute("preloadopinion") Opinion opinion) {
		ShiroUser shiroUser = SecurityUtils.getShiroUser();
		opinion.setOpinionStatus("708");

		opinion.setReportTime(new Date());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 30);
		opinion.setFeedbackTime(cal.getTime());
//		opinion.setHandleResult(handleResult);
		opinionService.saveOrUpdate(opinion);

		OpinionBusiness opinionBusiness = new OpinionBusiness();
		opinionBusiness.setActionUserid(shiroUser.getUser().getUsername());
		opinionBusiness.setActionName("单位回退");
		opinionBusiness.setActionConts(opinion.getHandleResult());
		opinionBusiness.setMainOpinionId(String.valueOf(opinion.getPubopinion().getId()));
		opinionBusiness.setCreateTime(new Date());
		opinionBusinessService.saveOrUpdate(opinionBusiness);
		return AjaxObject.newOk("操作成功！").toString();
	}
	
	/**
	 * 职能单位已处理案件
	 */
	@RequestMapping(value = "/listOpinionOver2", method = { RequestMethod.GET, RequestMethod.POST })
	public String listOpinionOver2(ServletRequest request, Page page, Map<String, Object> map) {
		String opinionStatus = "712";
		String guildUnitId=SecurityUtils.getLoginUser().getOrganization().getId().toString();
		Specification<Opinion> specification = DynamicSpecifications.bySearchFilter(request, Opinion.class,
				new SearchFilter("opinionStatus", Operator.EQ, opinionStatus),
				new SearchFilter("guildUnitId", Operator.EQ, guildUnitId));
		List<Opinion> opinions = opinionService.findByExample(specification, page);

		map.put("page", page);
		map.put("opinions", opinions);
		return LISTOPINIONOVER2;
	}
}
