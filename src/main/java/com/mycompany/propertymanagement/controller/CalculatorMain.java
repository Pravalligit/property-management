package com.mycompany.propertymanagement.controller;

import ch.qos.logback.core.net.SyslogOutputStream;

public class CalculatorMain {

    public static void main(String[] args){
       CalculatorController cc = new CalculatorController();
       Double result = cc.add(4.5, 8.5, 6.1);
        System.out.println(result);

    }
}
