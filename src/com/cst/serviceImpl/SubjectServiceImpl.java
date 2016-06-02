package com.cst.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cst.dao.BaseDao;
import com.cst.model.Subject;
import com.cst.service.SubjectService;

@Service("subjectServiceImpl")
@Repository
public class SubjectServiceImpl implements SubjectService{

	private BaseDao dao;
	
	public void setDao(BaseDao dao) {  
        this.dao = dao;  
    }
	
	@Override
	public List<Subject> getAll() {
		// TODO Auto-generated method stub
		try {
			return dao.getList(Subject.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Subject get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
