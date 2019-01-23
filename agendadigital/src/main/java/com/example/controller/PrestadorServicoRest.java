package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.business.PrestadorServicoBusiness;
import com.example.entity.PrestadorServico;

@RestController
@RequestMapping(value = "/prestadorServico")
public class PrestadorServicoRest {
	@Autowired
	private PrestadorServicoBusiness business;

	@PostMapping()
	public ResponseEntity<?> create(@RequestBody PrestadorServico prestadorServico) {

		try {
			prestadorServico = business.create(prestadorServico);
			return ResponseEntity.ok(prestadorServico);
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);

		}
	}

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

	@PutMapping
	public ResponseEntity<?> update(@RequestBody PrestadorServico prestadorServico) {
		try {
			prestadorServico = business.update(prestadorServico);
			return ResponseEntity.ok(prestadorServico);
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}
	}

	@DeleteMapping(value = "/{codigo}")

	public ResponseEntity<?> delete(@PathVariable("codigo") Integer codigo) {
		try {
			business.delete(codigo);

			return ResponseEntity.ok().build();
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}

	}
}
