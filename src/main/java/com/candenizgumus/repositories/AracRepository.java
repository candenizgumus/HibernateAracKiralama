package com.candenizgumus.repositories;

import com.candenizgumus.entities.Arac;
import com.candenizgumus.entities.enums.Status;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;


public class AracRepository extends RepositoryManager<Arac,Long>
{
    public AracRepository()
    {
        super(Arac.class);
    }


    /**
     * aracId ve Status alarak aracın database'deki durumunu günceller.
     * @param aracId Durumu değiştirilecek olan arac'ın id'si.
     * @param newStatus Güncellenecek olan yeni durumu
     */
    public  void updateAracStatus(Long aracId, Status newStatus) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();

            em.createNamedQuery("Arac.updateStatusById")
                    .setParameter("aracId", aracId)
                    .setParameter("newStatus", newStatus)
                    .executeUpdate();
            tx.commit();
        }
        catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
        finally {
            em.close();
        }

    }

    /**
     * Database'den Status'u KIRADA olan araçlari getirir.
     * @return kirada olan araç listesinin döndürür.
     */
    public List<Arac> findKiradaOlanAracListesi(){
            TypedQuery<Arac> query = getEntityManager().createQuery(
                    "SELECT a FROM Arac a WHERE a.status = 'KIRADA'", Arac.class);
            return query.getResultList();

    }
    /**
     * Database'den Status'u KIRADA_DEGIL olan araçlari getirir.
     * @return kirada olmayan araç listesinin döndürür.
     */
    public List<Arac> findKiradaOlmayanAracListesi(){
        TypedQuery<Arac> query = getEntityManager().createQuery(
                "SELECT a FROM Arac a WHERE a.status = 'KIRADA_DEGIL'", Arac.class);
        return query.getResultList();

    }



}
