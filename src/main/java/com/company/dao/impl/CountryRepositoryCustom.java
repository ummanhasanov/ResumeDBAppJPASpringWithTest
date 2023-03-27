/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.entity.Country;

import java.util.List;

/**
 *
 * @author Umman Hasan
 */
public interface CountryRepositoryCustom
{
        List<Country> getAll();

        public Country getById(int id);
        boolean insertCountry(Country country);
        boolean updateCountry(Country country);
        boolean removeCountry(int id);

}
