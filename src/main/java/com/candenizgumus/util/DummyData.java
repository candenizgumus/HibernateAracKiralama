package com.candenizgumus.util;

import com.candenizgumus.entities.Arac;
import com.candenizgumus.entities.Kisi;
import com.candenizgumus.entities.enums.Status;
import com.candenizgumus.services.AracKiralamaService;

import java.util.Random;


/**
 * Test Data eklemek icin kullanilan sınıftır.
 */
public class DummyData
{

    public DummyData()
    {   addKisi();
        addArac();

    }

    /**
     * Rastgele isimlerle 20 kisi ekler.
     */
    public void addKisi(){
       AracKiralamaService.kisiService.kisiRepository.save(Kisi.builder().ad("Deniz").soyad("Gumus").build());
        String[] isimler = {"Deniz", "Ali", "Ayşe", "Mehmet", "Zeynep", "Hasan", "Elif", "Emre", "Selin", "Ahmet", "Gizem", "Mustafa", "Sude", "Burak", "İpek", "Can", "Ezgi", "Kerem", "Şeyma", "Oğuz","Fatih","Emir","Kadir","Görkem","Ceyda"};
        String[] soyadlar = {"Gumus", "Yılmaz", "Kaya", "Demir", "Çelik", "Şahin", "Aydın", "Arslan", "Öztürk", "Kocaman", "Şahin","Veli","Osman","Yakıcı","Atak","Tetik","Kılıççı","Solmaz"};

            Random random = new Random();
            for (int i = 0; i < 20; i++) {
                String randomIsim = isimler[random.nextInt(isimler.length)];
                String randomSoyad = soyadlar[random.nextInt(soyadlar.length)];
                AracKiralamaService.kisiService.kisiRepository.save(Kisi.builder().ad(randomIsim).soyad(randomSoyad).build());
            }

    }
    /**
     * Rastgele marka ve modellerle 20 arac ekler.
     */
    public void addArac(){
        String[] markalar = {"Volswagen", "Toyota", "Ford", "BMW", "Mercedes", "Audi", "Honda", "Renault", "Hyundai", "Nissan", "Peugeot", "Chevrolet", "Fiat", "Opel", "Kia", "Skoda", "Subaru", "Mazda", "Lexus", "Jeep"};
        String[] modeller = {"Golf", "Corolla", "Focus", "3 Series", "C-Class", "A4", "Civic", "Clio", "Accent", "Qashqai", "208", "Cruze", "Egea", "Astra", "Rio", "Octavia", "Impreza", "3", "RX", "Grand Cherokee"};

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            String randomMarka = markalar[random.nextInt(markalar.length)];
            String randomModel = modeller[random.nextInt(modeller.length)];
            AracKiralamaService.aracService.aracRepository.save(Arac.builder().marka(randomMarka).model(randomModel).status(Status.KIRADA_DEGIL).build());
        }
    }

}
