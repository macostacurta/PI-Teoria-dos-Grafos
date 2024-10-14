package iesb.tg2024.aula05;

public class DevLab5Main {

	
	//Exemplo 1: Menos robusto
	public void gerarPrimeiraMatriz(int qtdLinhas,int qtdColunas,int valorInicial, int valorDiagonal, boolean isArestaLoop ) {
		
		System.out.println(">> gerarPrimeiraMatriz() ");
		
		
		// inicialização da matriz
		int[][] matriz = new int[qtdLinhas][qtdColunas];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++){
				if (isArestaLoop == true && i == j)
					matriz[i][j] = valorDiagonal;
				else
					matriz[i][j] = valorInicial;
			}
		}
		System.out.println(">> matriz inicializada...");
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++){
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {

		//Exemplo 1
		DevLab5Main lab1 = new DevLab5Main();
		//lab1.gerarPrimeiraMatriz(10, 10, 0, 1, true);
		
		//Exemplo 2
		ManipulaMatrizAdjacencia matrizAdjacencia = new ManipulaMatrizAdjacencia();
		int[][] matriz = matrizAdjacencia.gerarMatrizAdajcencia(20, 20, 0, 1, true);
		
		//imprimir a minha matriz de adajacenica
		matrizAdjacencia.printMatrizAdajcencia(matriz);
	}

}
