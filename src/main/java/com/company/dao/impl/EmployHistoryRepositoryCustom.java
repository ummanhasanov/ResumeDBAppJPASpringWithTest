/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.entity.EmploymentHistory;

import java.util.List;

/**
 * @author Umman Hasan
 */
public interface EmployHistoryRepositoryCustom {

    List<EmploymentHistory> getAll();

    public EmploymentHistory getById(int id);

    public boolean insertEmployHistory(EmploymentHistory eh);

    public boolean updateEmployHistory(EmploymentHistory eh);
    public boolean removeEmployHistory(int id);

}
