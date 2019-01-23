package com.example.dao;

import java.util.List;

import com.example.entity.Cidade;
import com.example.enums.Estado;

public interface CidadeDAO {

	/**
	 * 
	 * @param cidade
	 * @return
	 */
	Cidade create(Cidade cidade);

	/**
	 * 
	 * @return
	 */
	List<Cidade> read();

	/**
	 * 
	 * @param nome
	 * @return
	 */
	List<Cidade> readByName(String nome);

	/**
	 * 
	 * @param cidade
	 * @return
	 */
	Cidade update(Cidade cidade);

	/**
	 * 
	 * @param id
	 */
	void delete(Integer id);

	/**
	 * 
	 * @param estado
	 * @return
	 */
	List<Cidade> readByEstado(Estado estado);

}
