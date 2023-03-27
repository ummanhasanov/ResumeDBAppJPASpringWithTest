/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.entity.EmploymentHistory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Umman Hasan
 */
@Repository
@Qualifier("employHistoryDao")
public class EmployHistoryRepositoryCustomImpl implements EmployHistoryRepositoryCustom {
    @PersistenceContext
    EntityManager em;

//    private EmploymentHistory getAll(ResultSet rs) throws Exception {
//
//        String header = rs.getString("header");
//        String jobDescription = rs.getString("job_description");
//        Date beginDate = rs.getDate("begin_date");
//        Date endDate = rs.getDate("end_date");
//        int userId = rs.getInt("user_id");
//
//        EmploymentHistory emp = new EmploymentHistory(null, header, beginDate, endDate, jobDescription, new User(userId));
//        return emp;
//
//    }

    @Override
    public List<EmploymentHistory> getAll() {
        String jpql = "SELECT eh FROM EmploymentHistory eh ";
        Query query = em.createQuery(jpql, EmploymentHistory.class);

        return query.getResultList();
    }

    @Override
    public EmploymentHistory getById(int empId) {
        String jpql = "SELECT eh FROM EmploymentHistory eh ";
        jpql += " AND eh.id=:empId ";
        Query query = em.createQuery(jpql, EmploymentHistory.class);
        query.setParameter("empId", empId);

        List<EmploymentHistory> list = query.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean insertEmployHistory(EmploymentHistory eh) {
        em.persist(eh);
        return true;
    }

    @Override
    public boolean updateEmployHistory(EmploymentHistory eh) {
        em.merge(eh);
        return true;
    }

    @Override
    public boolean removeEmployHistory(int id) {
        EmploymentHistory eh = em.find(EmploymentHistory.class, id);
        em.remove(id);
        return true;
    }

}
