package com.kreitek.refactor.bien.infraestructure;

public class ValidadorDNIFactory implements ValidadorFactory{

    public Validador getValidador() {return new ValidadorDNI();}

}
