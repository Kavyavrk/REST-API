package practiceserialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFSGame implements Serializable
{
	String name;
	int level;
	long score;
	int life;
	public NFSGame(String name,int level,long score,int life)
	{
		super();
		this.name=name;
		this.level=level;
		this.score=score;
		this.life=life;
	}
}

public class Run1_ser 
{
	public static void main(String[] args) throws IOException 
	{
		NFSGame userobj=new NFSGame("deepak", 10, 50000, 2);
		FileOutputStream fos=new FileOutputStream("./f.txt");
		ObjectOutputStream objout=new ObjectOutputStream(fos);
		objout.writeObject(userobj);
		System.out.println("====Completed===");
	}
}
