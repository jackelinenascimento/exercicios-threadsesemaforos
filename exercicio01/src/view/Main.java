package view;

import controller.Threads;

public class Main {

	public static void main(String[] args) {
		
		for(int idThread = 1; idThread < 22; idThread++) {
			
			Thread operacao = new Threads(idThread);
			operacao.start();
		}

	}

}
