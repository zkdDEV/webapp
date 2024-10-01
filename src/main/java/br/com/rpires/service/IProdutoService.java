/**
 * 
 */
package br.com.rpires.service;

import br.com.rpires.domain.Produto;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.services.generic.IGenericService;

/**
 * @author rodrigo.pires
 *
 */
public interface IProdutoService extends IGenericService<Produto, Long> {

	Produto buscarCodigo(Long codigo) throws DAOException;

}
