package application;

public class BlockThread extends Thread {
	
	FXMLDocumentController GUI = new FXMLDocumentController();
	private final int DELAY = 25;
	@Override
	public void run() {

	//	long startTime = System.currentTimeMillis();
		long beforeTime, timeDiff, sleep;

		while (true) {

			beforeTime = System.currentTimeMillis();
			GUI.redBlock.setY(GUI.redBlock.getY()-2);

			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = DELAY - timeDiff;

			if (sleep < 0) {
				sleep = 2;
			}

			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {

				String msg = String.format("Thread interrupted: %s", e.getMessage());
				System.out.println(msg);
			}
		}
	}
}
