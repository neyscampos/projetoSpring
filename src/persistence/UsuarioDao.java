package persistence;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import entity.Usuario;

public class UsuarioDao  implements Serializable {

	private static final long serialVersionUID = 1L;

	private HibernateTemplate hibernate;
	
	public void setSessionFactory(SessionFactory sessionFactory) 
			   throws Exception{
				  hibernate = new HibernateTemplate(sessionFactory);
			 }

	public void create(Usuario u) throws Exception {
		hibernate.save(u);
	}

	public void update(Usuario u) throws Exception {
		hibernate.update(u);
	}

	public void delete(Usuario u) throws Exception {
		hibernate.delete(u);
	}

	public Usuario findBy(Integer cod) throws Exception {
		return (Usuario) hibernate.get(Usuario.class, cod);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() throws Exception {
		return hibernate.loadAll(Usuario.class);
	}
	
	public HibernateTemplate getHibernate() {
		return hibernate;
	}

	public void setHibernate(HibernateTemplate hibernate) {
		this.hibernate = hibernate;
	}	
}
