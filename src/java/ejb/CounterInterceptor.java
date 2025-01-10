/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import java.util.HashMap;

/**
 *
 * @author Alex
 */
// Per usare la classe: @Counter sulla classe ejb
@Interceptor
@Counter //annotazione creata in Counter.java
public class CounterInterceptor {
    private HashMap<String, Integer> counterMap = new HashMap<String, Integer>();
    
    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        if(!counterMap.containsKey(ic.getMethod().getName())) {
            counterMap.put(ic.getMethod().getName(), 0);
        }
        counterMap.put(ic.getMethod().getName(), counterMap.get(ic.getMethod().getName()) + 1);
        
        System.out.println("Chiamata n." + counterMap.get(ic.getMethod().getName()) + ": " + ic.getMethod().getName());
        
        return ic.proceed();
    }
}
