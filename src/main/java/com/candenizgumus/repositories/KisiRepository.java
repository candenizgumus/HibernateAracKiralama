package com.candenizgumus.repositories;


import com.candenizgumus.entities.Kisi;

public class KisiRepository extends RepositoryManager<Kisi,Long>
{
    public KisiRepository()
    {
        super(Kisi.class);
    }
}
