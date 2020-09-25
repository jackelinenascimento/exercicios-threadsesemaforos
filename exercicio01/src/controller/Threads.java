package controller;

public class Threads extends Thread{

	private int idThread;
	
	public Threads(int idThread) {
		this.idThread = idThread;
	}
	
	@Override
	public void run() {
		
		int tempo = 0;
		
		if(idThread % 3 == 1) {
			tempo = (int)((Math.random()*200)+800);
			
			calculos(tempo);
			transacaoBD(1000);
			calculos(tempo);
			transacaoBD(1000);
		
		} else if(idThread % 3 == 2) {
			tempo = (int)((Math.random()*500)+1000);
		
			calculos(tempo);
			transacaoBD(1500);
			calculos(tempo);
			transacaoBD(1500);
			calculos(tempo);
			transacaoBD(1500);
		
		} else {
			tempo = (int)((Math.random()*1000)+1000);
			
			calculos(tempo);
			transacaoBD(1500);
			calculos(tempo);
			transacaoBD(1500);
			calculos(tempo);
			transacaoBD(1500);
		}
		
		System.out.println("#" + idThread + " finalizou todas operações.");
	}
	
	private void calculos(int tempo) {
		try {
			System.out.println("#" + idThread + " realizando calculo.");
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void transacaoBD(int tempo) {
		try {
			System.out.println("#" + idThread + " realizando transação de BD.");
			sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
