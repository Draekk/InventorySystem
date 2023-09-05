package Database;

import java.util.UUID;
import java.util.ArrayList;

public class ProductDB {

    //Properties
    private UUID id;
    private String barCode;
    private String name;
    private int quantity;
    private float costPrice;
    private float sellPrice;
    public static ArrayList<ProductDB> products;

    //Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }


    //Functions

    /**
     * Mostrar lista de productos en consola.
     */
    public void showProducts(){
        if(!products.isEmpty()){
            for (ProductDB product : products) {
                System.out.println(product.toString());
            }
        } else {
            System.out.println("Empty list of products.");
        }
    }

    /**
     * Funcion para crear y agregar producto a la lista
     * @param productToInsert Producto a insertar
     * @return true si el proceso se completo correctamente.
     */
    public boolean createProduct(ProductDB productToInsert){
        try{
            if(!products.isEmpty()){
                if(searchProduct(productToInsert.barCode) != null){
                    System.out.println("Product already exist");
                    return false;
                }
            }
            products.add(productToInsert);
            System.out.println("Product created successfully");
            return true;
        } catch(Exception ex){
            System.out.println("An error has occurred: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Funcion para borrar un producto
     * @param product Producto a borrar
     * @return True si el producto fue borrado correctamente
     */
    public boolean deleteProduct(ProductDB product){
        try{
            if(!products.isEmpty()){
                products.remove(product);
                return true;
            }
            System.out.println("The product list is empty");
            return false;
        } catch (Exception ex) {
            System.out.printf("An error has occurred: %s", ex.getMessage());
            return false;
        }
    }

    /**
     * Funcion para buscar un producto por su codigo de barra
     * @param barCode Codigo del producto a buscar
     * @return un ProductDB si el proceso se completa correctamente, o retorna null.
     */
    public ProductDB searchProduct(String barCode){
        try{
            if(!products.isEmpty()){
                for (ProductDB product : products) {
                    if(product.barCode.equals(barCode)){
                        //System.out.println("Product founded");
                        return product;
                    }
                }
                System.out.println("Product not found");
            } else {
                System.out.println("The product list is empty");
            }
            return null;
        } catch(Exception ex){
            System.out.println("An error has occurred: " + ex.getMessage());
            return null;
        }
    }


    /*public boolean editProduct(ProductDB product){
        try{
            for (ProductDB p: products) {
                if(p.id == product.id){
                    p = product;
                    return true;
                }
            }
            System.out.println("Product not found");
            return false;
        } catch(Exception ex){
            System.out.println("An error has occurred: " + ex.getMessage());
            return false;
        }
    }*/

    //Overrides
    @Override
    public String toString() {
        return "ID: " + id +
                "\nBarcode: " +barCode +
                "\nName: " + name +
                "\nQuantity: " + quantity +
                "\nCost Price: " + costPrice +
                "\nSell Price: " + sellPrice + "\n";
    }

    //Constructors
    public ProductDB(){}

    public ProductDB(
            String barCode,
            String name,
            int quantity,
            float costPrice
    ){
        id = UUID.randomUUID();
        this.barCode = barCode;
        this.name = name;
        this.quantity = quantity;
        this.costPrice = costPrice;
        sellPrice = costPrice + Math.round((float)(costPrice * 0.3));
    }

}
