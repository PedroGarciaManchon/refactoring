package com.kreitek.refactor.bien.infraestructure;

import com.kreitek.refactor.bien.documentos.DNI;
import com.kreitek.refactor.bien.documentos.Documento;

public interface Validador {
    int validar(Documento dni);
    boolean isNumeric(String strNum);
}
