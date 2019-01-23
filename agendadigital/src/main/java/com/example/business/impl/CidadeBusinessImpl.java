package com.example.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.business.BusinessException;
import com.example.business.CidadeBusiness;
import com.example.dao.CidadeDAO;
import com.example.entity.Cidade;
import com.example.enums.Estado;

@Service
public class CidadeBusinessImpl implements CidadeBusiness {

	@Autowired
	private CidadeDAO dao;

	@Override
	public Cidade create(Cidade cidade) throws BusinessException {
		if (StringUtils.isEmpty(cidade.getNome())) {
			throw new BusinessException("Nome da Cidade Requerido ! ");
		}
		if (cidade.getEstado() == (null)) {
			throw new BusinessException("Estado Requerido !");
		}

		return dao.create(cidade);
	}

	@Override
	public List<Cidade> read() throws BusinessException {

		return dao.read();
	}

	@Override
	public List<Cidade> readByEstado(Estado estado) throws BusinessException {
		if (estado == null) {
			throw new BusinessException("Estado Requerido");
		}
		return dao.readByEstado(estado);
	}

	@Override
	public Cidade update(Cidade cidade) throws BusinessException {
		if (cidade.getCodigo() == null) {
			throw new BusinessException("Código da Cidade Requerido ! ");
		}
		if (StringUtils.isEmpty(cidade.getNome())) {
			throw new BusinessException("Nome Requerido");
		}
		if (cidade.getEstado() == null) {
			throw new BusinessException("Nome da Cidade Requerido !");
		}
		return dao.update(cidade);

	}

	@Override
	public void delete(Integer codigo) throws BusinessException {
		if (codigo == null) {
			throw new BusinessException("Codigo da Cidade Requerido !");
		}
		dao.delete(codigo);
	}

}
