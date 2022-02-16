package spring.album.all.access;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.album.all.data.Contact;
import spring.album.all.data.Manager;
import spring.album.all.data.User;

@Service
public class ServiceMan {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private ContactDao contactDao;
	@Autowired
	private ManagerDao managerDao;
	
	
	
	
	public void creatingAccount(User user)
	{
		 userDao.createAccount(user);
	}

	public User findingUser(String username) {		
		User t=userDao.findUser(username);
	
		return t;
	}

	public boolean updatingUser(String u, String p) {
		
		boolean b=userDao.updateUser(u,p);
		return b;
		
	}
//Adding contacts..
	public boolean AddContact(Contact contact) {
		boolean t=contactDao.addContact(contact);
		System.out.println("in  cantact service..");
		return t;
		
	}

	// find profile
	public boolean findAccount(String n) {
		
		try {
			User t= userDao.findUser(n);
			if(t!=null)
				return true;
			else
				return false;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	
	}

	//update profile
	public boolean updateAccount(Manager manager, String n) {
		boolean r=managerDao.updateAccount(manager,n);
	
		return r;
	}

	public Manager getManager(String u) {
		Manager w=managerDao.getManager(u);
		return w;
	}

	public List<Contact> getContacts(String u) {
		
	      List<Contact> c= contactDao.getContacts(u);
	   
		return c;
	}

	public void  delContact(String phone, String u) {
		   contactDao.delContact(phone,u);
		
	}

	public boolean editContact(String phone, String u, Contact contact) {
		boolean w=contactDao.editContact(phone,u,contact);
		return w;
	}

	public Contact getContact(String phone, String u) {
		  Contact c= contactDao.getContact(phone,u);
		return c;
	}

}
