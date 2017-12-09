package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idUsuario;
	@Column(length = 50)
	private String nome;
	@Column(length = 50)
	private String login;
	@Column(length = 255)
	private String senha;
	@Column(length = 20)
	private String perfil;
	@Column
	private Integer ativo;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", login=" + login + ", perfil=" + perfil
				+ ", ativo=" + ativo + "]";
	}

	public Usuario(String nome, String login, String senha, String perfil, Integer ativo) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
		this.ativo = ativo;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

}
