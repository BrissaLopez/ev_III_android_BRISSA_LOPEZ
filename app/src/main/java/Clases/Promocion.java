package Clases;

public class Promocion {

    private String[] promocion;
    private int precio;

    public Promocion(){
        this.promocion = new String[]{"Pizzas promo", "Master pizza", "Pizza max"};

    }

    public int verificaPromo (String promo){

        if(promo.equalsIgnoreCase(getPromocion()[0])){
            setPrecio(5990);
        }
        else if(promo.equalsIgnoreCase(getPromocion()[1])){
            setPrecio(12990);

        }else if(promo.equalsIgnoreCase(getPromocion()[2])){
            setPrecio(18500);

        }


        return getPrecio();

    }

    public String[] getPromocion() {
        return promocion;
    }

    public void setPromocion(String[] promocion) {
        this.promocion = promocion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
