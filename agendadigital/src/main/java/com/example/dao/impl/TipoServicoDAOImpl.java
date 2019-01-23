package com.example.dao.impl;

//IMPORTAR BIBLIOTECAS DE OUTRAS CLASSES
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.dao.TipoServicoDAO;
import com.example.entity.TipoServico;

@Repository
public class TipoServicoDAOImpl implements TipoServicoDAO {

	private List<TipoServico> lista = new ArrayList<>();
	private int indice = 0;

	@Override
	public TipoServico create(TipoServico tipoServico) {
		tipoServico.setCodigo(indice++);
		lista.add(tipoServico);
		return tipoServico;
	}

	@Override

	public List<TipoServico> read() {

		return lista;
	}

	@Override
	public List<TipoServico> readByName(String nome) {
		List<TipoServico> listaRetorno = new ArrayList<>();
		for (TipoServico tipoServico : lista) {
			if (tipoServico.getNome().toUpperCase().contains(nome.toUpperCase())) {
				listaRetorno.add(tipoServico);
			}
		}
		return listaRetorno;
	}

	@Override
	public TipoServico update(TipoServico tipoServico) {
		for (TipoServico tipoServico2 : lista) {
			if (tipoServico2.getCodigo().equals(tipoServico.getCodigo())) {
				tipoServico2.setNome(tipoServico.getNome());
			}
		}
		return tipoServico;
	}

	@Override
	public void delete(Integer id) {
		for (TipoServico tipoServico2 : lista) {
			if (tipoServico2.getCodigo().equals(id)) {
				lista.remove(tipoServico2);
				break;
			}
		}

	}

}
