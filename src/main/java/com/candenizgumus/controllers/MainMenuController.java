package com.candenizgumus.controllers;

import com.candenizgumus.services.AracKiralamaService;
import com.candenizgumus.util.Util;

public class MainMenuController
{
    AracController aracController;
    KisiController kisiController;
    KiralamaController kiralamaController;

    public MainMenuController()
    {
        this.aracController = new AracController();
        this.kisiController = new KisiController();
        this.kiralamaController = new KiralamaController();
    }


    public void anaMenu()
    {
        while(true)
        {
            System.out.println("************************************************************");
            System.out.println("************************ARAÇ KİRALAMA***********************");
            System.out.println("************************************************************");
            System.out.println("1- Arac Ekle");
            System.out.println("2- Arac Arama");
            System.out.println("3- Kisi Ekle");
            System.out.println("4- Kiralama");
            System.out.println("5- Rapor");
            System.out.println("0- Cıkıs Yap");
            int secim = Util.getIntegerValue("Secim yapınız");
            switch (secim)
            {
                case 1:
                    aracController.aracEkleWithInput();
                    break;
                case 2:
                    aracController.aracAramaWithInput();
                    break;
                case 3:
                    kisiController.kisiEkleWithInput();
                    break;
                case 4:
                    kiralamaController.kiralamaWithInput();
                    break;
                case 5:
                    raporMenu();
                    break;
                case 0:
                    System.exit(0);

            }
        }


    }

    private void raporMenu()
    {
        while (true)
        {
            System.out.println("1- Kirada olan araclari listele");
            System.out.println("2- Bosta olan araclari listele");
            System.out.println("3- Herhangi bir musterinin kiraladigi araclari listele ");
            System.out.println("4- Ust Menu ");
            int secim = Util.getIntegerValue("Secim Giriniz");
            switch (secim)
            {
                case 1:
                    AracKiralamaService.aracService.kiradaOlanAraclariListele();
                    break;
                case 2:
                    AracKiralamaService.aracService.kiradaOlmayanAraclariListele();
                    break;
                case 3:
                    kiralamaController.musterininKiraladigiAraclariListeleWithInput();
                    break;
                case 4:
                    anaMenu();
                    break;

            }
        }
    }

}
