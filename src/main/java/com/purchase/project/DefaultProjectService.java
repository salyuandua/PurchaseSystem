package com.purchase.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.purchase.bean.Project;
@Service
//@Transactional(rollbackFor=Exception.class)
public class DefaultProjectService implements ProjectService{
	
	@Autowired
	private ProjectDao projectDao;
	
	
	public List<Project> getAllProjects() {
		return projectDao.getAllProjects();
	}


	@Override
	public Project getPorjectById(int id) {
		// TODO Auto-generated method stub
		return projectDao.getPorjectById(id);
	}


	@Override
	public boolean submit(Project project) {
		// TODO Auto-generated method stub
		
		return projectDao.submit(project);
	}

	
}
