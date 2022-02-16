package spring.album.all.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.album.all.data.User;

@Repository
public class UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createAccount(User u)
	{
		  hibernateTemplate.save(u);
	}

	public User findUser(String username) {
		// TODO Auto-generated method stub
 System.out.println(username);
		try {
		User r=(User)hibernateTemplate.get(User.class,username);
		System.out.println(r);
		if(r==null)
			return null;
		else
		{
			return r;
		}
		}
		catch(Exception e)
		{
			 return null;}
	}

	public boolean updateUser(String u, String p) {
	  try {
		User r=hibernateTemplate.get(User.class, u);
		
		if(r==null)
			return false;
	  r.setPassword(p);
		return true;}
	  catch(Exception e)
	  {return false;}
	}
}
