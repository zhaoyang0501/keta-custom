/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.cm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cm.entity.OpinionBusiness;

public interface OpinionBusinessDAO extends JpaRepository<OpinionBusiness, Long>, JpaSpecificationExecutor<OpinionBusiness> {
	List<OpinionBusiness> findByMainOpinionId(String id);
}