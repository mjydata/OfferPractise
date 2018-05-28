package designPatterns;

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
