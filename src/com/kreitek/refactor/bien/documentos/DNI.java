package com.kreitek.refactor.bien.documentos;


import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DNI extends Documento{

    public String numDNI;       // identificador del documento
    public Date fchValidez;     // fecha de validez del documento

    // construye un DNI
    public DNI(String numDNI, Date fchValidez) {
        this.numDNI = numDNI;           // asignamos el DNI
        this.fchValidez = fchValidez;   // asignamos la fecha de validez
    }

    @Override
    public String getNumDNI() {
        return numDNI;
    }

}
