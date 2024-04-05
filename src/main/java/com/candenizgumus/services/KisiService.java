package com.candenizgumus.services;

import com.candenizgumus.entities.Kisi;
import com.candenizgumus.repositories.KisiRepository;

public class KisiService
{
    public KisiRepository kisiRepository;

    public KisiService()
    {
        this.kisiRepository = new KisiRepository();
    }

    /**
     * Database'e kisi ekler.
     * @param ad Eklenecek kisinin adi
     * @param soyad Eklenecek kisinin soyadi
     */
    public void kisiEkle(String ad, String soyad){
        AracKiralamaService.kisiService.kisiRepository.save(Kisi.builder().ad(ad).soyad(soyad).build());
    }
}
