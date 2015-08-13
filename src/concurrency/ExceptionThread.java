package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Method Main could not catch exceptions from other threads.
// It can be solved, see CaptureUncaughtException.java.
public class ExceptionThread implements Runnable{
		public void run() {
			throw new RuntimeException();
		}
		public static void main(String[] args) {
			ExecutorService exec =Executors.newCachedThreadPool();
			exec.execute(new ExceptionThread());
		}
}
