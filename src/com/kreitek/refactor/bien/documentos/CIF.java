package com.kreitek.refactor.bien.documentos;

import java.util.Date;

public class CIF extends Documento{
    public String numDNI;       // identificador del documento
    public Date fchValidez;     // fecha de validez del documento

    // construye un NIF
    public CIF(String numDNI, Date fchValidez) {
        this.numDNI = numDNI;           // asignamos el DNI
        this.fchValidez = fchValidez;   // asignamos la fecha de validez
    }

    @Override
    public String getNumDNI() {
        return numDNI;
    }

}
