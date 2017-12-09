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
	private UsuarioDao usuariodao;

	@ManagedProperty("#{produtoDaoSpring}")
	private ProdutoDao produtodao;

	private List<Produto> produtos;

	private Usuario logado;
	private Produto produto;

	public ManagerBean() {
		logado = new Usuario();
		  SecurityContext context = SecurityContextHolder.getContext();
		 Authentication userLogado = context.getAuthentication();
		logado.setNome( 
				                       ((User)  userLogado.getPrincipal()).getUsername()
		                       );
      	}

	
	
	
	
	public UsuarioDao getUsuariodao() {
		return usuariodao;
	}

	public void setUsuariodao(UsuarioDao usuariodao) {
		this.usuariodao = usuariodao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ProdutoDao getProdutodao() {
		return produtodao;
	}

	public void setProdutodao(ProdutoDao produtodao) {
		this.produtodao = produtodao;
	}

	public List<Produto> getProdutos() {
		produtos = produtodao.findAll();
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Usuario getLogado() {
		return logado;
	}


	public void setLogado(Usuario logado) {
		this.logado = logado;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public void gravar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try{
			produtodao.create(produto);
			produto = new Produto();
			fc.addMessage(null, new FacesMessage ("Dados Gravados Produto..."));
		}catch(Exception ex){
			fc.addMessage(null, new FacesMessage ("Error:" + ex.getMessage()));

		}
	}
}
