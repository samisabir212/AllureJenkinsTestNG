package UnitTests;

public class TestCharArrayThreadSLeeploop {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		String myStr = "netflix and chill";
		
		char[] chars = myStr.toCharArray();
		
		for(char c : chars){
			Thread.sleep(300);
			System.out.print(c);
			
		}
		
	}

}
