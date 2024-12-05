package com.eni.amis.des.objets.bll;

import com.eni.amis.des.objets.bo.Utilisateur;

public interface UserServices {

    void createUser(Utilisateur utilisateur);
    void modifyUser(Utilisateur utilisateur);
    Utilisateur getByPseudo(String pseudo);

}
