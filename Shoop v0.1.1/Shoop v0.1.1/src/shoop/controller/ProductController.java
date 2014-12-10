/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoop.controller;

import shoop.model.Product;
import shoop.model.ProductXmlFile;

/**
 *
 * @author Antonio
 * Name, ImageUrl, Description, Provider, Price, MinCant, ID, ActualCant
 * product = new Product("1", "2", "3", "4", "4", "5", "6", "7");
        System.out.println(product.getName());
        System.out.println(product.getImageUrl());
        System.out.println(product.getDescription());
        System.out.println(product.getProvider());
        System.out.println(product.getPrice());
        System.out.println(product.getMinCant());
        System.out.println(product.getID());
        System.out.println(product.getActualCant());
        ProductXmlFile.saveProductInDataBase(product);
        
 */
public class ProductController {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Entró");
        
        Product product = null;
    }
        
    public static void AssingAndAddProductClass (String a, String b,String c,String d,String e,String f,String g,String h,String i){
        Product addproduct = null;
        boolean x;
        addproduct = new Product(a, b, "", d, e, f, "1", b+a+e,i);
        
        ProductXmlFile.saveProductInDataBase(addproduct);
        }
       
        

        
        
        
        
        
      //  System.out.println("Salió");
        // TODO code application logic here
    //}
    
    public static void printProducts(boolean x, String a){
        ProductXmlFile.printProductFromDataBase(x, a);
    }
    
    public static void saveProducts(Product x){
        ProductXmlFile.saveProductInDataBase(x);
    }
    
    
}
