package org.mlesyk.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TestApplicationContextAutowire {

    @Autowired
    ApplicationContext applicationContext;

   public ApplicationContext getApplicationContext() {
       return applicationContext;
   }
}
