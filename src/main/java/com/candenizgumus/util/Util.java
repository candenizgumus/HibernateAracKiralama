package com.candenizgumus.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Util
{

    static Scanner scanner = new Scanner(System.in);

    /**
     * Kullanıcıya soru sorar ve aldığı sonucu döndürür.
     * @param input Kullanıcıya soracağınız soruyu giriniz.
     * @return Kullanıcının cevabını String olarak döndürür.
     */
    public static String getStringValue(String input){
        System.out.println(input);
        return scanner.nextLine();
    }

    /**
     * Kullanıcıya soru sorar ve aldığı sonucu döndürür.
     * Yanlış girdi geldiğinde tekrar soruyu sorar.
     * @param input Kullanıcıya soracağınız soruyu giriniz.
     * @return Kullanıcının cevabını double olarak döndürür.
     */
    public static double getDoubleValue(String input){
        while(true)
        {
            System.out.println(input);
            double deger;
            try
            {
                deger = scanner.nextDouble();
                scanner.nextLine();
                return deger;
            } catch (InputMismatchException e)
            {
                System.out.println("Yanlış girdi girdiniz tekrar deneyin.");
                scanner.nextLine();
            }

        }
    }

    /**
     * Kullanıcıya soru sorar ve aldığı sonucu döndürür.
     * Yanlış girdi geldiğinde tekrar soruyu sorar.
     * @param input Kullanıcıya soracağınız soruyu giriniz.
     * @return Kullanıcının cevabını int olarak döndürür.
     */
    public static int getIntegerValue(String input){
        while(true)
        {
            System.out.println(input);
            int deger;
            try
            {
                deger = scanner.nextInt();
                scanner.nextLine();
                return deger;
            } catch (InputMismatchException e)
            {
                System.out.println("Yanlış girdi girdiniz tekrar deneyin.");
                scanner.nextLine();
            }

        }
    }

    /**
     * Kullanıcıya soru sorar ve aldığı sonucu döndürür.
     * Yanlış girdi geldiğinde tekrar soruyu sorar.
     * @param input Kullanıcıya soracağınız soruyu giriniz.
     * @return Kullanıcının cevabını Long olarak döndürür.
     */
    public static Long getLongValue(String input){
        while(true)
        {
            System.out.println(input);
            Long deger;
            try
            {
                deger = scanner.nextLong();
                scanner.nextLine();
                return deger;
            } catch (InputMismatchException e)
            {
                System.out.println("Yanlış girdi girdiniz tekrar deneyin.");
                scanner.nextLine();
            }

        }

    }


    /**
     *  String tipindeki tarihi LocalDateTime'a dönüştüren metod
     * @param tarihStr String türündeki tarih değerini alır. Format (dd-MM-yyyy)
     * @return LocalDateDate türünde tarihi döndürür.
     */
    public static LocalDateTime stringToDateTime(String tarihStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(tarihStr, formatter).atStartOfDay();
    }


}
