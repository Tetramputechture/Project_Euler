class Problem {
	public static void main(String[] args) {
		int count = 0;
		for(int x = 3; x < 1000; x++) {
			if(x%5==0 || x%3==0)
				count += x;
		} 
		System.out.println(count);
	}
}
