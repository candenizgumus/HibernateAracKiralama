package com.candenizgumus.services;

public class AracKiralamaService
{
    //Ortak servis kullanimi icin bütün servisler tek bir yerden yonetiliyor.
    public static AracService aracService = new AracService();
    public static KiralamaService kiralamaService = new KiralamaService();
    public static KisiService kisiService = new KisiService();
}
