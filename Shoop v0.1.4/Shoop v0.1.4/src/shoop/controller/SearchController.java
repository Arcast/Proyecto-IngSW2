/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shoop.controller;

import java.io.IOException;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.JDOMParseException;
import org.jdom2.input.SAXBuilder;
import shoop.model.ProductXmlFile;
import shoop.model.Util;
import shoop.view.Lobby;

/**
 *
 * @author Juan Francisco
 */
public class SearchController {
    
    
    
    public static void SearchByName(String a){
        ProductXmlFile.printProductFromDataBase(true,a);
    
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
                   
                   System.out.println(Category);
                    
                    
                    System.out.println(Description);
                    System.out.println(Price);
                    System.out.println(ActualCant);
                    System.out.println();
                   
                    pos++;
                }
                else if(a == false && Category != null && Category.equals(Search))
                {
                    
                   
                    
                    System.out.println(Name);
                    System.out.println(Description);
                    System.out.println(Price);
                    System.out.println(ActualCant);
                    System.out.println();
                   
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
}



