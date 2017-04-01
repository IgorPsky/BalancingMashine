package balancer;

public class printlnBalancer {

		static final int interval = 100;
		private BalancingMachine m;
		public printlnBalancer(BalancingMachine m) {
			super();
			this.m = m;
		}
		public void run() throws InterruptedException {
			m.Start();
			for(int i=1; i<300; i++) {
	        	Thread.sleep(100);
	        	System.out.println(Math.sin(m.getAngle()));
	        }
	        m.Stop();
		}

}
