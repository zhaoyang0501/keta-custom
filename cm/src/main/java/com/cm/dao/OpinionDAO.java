/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.cm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cm.entity.Opinion;

public interface OpinionDAO extends JpaRepository<Opinion, String>, JpaSpecificationExecutor<Opinion> {
	Opinion findByPubopinionId(Long id);
}