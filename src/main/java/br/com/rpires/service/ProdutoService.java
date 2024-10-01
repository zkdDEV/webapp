/**
 * 
 */
package br.com.rpires.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.rpires.dao.IProdutoDAO;
import br.com.rpires.domain.Produto;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.services.generic.GenericService;

/**
 * @author rodrigo.pires
 *
 */
@Stateless
public class ProdutoService extends GenericService<Produto, Long> implements IProdutoService {
	
	@Inject
	public ProdutoService(IProdutoDAO produtoDAO) {
		super(produtoDAO);
	}

	@Override
	public Produto buscarCodigo(Long codigo) throws DAOException {
		try {
			return this.dao.consultar(codigo);
		} catch (MaisDeUmRegistroException | TableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
