package com.sinnotech.hotel.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dto.UsersDTO;
import service.MemberService;

@Controller
public class MemberController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private final static String MEMBER_LIST_INDEX = CLIENT_BASE_PATH  + "user/userList";
	private final static String SIGN_UP_INDEX = CLIENT_BASE_PATH  + "user/signup";
	private final static String NON_MEMBER_SIGN_UP_INDEX = CLIENT_BASE_PATH  + "user/nonUserSignup";
	private final static String MEMBER_UPDATE_INDEX = CLIENT_BASE_PATH  + "user/userUpdate";
	private final static String MEMBER_LOGIN_INDEX = CLIENT_BASE_PATH  + "user/login";
	private final static String NON_MEMBER_LOGIN_INDEX = CLIENT_BASE_PATH  + "user/nonUserLogin";
	@Inject
	private MemberService memberService;
	//회원 로그인
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getMemberLogin(Model memberInfo) throws Exception {

		memberInfo.addAttribute("loginUser", new UsersDTO());
		ModelAndView model = new ModelAndView(MEMBER_LOGIN_INDEX);
		return model;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postMemberLogin(@ModelAttribute("loginUser") UsersDTO loginUser,HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
		logger.info("userLogin");
		logger.info("loginUser : " + loginUser);
		HttpSession session = request.getSession();
		logger.info("user : " + loginUser);
		UsersDTO user = memberService.getLoginMemberInfo(loginUser);
		logger.info("user : " + user);
		if(user != null) {
			session.setAttribute("loginUserInfo", user);
			return "redirect:/";
		} else {
			redirectAttributes.addFlashAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다. ");
			return "redirect:/login";
		}
	}
    //비회원 로그인
	@RequestMapping(value = "/nonUserLogin", method = RequestMethod.GET)
	public ModelAndView nonMemberLogin(Model memberInfo) throws Exception {
		memberInfo.addAttribute("loginUserInfo", new UsersDTO());
		ModelAndView model = new ModelAndView(NON_MEMBER_LOGIN_INDEX);
		return model;
	}
	@RequestMapping(value = "/nonUserLogin", method = RequestMethod.POST)
	public String nonMemberLogin(@ModelAttribute("loginUserInfo") UsersDTO loginUser,HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {

		logger.info("userLogin");
		HttpSession session = request.getSession();
		UsersDTO user = memberService.getLoginNonMemberInfo(loginUser);
		logger.info("user : " + user);
		if(user != null) {
			session.setAttribute("loginUserInfo", user);
			return "redirect:/";
		} else {
			redirectAttributes.addFlashAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다. ");
			return "redirect:/nonUserLogin";
		}
	}
	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		logger.info("get logout");
		session.invalidate();
		return "redirect:/login";
	}
	//회원가입 화면 
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView memberSignup(Model user) throws Exception {
		logger.info("userSignup start");
		user.addAttribute("userInfo", new UsersDTO());		
		ModelAndView model = new ModelAndView(SIGN_UP_INDEX);
		logger.info("userSignup end");
		return model;
	}
	//회원가입 
	@RequestMapping(value = "/insertMember", method = RequestMethod.POST)
	public String insertMember(@ModelAttribute("userInfo") UsersDTO usersDTO, RedirectAttributes rttr) throws Exception {
		logger.info("insertUser start");
		ModelAndView model = new ModelAndView("/insertMember");
		model.addObject("userInfo", usersDTO);
		memberService.insertMember(usersDTO);
		logger.info("insertUser end");
		return "redirect:/login";
	}
	@ResponseBody
	@RequestMapping(value = "/user/emailCheck", method = RequestMethod.POST)
		public int overlappedEmail(UsersDTO usersDTO) throws Exception {
		logger.info("email check start");
		int result = memberService.overlappedEmail(usersDTO);
		return result;
	}
	@ResponseBody
	@RequestMapping(value = "/phoneCheck", method = RequestMethod.POST)
		public int overlappedPhone(UsersDTO usersDTO) throws Exception {
		int result = memberService.overlappedPhone(usersDTO);
		return result;
	}
		//비회원으로 가입화면
	@RequestMapping(value = "/nonUserSignup", method = RequestMethod.GET)
	public ModelAndView nonMemberSignup(Model user) throws Exception {
		logger.info("nonUserSignin start");
		user.addAttribute("nonUserInfo", new UsersDTO());		
		ModelAndView model = new ModelAndView(NON_MEMBER_SIGN_UP_INDEX);
		logger.info("nonUserSignin end");
		return model;
	}
		//비회원 가입 
	@RequestMapping(value = "/insertNonMember", method = RequestMethod.POST)
	public String insertNonMember(@ModelAttribute("nonUserInfo") UsersDTO usersDTO, RedirectAttributes rttr) throws Exception {
		logger.info("insertNonUser start");
		ModelAndView model = new ModelAndView("/insertNonMember");
		model.addObject("nonUserInfo", usersDTO);
		memberService.insertNonMember(usersDTO);
		logger.info("insertNonUser end");
		return "redirect:/";
	 }
		
	@RequestMapping(value="/userUpdate", method = RequestMethod.GET)
	public String getMemberUpdate(HttpSession session, Model model) throws Exception{
		String email = (String) session.getAttribute("email");
		String password = (String) session.getAttribute("password");
		String phone = (String) session.getAttribute("phone");
		//MemberDAO memberDAO = memberService.updateMember(user);
		//정보저장 후 페이지 이동
		//model.addAttribute("memVO", vo);
		return "/userUpdate";
	}
	@RequestMapping(value = "/userUpdate", method = RequestMethod.POST)
	public String postMemberUpdate(@ModelAttribute("userInfo") UsersDTO user, RedirectAttributes rttr) throws Exception {
		logger.info("insertNonUser start");
		ModelAndView model = new ModelAndView("/insertMember");
		model.addObject("userInfo", user);
		memberService.updateMember(user);
		logger.info("insertNonUser end");
		return "redirect:/userList";
		 }
	}
