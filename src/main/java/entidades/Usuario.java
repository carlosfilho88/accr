package entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4306499762696262279L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="NOME", length=255, nullable=false)
	private String nome;
	@Column(name="CPF", length=11, unique=true)
	private String cpf;
	@Column(name="SENHA", length=15, nullable=false)
	private String senha;
	@Column(name="DT_NASCIMENTO")
	private Date dataNascimento;
	@Column(name="STATUS", columnDefinition = "tinyint default 1")
	private int status = 1; 
	@Column(name="CREATED", columnDefinition = "datetime default current_timestamp")
	private Date created;
	@Column(name="MODIFIED", columnDefinition = "datetime default current_timestamp")
	private Date modified;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public void setModified() {
		this.modified = new Date();
	}
	
	
	
}
