package com.candenizgumus.controllers;

import com.candenizgumus.entities.Arac;
import com.candenizgumus.entities.Kisi;
import com.candenizgumus.entities.enums.Status;
import com.candenizgumus.services.AracKiralamaService;
import com.candenizgumus.util.Util;

import java.util.List;
import java.util.Optional;

public class KiralamaController
{

    /**
     * Kullanıcıdan aldığı girdiler ile kiralama yapar.
     */
    public void kiralamaWithInput()
    {
        //Kirada olmayan bütün araçları getirir.
        AracKiralamaService.aracService.aracRepository.findAll().stream().filter(arac -> arac.getStatus() == Status.KIRADA_DEGIL).forEach(arac -> System.out.println(arac.getId() + " id'li " + arac.getMarka() + " marka " + arac.getModel() + " model aracımızın durumu " + arac.getStatus()));
        Long aracId = Util.getLongValue("Kiraya vermek istediğiniz aracın id'sini giriniz.");
        //Bütün kisileri getirir.
        AracKiralamaService.kisiService.kisiRepository.findAll().stream().forEach(kisi -> System.out.println(kisi.getId() + " id --> " + kisi.getAd() + " " + kisi.getSoyad()));
        Long uyeId = Util.getLongValue("Aracı vereceğiniz uye id'sini giriniz.");


        Optional<Arac> arac = AracKiralamaService.aracService.aracRepository.findById(aracId);
        if (arac.isEmpty()) //araç bulundu mu checki yapar.
        {
            System.out.println("Verilen arac id ile bir araç bulunmamaktadır.");
            return;
        }

        Optional<Kisi> uye = AracKiralamaService.kisiService.kisiRepository.findById(uyeId);
        if (uye.isEmpty()) //uye bulundu mu checki yapar.
        {
            System.out.println("Verilen id ile uye bulunmamaktadır.");
            return;
        }
        if (arac.get().getStatus() == Status.KIRADA_DEGIL) //aracın boşta olup olmadığı check'ini yapar.
        {
            AracKiralamaService.kiralamaService.kiralamaEkle(arac.get(), uye.get());
        } else
        {
            System.out.println("Bu araç başka bir müşteriye kiralanmıştır.");
        }
    }

    /**
     * Bir musteri tarafından kiralanmış araç var ise onları listeler.
     */
    public void musterininKiraladigiAraclariListeleWithInput()
    {
        //Bütün kisileri getirir.
        AracKiralamaService.kisiService.kisiRepository.findAll().stream().forEach(kisi -> System.out.println(kisi.getId() + " id --> " + kisi.getAd() + " " + kisi.getSoyad()));
        Long uyeId = Util.getLongValue("Kiralık aracına bakmak istediğiniz müşterinin id'sini giriniz.");

        Optional<Kisi> kisi = AracKiralamaService.kisiService.kisiRepository.findById(uyeId);
        if (kisi.isEmpty()) //Kisi bulundu mu checki yapar.
        {
            System.out.println("Aranan uye bulunamamıstır.");
            return;
        }

        List<Arac> kisininAracListesi = AracKiralamaService.kiralamaService.birMusterininKiraladigiAraciListele(kisi.get());
        if (kisininAracListesi.isEmpty()) //Kisinin aracı var mı yok mu checki yapar.
        {
            System.out.println("Bu uye araç kiralamamıştır.");
            return;
        }

        //Müşterinin kiraladığı araç varsa listeler.
        kisininAracListesi.stream().forEach(arac -> System.out.println(kisi.get().getAd() + " " + kisi.get().getSoyad() + " isimli musteride " + arac.getId() + " id'li " + arac.getMarka() + " marka " + arac.getModel() + " model aracımızın durumu " + arac.getStatus()));;


    }
}
