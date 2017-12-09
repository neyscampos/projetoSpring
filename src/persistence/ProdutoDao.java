package persistence;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import entity.Produto;

public class ProdutoDao {

	private HibernateTemplate hibernate;

	public void setSessionFactory(SessionFactory sessionFactory) throws Exception {
		hibernate = new HibernateTemplate(sessionFactory);
	}

	public void create(Produto p) throws Exception {
		hibernate.save(p);
	}

	public void update(Produto p) throws Exception {
		hibernate.update(p);
	}

	public void delete(Produto p) throws Exception {
		hibernate.delete(p);
	}

	public Produto findBy(Integer cod) throws Exception {
		return (Produto) hibernate.get(Produto.class, cod);
	}

	@SuppressWarnings("unchecked")
	public List<Produto> findAll() {
		return hibernate.loadAll(Produto.class);
	}

	public HibernateTemplate getHibernate() {
		return hibernate;
	}

	public void setHibernate(HibernateTemplate hibernate) {
		this.hibernate = hibernate;
	}
}
