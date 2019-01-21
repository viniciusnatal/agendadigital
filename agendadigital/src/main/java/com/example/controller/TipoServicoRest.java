package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.TipoServico;

@RestController // Habilita classe como um servico REST -> Recurso
@RequestMapping(value="/tiposervico") //Disponibiliza o Nome do Servico na barra de navegacao 

public class TipoServicoRest {
	
	private List<TipoServico> lista= new ArrayList<>();
	private int indice = 0;
	
//Metodo Create 
// Request Body vem em forma de parametro

	@PostMapping()//Sempre ira devolver uma entidade (ResponseEntity)
	public ResponseEntity<?> create (@RequestBody TipoServico tipoServico){

//Se nome = null ou nome estar vazio, entao retorne a frase
		if(StringUtils.isEmpty(tipoServico.getNome())) {
			
//BAD REQUEST = informa o erro + frase 
			return ResponseEntity.badRequest().body("Nome Requerido! ");
		}	//adiciona numeracao do codigo
		tipoServico.setCodigo(indice++);
				
		lista.add(tipoServico);
//Devolve o tipo Servico para o soapUI
		return ResponseEntity.ok(tipoServico);
				
	}
		
	//Metodo read
	//lê o método e retorna a lista inteira (lista)
	@GetMapping 
	
	public ResponseEntity<?> read(){
		
		return ResponseEntity.ok(lista);
	}
		
//Metodo update
	@PutMapping
//Igualar Metodos e parametros
	public ResponseEntity<?> update(@RequestBody TipoServico tipoServico){
		if(tipoServico.getCodigo() == null) {
			return ResponseEntity.badRequest().body("Código Requerido! ");
		
			}
		if(StringUtils.isEmpty(tipoServico.getNome())) {
			return ResponseEntity.badRequest().body("Nome Requerido! ");
//Fazendo a Ligacao dos metodos para confirmar
		}
		for(TipoServico tipoServico2 : lista) {
			if(tipoServico2.getCodigo().equals(tipoServico.getCodigo())) {
				tipoServico2.setNome(tipoServico.getNome());
			}
			
		}
		return ResponseEntity.ok(tipoServico);
	
		
		}
			
//Metodo delete
	@DeleteMapping
	public ResponseEntity<?>delete(@RequestBody TipoServico tipoServico){
		if(tipoServico.getCodigo()==null) {
			return ResponseEntity.badRequest().body("Código Requerido!");	
		}
		for(TipoServico tipoServico2 : lista) {
		if(tipoServico2.getCodigo().equals(tipoServico.getCodigo())) {
			lista.remove(tipoServico2);
			break;
		}
	}	
		return ResponseEntity.ok().build();
		
	}
}


