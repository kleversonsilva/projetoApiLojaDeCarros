package io.projetoApiDeLojaDeCarroVirtual;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LojaDeCarrosVirtualApplication {
	
	@Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

	public static void main(String[] args) {
		SpringApplication.run(LojaDeCarrosVirtualApplication.class, args);
	}

}
