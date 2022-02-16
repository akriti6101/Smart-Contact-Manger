package spring.album.all.access;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.album.all.data.Contact;

@Repository
public class ContactDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Autowired
	private JdbcTemplate jd;

	@Transactional
	public boolean addContact(Contact contact) {
		try {
			System.out.println("fiename=" + contact.getFilename());
			hibernateTemplate.save(contact);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Contact> getContacts(String u) {
		try {
			RowMapper<Contact> rm = new MyRowMapperImpl();
			String sql = "select * from contact where userAccountName='" + u + "'";

			List<Contact> c = (List<Contact>) jd.query(sql, rm);

			return c;
		} catch (Exception e) {
			return null;
		}

	}

	@Transactional
	public void delContact(String phone, String u) {

		List<Contact> list = this.getContacts(u);

		for (Contact v : list) {
			if (v.getPhone().equals(phone)) {
				try {

					hibernateTemplate.delete(v);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Transactional
	public boolean editContact(String phone, String u, Contact contact) {

		try {
			Contact v = hibernateTemplate.get(Contact.class, phone);

			if (!(v.getPhone().equals(contact.getPhone()))) {
				if (!(v.getFilename().equals("profile.png"))) {
					if (contact.getFilename().equals("profile.png")) {
						contact.setFilename(v.getFilename());
					}
				}
				hibernateTemplate.delete(v);

				boolean b = this.addContact(contact);
				return b;
			} else {
				v.setEmail(contact.getEmail());

				v.setName(contact.getName());
				v.setUserAccountName(u);
				v.setWork(contact.getWork());

				if (!(v.getFilename().equals("profile.png"))) {
					if (contact.getFilename().equals("profile.png")) {
						contact.setFilename(v.getFilename());
					}
				}
				v.setFilename(contact.getFilename());

				hibernateTemplate.save(v);
				return true;
			}
		} catch (Exception e) {
			return false;
		}

	}

	public Contact getContact(String phone, String u) {
		List<Contact> l = this.getContacts(u);
		for (Contact v : l) {
			if (v.getPhone().equals(phone))
				return v;
		}
		return null;
	}

}
