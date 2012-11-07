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

import com.mmm.dsjsm.dao.impl.GroupDaoImpl;
import com.mmm.dsjsm.dao.impl.StudentDaoImpl;
import com.mmm.dsjsm.dao.impl.SubjectDaoImpl;
import com.mmm.dsjsm.entity.Group;
import com.mmm.dsjsm.entity.Student;
import com.mmm.dsjsm.entity.Subject;

@Controller
@RequestMapping("/student")
public class StudentsController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private StudentDaoImpl studentDao;
	@Autowired
	private GroupDaoImpl groupDao;
	@Autowired
	private SubjectDaoImpl subjectDao;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Group.class, "group", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				Group group = groupDao.read(Long.parseLong(text));
				setValue(group);
			}
		});
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
	public ModelAndView student(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("student");
		modelAndView.addObject("students", studentDao.readAll());
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public String addStudent(@ModelAttribute Student student, HttpServletRequest request) {
		studentDao.create(student);
		return "redirect:/student";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/edit")
	public String editStudent(@ModelAttribute Student student, HttpServletRequest request) {
		studentDao.update(student);
		return "redirect:/student";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/add")
	public ModelAndView addStudentForm(@ModelAttribute Student student) {
		ModelAndView modelAndView = new ModelAndView("student_add");
		modelAndView.addObject("groups", groupDao.readAll());
		modelAndView.addObject("subjects", subjectDao.readAll());
		modelAndView.addObject("action", "add");
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/edit")
	public ModelAndView editStudent(@RequestParam("id") Long id, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("student_add");
		modelAndView.addObject("student", studentDao.read(id));
		modelAndView.addObject("groups", groupDao.readAll());
		modelAndView.addObject("subjects", subjectDao.readAll());
		modelAndView.addObject("action", "edit");
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/delete")
	public String deleteStudent(@RequestParam("id") Long id, HttpServletRequest request) {
		Student student = studentDao.read(id);
		logger.info(student.toString());
		studentDao.delete(student);
		return "redirect:/student";
	}
	
	@ModelAttribute("student")
	public Student getStudent() {
		return new Student();
	}
}
