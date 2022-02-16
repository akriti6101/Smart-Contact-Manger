package spring.album.all.access;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import spring.album.all.data.User;

@Controller
public class MyController {
	@Autowired
	private ServiceMan serviceMan;

	@GetMapping("/")
	public String login(Model m) {
		m.addAttribute("status", "LOGIN");
		m.addAttribute("statusButton", "LOGIN");
		m.addAttribute("action", "login");
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user, Model m) {
		String password = user.getPassword();
		User c = serviceMan.findingUser(user.getUsername());
		if (c != null && c.getPassword().equals(password)) {
			System.out.println("user is present..");
			m.addAttribute("image", "profile.png");
			m.addAttribute("username", user.getUsername());
			m.addAttribute("password", user.getPassword());

			return "home";
		} else {
			m.addAttribute("status", "LOGIN");
			m.addAttribute("statusButton", "LOGIN");
			m.addAttribute("action", "login");

			m.addAttribute("info", "This account does not exist..");
			return "login";
		}
	}

	@PostMapping("/checkUser")
	public String checkUser(@Valid @ModelAttribute("user") User user, BindingResult r, Model m) {
		User b = serviceMan.findingUser(user.getUsername());
		if (b != null) {
			return "redirect:/createDup";
		} else if (!r.hasErrors()) {
			serviceMan.creatingAccount(user);
			m.addAttribute("status", "LOGIN");
			m.addAttribute("statusButton", "LOGIN");
			m.addAttribute("action", "login");

			m.addAttribute("info", "Account created....");
			return "login";
		} else
			m.addAttribute("status", "CREATE ACCOUNT");
		m.addAttribute("statusButton", "SIGN UP");
		m.addAttribute("action", "checkUser");
		m.addAttribute("err", r);
		return "login";
	}

	@GetMapping("/create")
	public String create(Model m) {
		m.addAttribute("status", "CREATE ACCOUNT");
		m.addAttribute("statusButton", "Sign UP");
		m.addAttribute("action", "checkUser");

		return "login";
	}

	@GetMapping("/createDup")
	public String createDup(Model m) {
		m.addAttribute("status", "CREATE ACCOUNT");
		m.addAttribute("statusButton", "Sign UP");

		m.addAttribute("info", "This username is already used..");
		m.addAttribute("action", "checkUser");

		return "login";
	}

	@GetMapping("/forgotPassword")
	public String forgotPassword(Model m) {
		m.addAttribute("status", "UPDATE ACCOUNT");
		m.addAttribute("statusButton", "UPDATE PASSWORD");
		m.addAttribute("action", "updateUser");
		return "login";

	}

	@PostMapping("/updateUser")
	public String updateUser(@RequestParam("username") String u, @RequestParam("password") String p, Model m) {
		if (serviceMan.updatingUser(u, p)) {
			m.addAttribute("status", "LOGIN");
			m.addAttribute("statusButton", "LOGIN");
			m.addAttribute("action", "login");
			m.addAttribute("info", "Password updated...");
			return "login";
		} else {
			m.addAttribute("status", "LOGIN");
			m.addAttribute("statusButton", "LOGIN");
			m.addAttribute("action", "login");
			m.addAttribute("info", "No such account exists...");
			return "login";
		}
	}

}
