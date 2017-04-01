package balancer;

public class balanser1 {
	
	public static void main(String[] args) throws InterruptedException {
		BalancingMachine m1 = new BalancingMachine(Math.PI/4.0, 1.0, 1.0);
		printlnBalancer o = new printlnBalancer(m1);
		o.run();
	}
}
