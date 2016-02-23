import java.util.Random;


public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand = new Random();
		// TODO Auto-generated method stub
		int [] numArray = new int [10];
		int num, i=0;
		int b = 0;
		while(i < 10){
			num = rand.nextInt(63);
			if(i==0){
				numArray[i] = num;
			}
			else{
				for(int n = 0; n<i;n++){
					if(numArray[i] == num){
						continue;
					}
				}
				numArray[i] = num;
			}
			System.out.println(numArray[i]);
			i++;
		}
		for(i=0; i<8; i++){
			for(int n=0; n<8; n++){
				for(int numb : numArray){
					b = 0;
					if(numb == (i*8+n)){
						b = 1;
						break;
					}
					else{ 
						b = 0;
					}
					
				}
				System.out.printf("%d", b);
			}
			System.out.println("");
		}
	}

}
