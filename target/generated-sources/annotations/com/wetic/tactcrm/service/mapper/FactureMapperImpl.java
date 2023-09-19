package com.wetic.tactcrm.service.mapper;

import com.wetic.tactcrm.domain.Adresse;
import com.wetic.tactcrm.domain.Devise;
import com.wetic.tactcrm.domain.Facture;
import com.wetic.tactcrm.domain.Taxe;
import com.wetic.tactcrm.domain.TypePaiement;
import com.wetic.tactcrm.domain.Utilisateur;
import com.wetic.tactcrm.service.dto.AdresseDTO;
import com.wetic.tactcrm.service.dto.FactureDTO;
import com.wetic.tactcrm.service.dto.FactureViewDTO;
import com.wetic.tactcrm.service.dto.UtilisateurDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-19T17:13:26+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230523-1233, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class FactureMapperImpl implements FactureMapper {

    @Autowired
    private DeviseMapper deviseMapper;
    @Autowired
    private TaxeMapper taxeMapper;
    @Autowired
    private UtilisateurMapper utilisateurMapper;
    @Autowired
    private TypePaiementMapper typePaiementMapper;

    @Override
    public List<Facture> toEntity(List<FactureDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Facture> list = new ArrayList<Facture>( dtoList.size() );
        for ( FactureDTO factureDTO : dtoList ) {
            list.add( toEntity( factureDTO ) );
        }

        return list;
    }

    @Override
    public List<FactureDTO> toDto(List<Facture> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<FactureDTO> list = new ArrayList<FactureDTO>( entityList.size() );
        for ( Facture facture : entityList ) {
            list.add( toDto( facture ) );
        }

        return list;
    }

    @Override
    public FactureDTO toDto(Facture entity) {
        if ( entity == null ) {
            return null;
        }

        FactureDTO factureDTO = new FactureDTO();

        factureDTO.setTaxeNom( entityTaxeNom( entity ) );
        factureDTO.setTaxeId( entityTaxeId( entity ) );
        factureDTO.setDeviseId( entityDeviseId( entity ) );
        factureDTO.setTypePaiementId( entityTypePaiementId( entity ) );
        factureDTO.setTypePaiementNom( entityTypePaiementNom( entity ) );
        factureDTO.setUtilisateurId( entityUtilisateurId( entity ) );
        factureDTO.setUtilisateurNom( entityUtilisateurNom( entity ) );
        factureDTO.setId( entity.getId() );
        factureDTO.setDateFacturation( entity.getDateFacturation() );
        factureDTO.setNumeroFacture( entity.getNumeroFacture() );

        return factureDTO;
    }

    @Override
    public Facture toEntity(FactureDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Facture facture = new Facture();

        facture.setTaxe( taxeMapper.fromId( dto.getTaxeId() ) );
        facture.setUtilisateur( utilisateurMapper.fromId( dto.getUtilisateurId() ) );
        facture.setDevise( deviseMapper.fromId( dto.getDeviseId() ) );
        facture.setTypePaiement( typePaiementMapper.fromId( dto.getTypePaiementId() ) );
        facture.setId( dto.getId() );
        facture.setDateFacturation( dto.getDateFacturation() );
        facture.setNumeroFacture( dto.getNumeroFacture() );

        return facture;
    }

    @Override
    public FactureViewDTO toFactureViewDto(Facture entity) {
        if ( entity == null ) {
            return null;
        }

        FactureViewDTO factureViewDTO = new FactureViewDTO();

        factureViewDTO.setUtilisateurDTO( utilisateurToUtilisateurDTO( entity.getUtilisateur() ) );
        factureViewDTO.setTaxeId( entityTaxeId( entity ) );
        factureViewDTO.setClientAdressDTO( adresseToAdresseDTO( entityUtilisateurAdresse( entity ) ) );
        factureViewDTO.setDeviseId( entityDeviseId( entity ) );
        factureViewDTO.setTypePaiementDTO( typePaiementMapper.toDto( entity.getTypePaiement() ) );
        factureViewDTO.setDeviseDTO( deviseMapper.toDto( entity.getDevise() ) );
        factureViewDTO.setUtilisateurId( entityUtilisateurId( entity ) );
        factureViewDTO.setId( entity.getId() );
        factureViewDTO.setDateFacturation( entity.getDateFacturation() );
        factureViewDTO.setNumeroFacture( entity.getNumeroFacture() );

        return factureViewDTO;
    }

    private String entityTaxeNom(Facture facture) {
        if ( facture == null ) {
            return null;
        }
        Taxe taxe = facture.getTaxe();
        if ( taxe == null ) {
            return null;
        }
        String nom = taxe.getNom();
        if ( nom == null ) {
            return null;
        }
        return nom;
    }

    private Long entityTaxeId(Facture facture) {
        if ( facture == null ) {
            return null;
        }
        Taxe taxe = facture.getTaxe();
        if ( taxe == null ) {
            return null;
        }
        Long id = taxe.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityDeviseId(Facture facture) {
        if ( facture == null ) {
            return null;
        }
        Devise devise = facture.getDevise();
        if ( devise == null ) {
            return null;
        }
        Long id = devise.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityTypePaiementId(Facture facture) {
        if ( facture == null ) {
            return null;
        }
        TypePaiement typePaiement = facture.getTypePaiement();
        if ( typePaiement == null ) {
            return null;
        }
        Long id = typePaiement.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String entityTypePaiementNom(Facture facture) {
        if ( facture == null ) {
            return null;
        }
        TypePaiement typePaiement = facture.getTypePaiement();
        if ( typePaiement == null ) {
            return null;
        }
        String nom = typePaiement.getNom();
        if ( nom == null ) {
            return null;
        }
        return nom;
    }

    private Long entityUtilisateurId(Facture facture) {
        if ( facture == null ) {
            return null;
        }
        Utilisateur utilisateur = facture.getUtilisateur();
        if ( utilisateur == null ) {
            return null;
        }
        Long id = utilisateur.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String entityUtilisateurNom(Facture facture) {
        if ( facture == null ) {
            return null;
        }
        Utilisateur utilisateur = facture.getUtilisateur();
        if ( utilisateur == null ) {
            return null;
        }
        String nom = utilisateur.getNom();
        if ( nom == null ) {
            return null;
        }
        return nom;
    }

    protected UtilisateurDTO utilisateurToUtilisateurDTO(Utilisateur utilisateur) {
        if ( utilisateur == null ) {
            return null;
        }

        UtilisateurDTO utilisateurDTO = new UtilisateurDTO();

        utilisateurDTO.setAdmin( utilisateur.getAdmin() );
        utilisateurDTO.setId( utilisateur.getId() );
        utilisateurDTO.setNom( utilisateur.getNom() );
        utilisateurDTO.setPrenom( utilisateur.getPrenom() );
        utilisateurDTO.setLogin( utilisateur.getLogin() );
        utilisateurDTO.setEmail( utilisateur.getEmail() );
        utilisateurDTO.setTelephone( utilisateur.getTelephone() );

        return utilisateurDTO;
    }

    private Adresse entityUtilisateurAdresse(Facture facture) {
        if ( facture == null ) {
            return null;
        }
        Utilisateur utilisateur = facture.getUtilisateur();
        if ( utilisateur == null ) {
            return null;
        }
        Adresse adresse = utilisateur.getAdresse();
        if ( adresse == null ) {
            return null;
        }
        return adresse;
    }

    protected AdresseDTO adresseToAdresseDTO(Adresse adresse) {
        if ( adresse == null ) {
            return null;
        }

        AdresseDTO adresseDTO = new AdresseDTO();

        adresseDTO.setId( adresse.getId() );
        adresseDTO.setRue( adresse.getRue() );
        adresseDTO.setLocalite( adresse.getLocalite() );
        adresseDTO.setPays( adresse.getPays() );
        adresseDTO.setVille( adresse.getVille() );

        return adresseDTO;
    }
}
