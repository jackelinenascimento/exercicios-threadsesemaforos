package controller;

import java.util.concurrent.Semaphore;

public class ThreadPrato extends Thread{

	private int idPrato;
	private Semaphore semaforo;
	
	public ThreadPrato(int idPrato, Semaphore semaforo) {
		this.idPrato = idPrato;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		
		cozimentoPrato();
		try {
			semaforo.acquire();
			entrega();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
	
	private void cozimentoPrato() {
		int tempo = 0;
		String nomePrato = "";
		
		if(idPrato % 2 == 1 ) {
			nomePrato = "Sopa de Cebola";
			tempo = (int)((Math.random()*500)+300);
		} else {
			nomePrato = "Lasanha de Bolonhesa";
			tempo = (int)((Math.random()*600)+600);
		}
		
		System.out.println("Prato #" + idPrato + " : " + nomePrato + " iniciado.");
		
		while(tempo > 0) {
			try {
				sleep(100);
				tempo-=100;
				System.out.println("Prato #" + idPrato + " => porcentagem: " + tempo/100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}	
	}
	
	private void entrega() {
		try {
			sleep(500);
			System.out.println("Prato #" + idPrato + " entregue na mesa!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
