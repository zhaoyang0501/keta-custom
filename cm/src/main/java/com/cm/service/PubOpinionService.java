/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.cm.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.cm.entity.PubOpinion;
import com.ketayao.ketacustom.util.dwz.Page;

public interface PubOpinionService {
	PubOpinion get(Long id);

	void saveOrUpdate(PubOpinion pubopinion);

	void delete(Long id);
	
	List<PubOpinion> findAll(Page page);
	
	List<PubOpinion> findByExample(Specification<PubOpinion> specification, Page page);
}
