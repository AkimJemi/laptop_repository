package others;

public class Test2 {
	void printTable(int n) {
		synchronized (this) {// synchronized block
			for (int i = 1; i <= 5; i++) {
				System.out.println(n * i);
				try {
					Thread.sleep(3000);
					System.out.println("test" + i);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}

}
