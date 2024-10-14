package iesb.tg2024.devlab6;

import java.util.ArrayList;
import java.util.List;

public class MatrizAdjacencia {

	private int[][] matriz;
	private List<Vertice> vertices;
	int qtdVertices;
	
	public MatrizAdjacencia(List<Vertice> vertices) {
		this.vertices = vertices;
		this.qtdVertices = vertices.size();
		this.matriz = new int[this.qtdVertices][this.qtdVertices];
		
		this.iniciarMatriz(0);
	}
	
	private void iniciarMatriz(int valorInicial) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++){
				this.matriz[i][j] = valorInicial;
			}
		}
	}
	
	public void adicionarAresta(int indiceVerticeInicial, int indiceVerticeFinal) {
		Vertice verticeInicial = this.vertices.get(indiceVerticeInicial);
		Vertice verticeFinal = this.vertices.get(indiceVerticeFinal);
		
		if (verticeInicial == verticeFinal) {
			this.matriz[indiceVerticeInicial][indiceVerticeFinal] = 1;
			verticeInicial.adicionarGrau();
		} else {
			this.matriz[indiceVerticeInicial][indiceVerticeFinal] = 1;
			verticeInicial.adicionarGrau();
			
			this.matriz[indiceVerticeInicial][indiceVerticeFinal] = 1;
			verticeFinal.adicionarGrau();
		}
	}
	
	
	public List<Vertice> getAdjacencias(int indiceVertice){
		int linha = indiceVertice;
		List<Vertice>adjacencias = new ArrayList<Vertice>();
		
		for (int j= 0; j < this.vertices.size() ; j++) {
			if (this.matriz[linha][j] == 1) {
				Vertice vertice = this.vertices.get(j);
				adjacencias.add(vertice);
			}
		}
		
		return adjacencias;
	}
}
