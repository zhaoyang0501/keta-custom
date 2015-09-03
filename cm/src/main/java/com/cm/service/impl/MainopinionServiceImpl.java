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
import com.cm.entity.Mainopinion;
import com.cm.dao.MainopinionDAO;
import com.cm.service.MainopinionService;

@Service
@Transactional
public class MainopinionServiceImpl implements MainopinionService {
	
	@Autowired
	private MainopinionDAO mainopinionDAO;

	/*
	 * (non-Javadoc)
	 * @see com.cm.service.MainopinionService#get(java.lang.Long)  
	 */ 
	@Override
	public Mainopinion get(String id) {
		return mainopinionDAO.findOne(id);
	}

	/*
	 * (non-Javadoc) 
	 * @see com.cm.service.MainopinionService#saveOrUpdate(com.cm.entity.Mainopinion)  
	 */
	@Override
	public void saveOrUpdate(Mainopinion mainopinion) {
		mainopinionDAO.save(mainopinion);
	}

	/*
	 * (non-Javadoc)
	 * @see com.cm.service.MainopinionService#delete(java.lang.Long)  
	 */
	@Override
	public void delete(String id) {
		mainopinionDAO.delete(id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.cm.service.MainopinionService#findAll(com.ketayao.ketacustom.util.dwz.Page)  
	 */
	@Override
	public List<Mainopinion> findAll(Page page) {
		org.springframework.data.domain.Page<Mainopinion> springDataPage = mainopinionDAO.findAll(PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.cm.service.MainopinionService#findByExample(org.springframework.data.jpa.domain.Specification, com.ketayao.ketacustom.util.dwz.Page)	
	 */
	@Override
	public List<Mainopinion> findByExample(
			Specification<Mainopinion> specification, Page page) {
		org.springframework.data.domain.Page<Mainopinion> springDataPage = mainopinionDAO.findAll(specification, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}
}
