package spring.album.all.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.album.all.data.Manager;
import spring.album.all.data.User;

@Repository
public class ManagerDao {
@Autowired
	private HibernateTemplate hibernateTemplate;
@Autowired
  private UserDao userDao;

@Transactional
	public boolean updateAccount(Manager manager, String n) {
		User r=userDao.findUser(n);
	
			if(r!=null) {
			
				try {
			       Manager man=hibernateTemplate.get(Manager.class, n);
					man.setEmail(manager.getEmail());
					man.setName(manager.getName());
					man.setPhone(manager.getPhone());
					man.setWork(manager.getWork());
					man.setFilename(manager.getFilename());
					return true;
				
				}catch(Exception e)
				{ 
					hibernateTemplate.save(manager);
				
					return true;
				}
			}
			else
			{ 
			   return false; }
		}

//getting Manager data
public Manager getManager(String u) {
	  try {
		    Manager q= hibernateTemplate.get(Manager.class, u);
		    	 return q; 
	  }catch(Exception e)
	  {
		  
	  }
	return null;
}
	
		
	}


