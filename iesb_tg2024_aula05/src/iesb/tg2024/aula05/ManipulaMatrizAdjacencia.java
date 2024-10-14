package iesb.tg2024.aula05;

public class ManipulaMatrizAdjacencia {

	public int[][] gerarMatrizAdajcencia(int qtdLinhas,int qtdColunas,int valorInicial, int valorDiagonal, boolean isArestaLoop ) {
		
		System.out.println(">> Gerando Matriz de Adjacencia ");
		
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
		
		return matriz;
	}

	public void printMatrizAdajcencia(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++){
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
