/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.service.impl;

import com.company.dao.impl.CountryRepositoryCustom;
import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;
import com.company.service.inter.CountryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author Umman Hasan
 */
@Service
@Transactional
public class CountryServiceImpl implements CountryServiceInter {
    @Autowired
    @Qualifier("countryDao")
    private CountryRepositoryCustom countryDao;

    @Override
    public List<Country> getAll() {
        return countryDao.getAll();
    }

    @Override
    public Country getById(int id) {
        return countryDao.getById(id);
    }

    @Override
    public boolean updateCountry(Country country) {
        return countryDao.updateCountry(country);
    }

    public boolean insertCountry(Country country) {
        return countryDao.insertCountry(country);
    }

    @Override
    public boolean removeCountry(Integer id) {
        return countryDao.removeCountry(id);
    }

}
