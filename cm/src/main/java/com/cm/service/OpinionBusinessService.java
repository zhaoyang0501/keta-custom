/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.cm.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.cm.entity.OpinionBusiness;
import com.ketayao.ketacustom.util.dwz.Page;

public interface OpinionBusinessService {
	OpinionBusiness get(Long id);

	void saveOrUpdate(OpinionBusiness opinionBusiness);

	void delete(Long id);
	
	List<OpinionBusiness> findAll(Page page);
	
	List<OpinionBusiness> findByExample(Specification<OpinionBusiness> specification, Page page);
	
	List<OpinionBusiness>  findByMainOpinionId(String id);
}
