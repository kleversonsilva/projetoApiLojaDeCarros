package io.projetoApiDeLojaDeCarroVirtual.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.projetoApiDeLojaDeCarroVirtual.dto.CarroDTO;
import io.projetoApiDeLojaDeCarroVirtual.model.Carro;
import io.projetoApiDeLojaDeCarroVirtual.service.CarroService;

@RestController
@RequestMapping("/api/carros")
public class CarroController {

	private final CarroService carroService;
	
	private ModelMapper modelMapper;
	
	public CarroController(CarroService carroService, ModelMapper modelMapper) {
		this.carroService = carroService;
		this.modelMapper = modelMapper;
		
	}

	@GetMapping()
	public List<Carro> listaTodos() {

		return carroService.todos();

	}
	
	@GetMapping("{id}")
	public Carro listarPorId(@PathVariable Integer id) {
		Carro carroAchado = carroService.listarCarroPorId(id);
		
		return carroAchado;
	}

	@PostMapping()
	public ResponseEntity<Carro> cadastrar(@RequestBody CarroDTO carroDTO) {

		Carro c = this.convertToEntity(carroDTO);
		
		this.carroService.adicionar(c);

		return ResponseEntity.ok().build();

	}

	@PutMapping("{id}")
	public ResponseEntity<Carro> atualizar(@PathVariable Integer id, @RequestBody CarroDTO carroDTO) {
		
		Carro c = this.convertToEntity(carroDTO);
		
		if (carroService.carroEstaPresente(id).isPresent()) {
			carroService.atualizar(id, c);
			
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();


	}
	
	@DeleteMapping("{id}") 
	public void deletar(@PathVariable Integer id) {
		this.carroService.deletar(id);
	}
	
	// Converter para DTO
	private CarroDTO convertToDTO(Carro c) {
		return modelMapper.map(c, CarroDTO.class);
	}
	
	// Converter para entidade
	private Carro convertToEntity(CarroDTO carroDTO) {
        return modelMapper.map(carroDTO, Carro.class);
    }

}
