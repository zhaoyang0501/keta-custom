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
import com.cm.entity.Opinion;
import com.cm.dao.OpinionDAO;
import com.cm.service.OpinionService;

@Service
@Transactional
public class OpinionServiceImpl implements OpinionService {
	
	@Autowired
	private OpinionDAO opinionDAO;

	/*
	 * (non-Javadoc)
	 * @see com.cm.service.opinionService#get(java.lang.Long)  
	 */ 
	@Override
	public Opinion get(String id) {
		return opinionDAO.findOne(id);
	}

	/*
	 * (non-Javadoc) 
	 * @see com.cm.service.opinionService#saveOrUpdate(com.cm.entity.opinion)  
	 */
	@Override
	public void saveOrUpdate(Opinion opinion) {
		opinionDAO.save(opinion);
	}

	/*
	 * (non-Javadoc)
	 * @see com.cm.service.opinionService#delete(java.lang.Long)  
	 */
	@Override
	public void delete(String id) {
		opinionDAO.delete(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.cm.service.opinionService#findAll(com.ketayao.ketacustom.util.dwz.Page)  
	 */
	@Override
	public List<Opinion> findAll(Page page) {
		org.springframework.data.domain.Page<Opinion> springDataPage = opinionDAO.findAll(PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.cm.service.opinionService#findByExample(org.springframework.data.jpa.domain.Specification, com.ketayao.ketacustom.util.dwz.Page)	
	 */
	@Override
	public List<Opinion> findByExample(
			Specification<Opinion> specification, Page page) {
		org.springframework.data.domain.Page<Opinion> springDataPage = opinionDAO.findAll(specification, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

	@Override
	public Opinion findByPubopinionId(Long id) {
		return opinionDAO.findByPubopinionId(id);
	}
}
