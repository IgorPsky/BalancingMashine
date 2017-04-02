package balancer;

public class printlnBalancer {

		static final int interval = 100;
		static final int width = 60;
		
		private BalancingMachine m;
		public printlnBalancer(BalancingMachine m) {
			super();
			this.m = m;
		}
		
		public static String getLine(double angle) {
			String result = "";
			long tabs = Math.round(angle/(Math.PI*2)*width);
			for(int i=0;i<tabs;i++) {
				result += " ";
			}
			result += "X";
			return result;
		}
		
		public void run() throws InterruptedException {
			m.Start();
			for(int i=1; i<300; i++) {
	        	Thread.sleep(100);
	        	System.out.println(m.runningSeconds().ToString + "sec:" + getLine(m.getAngle()));
	        }
	        m.Stop();
		}

}
