package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping("/guest")
public class GuestController {
	private int count = 1;
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		GuestbookDao dao = new GuestbookDao();
		List<GuestbookVo> gList = dao.getPersonList();
		
		model.addAttribute("count", count);
		model.addAttribute("gList", gList);
		return "/WEB-INF/views/addList.jsp";
	}

	@RequestMapping("/insert")
	public String insert(@ModelAttribute GuestbookVo vo) {
		GuestbookDao dao = new GuestbookDao();
		dao.personInsert(vo);

		return "redirect:/guest/list";
	}

	@RequestMapping("/deleteForm")
	public String deleteForm(Model model, @RequestParam("no") int no) {

		model.addAttribute("num", no);
		return "/WEB-INF/views/deleteForm.jsp";
	}

	@RequestMapping("/delete")
	public String deleteForm(@RequestParam("no") int no, @RequestParam("pw") String pw) {
		GuestbookDao dao = new GuestbookDao();

		count = dao.personDelete(no, pw);
		return "redirect:/guest/list";

	}
}