package com.kreitek.refactor.bien.infraestructure;

public class ValidadorCIFFactory implements ValidadorFactory{

    public Validador getValidador() {return new ValidadorCIF();}

}
