package com.candenizgumus.repositories;


import com.candenizgumus.entities.Arac;
import com.candenizgumus.entities.Kiralama;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class KiralamaRepository extends RepositoryManager<Kiralama,Long>
{
    public KiralamaRepository()
    {
        super(Kiralama.class);
    }

    /**
     * Database'den kisi id'si ile o kisiye kiralanmış araçları getirir.
     * @param id Aranan Kisi'nin id'si.
     * @return Kisiye kiralanmış araçlar listesini döndürür.
     */
    public List<Arac> findAracByKisiId(Long id){
        TypedQuery<Arac> query = getEntityManager().createQuery(
                "SELECT k.arac FROM Kiralama k WHERE k.kisi.id =: id ", Arac.class);
        query.setParameter("id", id);
        return query.getResultList();

    }
}
