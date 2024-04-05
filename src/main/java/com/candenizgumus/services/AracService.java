package com.candenizgumus.services;

import com.candenizgumus.entities.Arac;
import com.candenizgumus.entities.enums.Status;
import com.candenizgumus.repositories.AracRepository;

public class AracService
{
    public AracRepository aracRepository;

    public AracService()
    {
        this.aracRepository = new AracRepository();
    }

    /**
     * Database'e verilen model ve marka ile araç ekler.
     * @param model Aracın modeli
     * @param marka Aracın markası
     */
    public void aracEkle(String model,String marka){
        aracRepository.save(Arac.builder().marka(marka).model(model).status(Status.KIRADA_DEGIL).build());

    }

    /**
     * Kirada olan araçları listeler.
     */
    public void kiradaOlanAraclariListele(){
        aracRepository.findKiradaOlanAracListesi().stream().forEach(arac -> System.out.println(arac.getId() + " id'li " + arac.getMarka() + " marka " + arac.getModel() + " model aracımızın durumu " + arac.getStatus()));
    }

    /**
     * Kirada olmayan araçları listeler.
     */
    public void kiradaOlmayanAraclariListele(){
        aracRepository.findKiradaOlmayanAracListesi().stream().forEach(arac -> System.out.println(arac.getId() + " id'li " + arac.getMarka() + " marka " + arac.getModel() + " model aracımızın durumu " + arac.getStatus()));
    }
}
