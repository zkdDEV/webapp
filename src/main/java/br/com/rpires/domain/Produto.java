/**
 * 
 */
package br.com.rpires.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author rodrigo.pires
 *
 */
@Entity
@Table(name = "TB_PRODUTO")
public class Produto implements Persistente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="prod_seq")
	@SequenceGenerator(name="prod_seq", sequenceName="sq_produto", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "NOME", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "CODIGO", nullable = false, unique = true)
    private Long codigo;
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setNome(Long codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}
	
}
