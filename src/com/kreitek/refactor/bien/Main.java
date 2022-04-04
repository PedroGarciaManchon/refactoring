package com.kreitek.refactor.bien;

import com.kreitek.refactor.bien.documentos.CIF;
import com.kreitek.refactor.bien.documentos.DNI;
import com.kreitek.refactor.bien.documentos.NIE;
import com.kreitek.refactor.bien.exceptions.TipoException;
import com.kreitek.refactor.bien.infraestructure.*;

class Main
{
    public static void main(String args[])
    {
        System.out.println("=====================");
        System.out.println("Vamos a refactorizar!");
        System.out.println("=====================");

        ValidadorFactoryProducer factoryProducer = new ValidadorFactoryProducer();
        try {
            //Conseguimos el primer validador
            ValidadorFactory factory = factoryProducer.getFactory("DNI");
            Validador validador = factory.getValidador();

            // creamos un DNI correcto
            DNI dniCorrecto = new DNI("11111111H", null);
            Boolean esValido = (validador.validar(dniCorrecto) == 1);
            System.out.println( "DNI " + dniCorrecto.getNumDNI() + " es: " + esValido.toString());

            // creamos un DNI incorrecto
            DNI dniIncorrecto01 = new DNI("24324356A", null);
            Boolean esValido01 = (validador.validar(dniIncorrecto01) == 1);
            System.out.println( "DNI " + dniIncorrecto01.getNumDNI() + " es: " + esValido01.toString());

            //Nuevo validador
            factory = factoryProducer.getFactory("NIE");
            validador = factory.getValidador();

            // creamos un NIE correcto
            NIE nieCorrecto = new NIE("X0932707B", null);
            Boolean esValidoNie = (validador.validar(nieCorrecto) == 1);
            System.out.println( "NIE " + nieCorrecto.numDNI + " es: " + esValidoNie.toString());

            // creamos un NIE incorrecto
            NIE nieIncorrecto = new NIE("Z2691139Z", null);
            Boolean esValidoNieIncorrecto = (validador.validar(nieIncorrecto) == 1);
            System.out.println( "NIE " + nieIncorrecto.numDNI + " es: " + esValidoNieIncorrecto.toString());

            //Nuevo validador
            factory = factoryProducer.getFactory("CIF");
            validador = factory.getValidador();

            // creamos un CIF correcto
            CIF cifCorrecto = new CIF("W9696294I", null);
            Boolean esValidoCIF = (validador.validar(cifCorrecto) == 1);
            System.out.println( "CIF " + cifCorrecto.numDNI + " es: " + esValidoCIF.toString());

            // creamos un CIF incorrecto
            CIF cifIncorrecto = new CIF("W9696294A", null);
            Boolean esValidoCifIncorrecto = (validador.validar(cifIncorrecto) == 1);
            System.out.println( "NIE " + cifIncorrecto.numDNI + " es: " + esValidoCifIncorrecto.toString());

        } catch (TipoException e) {
            System.err.println("Tipo de documento incorrecto");
        }

    }
}