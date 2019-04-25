package org.academiadecodigo.tropadelete.persistance.dao.jpa;

import org.academiadecodigo.tropadelete.persistance.Client;
import org.academiadecodigo.tropadelete.persistance.dao.Dao;

public class JpaClientDao extends GenericJpaDao<Client> implements Dao<Client> {

    public JpaClientDao(Class<Client> modelClass) {
        super(modelClass);
    }
}
