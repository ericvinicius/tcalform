package tcalform;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Estado {

	private String nome;
	private boolean terminavel;
	private List<Caminho> caminhos;

	public Estado(String string, boolean b) {
		this.setNome(string);
		this.setTerminavel(b);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isTerminavel() {
		return terminavel;
	}

	public void setTerminavel(boolean terminavel) {
		this.terminavel = terminavel;
	}

	public void setCaminhos(Caminho... caminhos) {
		this.caminhos = Arrays.asList(caminhos);
	}

	public Optional<Estado> entra(String entrada) {
		for (Caminho caminho : caminhos) {
			if(caminho.getValor().equals(entrada)){
				return Optional.of(caminho.getProximoEstado());
			}
		}
		return Optional.empty();
	}

	public List<Caminho> getCaminhos() {
		return caminhos;
	}

}
