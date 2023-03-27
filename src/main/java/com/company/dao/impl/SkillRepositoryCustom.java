/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.entity.Skill;

import java.util.List;

/**
 *
 * @author Umman Hasan
 */
public interface SkillRepositoryCustom
{
    
    List<Skill> getAll();

    public List<Skill> getByName(String name);
    public Skill getById(int id);

    public boolean insertSkill(Skill skill);

    public boolean updateSkill(Skill skill);

    public boolean removeSkill(int id);


}
