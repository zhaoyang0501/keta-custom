/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.cm.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.cm.entity.Mainopinion;
import com.ketayao.ketacustom.util.dwz.Page;

public interface MainopinionService {
	Mainopinion get(String id);

	void saveOrUpdate(Mainopinion mainopinion);

	void delete(String id);
	
	List<Mainopinion> findAll(Page page);
	
	List<Mainopinion> findByExample(Specification<Mainopinion> specification, Page page);
}
