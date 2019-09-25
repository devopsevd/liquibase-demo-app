package com.premierinc.sboot.demo.service.impl;


import com.premierinc.sboot.demo.service.SomeService;

public class OldSomeServiceImpl implements SomeService {

    @Override
    public String getSomeValue() {
        return "Value from old service implementation";
    }
}