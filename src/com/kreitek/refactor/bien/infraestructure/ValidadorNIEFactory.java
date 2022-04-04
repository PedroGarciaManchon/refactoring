package com.kreitek.refactor.bien.infraestructure;

public class ValidadorNIEFactory implements ValidadorFactory{

    public Validador getValidador() {return new ValidadorNIE();}

}
