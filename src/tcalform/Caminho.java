package tcalform;

public class Caminho {

	private String valor;
	private Estado proximoEstado;

	public Caminho(String string, Estado q1) {
		this.setValor(string.toLowerCase());
		this.setProximoEstado(q1);
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Estado getProximoEstado() {
		return proximoEstado;
	}

	public void setProximoEstado(Estado proximoEstado) {
		this.proximoEstado = proximoEstado;
	}

}
