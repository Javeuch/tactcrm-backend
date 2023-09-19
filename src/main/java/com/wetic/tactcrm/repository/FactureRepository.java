package com.wetic.tactcrm.repository;

import com.wetic.tactcrm.domain.Contrat;
import com.wetic.tactcrm.domain.Facture;
import com.wetic.tactcrm.service.dto.MasterTypeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FactureRepository extends JpaRepository<Facture,Long> {

    @Query(value = "SELECT fcts.*, tp.nom AS type_paiement_nom , util.nom AS utilisateur_nom, tx.nom as taxe_nom \n" +
            "from factures fcts \n" +
            "JOIN type_paiements tp on tp.id = fcts.type_paiement \n" +
            "JOIN utilisateurs util on util.id = fcts.user_id \n" +
            "JOIN taxes tx on tx.id = fcts.taxe_id", nativeQuery = true)
    public Page<Facture> findAllForView(Pageable pageable);

    @Query(value = "select fact.*, users.*,adrs.*,pymnts.* from factures fact\n" +
            "JOIN utilisateurs users ON fact.user_id = users.id\n" +
            "Join adresses adrs ON users.adresse_id = adrs.id\n" +
            "JOIN type_paiements pymnts ON fact.type_paiement = pymnts.id where fact.id = ?1", nativeQuery = true)
    public Optional<Facture> findOneForViewById(Long id);


    public Page<Facture> findByUtilisateurId(Pageable pageable, Long Id);

    @Query(value = "select new com.wetic.tactcrm.service.dto.MasterTypeDTO(COUNT(f.typePaiement), tp.nom) from Facture f \n" +
            "join TypePaiement tp on tp.id = f.typePaiement.id\n" +
            "GROUP BY f.typePaiement\n")
    public List<MasterTypeDTO> factureByTypePaiement();

    
}
