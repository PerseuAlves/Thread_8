package controller;

import java.util.concurrent.Semaphore;

public class ThreadCruzamento extends Thread {
	
	private int id;
	private String sentido;
	private Semaphore semaforo;
	
	public ThreadCruzamento (int id, String sentido, Semaphore semaforo) {
		
		this.id = id;
		this.sentido = sentido;
		this.semaforo = semaforo;
	}
	
	public void run () {
		
///////////////////////////////////////	Seção Crítica ///////////////////////////////////////
		try {
			semaforo.acquire();
			Verde();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
///////////////////////////////////////	Seção Crítica ///////////////////////////////////////
	}
	
	public void Verde () {
		
		System.out.println("Sinal verde para o sentido " + sentido);
		System.out.println("O carro " + (id + 1) + " está atravessando no sentido " + sentido);
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" ");
		System.out.println("Sinal vermelho para o sentido " + sentido);
		System.out.println(" ");
	}
}