package designPatterns;

import java.io.ObjectInputStream.GetField;

public class singlePatterns2 {
    private singlePatterns2(){}
    private static class m{
    	private static  singlePatterns2 singlePatterns2=new singlePatterns2();
    }
    public singlePatterns2 getInstance(){
    	return m.singlePatterns2;
    }
    
}
