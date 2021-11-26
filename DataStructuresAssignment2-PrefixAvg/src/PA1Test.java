public class PA1Test {
	public static void main(String args[]) {
		PrefixAverage pa = new PrefixAverage();	
		int iter = 20;
		int limit = 200;
		for (int c = 0; c < iter; c++) {
			double[] data = new double[limit];
			double[] ylist1 = new double[limit];
			double[] xlist1 = new double[limit];
			
			for (int i = 0; i < limit; i++) {
				data[i] = (int) (Math.random() * 10);
			}
	
			for (int i = 0; i < limit; i++) {
				long start = System.nanoTime();
				double[] ok = pa.prefixAverage1(data);
				long end = System.nanoTime();
				
				ylist1[i] = (end-start) * Math.pow(10, -9);
				xlist1[i] = limit;
			}
			limit = limit + 200;
			System.out.println(ylist1[c] + " ");
		}
	}
}
