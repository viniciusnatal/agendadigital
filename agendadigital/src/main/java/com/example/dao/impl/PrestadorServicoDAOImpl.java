package com.example.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.dao.PrestadorServicoDAO;
import com.example.entity.PrestadorServico;

@Repository
public class PrestadorServicoDAOImpl implements PrestadorServicoDAO {

	private List<PrestadorServico> lista = new ArrayList<>();
	private int indice = 0;

	@Override
	public PrestadorServico create(PrestadorServico prestadorServico) {
		prestadorServico.setCodigo(indice++);
		lista.add(prestadorServico);

		return (prestadorServico);
	}

	@Override
	public List<PrestadorServico> read() {

		return lista;
	}

	@Override
	public PrestadorServico update(PrestadorServico prestadorServico) {
		for (PrestadorServico prestadorServico1 : lista) {
			if (prestadorServico1.getCodigo().equals(prestadorServico.getCodigo())) {
				prestadorServico1.setCidade(prestadorServico.getCidade());
				prestadorServico1.setBairro(prestadorServico.getBairro());
				prestadorServico1.setCep(prestadorServico.getCep());
				prestadorServico1.setNumero(prestadorServico.getNumero());
				prestadorServico1.setTipoLogradouro(prestadorServico.getTipoLogradouro());
				prestadorServico1.setComplemento(prestadorServico.getComplemento());
				prestadorServico1.setEmail(prestadorServico.getEmail());
				prestadorServico1.setTelefone(prestadorServico.getTelefone());
				prestadorServico1.setTiposervico(prestadorServico.getTiposervico());
				break;

			}
		}
		return prestadorServico;

	}

	@Override
	public void delete(Integer id) {
		for (PrestadorServico prestadorServico1 : lista) {
			if (prestadorServico1.getCodigo().equals(id)) {
				lista.remove(prestadorServico1);
				break;

			}

		}
	}

}
