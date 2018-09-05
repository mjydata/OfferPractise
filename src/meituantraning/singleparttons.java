package meituantraning;

//懒汉模式
public class singleparttons {
    private  static  final singleparttons singleparttons=null;
    private static void  singleparttons(){};
    public singleparttons getSingleparttons(){
        if (singleparttons==null){
            synchronized (singleparttons.class){
                if (singleparttons==null){
                    return new singleparttons();
                }
            }
        }
        return singleparttons;
    }
}
