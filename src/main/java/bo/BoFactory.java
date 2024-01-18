package bo;

import bo.custom.impl.PlaceOrderBoImpl;

public class BoFactory {
    private BoFactory(){}
    private static BoFactory boFactory;
    public static BoFactory getInstance(){
        return boFactory!=null?boFactory:(boFactory=new BoFactory());
    }
    public <T extends SuperBo>T getBo(BoType boType){

        switch (boType){
            case PLACE_ORDER:return (T)new PlaceOrderBoImpl();
        }

        return null;
    }
}