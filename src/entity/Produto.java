package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idProduto;
	@Column(length = 50)
	private String nomeProduto;
	@Column
	private Double preco;

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nomeProduto;
	}

	public void setNome(String nome) {
		this.nomeProduto = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Produto(String nome, Double preco) {
		super();
		this.nomeProduto = nome;
		this.preco = preco;
	}

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nome=" + nomeProduto + ", preco=" + preco + "]";
	}

}
