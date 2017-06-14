/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.bean;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;
import service.InvoiceService;

/**
 *
 * @author lino_
 */
@MessageDriven(name = "testmdb", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/invoicequeue")
    ,
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
    ,
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "invoicequeue")
    ,
    @ActivationConfigProperty(propertyName = "resourceAdapter", propertyValue = "activemq-rar-5.12.0")

})
public class MessageBean implements MessageListener  {
    @Inject
    InvoiceService is;
    
    public MessageBean() {
    }
    
    @Override
    public void onMessage(Message msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
