package com.mmm.dsjsm.controller;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

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

import com.mmm.dsjsm.dao.impl.SubjectDaoImpl;
import com.mmm.dsjsm.dao.impl.TeacherDaoImpl;
import com.mmm.dsjsm.entity.Subject;
import com.mmm.dsjsm.entity.Teacher;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TeacherDaoImpl teacherDao;
	@Autowired
	private SubjectDaoImpl subjectDao;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(List.class, "subjects", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				if (text != null && text != "") {
					String[] values = text.split(",");
					List<Subject> subjects = new ArrayList<Subject>();
					for (String value : values) {
						subjects.add(subjectDao.read(Long.parseLong(value)));
					}
					setValue(subjects);
				}
			}
		});
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView teachers(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("teacher");
		modelAndView.addObject("teachers", teacherDao.readAll());
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public String addTeacher(@ModelAttribute Teacher teacher, HttpServletRequest request) {
		teacherDao.create(teacher);
		return "redirect:/teacher";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/edit")
	public String editTeacher(@ModelAttribute Teacher teacher, HttpServletRequest request) {
		teacherDao.update(teacher);
		return "redirect:/teacher";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/add")
	public ModelAndView addTeacherForm(@ModelAttribute Teacher teacher) {
		ModelAndView modelAndView = new ModelAndView("teacher_add");
		modelAndView.addObject("subjects", subjectDao.readAll());
		modelAndView.addObject("action", "add");
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/edit")
	public ModelAndView editTeacherForm(@RequestParam("id") Long id, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("teacher_add");
		modelAndView.addObject("teacher", teacherDao.read(id));
		modelAndView.addObject("subjects", subjectDao.readAll());
		modelAndView.addObject("action", "edit");
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/delete")
	public String deleteTeacher(@RequestParam("id") Long id, HttpServletRequest request) {
		Teacher teacher = teacherDao.read(id);
		logger.info(teacher.toString());
		teacherDao.delete(teacher);
		return "redirect:/teacher";
	}
	
	@ModelAttribute("teacher")
	public Teacher getTeacher() {
		return new Teacher();
	}
}
