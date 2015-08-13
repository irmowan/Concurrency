package concurrency;

class UnresponsiveUI {
	private volatile double d = 1;

	public UnresponsiveUI() throws Exception {
		System.out.println("UnresponsiveUI3");
		while (d > 0)
			d = d + (Math.PI + Math.E) / d;
		System.in.read(); // Never gets here.
	}
}

public class ResponsiveUI extends Thread {
	private static volatile double d = 1;

	public ResponsiveUI() {
		setDaemon(true);
		start();
	}

	// Calculation should be contained in method run. So it can be killed.
	public void run() {
		while (true) {
			d = d + (Math.PI + Math.E) / d;
		}
	}

	public static void main(String[] args) throws Exception {
		// ! new UnresponsiveUI(); // Must kill this process
		new ResponsiveUI();
		System.in.read();
		System.out.println(d);
	}
}
