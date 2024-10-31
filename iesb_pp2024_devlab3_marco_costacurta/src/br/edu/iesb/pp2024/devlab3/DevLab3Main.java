package br.edu.iesb.pp2024.devlab3;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class DevLab3Main {

	public static void main(String[] args) {
		
		BlockingQueue<String> queue = new LinkedBlockingQueue<>();
		
		Thread producerThread = new Thread(new FileProducer(queue, IConfig.ARQUIVO_ORIGEM));
		Thread consumerThread = new Thread(new FileConsumer(queue, IConfig.ARQUIVO_DESTINO));

		// inicio do sincronismo
		producerThread.start();
		
		try {
			
			// esse sleep vai permitir que a fia seja criada com sucesso!
			Thread.sleep(5000);
			consumerThread.start();
			
			producerThread.join();
			consumerThread.join();
			
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}
}
