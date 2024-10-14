package iesb.tg2024.devlab2.search;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Stack;

import iesb.tg2024.devlab2.core.Grafo;
import iesb.tg2024.devlab2.core.Vertice;

//Algoritmo em Grafo: Depth-First Search
public class BuscaEmProfundidade {
	
	private static BuscaEmProfundidade instance;

	private BuscaEmProfundidade() {
		
	}
	
	public static BuscaEmProfundidade getInstance() {
		
		if(instance == null) {
			instance = new BuscaEmProfundidade();
		}
		
		return instance;
	}
	
	
	public List<String> buscar(Grafo grafo, String origem, String destino){
		
		Stack<String> rastroPercorrido = new Stack<String>();
		LinkedHashSet<String> verticesVisitados = new LinkedHashSet<String>();
		
		Caminho caminho = new Caminho();
		
		//primeiro rastro --> origem
		rastroPercorrido.push(origem);
		
		while(!rastroPercorrido.empty()) {
			String rastro = rastroPercorrido.pop();
			
			if(rastro.equals(destino)) {
				break;			
			}
			
			for (Vertice v : grafo.getGrafoAdjacencias(rastro)) {
				String rotulo = v.getRotulo();
				
				if(!verticesVisitados.contains(rotulo)) {
					verticesVisitados.add(rotulo);
					caminho.ligarVertices(rotulo, rastro);
					rastroPercorrido.push(rotulo);
				}
			}
		}
		
		return caminho.gerarCaminho(origem, destino);
	}

}
