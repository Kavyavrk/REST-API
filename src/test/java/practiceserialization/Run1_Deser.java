package practiceserialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Run1_Deser
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		FileInputStream input= new FileInputStream("./f.txt");
		ObjectInputStream objin=new ObjectInputStream(input);
		NFSGame userobj =(NFSGame)objin.readObject();
		System.out.println(userobj.name);
		System.out.println(userobj.score);
		System.out.println(userobj.level);
		System.out.println(userobj.life);
	}
}
