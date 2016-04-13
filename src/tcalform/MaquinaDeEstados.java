package tcalform;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MaquinaDeEstados {

	private List<Estado> estados;
	private Estado atual;

	public MaquinaDeEstados(Estado... estados) {
		this.estados = Arrays.asList(estados);
		atual = this.estados.get(0);
	}

	public Estado entra(String entrada) {
		Optional<Estado> estado = atual.entra(entrada);
		
		if(!estado.isPresent()){
			throw new RuntimeException("Valor Invalido");
		}
		
		atual = estado.get();
		return atual;
	}

	public Estado getAtual() {
		return atual;
	}

}
