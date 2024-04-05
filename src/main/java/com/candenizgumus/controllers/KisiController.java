package com.candenizgumus.controllers;

import com.candenizgumus.entities.Kisi;
import com.candenizgumus.services.AracKiralamaService;
import com.candenizgumus.util.Util;

public class KisiController
{
    /**
     * Kullanıcıdan aldığı girdiler ile kisi ekler.
     */
    public void kisiEkleWithInput()
    {
        String ad = Util.getStringValue("Eklemek istediğiniz kisinin adini giriniz");
        String soyad = Util.getStringValue("Eklemek istediğiniz kisini soyadini giriniz");
        AracKiralamaService.kisiService.kisiEkle(ad,soyad);
    }
}
