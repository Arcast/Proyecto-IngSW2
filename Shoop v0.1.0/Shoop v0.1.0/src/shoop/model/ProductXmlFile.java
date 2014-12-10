/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shoop.model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.JDOMParseException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import shoop.model.Util;
import shoop.model.Util;

/** Class reads the information from XML
 * @author Antonio
 */
public class ProductXmlFile
{
    /**Method read  information from data base
     * 
     * @param product
     * @return 
     */

    
    public static String saveProductInDataBase(Product product)
    {
        int actualcantconvertido;
        Document    doc;
        Element     root, newChild;

        SAXBuilder  builder = new SAXBuilder();
        if(readProductToWriteOnDataBase(product.getID())==true) 
         {  
             actualcantconvertido = UtilFunctions.stringToInteger(product.getActualCant());
             
             return "false:Provider repeated";
            }

        try
        { 
            
            doc = builder.build(Util.PRODUCT_XML_PATH);

            root = doc.getRootElement();

            // Creamos una nueva etiqueta
            newChild = new Element(Util.PRODUCT_TAG);

            // Añadimos un atributo   
            newChild.setAttribute(Util.PRODUCT_CATEGORY_TAG,product.getCategory());
            newChild.setAttribute(Util.PRODUCT_NAME_TAG, product.getName());
            newChild.setAttribute(Util.PRODUCT_IMAGEURL_TAG, product.getImageUrl());
            newChild.setAttribute(Util.PRODUCT_DESCRIPTION_TAG,product.getDescription());
            newChild.setAttribute(Util.PRODUCT_PROVIDER_TAG,product.getProvider());
            newChild.setAttribute(Util.PRODUCT_PRICE_TAG,product.getPrice());
            newChild.setAttribute(Util.PRODUCT_MINCANT_TAG,product.getMinCant());
            newChild.setAttribute(Util.PRODUCT_ID_TAG,product.getID());
            newChild.setAttribute(Util.PRODUCT_ACTUALCANT_TAG,product.getActualCant());




                                                            




                

            // La añadimos como hija a una etiqueta ya existente
            root.addContent(newChild);

            try
            {
                Format format = Format.getPrettyFormat();

                /* Se genera un flujo de salida de datos XML */
                XMLOutputter out = new XMLOutputter(format);

                /* Se asocia el flujo de salida con el archivo donde se guardaran los datos */
                FileOutputStream file = new FileOutputStream(Util.PRODUCT_XML_PATH);

                /* Se manda el documento generado hacia el archivo XML */
                out.output(doc,file);

                /* Se limpia el buffer ocupado por el objeto file y se manda a cerrar el archivo */
                file.flush();
                file.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

        return "true:Successfuly Registration";
        
    }
    
    public static boolean printProductFromDataBase(Boolean a, String Search)
    {  
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          Category, Name, ImageUrl, Description, Provider,Price, MinCant,ID,ActualCant;
        boolean         found = false;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.PRODUCT_XML_PATH);

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);
                
                Category            = child.getAttributeValue(Util.PRODUCT_CATEGORY_TAG);
                Name            = child.getAttributeValue(Util.PRODUCT_NAME_TAG);
                ImageUrl        = child.getAttributeValue(Util.PRODUCT_IMAGEURL_TAG);
                Description =  child.getAttributeValue(Util.PRODUCT_DESCRIPTION_TAG);
                Price    =        child.getAttributeValue(Util.PRODUCT_PRICE_TAG);
                MinCant =        child.getAttributeValue(Util.PRODUCT_MINCANT_TAG);
                ActualCant =        child.getAttributeValue(Util.PRODUCT_ACTUALCANT_TAG);
                ID =          child.getAttributeValue(Util.PRODUCT_ID_TAG);
                Provider =        child.getAttributeValue(Util.PRODUCT_PROVIDER_TAG);

             
                if(a == true && Name != null && Name.equals(Search))       
                {
                    System.out.println(Name);
                    pos++;
                }
                if(a == false && Category != null && Category.equals(Search))
                {
                    System.out.println(Name);
                    pos++;
                }
                else
                {
                    if (Category == null)
                        System.out.println(Util.ERROR_PRODUCT_CATEGORY_TAG);

                    if (Name == null)
                        System.out.println(Util.ERROR_PRODUCT_NAME_TAG);

                    if (ImageUrl == null)
                        System.out.println(Util.ERROR_PRODUCT_IMAGEURL_TAG);
                   
                    if (Description==null)
                        System.out.println(Util.ERROR_PRODUCT_DESCRIPTION_TAG);

                    if (Provider == null)
                        System.out.println(Util.ERROR_PRODUCT_PROVIDER_TAG);
                     
                    if (Price==null)
                         System.out.println(Util.ERROR_PRODUCT_PRICE_TAG);
                    
                    if (MinCant == null)
                         System.out.println(Util.ERROR_PRODUCT_MINCANT_TAG);
                    
                    if  (ActualCant == null)
                         System.out.println(Util.ERROR_PRODUCT_ACTUALCANT_TAG);
                    
                    pos++;
                }
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

        return found;
    } 
  
    
    public static boolean readProductToWriteOnDataBase(String ID)
    {
        Product            product = null;
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          UProvider;
        boolean         found = false;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.PRODUCT_XML_PATH);
                    

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (!found && pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                UProvider        = child.getAttributeValue(Util.PRODUCT_ID_TAG);

                if(UProvider != null && UProvider.equals(ID))
                {
                    
                    found = true;
                }
                else
                {
                    if (UProvider == null)
                        System.out.println(Util.ERROR_PRODUCT_PROVIDER_TAG);
                    pos++;
                }
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
        }

        return found;
        
    }
    
    
    
    
    
   

    
    
        
    
    
    
    
    
    
    
    
    
    
        
//-------------------------------------------------------------------------------------------------------------------------------        
    
    
   /*  public static void Addtocount (String ID, String ActualCant)
    {
        Product            product = null;
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          UProvider;
        boolean         found = false;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.PRODUCT_XML_PATH);
                    

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while ( pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                UProvider        = child.getAttributeValue(Util.PRODUCT_ID_TAG);
                ActualCant = child.getAttributeValue(Util.PRODUCT_ACTUALCANT_TAG);
                
                
                

                if(UProvider != null && UProvider.equals(ID))
                {
                    return ActualCant;
                }
                else
                {
                    if (UProvider == null)
                        System.out.println(Util.ERROR_PRODUCT_PROVIDER_TAG);
                    pos++;
                }
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
        }

//        return found;
        
        
        
        
        
    }   */     
    
    
    
    
    
    
    
    }
    
     
     
     

      
                    
                        
                    
                    
                   
                
            
        
       