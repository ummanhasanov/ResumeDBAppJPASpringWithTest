/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.entity.Skill;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.SkillDaoInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Umman Hasan
 */
@Repository
@Qualifier("skillDao")
public class SkillRepositoryCustomImpl implements SkillRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Skill> getAll() {
        String jpql = "SELECT s FROM Skill s ";

        Query query = em.createQuery(jpql, Skill.class);

        return query.getResultList();
    }

    @Override
    public List<Skill> getByName(String name) {
        String jpql = "SELECT s FROM Skill s WHERE s.name = :name ";
        Query query = em.createQuery(jpql, Skill.class);
        return query.getResultList();
    }

    @Override
    public Skill getById(int id) {
        String jpql = "SELECT s FROM Skill s WHERE 1=1 ";
        jpql += " AND s.id=:id ";

        Query query = em.createQuery(jpql, Skill.class);
        query.setParameter("id", id);
        List<Skill> list = query.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean insertSkill(Skill skill) {
        em.persist(skill);
        return true;
    }

    @Override
    public boolean updateSkill(Skill skill) {
        em.merge(skill);
        return true;
    }

    @Override
    public boolean removeSkill(int id) {
        Skill skill = em.find(Skill.class, id);
        em.remove(skill);
        return true;
    }
}
