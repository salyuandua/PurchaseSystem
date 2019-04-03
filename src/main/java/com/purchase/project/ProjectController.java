package com.purchase.project;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.purchase.bean.Project;
import com.purchase.utils.ApiResult;

@Controller
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
	/**
	 * Submit project
	 * @param project
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value="/submit",method=RequestMethod.POST)
	public @ResponseBody ApiResult submit(@RequestBody @Valid Project project,
			BindingResult bindingResult) {
		
		if(bindingResult.getErrorCount()>0) {
			
			return new ApiResult(false, "validate error!");
		}
		//System.out.println(project);
		
		if(!projectService.submit(project)) {//submit failed
			return new ApiResult(false, "submit failed!");
			
		}
		
		return new ApiResult(true, "Submit Successfully!");
		
	}
	
	
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
	
	@RequestMapping("/{id}")
	public String getProject(@PathVariable int id,Model model) {
		Project p= projectService.getPorjectById(id);
		model.addAttribute("project",p);
		return "/equipment/equipments_container";
	}
	
	
}
