package com.sys.org.spring.component;

import com.sys.org.spring.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Component
public class Component {
    @Autowired
    public ContractRepository contractRepository;

    private static final Component COMPONENT = new Component();

    public static Component getCompo(){
        return COMPONENT;
    }
}
