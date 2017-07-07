package cf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cf.dao.TestDao;
import cf.service.ITestService;

@Service
public class TestService implements ITestService {
	
	@Autowired
	private TestDao testDao;

	@Override
	public String getNameById(int id) {
		// TODO Auto-generated method stub
		return testDao.getNameById(id);
	}

}
