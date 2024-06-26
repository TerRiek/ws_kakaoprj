package com.example.kakaoPrj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kakaoPrj.dao.IMemberDao;
import com.example.kakaoPrj.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	private IMemberDao mdao;
	
	@RequestMapping("/regForm")
	public String regForm() {
		
		return "regForm";
	}
	
	@RequestMapping("/regist")
	public String regDto(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		

		int result = mdao.regCheck(id);
		System.out.println(result);
			
		if(result != 0) {
			model.addAttribute("msg", "등록되지 않았습니다. 다시 입력해주세요.");
			return "alert";
		}else if(result == 0){
			MemberDto dto = new MemberDto("", id, pw, name);
			mdao.regDto(dto);	
			model.addAttribute("msg", "등록이 완료되었습니다.");
		}
		return "alert";
	}
	
	@RequestMapping("/mDetail")
	public String mDetail(HttpSession session, Model model) {
		MemberDto dto = (MemberDto)session.getAttribute("dto");
		model.addAttribute("dto", dto);
		
		return "mDetail";
	}
	
	@RequestMapping("/mDelete")
	public String mDelete(@RequestParam("mno") String mno) {
		int result = mdao.deleteDto(mno);
		if(result == 1) {
			return "loginForm";
		}
		return "";
	}
	
	@RequestMapping("/mUpdate")
	public String mUpdate(@RequestParam("mno") String mno, @RequestParam("id") String id, @RequestParam("pw") String pw, @RequestParam("name") String name) {
		MemberDto dto = new MemberDto(mno, id, pw, name);
		int result = mdao.updateDto(dto);
		if(result == 1) {
			return "redirect:list";
		}
		return "";
	}
}
