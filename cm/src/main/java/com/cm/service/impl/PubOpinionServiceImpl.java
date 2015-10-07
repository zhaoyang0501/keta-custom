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
import com.cm.entity.PubOpinion;
import com.cm.dao.PubOpinionDAO;
import com.cm.service.PubOpinionService;

@Service
@Transactional
public class PubOpinionServiceImpl implements PubOpinionService {
	
	@Autowired
	private PubOpinionDAO pubopinionDAO;

	/*
	 * (non-Javadoc)
	 * @see com.cm.service.PubopinionService#get(java.lang.Long)  
	 */ 
	@Override
	public PubOpinion get(Long id) {
		return pubopinionDAO.findOne(id);
	}

	/*
	 * (non-Javadoc) 
	 * @see com.cm.service.PubopinionService#saveOrUpdate(com.cm.entity.Pubopinion)  
	 */
	@Override
	public void saveOrUpdate(PubOpinion pubopinion) {
		pubopinionDAO.save(pubopinion);
	}

	/*
	 * (non-Javadoc)
	 * @see com.cm.service.PubopinionService#delete(java.lang.Long)  
	 */
	@Override
	public void delete(Long id) {
		pubopinionDAO.delete(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.cm.service.PubopinionService#findAll(com.ketayao.ketacustom.util.dwz.Page)  
	 */
	@Override
	public List<PubOpinion> findAll(Page page) {
		org.springframework.data.domain.Page<PubOpinion> springDataPage = pubopinionDAO.findAll(PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.cm.service.PubopinionService#findByExample(org.springframework.data.jpa.domain.Specification, com.ketayao.ketacustom.util.dwz.Page)	
	 */
	@Override
	public List<PubOpinion> findByExample(
			Specification<PubOpinion> specification, Page page) {
		org.springframework.data.domain.Page<PubOpinion> springDataPage = pubopinionDAO.findAll(specification, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}
}
