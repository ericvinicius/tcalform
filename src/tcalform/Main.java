package tcalform;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Estado q0 = new Estado("Inicial", false);
		Estado q1 = new Estado("1 real", false);
		Estado q2 = new Estado("2 reais", false);
		Estado q3 = new Estado("3 reais", false);
		Estado q4 = new Estado("4 reais", false);
		Estado q5 = new Estado("5 reais", false);
		Estado q6 = new Estado("6 reais", false);
		Estado q7 = new Estado("7 reais", false);
		Estado q8 = new Estado("8 reais", false);
		Estado q9 = new Estado("9 reais", false);
		Estado q10A = new Estado("Doce A sem troco", true);
		Estado q10AT = new Estado("Doce A com troco", true);
		Estado q11B = new Estado("Doce B sem troco", true);
		Estado q11BT = new Estado("Doce B com troco", true);
		Estado q12C = new Estado("Doce C sem troco", true);
		Estado q12CT = new Estado("Doce C com troco", true);
		
		q0.setCaminhos(new Caminho("1", q1), new Caminho("2", q2), new Caminho("5", q5));
		q1.setCaminhos(new Caminho("1", q2), new Caminho("2", q3), new Caminho("5", q6));
		q2.setCaminhos(new Caminho("1", q3), new Caminho("2", q4), new Caminho("5", q7));
		q3.setCaminhos(new Caminho("1", q4), new Caminho("2", q5), new Caminho("5", q8));
		q4.setCaminhos(new Caminho("1", q5), new Caminho("2", q6), new Caminho("5", q9));
		q5.setCaminhos(new Caminho("1", q6), new Caminho("2", q7), new Caminho("5", q9));
		q6.setCaminhos(new Caminho("1", q7), new Caminho("2", q8), new Caminho("5", q9), new Caminho("A", q10A));
		q7.setCaminhos(new Caminho("1", q8), new Caminho("2", q9), new Caminho("5", q9), new Caminho("A", q10AT), new Caminho("B", q11B));
		q8.setCaminhos(new Caminho("1", q9), new Caminho("2", q9), new Caminho("5", q9), new Caminho("A", q10AT), new Caminho("B", q11BT), new Caminho("C", q12C));
		q9.setCaminhos(new Caminho("1", q9), new Caminho("2", q9), new Caminho("5", q9), new Caminho("A", q10AT), new Caminho("B", q11BT), new Caminho("C", q12CT));
		
		MaquinaDeEstados maquinaDeEstados = new MaquinaDeEstados(q0, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10A, q11B, q12C);
		Estado novoEstado = maquinaDeEstados.getAtual();
		
		while(!novoEstado.isTerminavel()){
			List<String> opcoes = getOpcoes(novoEstado);
			
			novoEstado = maquinaDeEstados.entra(JOptionPane.showInputDialog("Entre com a nota (" + opcoes + ")").toLowerCase());
			System.out.println(novoEstado.getNome());
		}
		JOptionPane.showMessageDialog(null, novoEstado.getNome() + "!!!!");
	}

	private static List<String> getOpcoes(Estado novoEstado) {
		List<Caminho> caminhos = novoEstado.getCaminhos();
		return caminhos.stream().map(c -> c.getValor()).collect(Collectors.toList());
	}

}
