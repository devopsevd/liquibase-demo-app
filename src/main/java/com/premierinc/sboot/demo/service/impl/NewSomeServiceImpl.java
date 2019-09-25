package com.premierinc.sboot.demo.service.impl;

import com.premierinc.sboot.demo.service.SomeService;

public class NewSomeServiceImpl implements SomeService {

    @Override
    public String getSomeValue() {
        return "Value from new service implementation";
    }
}