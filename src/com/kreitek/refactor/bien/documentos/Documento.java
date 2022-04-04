package com.kreitek.refactor.bien.documentos;

import java.util.Date;

public abstract class Documento {
    public String numDNI;       // identificador del documento
    public Date fchValidez;     // fecha de validez del documento

    public String getNumDNI() {
        return numDNI;
    }
}
