/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Airon
 */
public class Movimentacao implements Serializable {

    private int id;
    private Item item;
    private Usuario usuario;
    private String tipoMovimentacao;
    private int status;
    private Date created;
    private Date modified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public String toString() {
        return this.item.getDescricao() + " " + this.usuario.getNome() + " " + this.tipoMovimentacao + " " + this.created;
        //return this.id + " " + this.item.getId() + " " + this.usuario.getId() + " " + this.tipoMovimentacao + " " + this.status + " " + this.created + " " + this.modified;
    }

}
