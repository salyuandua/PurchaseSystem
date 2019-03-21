package com.purchase.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.purchase.bean.Project;

@Controller
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping("/hello")
	public void sayHello() {
		System.out.println("hello...");
	}
	
	@RequestMapping("/list")
	public String projectList(Model model) {
		List<Project> projects= projectService.getAllProjects();
		model.addAttribute("projects", projects);
		return "/project/projects";
	}

	
	@RequestMapping("/getAddPage")
	public String getAddProject() {
		
		return "/project/addProject";
	}
	
	
}
