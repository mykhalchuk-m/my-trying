package com.mmm.dsjsm.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mmm.dsjsm.dao.impl.SubjectDaoImpl;
import com.mmm.dsjsm.entity.Subject;

@Controller
@RequestMapping("/subject")
public class SubjectController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SubjectDaoImpl subjectDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView subjects(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("subject");
		modelAndView.addObject("subjects", subjectDao.readAll());
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public String addSubject(@ModelAttribute Subject subject, HttpServletRequest request) {
		subjectDao.create(subject);
		return "redirect:/subject";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/edit")
	public String editSubject(@ModelAttribute Subject subject, HttpServletRequest request) {
		subjectDao.update(subject);
		return "redirect:/subject";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/add")
	public ModelAndView addSubjectForm(@ModelAttribute Subject subject) {
		ModelAndView modelAndView = new ModelAndView("subject_add");
		modelAndView.addObject("action", "add");
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/edit")
	public ModelAndView editSubjectForm(@RequestParam("id") Long id, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("subject_add");
		modelAndView.addObject("subject", subjectDao.read(id));
		modelAndView.addObject("action", "edit");
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/delete")
	public String deleteSubject(@RequestParam("id") Long id, HttpServletRequest request) {
		Subject subject = subjectDao.read(id);
		logger.info(subject.toString());
		subjectDao.delete(subject);
		return "redirect:/subject";
	}
	
	@ModelAttribute("subject")
	public Subject getSubject() {
		return new Subject();
	}
}
