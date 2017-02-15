/**
 * This file was generated by the JPA Modeler
 */ 

package com.trusty3pl.business.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author  EL KHALYLYBADR
 */

@Entity
@Table(name="vendeur_has_appel_offre")
@IdClass(VendeurHasAppelOffrePK.class)
public class VendeurHasAppelOffre implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = -3697768217466311482L;

	@Column(name="Vendeur_idVendeur",table="vendeur_has_appel_offre",nullable=false,length=45)
    @Id
    private String vendeuridVendeur;

    @Column(name="Appel_Offre_Acheteur_idAcheteur",table="vendeur_has_appel_offre",nullable=false,length=45)
    @Id
    private String appelOffreAcheteuridAcheteur;

    @Column(name="Appel_Offre_Produit_idProduit",table="vendeur_has_appel_offre",nullable=false,length=45)
    @Id
    private String appelOffreProduitidProduit;

    @Column(name="Etat_idEtat",table="vendeur_has_appel_offre",nullable=false,length=45)
    @Id
    private String etatidEtat;


    public String getVendeuridVendeur() {
        return this.vendeuridVendeur;
    }

    public void setVendeuridVendeur(String vendeuridVendeur) {
        this.vendeuridVendeur = vendeuridVendeur;
    }

        public String getAppelOffreAcheteuridAcheteur() {
        return this.appelOffreAcheteuridAcheteur;
    }

    public void setAppelOffreAcheteuridAcheteur(String appelOffreAcheteuridAcheteur) {
        this.appelOffreAcheteuridAcheteur = appelOffreAcheteuridAcheteur;
    }

        public String getAppelOffreProduitidProduit() {
        return this.appelOffreProduitidProduit;
    }

    public void setAppelOffreProduitidProduit(String appelOffreProduitidProduit) {
        this.appelOffreProduitidProduit = appelOffreProduitidProduit;
    }

        public String getEtatidEtat() {
        return this.etatidEtat;
    }

    public void setEtatidEtat(String etatidEtat) {
        this.etatidEtat = etatidEtat;
    }

     

    }