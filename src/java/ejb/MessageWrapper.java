/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;

import java.io.Serializable;

/**
 *
 * @author Alex
 */
public class MessageWrapper implements Serializable{
    private Integer id;
    private Integer vendite;
    
    public MessageWrapper(Integer id, Integer vendite) {
        this.id = id;
        this.vendite = vendite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVendite() {
        return vendite;
    }

    public void setVendite(Integer vendite) {
        this.vendite = vendite;
    }
    
    
}
