package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	public static void main(String[] args) {
		String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};
			for(String candidato : candidatos) {
				entrandoEmContato(candidato);
			}
	}
	
	static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		
		do {
			//elas precisaram sofrer alterção
			
			atendeu = atender();
			continuarTentando =! atendeu;
			
			if(continuarTentando) 
				tentativasRealizadas++;
			else 
				System.out.println("CONTATO REALIZADO COM SUCESSO");
			
		}while(continuarTentando && tentativasRealizadas < 3);
		
		if(atendeu)
			System.out.println("CONSEGUIMOS CONTATO COM" + candidato
					+"NA" + tentativasRealizadas + "TENTATIVAS");
		else
			System.out.println("NAO CONSEGUIMOS CONTATO COM" + candidato
					+"NUMERO MAXIMO TENTATIVSAS" + tentativasRealizadas);
	}
	
	static boolean atender() {
		return new Random().nextInt(3)==1;
	}
	
	static void imprimirListaCandidatos() {
		String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};
			
		System.out.println("Imprimindo lista de candidatos com o indice");
			for(int indice = 0; indice < candidatos.length;indice++) {
				System.out.println("O candidato de n°" + (indice+1) + "é"
					+ candidatos[indice]);
				
		System.out.println("Forma abreviada de interação for each");
			for(String candidato: candidatos) {
				System.out.println("Candidato selecionado" + candidato);
			}
		}
		
	}
	
	static void selecaoCandidatos(){
		String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO","MONICA"
			+ "FABRICIO","MIRELA","DANIELA","JOSE"};
	
	int candidatosSelecionados =0;
	int candidatosAtual = 0;
	double salarioBase = 2000.0;
	
	while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
		String candidato = candidatos[candidatosAtual];
		double salarioPretendido = valorPretendido();
		
		System.out.println("O candidato"+candidato+"Solicitou este valor"
				+salarioPretendido);
		
		if(salarioBase >= salarioPretendido) {
			System.out.println("O candidato" + candidato +"foi selecionado"
					+ "para vaga");
			candidatosSelecionados++;
		}
		
		candidatosAtual++;
	}
}
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800,2200);
	}
	
	static void analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0;
		if(salarioBase > salarioPretendido) {
			System.out.println("LIGAR PARA O CANDIDATO");
		}else if(salarioBase == salarioPretendido)
			System.out.println("LIGAR PARA O CANDIDATO"
					+ "COM CONTRA PROPOSTA");
		else {
			System.out.println("AGUARDANDO O RESULTADO DOS"
					+ "DEMAIS CANDIDATOS");
		}
	}
}
