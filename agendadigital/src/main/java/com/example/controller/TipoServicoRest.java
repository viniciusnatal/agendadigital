package com.example.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.business.BusinessException;
import com.example.business.TipoServicoBusiness;
import com.example.business.impl.TipoServicoBusinessImpl;
import com.example.entity.TipoServico;

@RestController // Habilita classe como um servico REST -> Recurso
@RequestMapping(value = "/tiposervico") // Disponibiliza o Nome do Servico na barra de navegacao

public class TipoServicoRest {

	private TipoServicoBusiness business = new TipoServicoBusinessImpl();

//Metodo Create 
// Request Body vem em forma de parametro
//Parametro do tipoServico vem pelo request body -->  
	@PostMapping() // Sempre ira devolver uma entidade (ResponseEntity)
	public ResponseEntity<?> create(@RequestBody TipoServico tipoServico) {

		try {
			tipoServico = business.create(tipoServico);// atribuir o Objeto no mesmo objeto+business
			return ResponseEntity.ok(tipoServico);
		} catch (BusinessException e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		}
	}

	// Metodo read
	// lê o método e retorna a lista inteira (lista)
	@GetMapping

	public ResponseEntity<?> read() {
		try {
			return ResponseEntity.ok(business.read());
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}

	}

//Metodo update
	@PutMapping
//Igualar Metodos e parametros
	public ResponseEntity<?> update(@RequestBody TipoServico tipoServico) {
		try {
			tipoServico = business.update(tipoServico);

			return ResponseEntity.ok(tipoServico);
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}
	}

//Metodo delete
	@DeleteMapping(value = "/{id}")
//Utilizando o Delete para excluir informacoes com id	
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		try {
			business.delete(id);

			return ResponseEntity.ok().build();
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}
	}

	// metodo get busca por parametro
	@GetMapping("/filtro/nome")
	public ResponseEntity<?> readByName(@PathParam("nome") String nome) {

		try {
			List<TipoServico> readByName = business.readByName(nome);
			if (readByName.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(readByName);
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}
	}

}
