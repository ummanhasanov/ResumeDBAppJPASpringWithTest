/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.service.impl;

import com.company.dao.impl.SkillRepositoryCustom;
import com.company.entity.Skill;
import com.company.service.inter.SkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author Umman Hasan
 */
@Service
@Transactional
public class SkillServiceImpl implements SkillServiceInter {

    @Autowired
    @Qualifier( "skillDao")
    private SkillRepositoryCustom skillDao;

    @Override
    public List<Skill> getAll() {
        return skillDao.getAll();
    }

    @Override
    public List<Skill> getByName(String name) {
        return skillDao.getByName(name);
    }

    @Override
    public Skill getById(int id) {
        return skillDao.getById(id);
    }

    @Override
    public boolean insertSkill(Skill skill) {
        return skillDao.insertSkill(skill);
    }

    @Override
    public boolean updateSkill(Skill skill) {
        return skillDao.updateSkill(skill);
    }

    @Override
    public boolean removeSkill(int id) {
        return skillDao.removeSkill(id);
    }
}
