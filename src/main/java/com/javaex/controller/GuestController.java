package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping("/guest")
public class GuestController {
	
	@Autowired
	GuestbookDao dao;
	
	private int count = 1;

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		List<GuestbookVo> gList = dao.getPersonList();

		model.addAttribute("count", count);
		model.addAttribute("gList", gList);
		return "addList";
	}

	@RequestMapping("/insert")
	public String insert(@ModelAttribute GuestbookVo vo) {
		dao.personInsert(vo);

		return "redirect:/guest/list";
	}
	
	@RequestMapping("/deleteForm")
	public String deleteForm(Model model,@RequestParam("num") int num) {
		model.addAttribute("num", num);

		return "deleteForm";
	}
	@RequestMapping("/delete/{no}")
	public String deleteForm( @PathVariable("no") int num, @RequestParam("pw") String pw) {
		GuestbookVo guestVo = new GuestbookVo(num,pw); 
		
		count = dao.personDelete(guestVo);

		return "redirect:/guest/list";
	}



}