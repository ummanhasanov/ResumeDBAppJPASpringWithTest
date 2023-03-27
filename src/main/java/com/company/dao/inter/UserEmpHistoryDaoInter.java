package com.company.dao.inter;

import com.company.entity.EmploymentHistory;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author TURAL
 */
public interface UserEmpHistoryDaoInter {
    
    public List<EmploymentHistory> getAllEmpHistoryByUserId(int id);

}
