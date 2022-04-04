package com.kreitek.refactor.bien.infraestructure;

import com.kreitek.refactor.bien.documentos.Documento;
import com.kreitek.refactor.bien.emuns.TipoUltCaracter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorCIF implements Validador{
    @Override
    public int validar(Documento cif) {
        if (cif.getNumDNI() != null) {
            final String cifUP = cif.getNumDNI().toUpperCase();

            // si el primer caracter no es uno de los válidos entonces ya fallamos
            if ("ABCDEFGHJKLMNPQRSUVW".indexOf(cifUP.charAt(0)) == -1) {
                return 0; // no cumple el primer char
            }

            // si no cumple el patrón de CIF fallamos
            final Pattern mask = Pattern
                    .compile("[ABCDEFGHJKLMNPQRSUVW][0-9]{7}[A-Z[0-9]]{1}");
            final Matcher matcher = mask.matcher(cifUP);
            if (!matcher.matches()) {
                return 0; // no cumple la máscara
            }

            final char primerCar = cifUP.charAt(0);
            final char ultimoCar = cifUP.charAt(cifUP.length() - 1);


            TipoUltCaracter tipUltCar;

            // si empiezo por P,Q, S, K o W la última letra tiene que ser una LETRA
            if (primerCar == 'P' || primerCar == 'Q' || primerCar == 'S' || primerCar == 'K' || primerCar == 'W') {
                tipUltCar = TipoUltCaracter.LETRA;
                if (!(ultimoCar >= 'A' && ultimoCar <= 'Z')) {
                    return 0; // no es una letra
                }
                // si empiezo por A, B, E o H la última letra tiene que ser un número
            } else if (primerCar == 'A' || primerCar == 'B' || primerCar == 'E'
                    || primerCar == 'H') {
                tipUltCar = TipoUltCaracter.NUMERO;
                if (!(ultimoCar >= '0' && ultimoCar <= '9')) {
                    return 0; // no es un número --> casco!
                }
                // en otro caso la última letra puede ser cualquier cosa
            } else {
                tipUltCar = TipoUltCaracter.AMBOS;
            }


            final String digitos = cifUP.substring(1, cifUP.length() - 1);

            // sumo los pares
            Integer sumaPares = 0;
            for (int i = 1; i <= digitos.length() - 1; i = i + 2) {
                sumaPares += Integer.parseInt(digitos.substring(i, i + 1));
            }

            // sumo los impares
            Integer sumaImpares = 0;
            for (int i = 0; i <= digitos.length() - 1; i = i + 2) {
                Integer cal = Integer.parseInt(digitos.substring(i, i + 1)) * 2;
                if (cal.toString().length() > 1) {
                    cal = Integer.parseInt(cal.toString().substring(0, 1))
                            + Integer.parseInt(cal.toString().substring(1, 2));
                }
                sumaImpares += cal;
            }

            // los sumo todos
            final Integer total = sumaPares + sumaImpares;

            // calculo el número de control
            Integer numControl = 10 - (total % 10);

                     /*if (numControl == 10){
                     numControl = 0;
                     }*/
            int pos = numControl == 10? 0:numControl;
            final char carControl = "JABCDEFGHI".charAt(pos);

            // con el número de control calculado validamos
            if (tipUltCar == TipoUltCaracter.NUMERO) {

                final Integer ultCar = Integer.parseInt(Character
                        .toString(ultimoCar));
                if (pos != ultCar.intValue()) {

                    return 0; // NOK
                }

            } else if (tipUltCar == TipoUltCaracter.LETRA) {
                if (carControl != ultimoCar) {
                    return 0; // NOK
                }

            } else {
                // find all occurrences forward
                Integer ultCar = -1;

                ultCar = "JABCDEFGHI".indexOf(ultimoCar);

                if (ultCar < 0){
                    ultCar = Integer.parseInt(Character.toString(ultimoCar));
                    if (pos != ultCar.intValue()) {
                        return 0; // NOK
                    }
                }
                if ((pos != ultCar.intValue()) && (carControl != ultimoCar)) {
                    return 0; // NOK
                }
            }
            return 1; // OK
        }
        return 0; //NOK
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
