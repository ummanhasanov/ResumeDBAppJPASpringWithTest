/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.service.inter;

import com.company.entity.Country;

import java.util.List;

/**
 *
 * @author Umman Hasan
 */
public interface CountryServiceInter
{
        public List<Country> getAll();

        public Country getById(int id);

        boolean updateCountry(Country country);
        boolean insertCountry(Country country);
        boolean removeCountry(Integer id);

}
