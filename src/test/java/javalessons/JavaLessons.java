package javalessons;

    public class JavaLessons {
        public static void main(String[] args) {
            // целочисленные
            byte varByte = 127; //-128 ... 127
            short varShort = 32767; // -32788 ... 32767
            int varInt = 2_147_483_647; // -2 в 31 степени ... 2 в 31 степени -1
            long varLong = 9_223_372_036_854_775_807L; // -2 в 64 степени ... до 2 в 64 степени -1
            // с плавающей точкой
            float varFloat = 0.5f;
            double varDouble = 2.0d;
            //операции с переменными
            System.out.println(varByte + varShort);
            System.out.println(varInt - varLong);
            System.out.println(varByte / varFloat);
            System.out.println(varByte % varShort);
            System.out.println(varByte * varFloat);
            // переполнение
            System.out.println("Переполнение byte: " + (varByte + 1 ));
            System.out.println("Переполнение short: " + (varShort + 1));
            System.out.println("Переполнение int: " + (varInt + 1));
            System.out.println("Переполнение long: " + (varLong + 1));
            System.out.println(" ");
            // комбинации int и double
            int varInt2 = 100;
            double varDouble2 = 5.5;
            System.out.println("100 - 5.5 = " + (varInt2 - varDouble2));
            System.out.println("100 + 5.5 = " + (varInt2 + varDouble2));
            System.out.println("100 / 5.5 = " + (varInt2 / varDouble2));
            System.out.println("100 * 5.5 = " + (varInt2 * varDouble2));
        }
    }
