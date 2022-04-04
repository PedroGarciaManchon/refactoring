package com.kreitek.refactor.bien.documentos;

import java.util.Date;

public class NIE extends Documento{
    public String numDNI;       // identificador del documento
    public Date fchValidez;     // fecha de validez del documento

    // construye un NIE
    public NIE(String numDNI, Date fchValidez) {
        this.numDNI = numDNI;           // asignamos el DNI
        this.fchValidez = fchValidez;   // asignamos la fecha de validez
    }

    @Override
    public String getNumDNI() {
        return numDNI;
    }
}
