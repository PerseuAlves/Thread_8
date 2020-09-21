package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCruzamento;

public class Main {

	public static void main(String[] args) {
		
		int permisao = 1;
		Semaphore semaforo = new Semaphore(permisao);
		for (int id=0; id<4; id++) {
			if (id == 0) {
				String sentido = "Norte";
				Thread threadCruzamento = new ThreadCruzamento(id, sentido, semaforo);
				threadCruzamento.start();
			} else if (id == 1) {
				String sentido = "Sul";
				Thread threadCruzamento = new ThreadCruzamento(id, sentido, semaforo);
				threadCruzamento.start();
			} else if (id == 2) {
				String sentido = "Leste";
				Thread threadCruzamento = new ThreadCruzamento(id, sentido, semaforo);
				threadCruzamento.start();
			} else {
				String sentido = "Oeste";
				Thread threadCruzamento = new ThreadCruzamento(id, sentido, semaforo);
				threadCruzamento.start();
			}
		}
	}

}
