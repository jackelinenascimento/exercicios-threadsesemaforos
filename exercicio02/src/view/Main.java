package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPrato;

public class Main {

	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1);
		
		for(int idPrato = 0; idPrato < 5; idPrato++) {
			
			Thread prato = new ThreadPrato(idPrato, semaforo);
			prato.start();
		}
	}

}
