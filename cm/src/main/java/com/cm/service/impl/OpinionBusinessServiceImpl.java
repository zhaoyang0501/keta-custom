/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package	com.cm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ketayao.ketacustom.util.dwz.Page;
import com.ketayao.ketacustom.util.dwz.PageUtils;
import com.cm.entity.OpinionBusiness;
import com.cm.dao.OpinionBusinessDAO;
import com.cm.service.OpinionBusinessService;

@Service
@Transactional
public class OpinionBusinessServiceImpl implements OpinionBusinessService {
	
	@Autowired
	private OpinionBusinessDAO opinionBusinessDAO;

	/*
	 * (non-Javadoc)
	 * @see com.cm.service.OpinionBusinessService#get(java.lang.Long)  
	 */ 
	@Override
	public OpinionBusiness get(Long id) {
		return opinionBusinessDAO.findOne(id);
	}

	/*
	 * (non-Javadoc) 
	 * @see com.cm.service.OpinionBusinessService#saveOrUpdate(com.cm.entity.OpinionBusiness)  
	 */
	@Override
	public void saveOrUpdate(OpinionBusiness opinionBusiness) {
		opinionBusinessDAO.save(opinionBusiness);
	}

	/*
	 * (non-Javadoc)
	 * @see com.cm.service.OpinionBusinessService#delete(java.lang.Long)  
	 */
	@Override
	public void delete(Long id) {
		opinionBusinessDAO.delete(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.cm.service.OpinionBusinessService#findAll(com.ketayao.ketacustom.util.dwz.Page)  
	 */
	@Override
	public List<OpinionBusiness> findAll(Page page) {
		org.springframework.data.domain.Page<OpinionBusiness> springDataPage = opinionBusinessDAO.findAll(PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.cm.service.OpinionBusinessService#findByExample(org.springframework.data.jpa.domain.Specification, com.ketayao.ketacustom.util.dwz.Page)	
	 */
	@Override
	public List<OpinionBusiness> findByExample(
			Specification<OpinionBusiness> specification, Page page) {
		org.springframework.data.domain.Page<OpinionBusiness> springDataPage = opinionBusinessDAO.findAll(specification, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

	@Override
	public List<OpinionBusiness> findByMainOpinionId(String id) {
		return opinionBusinessDAO.findByMainOpinionId(id);
	}
}
