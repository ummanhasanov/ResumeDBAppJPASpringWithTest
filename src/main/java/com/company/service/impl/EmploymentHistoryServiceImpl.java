/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.service.impl;

import com.company.dao.impl.EmployHistoryRepositoryCustom;
import com.company.dao.impl.EmployHistoryRepositoryCustomImpl;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import com.company.service.inter.EmploymentHistoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author Umman Hasan
 */
@Service
@Transactional
public class EmploymentHistoryServiceImpl  implements EmploymentHistoryServiceInter {
    @Autowired
    @Qualifier("employHistoryDao")
    private EmployHistoryRepositoryCustom employHistoryDao;


    @Override
    public List<EmploymentHistory> getAll() {
        return employHistoryDao.getAll();
    }

    @Override
    public EmploymentHistory getById(int id) {
        return employHistoryDao.getById(id);
    }

    @Override
    public boolean insertEmployHistory(EmploymentHistory eh) {
        return employHistoryDao.insertEmployHistory(eh);
    }

    @Override
    public boolean updateEmployHistory(EmploymentHistory eh) {
        return employHistoryDao.updateEmployHistory(eh);
    }

    @Override
    public boolean removeEmployHistory(int id) {
        return employHistoryDao.removeEmployHistory(id);
    }
}
