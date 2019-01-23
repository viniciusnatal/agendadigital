package com.example.business;

import java.util.List;

import com.example.entity.Cidade;
import com.example.enums.Estado;

public interface CidadeBusiness {

	/**
	 * 
	 * @param cidade
	 * @return
	 * @throws BusinessException
	 */
	Cidade create(Cidade cidade) throws BusinessException;

	/**
	 * 
	 * @param cidade
	 * @return
	 * @throws BusinessException
	 */
	List<Cidade> read() throws BusinessException;

	/**
	 * 
	 * @param nome
	 * @return
	 * @throws BusinessException
	 */
	List<Cidade> readByEstado(Estado estado) throws BusinessException;

	/**
	 * 
	 * @param cidade
	 * @return
	 * @throws BusinessException
	 */
	Cidade update(Cidade cidade) throws BusinessException;

	/**
	 * 
	 * @param codigo
	 * @throws BusinessException
	 */
	void delete(Integer codigo) throws BusinessException;
}
