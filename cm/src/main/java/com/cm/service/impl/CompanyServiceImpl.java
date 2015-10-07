/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package	com.cm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cm.dao.CompanyDAO;
import com.cm.entity.Company;
import com.cm.service.CompanyService;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyDAO companyDAO;

	public List<Company> findAllByCompanyType(String companyType) {
		return companyDAO.findAllByCompanyType(companyType);
	}
}
