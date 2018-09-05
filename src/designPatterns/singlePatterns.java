package designPatterns;

	import java.math.BigInteger;
	import java.util.Arrays;
	import java.util.Scanner;

public class singlePatterns {
   private static final singlePatterns singlePatterns=null;
   private singlePatterns() {
   }
   public static singlePatterns getInstance(){
	   if (singlePatterns==null) {
		       synchronized (singlePatterns.class) {
			    	   if (singlePatterns==null) {
			    	   return new singlePatterns();
			       }

		        }
	   }
	   return singlePatterns;
   }

}
