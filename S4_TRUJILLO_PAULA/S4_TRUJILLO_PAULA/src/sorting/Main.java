package sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {
		
	private static double [] array;
	private  static int setAmount;
	private static BufferedReader br;
	private static BufferedWriter bw;


	public static String bubbleSort() {
		int numbers =0;
		int totalPositions =0;

		for(int i=1; i<array.length;i++) {				
			for(int k=0;k<array.length-i;k++) {
				if(array[k]>array[k+1]) {
					Double temp=array[k];
					array[k]=array[k+1];
					array[k+1]=temp;
					totalPositions++;
				}
			}
			numbers++;
		}		
		DecimalFormat df = new DecimalFormat("0.0#");
		double average = (double)totalPositions/numbers;
		average = Math.floor(average*100)/100;
		String averageFormated = df.format(average).toString().replace(",", ".");		
		String format= averageFormated+"-"+Arrays.toString(array).replace("[","").replace("]","").replace(",","");
		return format;		
	}
		
	
	public static void fullSets() throws NumberFormatException, IOException {
		int i=0;	

		while (i<setAmount) {
			String ages=br.readLine();
			String[] arrayAges=ages.split(" ");
			array=new double[arrayAges.length];
			for(int j=0; j<arrayAges.length; j++) {
				array[j]=Double.parseDouble(arrayAges[j]);				
			}
			i++;
			bw.write(bubbleSort()+"\n");
			bw.flush();
		}			
	}
	
	public static void start() throws NumberFormatException, IOException {	
		setAmount=Integer.parseInt(br.readLine());
		
		fullSets();
	} 
	
	public static void main(String[] args) throws NumberFormatException, IOException {		
		br= new BufferedReader(new InputStreamReader(System.in));
		bw= new BufferedWriter(new OutputStreamWriter(System.out));
		start();
		br.close();	
	}
}
