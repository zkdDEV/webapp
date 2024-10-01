/**
 * 
 */
package br.com.rpires.dao;

import br.com.rpires.dao.generic.GenericDAO;
import br.com.rpires.domain.Produto;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoDAO extends GenericDAO<Produto, Long> implements IProdutoDAO {

	public ProdutoDAO() {
		super(Produto.class);
	}

}
