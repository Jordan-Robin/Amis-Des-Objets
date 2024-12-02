package com.eni.amis.des.objets.dal;

import com.eni.amis.des.objets.bo.Utilisateur;

public interface UserDAO {

    void create(Utilisateur utilisateur);
    Utilisateur findByPseudo(String pseudo);
    Utilisateur findByEmail(String email);

}
