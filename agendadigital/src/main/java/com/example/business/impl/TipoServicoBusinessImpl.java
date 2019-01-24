package com.example.business.impl;
//TABELA DE NEGOCIOS, ONDE AS CONDIÇÕES FICAM ARMAZENADAS

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.example.business.BusinessException;
import com.example.business.TipoServicoBusiness;
import com.example.dao.TipoServicoDAO;
import com.example.dao.impl.TipoServicoDAOImpl;
import com.example.entity.TipoServico;

@Service
@Transactional
public class TipoServicoBusinessImpl implements TipoServicoBusiness {

	@Autowired
	private TipoServicoDAO dao = new TipoServicoDAOImpl();

	@Override // Propagation serve para declarar cada metodo
	@Transactional(propagation = Propagation.REQUIRED)
	public TipoServico create(TipoServico tipoServico) throws BusinessException {

		if (StringUtils.isEmpty(tipoServico.getNome())) {
			throw new BusinessException("Nome Requerido!");

		}
		return dao.create(tipoServico);

	}

	@Transactional(readOnly = true)
	@Override
	public List<TipoServico> read() throws BusinessException {

		return dao.read();
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoServico> readByName(String nome) throws BusinessException {
		if (StringUtils.isEmpty(nome)) {
			throw new BusinessException("Nome Requerido!");
		}
		return dao.readByName(nome);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TipoServico update(TipoServico tipoServico) throws BusinessException {
		if (tipoServico.getCodigo() == null) {
			throw new BusinessException("Código Requerido! ");

		}
		if (StringUtils.isEmpty(tipoServico.getNome())) {
			throw new BusinessException("Nome Requerido!");
		}
		return dao.update(tipoServico);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Integer id) throws BusinessException {
		if (id == null) {
			throw new BusinessException("Código Requerido!");
		}
		dao.delete(id);

	}
}
