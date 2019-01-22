package com.example.business;

import java.util.List;

import com.example.entity.TipoServico;

public interface TipoServicoBusiness {

	/**
	 * Metodo responsavel por garantir os parametros obrigatorios, bem como
	 * solicitar a camada de acesso a dados que persista o objeto
	 * {@link TipoServico}
	 * 
	 * @param tiposervico Objeto a ser persistido
	 * @return Objeto Persistido
	 * @throws BusinessException
	 */
	TipoServico create(TipoServico tiposervico) throws BusinessException;

	/**
	 * Metodo responsavel por recuperar da base de dados todos os objetos
	 * {@link TipoServico}
	 * 
	 * @return Lista de {@link TipoServico}
	 * @throws BusinessException
	 */
	List<TipoServico> read() throws BusinessException;

	/**
	 * Metodo responsavel por recuperar a base de dados de todos os obetos
	 * {@link TipoServico} cujo seu nome possua parte do parametro Nome
	 * 
	 * @param Parte do nome a ser buscaod
	 * @return Lista de {@link TipoServico}
	 */
	List<TipoServico> readByName(String nome) throws BusinessException;

	/**
	 * Metodo responsavel por persistir(atualizar) na base de dados o objeto
	 * {@link TipoServico}
	 * 
	 * @param tipoServico Objeto a ser persistido
	 * @return objeto persistido
	 */
	TipoServico update(TipoServico tipoServico) throws BusinessException;

	/**
	 * Metodo Reponsavel por excluir da base de dados o objeto {@link TipoServico}
	 * referente ao id informado
	 * 
	 * @param id Identificador do objeto {@link TipoServico} a ser excluido
	 */
	void delete(Integer id) throws BusinessException;
}
