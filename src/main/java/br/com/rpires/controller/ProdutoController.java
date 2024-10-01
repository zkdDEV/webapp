/**
 * 
 */
package br.com.rpires.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.rpires.domain.Produto;
import br.com.rpires.service.IProdutoService;

/**
 * @author rodrigo.pires
 *
 */
@Named
@ViewScoped
public class ProdutoController implements Serializable {

	private static final long serialVersionUID = 8030245985235567808L;
	
	private Produto produto;
	
	private Collection<Produto> produtos;
	
	
	@Inject
	private IProdutoService produtoService;
	
	private Boolean isUpdate;
	
	@PostConstruct
    public void init() {
		try {
			this.isUpdate = false;
			this.produto = new Produto();
			this.produtos = produtoService.buscarTodos();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar os clientes"));
		}
	}
	
	public void cancel() {
		try {
			this.isUpdate = false;
			this.produto = new Produto();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar ação"));
		}
		
    } 
	
	public void edit(Produto cliente) {
		try {
			this.isUpdate = true;
			this.produto = cliente;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o cliente"));
		}
		
    } 
	
	public void delete(Produto cliente) {
		try {
			produtoService.excluir(cliente);
			produtos.remove(cliente);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o cliente"));
		}
		
    } 
	
	public void add() {
		try {
			produtoService.cadastrar(produto);
			this.produtos = produtoService.buscarTodos();
			this.produto = new Produto();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar criar o cliente"));
		}
		
        
    }

    public void update() {
    	try {
    		produtoService.alterar(this.produto);
			cancel();
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Cliente Atualiado com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar atualizar o cliente"));
		}
        
    }

	public Collection<Produto> getClientes() {
		return produtos;
	}

	public void setClientes(Collection<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	
	

}
