package iesb.tg2024.devlab2.app;

import java.util.List;

import iesb.tg2024.devlab2.core.Grafo;
import iesb.tg2024.devlab2.core.Vertice;
import iesb.tg2024.devlab2.search.BuscaEmProfundidade;

public class DevLab2Main {

	public static void main(String[] args) {
		
		// gerar um grafo do tipo G = (V,E)
		Grafo grafo = new Grafo(9);
		try {
			grafo.adicionarVertices("DF");		
			grafo.adicionarVertices("CR");
			grafo.adicionarVertices("CT");
			grafo.adicionarVertices("UA");
			grafo.adicionarVertices("UB");
			grafo.adicionarVertices("RP");
			grafo.adicionarVertices("SC");
			grafo.adicionarVertices("LM");
			grafo.adicionarVertices("CP");

			
			System.out.println(">> O G(V,E) possui os seguintes vértices: \n");
			for (Vertice vertice : grafo.getVertices()) {
				System.out.println("- vértice: " + vertice.getRotulo());
			}

			grafo.conectarVertices("DF", "CR");
			grafo.conectarVertices("CR", "CT");
			grafo.conectarVertices("CT", "UA");
			grafo.conectarVertices("UA", "UB");
			grafo.conectarVertices("UB", "RP");
			grafo.conectarVertices("RP", "SC");
			grafo.conectarVertices("SC", "LM");
			grafo.conectarVertices("LM", "CP");
			
			//Exemplo Aula 8
			BuscaEmProfundidade buscaEmProfundidade = BuscaEmProfundidade.getInstance();
			List<String> caminho = buscaEmProfundidade.buscar(grafo, "DF", "CP");
			
			System.out.println("[Depth First Search] >>  Caminho feito por uma busca em profundidade...");

			for (String passo : caminho) {
				System.out.println("[DFS]: >> " + passo + " ");
			}
			
			
			
			//System.out.println(">> Grau do vértice DF: " + grafo.getVertice("DF").getGrau());
		
			//System.out.println(">> O vértice DF possui as seguintes adjacências: ");
			
			//for(Vertice vertice : grafo.getGrafoAdjacencias("DF")) {
				//System.out.println(vertice.getRotulo() + " ");
			//}			
			
			// Imprime a Matriz Adjacencia do Grafo
			//grafo.imprimirMatrizAdjacenciaGrafo();			
			
		} catch (Exception e) {
			System.err.println(e);
		}		
	}
}