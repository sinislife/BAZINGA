package br.unibh.sdm.backend_usuario.entidades;

import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


@DynamoDBTable(tableName = "usuario")
public class Usuario {
	private String cpf;
	private String usuario;
	private String jogos;
	private String descricao;
	private Date dataCriacao;
	
	public Usuario() {
		super();
	}

	public Usuario(String cpf, String usuario, String jogos, String senha, Date dataCriacao) {
		super();
		this.cpf = cpf;
		this.usuario = usuario;
		this.jogos = jogos;
		this.descricao = senha;
		this.dataCriacao = dataCriacao;
	}

	@DynamoDBHashKey
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@DynamoDBAttribute
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@DynamoDBAttribute
	public String getJogos() {
		return jogos;
	}

	public void setJogos(String jogos) {
		this.jogos = jogos;
	}

	@DynamoDBAttribute
	public String getSenha() {
		return descricao;
	}

	public void setSenha(String senha) {
		this.descricao = senha;
	}

	@DynamoDBAttribute
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((jogos == null) ? 0 : jogos.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (jogos == null) {
			if (other.jogos != null)
				return false;
		} else if (!jogos.equals(other.jogos))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [cpf=" + cpf + ", usuario=" + usuario + ", jogos=" + jogos + ", descricao=" + descricao
				+ ", dataCriacao=" + dataCriacao + "]";
	}
	
	
	
	
	
	
	
	

}