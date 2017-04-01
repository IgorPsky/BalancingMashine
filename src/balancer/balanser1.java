package balancer;

public class balanser1 {

	public static void main(String[] args) throws InterruptedException {
		BalancingMachine m1 = new BalancingMachine(Math.PI/4.0, 1.0, 1.0);
        m1.Start();
        for(int i=1; i<100; i++) {
        	Thread.sleep(1);
        	System.out.println(m1.getAngle()*180.0/Math.PI);
        }
        m1.Stop();
	}

}
