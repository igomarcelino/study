package igo.primeiro_projeto.singletonOUprototype;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PrimeiroProjetoApplication {

	public static void main(String[] args) {

		SpringApplication.run(PrimeiroProjetoApplication.class,args);
	}

	@Bean
	public CommandLineRunner run(SistemaDeMensagem sistemaDeMensagem){
		return args -> {
			sistemaDeMensagem.enviarConfiguracaoCadastro();
			sistemaDeMensagem.enviarMensagemBoasVindas();
		};
	}
	
}
