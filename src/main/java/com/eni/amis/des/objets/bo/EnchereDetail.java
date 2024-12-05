package com.eni.amis.des.objets.bo;

//Tâche Gestion des enchères - Afficher le détail d’une enchère, Pas encore fait la Validation

public class EnchereDetail {
  private String nomArticle;
  private String description;
  private String dateFinEncheres;
  private int prixInitial;
	/* private int meilleureOffre; */
  private Integer meilleureOffre;
  private String vendeur;
  private String categorie;
  private String adresseRetrait;

  // Getters et setters
  public String getNomArticle() {
      return nomArticle;
  }

  public void setNomArticle(String nomArticle) {
      this.nomArticle = nomArticle;
  }

  public String getDescription() {
      return description;
  }

  public void setDescription(String description) {
      this.description = description;
  }

  public String getDateFinEncheres() {
      return dateFinEncheres;
  }

  public void setDateFinEncheres(String dateFinEncheres) {
      this.dateFinEncheres = dateFinEncheres;
  }

  public int getPrixInitial() {
      return prixInitial;
  }

  public void setPrixInitial(int prixInitial) {
      this.prixInitial = prixInitial;
  }

	/*
	 * public int getMeilleureOffre() {
	 * 	return meilleureOffre; 
	 * }
	 * 
	 * public void setMeilleureOffre(int meilleureOffre) {
	 * 	this.meilleureOffre = meilleureOffre;
	 * }
	 */

	public Integer getMeilleureOffre() {
	    return meilleureOffre;
	}
	
	public void setMeilleureOffre(Integer meilleureOffre) {
	    this.meilleureOffre = meilleureOffre;
	}

  public String getVendeur() {
      return vendeur;
  }

  public void setVendeur(String vendeur) {
      this.vendeur = vendeur;
  }

  public String getCategorie() {
      return categorie;
  }

  public void setCategorie(String categorie) {
      this.categorie = categorie;
  }

  public String getAdresseRetrait() {
      return adresseRetrait;
  }

  public void setAdresseRetrait(String adresseRetrait) {
      this.adresseRetrait = adresseRetrait;
  }
}
