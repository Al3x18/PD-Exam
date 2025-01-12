/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;

import jakarta.ejb.MessageDriven;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

/**
 *
 * @author Alex
 */
@MessageDriven(mappedName= "jms/javaee7/Topic")
public class AutoPartsMDB implements MessageListener {
    
    @Inject
    AutoPartsEJB ejb;
    
    @Inject
    Event<AutoParts> event;

    @Override
    public void onMessage(Message msg) {
        try {
            MessageWrapper wrapper = msg.getBody(MessageWrapper.class);
            
            Integer id = wrapper.getId();
            Integer itemSold = wrapper.getVendite();
            
            AutoParts a = ejb.findById(id);
            a.setItemSolds(a.getItemSolds() + itemSold);
            ejb.updatePart(a);
            
            event.fire(a);
            
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    
    
    
}
