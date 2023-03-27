/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Umman Hasan
 */
@Repository
@Qualifier("countryDao")
public class CountryRepositoryCustomImpl implements CountryRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Country> getAll() {
        List<Country> result = new ArrayList<>();
        String jpql = "SELECT c FROM Country c";
        Query query = em.createQuery(jpql, Country.class);
        result = query.getResultList();
        return result;
    }

    @Override
    public Country getById(int countryId) {
        String jpql = "SELECT c FROM Country c WHERE 1=1 ";
        jpql += " AND c.id=:countryId";

        Query query = em.createQuery(jpql, Country.class);
        query.setParameter("countryId", countryId);

        List<Country> list = query.getResultList();
        if(list.size() == 1){
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean updateCountry(Country country) {
        em.merge(country);
        return true;
    }

    @Override
    public boolean insertCountry(Country country) {
        em.persist(country);
        return true;
    }

    @Override
    public boolean removeCountry(int id) {
        Country country = em.find(Country.class, id);
        em.remove(country);
        return true;
    }
}
