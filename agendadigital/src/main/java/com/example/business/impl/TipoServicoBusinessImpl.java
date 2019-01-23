package com.example.business.impl;
//TABELA DE NEGOCIOS, ONDE AS CONDIÇÕES FICAM ARMAZENADAS

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.business.BusinessException;
import com.example.business.TipoServicoBusiness;
import com.example.dao.TipoServicoDAO;
import com.example.dao.impl.TipoServicoDAOImpl;
import com.example.entity.TipoServico;

@Service
public class TipoServicoBusinessImpl implements TipoServicoBusiness {
	private TipoServicoDAO dao = new TipoServicoDAOImpl();

	@Override
	public TipoServico create(TipoServico tipoServico) throws BusinessException {
		if (StringUtils.isEmpty(tipoServico.getNome())) {
			throw new BusinessException("Nome Requerido!");

		}
		return dao.create(tipoServico);

	}

	@Override
	public List<TipoServico> read() throws BusinessException {

		return dao.read();
	}

	@Override
	public List<TipoServico> readByName(String nome) throws BusinessException {
		if (StringUtils.isEmpty(nome)) {
			throw new BusinessException("Nome Requerido!");
		}
		return dao.readByName(nome);
	}

	@Override
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
	public void delete(Integer id) throws BusinessException {
		if (id == null) {
			throw new BusinessException("Código Requerido!");
		}
		dao.delete(id);

	}
}
