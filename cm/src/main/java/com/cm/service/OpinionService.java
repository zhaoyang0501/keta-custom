/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.cm.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.cm.entity.Opinion;
import com.ketayao.ketacustom.util.dwz.Page;

public interface OpinionService {
	Opinion get(String id);

	void saveOrUpdate(Opinion opinion);

	void delete(String id);
	
	List<Opinion> findAll(Page page);
	
	List<Opinion> findByExample(Specification<Opinion> specification, Page page);
	
	Opinion findByPubopinionId(Long id);
}
