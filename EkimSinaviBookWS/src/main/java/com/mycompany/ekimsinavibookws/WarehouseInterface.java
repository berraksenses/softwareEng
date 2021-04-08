package com.mycompany.ekimsinavibookws;

import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;
import java.util.Map;

@WebService
public interface WarehouseInterface {
    

    String getInfoAboutBook(int i);
    
    String deliveryTime(int book,int s);
   
}
