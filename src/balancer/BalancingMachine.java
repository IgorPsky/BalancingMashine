package balancer;

public class BalancingMachine {
	private double angle;
	private double length;
	private double weight;
	private double currentTime;
	private double rSpeed;
	
	public BalancingMachine(double angle, double length, double weight) {
		super();
		this.angle = angle;
		this.length = length;
		this.weight = weight;
	}

	public double getAngle(){
		return angle;
	}
	
	public static long getTime() {
		return System.nanoTime();
	}
	
	public double timeDeltaToSecs (long timeDelta) {
		return timeDelta/1e+9;
	}
	
	private void step(long timeDelta) {
		angle += timeDeltaToSecs(timeDelta);
	}
	
	private class executor implements Runnable {

		@Override
		public void run() {
			currentTime = getTime();
			
		}
		
	}
	
	public void Start() {
		
	}
	
	public void Stop() {
		
	}

}
