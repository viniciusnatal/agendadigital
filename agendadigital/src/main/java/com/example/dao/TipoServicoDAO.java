package com.example.dao;

import java.util.List;
import com.example.entity.TipoServico;
// Devolucao feita pela interface
public interface TipoServicoDAO {
	
	/**
	 * Metodo responsavel por persistir o objeto{@link TipoServico} na base de dados
	 * @param tipoServico Objeto a ser persistido 
	 * @return Objeto persistido
	 */
	TipoServico create(TipoServico tipoServico); 
	
	/**
	 * Metodo responsavel por recuperar da base de dados todos os objetos
	 * {@link TipoServico}
	 * @return Lista de {@link TipoServico}
	 */
	List<TipoServico> read();
	
	/**
	 * Metodo responsavel por recuperar a base de dados de todos os obetos {@link TipoServico}
	 * cujo seu nome possua parte do parametro Nome
	 * @param Parte do nome a ser buscaod
	 * @return Lista de {@link TipoServico}
	 */
	List<TipoServico> readByName(String nome);
	
	/**
	 * Metodo responsavel por persistir(atualizar) na base de dados o objeto
	 * {@link TipoServico}
	 * @param tipoServico Objeto a ser persistido
	 * @return objeto persistido
	 */
	TipoServico update (TipoServico tipoServico);
	
	/**
	 * Metodo Reponsavel por excluir da base de dados o objeto {@link TipoServico}
	 * referente ao id informado
	 * @param id Identificador do objeto {@link TipoServico} a ser excluido 
	 */
	void delete(Integer id);
}
