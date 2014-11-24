import java.io.*;


public class Floyd_warshall {
	static int [][]data=new int[7][7];
	private static BufferedReader br;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		readdata();
		floydwarshall();
		print();
		System.out.println();
	}
	public static void readdata()throws IOException{
		FileReader fr=new FileReader("./data.txt");
		br = new BufferedReader(fr);
		String s;
		int count=0;
		while((s=br.readLine())!=null){
			String []line=s.split(",");
			for(int i=0;i<line.length;i++){
				if(Integer.parseInt(line[i])==0){
					data[count][i]=999;
				}else
					data[count][i]=Integer.parseInt(line[i]);
			}
			count++;
		}
	}
	public static void floydwarshall(){
		for(int k=0;k<data[0].length;k++){
			for(int i=0;i<data[0].length;i++){
				for(int j=0;j<data[0].length;j++){
					if(i==j || j==k || k==i){
						continue;
					}
					if(data[i][k]+data[k][j]<data[i][j]){
						data[i][j]=data[i][k]+data[k][j];
						
					}
				}
			}
		}
	}
	
	public static void print(){
		for(int i=0;i<data.length;i++){
			for(int j=0;j<data.length;j++){
				System.out.print(data[i][j]+",	");
			}
			System.out.println();
		}
	}
	
	
}
