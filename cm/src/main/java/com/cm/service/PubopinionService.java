/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.cm.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.cm.entity.Pubopinion;
import com.ketayao.ketacustom.util.dwz.Page;

public interface PubopinionService {
	Pubopinion get(Long id);

	void saveOrUpdate(Pubopinion pubopinion);

	void delete(Long id);
	
	List<Pubopinion> findAll(Page page);
	
	List<Pubopinion> findByExample(Specification<Pubopinion> specification, Page page);
}
