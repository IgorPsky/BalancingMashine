package balancer;

public class BalancingMachine {
	private double angle;
	private double length;
	private double weight;
	private long startTime = getTime();
	private long currentTime;
	private double rSpeed = Math.PI*2/10;  // rads/sec
	private boolean isRunning = false;
	
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
	
	public double wMoment() {
		return weight/100.0*9.81*length/2.0;
	}
	
	private void step(long timeDelta) {
		// rSpeed = rSpeed;
		double mForce = weight/100.0*9.81*Math.sin(angle);
		double rMoment = mForce * length;
		double rAcc = rMoment / wMoment();
		rSpeed = rSpeed + Math.pow(timeDeltaToSecs(timeDelta), 2);
		angle += timeDeltaToSecs(timeDelta)*rSpeed;
		if (angle >= Math.PI * 2) {
			angle = angle - Math.PI * 2;
		}
	}
	
	public long runningSeconds () {
		return Math.round(timeDeltaToSecs(currentTime - startTime));
	}
	
	public class executor implements Runnable {

		@Override
		public void run() {
			long stepTime;
			long timeDelta;
			isRunning = true;
			startTime = getTime();
			while (isRunning) {
				stepTime = getTime();
				timeDelta = stepTime - currentTime;
				step(timeDelta);
			    currentTime = getTime();
			}
		}	
	}
	
	private Thread t;
	private executor exec;
	
	public void Start() {
		t = new Thread (new executor());
		t.start();		
	}
	
	public void Stop() {
		isRunning = false;
	}
}
