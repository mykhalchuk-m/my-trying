package com.mmm.dsjsm.controller;

import java.beans.PropertyEditorSupport;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mmm.dsjsm.dao.impl.GroupDaoImpl;
import com.mmm.dsjsm.dao.impl.TeacherDaoImpl;
import com.mmm.dsjsm.entity.Group;
import com.mmm.dsjsm.entity.Teacher;

@Controller
@RequestMapping("/group")
public class GroupController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private GroupDaoImpl groupDao;
	@Autowired
	private TeacherDaoImpl teacherDao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Teacher.class, "curator", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				Teacher teacher = teacherDao.read(Long.parseLong(text));
				setValue(teacher);
			}
		});
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView group(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("group");
		modelAndView.addObject("groups", groupDao.readAll());
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public String addGroup(@ModelAttribute Group group, HttpServletRequest request) {
		groupDao.create(group);
		return "redirect:/group";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/edit")
	public String editGroup(@ModelAttribute Group group, HttpServletRequest request) {
		groupDao.update(group);
		return "redirect:/group";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/add")
	public ModelAndView addGroupForm(@ModelAttribute Group group) {
		ModelAndView modelAndView = new ModelAndView("group_add");
		modelAndView.addObject("teachers", teacherDao.readAll());
		modelAndView.addObject("action", "add");
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/edit")
	public ModelAndView editGroupForm(@RequestParam("id") Long id, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("group_add");
		modelAndView.addObject("group", groupDao.read(id));
		modelAndView.addObject("teachers", teacherDao.readAll());
		modelAndView.addObject("action", "edit");
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/delete")
	public String deleteStudent(@RequestParam("id") Long id, HttpServletRequest request) {
		Group group = groupDao.read(id);
		logger.info(group.toString());
		groupDao.delete(group);
		return "redirect:/group";
	}
	
	@ModelAttribute("group")
	public Group getGroup() {
		return new Group();
	}
}
