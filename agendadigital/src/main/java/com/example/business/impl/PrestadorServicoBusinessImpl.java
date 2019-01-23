package com.example.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.business.BusinessException;
import com.example.business.PrestadorServicoBusiness;
import com.example.dao.PrestadorServicoDAO;
import com.example.entity.PrestadorServico;
import com.example.entity.Telefone;
import com.example.entity.TipoServico;

@Service
public class PrestadorServicoBusinessImpl implements PrestadorServicoBusiness {

	@Autowired
	private PrestadorServicoDAO dao;

	@Override
	public PrestadorServico create(PrestadorServico prestadorServico) throws BusinessException {
		if (StringUtils.isEmpty(prestadorServico.getNome())) {
			throw new BusinessException("Nome do Prestador Requerido !");
		}
		if (prestadorServico.getCidade().getCodigo() == null) {
			throw new BusinessException("Cidade Requerida");
		}
		if (StringUtils.isEmpty(prestadorServico.getBairro())) {
			throw new BusinessException("Bairro Requerido");
		}
		if (StringUtils.isEmpty(prestadorServico.getTipoLogradouro())) {
			throw new BusinessException("Tipo Logradouro Requerido");
		}
		if (prestadorServico.getTipoLogradouro() == null) {
			throw new BusinessException("Tipo Logradouro Requerido");
		}
		if (StringUtils.isEmpty(prestadorServico.getLogradouro())) {
			throw new BusinessException(" Logradouro Requerido");
		}
		if (StringUtils.isEmpty(prestadorServico.getCep())) {
			throw new BusinessException("CEP Requerido");
		}
		if (prestadorServico.getEmail() == null) {
			throw new BusinessException("Email Requerido");
		}
		if (prestadorServico.getTelefone() == null || prestadorServico.getTelefone().isEmpty()) {
			throw new BusinessException("Telefone Requerido");
		}
		for (Telefone telefone : prestadorServico.getTelefone()) {
			if (telefone.getDdd() == null) {
				throw new BusinessException("DDD Invalido");
			}
			if (telefone.getNumero() == null) {
				throw new BusinessException("Numero Invalido");
			}

			if (prestadorServico.getTiposervico() == null || prestadorServico.getTiposervico().isEmpty()) {
				throw new BusinessException("Pelo menos um tipo de servico é requerido");
			}
			for (TipoServico tipoServico : prestadorServico.getTiposervico()) {
				if (tipoServico.getCodigo() == null) {
					throw new BusinessException("Código tipo servico requerido");
				}
				return dao.create(prestadorServico);
			}

		}

		return dao.create(prestadorServico);
	}

	@Override
	public List<PrestadorServico> read() throws BusinessException {

		return dao.read();
	}

	@Override
	public PrestadorServico update(PrestadorServico prestadorServico) throws BusinessException {
		if (prestadorServico.getCodigo() == null) {
			throw new BusinessException("Codigo do Prestador Requerido!");
		}
		if (prestadorServico.getTelefone() == null) {
			throw new BusinessException("Telefone Requerido!");
		}
		if (prestadorServico.getCidade() == null) {
			throw new BusinessException("Cidade Requerida!");
		}
		if (StringUtils.isEmpty(prestadorServico.getNome())) {
			throw new BusinessException("Nome Requerido !");
		}
		return dao.update(prestadorServico);

	}

	@Override
	public void delete(Integer codigo) throws BusinessException {
		if (codigo == null) {
			throw new BusinessException("Codigo Requerido");
		}
		dao.delete(codigo);
	}
}
