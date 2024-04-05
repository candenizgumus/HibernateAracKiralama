package com.candenizgumus.controllers;

import com.candenizgumus.entities.Arac;
import com.candenizgumus.entities.enums.Status;
import com.candenizgumus.services.AracKiralamaService;
import com.candenizgumus.util.Util;

import java.util.List;

public class AracController
{
    /**
     * Kullanıcıdan girdi alarak Database'e araç ekler.
     */
    public void aracEkleWithInput()
    {
        String model = Util.getStringValue("Eklemek istediğiniz aracin modelini giriniz");
        String marka = Util.getStringValue("Eklemek istediğiniz aracin markasini giriniz");
        AracKiralamaService.aracService.aracEkle(model, marka);
    }

    /**
     * Kullanıcıdan araç model girdisini alarak Database'de aracı arar.
     */
    public void aracAramaWithInput()
    {
        String model = Util.getStringValue("Aradığınız aracın modelini giriniz.");
        List<Arac> aracByModel = AracKiralamaService.aracService.aracRepository.findByColumnAndValue("model", model);
        if (aracByModel.isEmpty()) //Arac var mı checki yapar.
        {
            System.out.println("Verilen model ile araç bulunmamaktadır.");
            return;
        }

        //Aracı listeler
        aracByModel.stream().forEach(arac -> System.out.println(arac.getMarka() + " marka " + arac.getModel() + " model aracımızın durumu " + arac.getStatus()));

    }
}
