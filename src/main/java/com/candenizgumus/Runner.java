package com.candenizgumus;

import com.candenizgumus.controllers.MainMenuController;
import com.candenizgumus.entities.Arac;
import com.candenizgumus.util.DummyData;

public class Runner
{
    public static void main(String[] args)
    {
        //DummyData dummyData = new DummyData();  sisteme test data eklemek için kullanıldı.
        MainMenuController mainMenuController = new MainMenuController();
        mainMenuController.anaMenu();
    }



}