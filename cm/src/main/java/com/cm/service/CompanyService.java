/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.cm.service;

import java.util.List;

import com.cm.entity.Company;

public interface CompanyService {
	List<Company> findAllByCompanyType(String companyType);
}
