package entidades;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {

    private static final long serialVersionUID = 4306499762696262279L;
    private int id;
    private String nome;
    private String cpf;
    private String senha;
    private Date dataNascimento;
    private int status;
    private Date created;
    private Date modified;
    private Perfil perfil_id;

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

    public Perfil getPerfil_id() {
        return perfil_id;
    }

    public void setPerfil_id(Perfil perfil_id) {
        this.perfil_id = perfil_id;
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

    public String toString() {
        return this.cpf + " " + this.nome + " " + this.senha;
    }

}
