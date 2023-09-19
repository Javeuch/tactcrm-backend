package com.wetic.tactcrm.repository;

import com.wetic.tactcrm.domain.DetailsFacture;
import com.wetic.tactcrm.domain.Facture;
import com.wetic.tactcrm.service.dto.SumByMonthSerieDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailsFactureRepository extends JpaRepository<DetailsFacture,Long> {

    @Query(value = "select dfcts.*, artcl.designation as articleDesignation from details_factures dfcts \n" +
            "JOIN articles artcl on artcl.id = dfcts.article_id \n" +
            "where dfcts.facture_id = ?1", nativeQuery = true)
    List<DetailsFacture> findDetailsFactureByFactureId(Long Id);

    @Query(value = "select SUM(df.quantite) from details_factures df", nativeQuery = true)
    public Long sumProduitQuantity();

    @Query(value = "select SUM(df.quantite * df.prix_facure_ht) from details_factures df", nativeQuery = true)
    public Long SumDetailsFacture();

   // SELECT new com.wetic.tactcrm.service.dto.SumByMonthSerieDTO(SUM(d.montant),MONTH(d.dateFacturation))

//    @Query(value = "SELECT MONTH(f.date_facturation) as mois, SUM(df.prix_facure_ht*df.quantite) as montant \n" +
//            "from details_factures df join factures f on f.id = df.facture_id where MONTH(f.date_facturation) \n" +
//            "is NOT NULL AND YEAR(f.date_facturation) = YEAR(NOW()) \n" +
//            "group by MONTH(f.date_facturation), YEAR(f.date_facturation)\n", nativeQuery = true)

    @Query(value = "SELECT new com.wetic.tactcrm.service.dto.SumByMonthSerieDTO(SUM(df.prixFactureHt * df.quantite),MONTH(f.dateFacturation)) \n" +
            "from DetailsFacture df join Facture f on f.id = df.facture.id where MONTH(f.dateFacturation) \n" +
            "is NOT NULL AND YEAR(f.dateFacturation) = YEAR(NOW()) \n" +
            "group by MONTH(f.dateFacturation), YEAR(f.dateFacturation)\n")
    public List<SumByMonthSerieDTO> SumProfitByMonth();




}
