package com.example.dao;

import java.util.List;

import com.example.entity.PrestadorServico;

public interface PrestadorServicoDAO {

	/**
	 * 
	 * @param prestadorServico
	 * @return
	 */
	PrestadorServico create(PrestadorServico prestadorServico);

	List<PrestadorServico> read();

	PrestadorServico update(PrestadorServico prestadorServico);

	void delete(Integer id);

}
