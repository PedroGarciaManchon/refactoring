package com.kreitek.refactor.bien.infraestructure;

import com.kreitek.refactor.bien.documentos.Documento;

public class ValidadorDNI implements Validador{
    @Override
    public int validar(Documento dni) {
        // posibles letras en un DNI
        String dniChars="TRWAGMYFPDXBNJZSQVHLCKE";
        // los primeros 8 caracteres son números
        String intPartDNI = dni.getNumDNI().trim().replaceAll(" ", "").substring(0, 8);
        // el último es un dígito de control
        char ltrDNI = dni.getNumDNI().charAt(8);
        // calculamos el módulo de 23 de la parte numérica que debería ser el caracter en esa
        // posición en la lista de dniChar --> my code Rocks!!!
        int valNumDni = Integer.parseInt(intPartDNI) % 23;

        // comprobamos que tutto esté bien
        if (dni.getNumDNI().length()!= 9 || !isNumeric(intPartDNI) || dniChars.charAt(valNumDni)!= ltrDNI) {
            return 0; // algo no se cumple
        } else {
            return 1; // to correcto
        }
    }

    @Override
    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
