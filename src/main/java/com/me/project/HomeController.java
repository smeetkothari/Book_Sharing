package com.me.project;

import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.me.dao.NotesDao;
import com.me.dao.PaymentDao;
import com.me.dao.ShareDao;
import com.me.dao.UserDao;
import com.me.model.Notes;
import com.me.model.Share;
import com.me.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/*
	 * Specify this useValidate will be injected
	 */
	@Autowired
	@Qualifier("userValidator") 
	private Validator validator;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private NotesDao notesDao;
	
	@Autowired
	private PaymentDao paymentDao;
	
	@Autowired
	private ShareDao shareDao;
	
	private User user1;
	/*
	 * This is to initialize webDataBinder,set its
	 * validator as we specify.
	 */
	@InitBinder
	private void initBinder (WebDataBinder binder){
		binder.setValidator(validator);
	}
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String initFirstPage(Model model, HttpServletRequest r) {
		HttpSession s  = r.getSession();
		User u = (User)s.getAttribute("User");
		List<Notes> list =   notesDao.listAllNotes(u);
		model.addAttribute("list", list);
		
		return "search";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST, params={"HOME"})
	public String Home(Model model, HttpServletRequest r) {
		
		HttpSession s  = r.getSession();
		User u = (User)s.getAttribute("User");
		List<Notes> list =   notesDao.listAllNotes(u);
		model.addAttribute("list", list);
		
		return"search";
	}
	
	
	
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public String SignUpSucess(Model model, HttpServletRequest r) {
		
		User user = new User();
		model.addAttribute("user", user);
		
		return"signUp";
	}
	
	
	@RequestMapping(value="/SignUp", method=RequestMethod.GET)
	public String giveSignUpForm(Model model, HttpServletRequest r) {
		
		User user = new User();
		model.addAttribute("user", user);
		
		return"signUp";
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST, params = { "Logout" })
	public String logout(Model model, HttpServletRequest r){
		//System.out.println("Logging out....");
		r.getSession().invalidate();
		List<Notes> list =   notesDao.listAllNotes(null);
		model.addAttribute("list", list);
		//System.out.println(list.size());
		return "search";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST, params = { "upload" })
	public String initUploadForm(Model model){
		
		return "upload";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST, params={"Login", "!SignUp","!Add Selected Items to Cart."})
	public String giveLoginForm(Model model, HttpServletRequest r) {
		
		User user = new User();
		model.addAttribute("user", user);
		
		return"home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST, params = { "viewsubs" })
	public String initViewForm(Model model, HttpServletRequest r){
		HttpSession s = r.getSession();
		User u = (User) s.getAttribute("User");
		Set<Notes> list = u.getNotesList();
		model.addAttribute("viewsubs",list);
		return "viewsubs";
	}
	
	@RequestMapping(value = "/editNote")
	public void initEditNotesForm(Model model, HttpServletRequest r){
		System.out.println("in edit page");
	}
	List<Notes> cartList;
	ArrayList<String> cartidsArrayList = new ArrayList<String>();
	
	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	public String initCartScreen(Model model, HttpServletRequest r){
		
		String[] id = r.getParameterValues("note");
		
		for(String g : id){
			g=g.trim();
			System.out.println("clicked: "+g);
			if(!cartidsArrayList.contains(g))
			cartidsArrayList.add(g);
		}
		HttpSession s = r.getSession();
		
		cartList =   notesDao.listCart(cartidsArrayList);
		s.setAttribute("cartid", cartList);
		model.addAttribute("list", cartList);
		return "cart";
		
	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String initCartScreen2(Model model, HttpServletRequest r){
		
		return "cart";
	}
	@RequestMapping(value = "/search",params = { "id" })
	public String removeFromCart(Model model, HttpServletRequest r, HttpServletResponse resp) throws IOException{
		
		String a = r.getParameter("id");
		a=a.trim();
		Notes n = notesDao.getNotesById(Integer.parseInt(a));
		HttpSession s = r.getSession();
		cartList =  (ArrayList<Notes>) s.getAttribute("cartid");
		Notes nn1=null;
		for(Notes nn : cartList){
			if(nn.getNotesid()==n.getNotesid()){
				
				 nn1 = nn;
			}
		}
		cartList.remove(nn1);
		String rem=null;
		for(String ss : cartidsArrayList){
			if(ss.equals(a)){
				
				rem=ss;
			}
		}
			cartidsArrayList.remove(rem);
			//cartList =   notesDao.listCart(ids);
			s.setAttribute("cartid", cartList);
			model.addAttribute("list", cartList);
			return "cart";
		//System.out.println("hereee.."+ids.size());
		
		//return "cart";
		
	}
	
	@RequestMapping(value = "/Payment", method = RequestMethod.POST, params = { "buy" })
	public String initPaymentScreen(Model model, HttpServletRequest r){
	return "payment";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST, params = { "pay" })
	public String makePayment(Model model, HttpServletRequest r){
		HttpSession s  =  r.getSession();
		String a = r.getParameter("a");
		String b = r.getParameter("b");
		String c = r.getParameter("c");
		String d = r.getParameter("d");
		User user  = (User)s.getAttribute("User"); 
		int uid = user.getUserid();
		ArrayList<Notes> cart = (ArrayList<Notes>) s.getAttribute("cartid");
		for(Notes n : cart){
			int nid = n.getNotesid();
			User u = n.getUser();
			int rid = u.getUserid();
			Share share =shareDao.addShare(n, user);
			paymentDao.addPayment(uid,rid , a, b, c, d, share);
			
		}
		List<Notes> list =   notesDao.listAllNotes(user);
		model.addAttribute("list", list);
		
		return "search";
	}
	
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST, params = { "viewnote" })
	public String initViewNotesForm2(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setAttribute("path", "C:\\Users\\Smeet\\Desktop\\spring-tool-suite-3.6.4.RELEASE-e4.4.2-win32-x86_64\\sts-bundle\\pivotal-tc-server-developer-3.1.0.RELEASE\tomcat-8.0.20.B.RELEASE\\tmpFiles");
	       return "viewnote";
			
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST , params = { "viewthenote" })
	public String initViewNotesForm(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{
		  int id = Integer.parseInt(request.getParameter("hide"));
		  Notes n = notesDao.getNotesById(id);
		  String path = n.getName()+"_"+n.getUser().getUserid()+".pdf";
		  model.addAttribute("path", path);
		  request.setAttribute("path", path);
	      return "viewnote";
			
	}
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST, params = { "bag" })
	
	public String initBag(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{
		  HttpSession s = request.getSession();
		  User u =(User) s.getAttribute("User");
		  List<Share> list = shareDao.getMyShare(u);
		 // System.out.println("list size="+list.size());
		 for(Share s1: list)
		 System.out.println( "desc="+s1.getNotes().getDescription());
		  model.addAttribute("list", list);
	       return "bag";
			
	}
	
@RequestMapping(value = "/search", method = RequestMethod.POST, params = { "bag" })
	
	public String initBag2(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{
	 HttpSession s = request.getSession();
	  User u =(User) s.getAttribute("User");
	  List<Share> list = shareDao.getMyShare(u);
	  model.addAttribute("list", list);
      return "bag";
			
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST, params = { "search" })
	public String searchQueryString(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{
		  System.out.println(request.getParameter("query"));
		  String q  = request.getParameter("query");
		  q=q.trim();
		  if(q.equals("")) return "search";
		   HttpSession s  = request.getSession();
			User u = (User)s.getAttribute("User");
			List<Notes> list =   notesDao.listAllNotesByQuery(u,q);
			model.addAttribute("list", list);
	       return "search";
			
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST, params = { "ftl" })
	public String ViewNotes(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setAttribute("path", "C:\\Users\\Smeet\\Desktop\\spring-tool-suite-3.6.4.RELEASE-e4.4.2-win32-x86_64\\sts-bundle\\pivotal-tc-server-developer-3.1.0.RELEASE\tomcat-8.0.20.B.RELEASE\\tmpFiles");
	       return "view";
			
	}
	
	
	
	
	@RequestMapping(value="/" ,method=RequestMethod.POST, params = { "cart" })
	public String goToCart(Model model, HttpServletRequest r) {
		
		return "cart";
	}
	
	@RequestMapping(value="/Payment" ,method=RequestMethod.POST, params = { "cart" })
	public String goToCardDetailsPage(Model model, HttpServletRequest r) {
		
		return "payment";
	}
	
	
	
	
	@RequestMapping(value="/" ,method=RequestMethod.POST, params = { "chklogin" })
	public String checkLogin(Model model, @Validated User user, BindingResult result, HttpServletRequest r) {
		System.out.println("check this");
		model.addAttribute("user",user);  
		String returnVal = "search";
		if (result.hasErrors()){
			
			return "home";
		}else{
			try {
				user = userDao.queryUserByNameAndPassword(user.getName(), user.getPassword());
				if (user != null){
					user1=user;
					model.addAttribute("user", user);
					HttpSession session = r.getSession(true);
					session.setAttribute("User", user);
					List<Notes> list =   notesDao.listAllNotes(user);
					model.addAttribute("list", list);
					System.out.println(list.size());
					return returnVal;		
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return "home";
	}
	/*
	 * Process From request
	 */
	//@RequestMapping(value="/" ,method=RequestMethod.POST)
	
	@RequestMapping(value="/", method=RequestMethod.POST, params={"!Login", "SignUp", "!Add Selected Items to Cart."})
	public String submitForm2(Model model, @Validated User user, BindingResult result, HttpServletRequest r){
		return "signUp";
		
	}
	
	
	
	
	@RequestMapping(value="/", method=RequestMethod.POST, params={"!Login", "!SignUp", "Add Selected Items to Cart."})
	public String getSelectedNotes(Model model, @Validated User user, BindingResult result, HttpServletRequest r){
		String[] id = r.getParameterValues("note");
		
		return null;
	}
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody
	String uploadFileHandler(@RequestParam("name") String name, @RequestParam("b") String b, @RequestParam("c") int c, @RequestParam("d") int d, @RequestParam("e") String e, @RequestParam("file") MultipartFile file, HttpServletRequest r) {
		System.out.println("now1");
		if (!file.isEmpty()) {
			System.out.println("now2");
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();
				System.out.println("now:"+file.getOriginalFilename());
				// Create the file on server
				HttpSession s = r.getSession();
				User u  = (User)s.getAttribute("User");
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name+"_"+u.getUserid()+".pdf");
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());
				//String filename = name+"_"+user1.getUserid();
				boolean flag = false;
				try{
				 flag=notesDao.insertNotes(user1, name, b, c, e, d );
				
				}
				catch(Exception e1){
					System.out.println("hi");
					return e1.getMessage();
				}
				if(flag)
				return "You successfully uploaded file=" + name;
				else
					return "fail";
			} catch (Exception e2) {
				return "You failed to upload " + name + " => " + e2.getMessage();
			}
		} else {
			return "You failed to upload " + name
					+ " because the file was empty.";
		}
	}
	
}
