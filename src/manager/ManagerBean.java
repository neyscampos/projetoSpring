package manager;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import entity.Produto;
import entity.Usuario;
import persistence.ProdutoDao;
import persistence.UsuarioDao;

public class ManagerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{usuarioDaoSpring}")
	private UsuarioDao usuarioDao;

	@ManagedProperty("#{produtoDaoSpring}")
	private ProdutoDao produtoDao;

	private List<Produto> produtos;

	private Usuario usuarioLogado;
	private Produto produto;

	public ManagerBean() {
		usuarioLogado = new Usuario();
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication autenticacao = context.getAuthentication();
		usuarioLogado.setNome(((User) autenticacao.getPrincipal()).getUsername());
	}

	public List<Produto> getProdutos() {
		produtos = produtoDao.findAll();
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Usuario getUsuario() {
		return usuarioLogado;
	}

	public void setUsuario(Usuario usuario) {
		this.usuarioLogado = usuario;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public ProdutoDao getProdutoDao() {
		return produtoDao;
	}

	public void setProdutoDao(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}

	public void gravar() {

		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			produtoDao.create(produto);
			produto = new Produto();
			fc.addMessage(null, new FacesMessage("Dados Gravados..."));
		} catch (Exception ex) {
			fc.addMessage(null, new FacesMessage("Error : " + ex.getMessage()));
		}
	}
}
