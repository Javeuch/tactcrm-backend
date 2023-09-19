package com.wetic.tactcrm.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "factures")
public class Facture extends  EntiteBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(name = "date_facturation")
    private Date dateFacturation;


    @Column(name = "numero_facture")
    private String numeroFacture;


    @ManyToOne
    @JoinColumn(name="user_id")
    private Utilisateur utilisateur;


    @ManyToOne
    @JoinColumn(name = "devise_id")
    private Devise devise;

    @ManyToOne
    @JoinColumn(name = "taxe_id")
    private Taxe taxe;

    @ManyToOne
    @JoinColumn(name = "type_paiement")
    private TypePaiement typePaiement;

    @OneToMany(mappedBy = "facture")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private Set<DetailsFacture> detailsFactures;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Devise getDevise() {
        return devise;
    }

    public void setDevise(Devise devise) {
        this.devise = devise;
    }

    public Taxe getTaxe() {
        return taxe;
    }

    public void setTaxe(Taxe taxe) {
        this.taxe = taxe;
    }

    public TypePaiement getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(TypePaiement typePaiement) {
        this.typePaiement = typePaiement;
    }

    public Set<DetailsFacture> getDetailsFactures() {
        return detailsFactures;
    }

    public void setDetailsFactures(Set<DetailsFacture> detailsFactures) {
        this.detailsFactures = detailsFactures;
    }


    public Date getDateFacturation() {
        return dateFacturation;
    }

    public void setDateFacturation(Date dateFacturation) {
        this.dateFacturation = dateFacturation;
    }

    public String getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(String numeroFacture) {
        this.numeroFacture = numeroFacture;
    }


    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof Facture)){
            return false;
        }
        return id!=null && ((Facture) o).id.equals(this.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode() * numeroFacture.hashCode() * dateFacturation.hashCode();
    }

    @Override
    public String toString() {
        return "Facture{" +
                "Numero facture='" + numeroFacture + '\'' +
                ", Date Facturation ='" + dateFacturation + '\'' +
                "}";
    }


}
