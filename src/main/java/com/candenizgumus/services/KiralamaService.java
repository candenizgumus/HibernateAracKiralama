package com.candenizgumus.services;

import com.candenizgumus.entities.Arac;
import com.candenizgumus.entities.Kiralama;
import com.candenizgumus.entities.Kisi;
import com.candenizgumus.entities.enums.Status;
import com.candenizgumus.repositories.AracRepository;
import com.candenizgumus.repositories.KiralamaRepository;

import java.util.List;

public class KiralamaService
{
    KiralamaRepository kiralamaRepository;

    public KiralamaService()
    {
        this.kiralamaRepository = new KiralamaRepository();
    }

    /**
     * Database'e kiralama ekler.
     * @param arac Kiralanacak olan araç
     * @param kisi Kiraya verilecek olan kisi.
     */
    public void kiralamaEkle(Arac arac, Kisi kisi){
        AracKiralamaService.kiralamaService.kiralamaRepository.save(Kiralama.builder().arac(arac).kisi(kisi).build());
        AracKiralamaService.aracService.aracRepository.updateAracStatus(arac.getId(), Status.KIRADA);
    }

    /**
     * Bir Kisinin kiraladığı araçları getirir.
     * @param kisi Araçları aranan kisi.
     * @return Kisinin kiraladığı araçlar listesini döndürür.
     */
    public List<Arac> birMusterininKiraladigiAraciListele(Kisi kisi){
        return kiralamaRepository.findAracByKisiId(kisi.getId());
    }
}
