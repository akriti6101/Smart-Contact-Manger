package spring.album.all.access;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import spring.album.all.data.Contact;
import spring.album.all.data.Manager;

@Controller
public class MyContactController {
	@Autowired
	private ServiceMan serviceMan;

	@GetMapping("/addContact/{username}")
	public String AddContactJsp(@PathVariable("username") String username, Model m) {
		m.addAttribute("username", username);

		m.addAttribute("msg", "");

		return "AddContact";
	}

	@GetMapping("/home/{username}")
	public String HomeJsp(@PathVariable("username") String username, Model m) {
		m.addAttribute("username", username);

		return "home";
	}

	@GetMapping("/Login")
	public String ExitJsp() {
		return "redirect:/";
	}

	@PostMapping("/submitContact/{username}")
	public String submittContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult r,
			@PathVariable("username") String n, @RequestParam(value = "img1", required = false) CommonsMultipartFile f,
			HttpServletRequest request, @RequestParam("work") String w, Model m) {
		if (r.hasErrors()) {
			return "AddContact";
		}

		else {
			contact.setUserAccountName(n);

			if (w.equals(""))
				contact.setWork("----");

			contact.setFilename("profile.png");

			if (f != null) {

				String path = request.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resource"
						+ File.separator + "images" + File.separator + f.getOriginalFilename();
				FileOutputStream fout;

				try {
					fout = new FileOutputStream(path);
					byte[] b = f.getBytes();
					fout.write(b);

					contact.setFilename(f.getOriginalFilename());

				} catch (IOException e) {
				}

			}
			boolean y = serviceMan.AddContact(contact);
			if (y) {
				m.addAttribute("msg", "Contact Added Successfully");
			}
			return "AddContact";
		}
	}

	@GetMapping("/Profile/{username}")
	public String Profile(@PathVariable("username") String u, Model m) {
		m.addAttribute("username", u);
		Manager ex = null;
		ex = serviceMan.getManager(u);
		
		if (ex == null) {
			ex = new Manager(u, "", "", "", "");
			ex.setFilename("profile.png");
		}

		m.addAttribute("ex", ex);
		return "profile";
	}

	@PostMapping("/profileUpdate/{username}")
	public String profileUpdate(@Valid @ModelAttribute("manager") Manager manager, BindingResult r,
			@PathVariable("username") String n, @RequestParam(value = "img1", required = false) CommonsMultipartFile f,
			HttpServletRequest request, Model m) {
		if (r.hasErrors())
			return "profile";

		else {
			manager.setUserAccountName(n);
			if (serviceMan.findAccount(n)) {
				if (f != null)
					manager.setFilename(f.getOriginalFilename());
				else {
					manager.setFilename("profile.png");
				}

				boolean e = serviceMan.updateAccount(manager, n);
				if(e)
					System.out.println("");
                  
			}

			if (f != null) {
				manager.setFilename(f.getOriginalFilename());

				String path = request.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resource"
						+ File.separator + "images" + File.separator + f.getOriginalFilename();
				FileOutputStream fout;

				try {
					fout = new FileOutputStream(path);
					byte[] b = f.getBytes();
					fout.write(b);
					m.addAttribute("msg", "Profile Updated Successfully");

					return "redirect:/Profile/" + "" + n + "";
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			m.addAttribute("msg", "Profile Updated Successfully2");
			return "redirect:/Profile/" + "" + n + "";

		}

	}

	@GetMapping("/showContacts/{username}")
	public String ShowContacts(Model m, @PathVariable("username") String u) {
		m.addAttribute("username", u);
		List<Contact> c = serviceMan.getContacts(u);

		m.addAttribute("list", c);
		return "ShowContacts";
	}

	@GetMapping("/ProfileDel/{phone}/{username}")
	public String ProfileDel(@PathVariable("phone") String phone, @PathVariable("username") String u) {
		serviceMan.delContact(phone, u);

		return "redirect:/showContacts/" + u + "";
	}

	@GetMapping("/editContacts/{phone}/{username}")
	public String editContact(@PathVariable("phone") String phone, @PathVariable("username") String u, Model m) {
		Contact c = serviceMan.getContact(phone, u);
		m.addAttribute("c", c);
		System.out.println("c=" + c);
		return "EditContact";
	}

	@PostMapping("/ContactUpdate/{phone}/{username}")
	public String updateContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult rq,
			@PathVariable("phone") String phone, @PathVariable("username") String u,
			@RequestParam(value = "img1", required = false) CommonsMultipartFile f, HttpServletRequest request,
			Model m) {

		System.out.println("in contactupdate=" + contact.getPhone());

		if (rq.hasErrors()) {
			Contact c = new Contact(u, "", "", "", "");
			m.addAttribute("c", c);
			return "EditContact";
		}

		else {
			contact.setUserAccountName(u);

			if (contact.getWork().equals(""))
				contact.setWork("----");

			contact.setFilename("profile.png");

			System.out.println("f=" + f);
			if (f != null) {

				String path = request.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resource"
						+ File.separator + "images" + File.separator + f.getOriginalFilename();
				FileOutputStream fout;

				try {
					fout = new FileOutputStream(path);
					byte[] b = f.getBytes();
					fout.write(b);

					contact.setFilename(f.getOriginalFilename());

				} catch (IOException e) {
				}

			}
			System.out.println(" file =" + contact.getFilename());
			boolean y = serviceMan.editContact(phone, u, contact);
			if (y)
				m.addAttribute("msg", "Contact Updated Successfully");
			Contact c = new Contact(u, "", "", "", "");
			m.addAttribute("c", c);

			return "EditContact";
		}

	}

	@GetMapping("/showContactProfile/{phone}/{username}")
	public String showContactProfile(@PathVariable("phone") String phone, @PathVariable("username") String u, Model m) {
		System.out.println("indndn");
		Contact c = serviceMan.getContact(phone, u);
		m.addAttribute("c", c);
		m.addAttribute("username", u);
		return "ContactProfile";
	}

}
