package io.projetoApiDeLojaDeCarroVirtual.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.projetoApiDeLojaDeCarroVirtual.model.Carro;
import io.projetoApiDeLojaDeCarroVirtual.repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository carroRepository;
	
	// Adicionar
	public void adicionar(Carro carro) {
		
		carroRepository.save(carro);
		
	}
	
	//Listar por id
	public Carro listarCarroPorId(Integer id) {
		return carroRepository.getReferenceById(id);
	}
	
	//Listar todos
	public List<Carro> todos() {
		return carroRepository.findAll();
	}
	
	//Deletar
	public void deletar(Integer id) {
		this.carroRepository.deleteById(id);
	}
	
	//Atualizar
	public Carro atualizar(Integer id, Carro carro) {
		Carro carro_atualizado = this.carroRepository.getReferenceById(id);
		
		carro_atualizado.setNome(carro.getNome());
		carro_atualizado.setCor(carro.getCor());
		carro_atualizado.setPreco(carro.getPreco());
		carro_atualizado.setModelo(carro.getModelo());
		
		
		return carro_atualizado;
	}
	
	//Verificar se o carro esta presente
	public Optional<Carro> carroEstaPresente(Integer id) {
		Optional<Carro> findById = this.carroRepository.findById(id);
		
		return findById;
	}

}
