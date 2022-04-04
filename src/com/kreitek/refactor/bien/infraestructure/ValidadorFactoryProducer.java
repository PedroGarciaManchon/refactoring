package com.kreitek.refactor.bien.infraestructure;

import com.kreitek.refactor.bien.exceptions.TipoException;

public class ValidadorFactoryProducer {

    public ValidadorFactory getFactory(String tipo) throws TipoException {
        //Lo ideal seria pasarle un hijo de documento y comprobar la clase
        switch (tipo){
            case "DNI":
                return new ValidadorDNIFactory();
            case "CIF":
                return new ValidadorCIFFactory();
            case "NIE":
                return new ValidadorNIEFactory();
            default:
                throw new TipoException();
        }
    }
}
