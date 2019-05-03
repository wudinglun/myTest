import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class m {
	public static void main(String[] args) {
		File f=new File("C:\\Users\\adam\\Desktop\\test.txt");
		try {
			PrintWriter pw =new PrintWriter(f);
			pw.println((char)3);
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
