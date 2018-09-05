package meituantraning;

public class single3 {
    private single3(){};
    private static class inner{
        private static final single3 single3=new single3();
    }
    public static  single3 getSingle3(){
        return inner.single3;
    }
}
