package com.wetic.tactcrm.repository;

import com.wetic.tactcrm.domain.Depense;
import com.wetic.tactcrm.domain.Utilisateur;
import com.wetic.tactcrm.service.dto.MasterTypeDTO;
import com.wetic.tactcrm.service.dto.SumByMonthSerieDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepenseRepository extends JpaRepository<Depense,Long> {


    @Query(value = "select sum(montant) as totalDepense from depenses", nativeQuery = true)
    public Long SumAll();

//    @Query(value = "SELECT new com.wetic.tactcrm.service.dto.SumByMonthSerieDTO(SUM(df.prixFactureHt * df.quantite),MONTH(f.dateFacturation)) \n" +
//            "from DetailsFacture df join Facture f on f.id = df.facture.id where MONTH(f.dateFacturation) \n" +
//            "is NOT NULL AND YEAR(f.dateFacturation) = YEAR(NOW()) \n" +
//            "group by MONTH(f.dateFacturation), YEAR(f.dateFacturation)\n")

    @Query(value = "select new com.wetic.tactcrm.service.dto.SumByMonthSerieDTO(SUM(d.montant),MONTH(d.dateDepense)) from Depense d\n" +
            "where MONTH(d.dateDepense) IS NOT NULL AND YEAR(d.dateDepense) = YEAR(NOW())\n" +
            "GROUP by MONTH(d.dateDepense)\n")
    public List<SumByMonthSerieDTO> SumDepenseByMonth();

    @Query(value = "select new com.wetic.tactcrm.service.dto.MasterTypeDTO(COUNT(d.typeDepense), td.nom) from Depense d \n" +
            "join TypeDepense td on td.id = d.typeDepense.id\n" +
            "GROUP BY d.typeDepense\n")
    public List<MasterTypeDTO> depenseByTypeDepense();

}
