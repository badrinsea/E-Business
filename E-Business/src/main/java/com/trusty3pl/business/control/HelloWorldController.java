package com.trusty3pl.business.control;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trusty3pl.business.model.AppelOffre;
import com.trusty3pl.business.model.Produit;
import com.trusty3pl.business.service.AppelOffreService;
import com.trusty3pl.business.service.ProduitService;

@Controller
public class HelloWorldController {
//*dfglf,fsfqlgz huojlh
	@Autowired
	ProduitService prdService;
	@Autowired
	AppelOffreService marcheService;
	@RequestMapping(value = { "/", "/welcome"}, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("greeting", "Hi, Welcome to mysite");
		model.addAttribute("role", getRole(getPrincipal()));
		List<Produit> produitList = this.prdService.findAllUsers();
		
		model.addAttribute("produitList", produitList);
		model.addAttribute("produit",new Produit());
		return "welcome";
	}
	
	@RequestMapping("marche/{id}") 
	public  @ResponseBody
	List<AppelOffre> searchlostcard(@PathVariable String id) {    

	List<AppelOffre> listlostcard = marcheService.finAppelProduct(id);

	return listlostcard ;
	}
	/*@RequestMapping(value = "/search/{idProduit}" , method = RequestMethod.GET)
	public String calPage(ModelMap model,@Valid @PathVariable("idProduit") String p) {
		List<AppelOffre> marcheList = this.marcheService.finAppelProduct(p);
System.out.println("jil of rz,");
		
        System.out.println("jil of rz,");
		System.out.println(marcheList);
List<Produit> produitList = this.prdService.findAllUsers();
		
		model.addAttribute("appeloffre",new AppelOffre());
		model.addAttribute("produitList", produitList);
		model.addAttribute("produit",new Produit());
		return "redirect:/welcome";
	}*/

	
	
	


	
	
	@RequestMapping(value = "/service", method = RequestMethod.GET)
	public String homeService(ModelMap model) {

		model.addAttribute("user", getPrincipal());
		model.addAttribute("role", getRole(getPrincipal()));
		if(getRole(getPrincipal())=="Administrator")
		       return "redirect:/admin";
		else if(getRole(getPrincipal())=="User")
		       return "redirect:/welcome";
		else if(getRole(getPrincipal())=="DBA")
		       return "redirect:/db";
		
		return "/";
	}


	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		model.addAttribute("role", getRole(getPrincipal()));
		return "admin";
	}
	
	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String dbaPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		model.addAttribute("role", getRole(getPrincipal()));
		return "dba";
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		
		return "accessDenied";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	@RequestMapping(value = "/button", method = RequestMethod.GET)
	public String buttonPage() {
		return "buttons";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	private String getRole(String st)
	{
		HashMap<String,String> hm=new HashMap<String,String>();
		hm.put("bill","User"); 
		  hm.put("admin","Administrator");
		  hm.put("dba", "DBA");
		return hm.get(st);
	}	

}