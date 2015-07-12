package entidades;

import java.io.Serializable;
import java.util.Date;

public class Perfil implements Serializable {

	private static final long serialVersionUID = 4306499762696262279L;
	private int id;
	private String nome;
	private int status = 1; 

	
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
        public String toString(){
            return this.id + " " + this.nome + " " + this.status;
        }
}
