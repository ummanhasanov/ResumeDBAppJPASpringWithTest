/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Umman Hasan Data Access Object
 */
@Repository
@Qualifier("userDao1")
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> getAll() {
        String jpql = "SELECT u FROM User u ";

        Query query = em.createQuery(jpql, User.class);

        return query.getResultList();
    }

    @Override
//    @Cacheable(value = "users") // usersleri dbapdeki son veziyyeti nezere almir. son deyiwiklikden evvelki veziyyeti cash edir
    public List<User> getAll(String name, String surname, Integer nationalityId) {
        String jpql = "SELECT u FROM User u WHERE 1=1 ";

        if (name != null && !name.trim().isEmpty()) {
            jpql += " AND u.name=:name ";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " AND u.surname=:surname ";
        }
        if (nationalityId != null) {
            jpql += " AND u.nationality.id=:nid ";
        }

        Query query = em.createQuery(jpql, User.class);

        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            query.setParameter("surname", surname);
        }
        if (nationalityId != null) {
            query.setParameter("nid", nationalityId);
        }

        return query.getResultList();
    }

    @Override //CriteriaBuilder 
    public User findByUserEmailAndPassword(String email, String password) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> q1 = cb.createQuery(User.class);
        Root<User> postRoot = q1.from(User.class);

        CriteriaQuery<User> q2 = q1
                .where(cb.equal(postRoot.get("email"), email), (cb.equal(postRoot.get("password"), password)));


        Query query = em.createQuery(q2);


        List<User> list = query.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }

        return null;
    }

//    @Override //jpql
//    public User findByUserEmailAndPassword(String email, String password) {
//
//        Query q = em.createQuery("select u from User u where u.email=:e and u.password=:p", User.class
//        );
//        q.setParameter("e", email);
//        q.setParameter("p", password);
//
//        List<User> list = q.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//
//        return null;
//    }

//     @Override //CriteriaBuilder 
//    public User findByEmail(String email) {
//
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<User> q1 = cb.createQuery(User.class);
//        Root<User> postRoot = q1.from(User.class);
//
//        CriteriaQuery<User> q2 = q1
//                .where(cb.equal(postRoot.get("email"), email));
//     
//
//        Query query = em.createQuery(q2);
//      
//        List<User> list = query.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//
//        return null;
//    }
//    

//     @Override //NamedQuery
//    public User findByEmail(String email) {
//
//        Query query = em.createNamedQuery("User.findByEmail", User.class);
//        query.setParameter("email", email);
//      
//        List<User> list = query.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//
//        return null;
//    }

    //    @Override //Native SQL
//    public User findByEmail(String email) {
//
//        Query query = em.createNativeQuery("select * from user where email = ?", User.class);
//        query.setParameter(1, email);
//
//        List<User> list = query.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//         return null;
//    }
//
    @Override //jpql
    public User findByEmail(String email) {
        String jpql = "SELECT u FROM User u WHERE u.email=:e ";
        Query query = em.createQuery(jpql, User.class);
        query.setParameter("e", email);

        List<User> list = query.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public boolean updateUser(User u) {
        em.merge(u);
        return true;
    }

    @Override
    @CacheEvict(value = "users", allEntries = true)
    public boolean removeUser(int id) {
        User u = em.find(User.class, id);
        em.remove(u);
        return true;
    }

    @Override
    public User getById(int userId) {
        String jpql = "SELECT u FROM User u WHERE 1=1 ";
        jpql += " AND u.id=:userId";

        Query query = em.createQuery(jpql, User.class);
        query.setParameter("userId", userId);

        List<User> list = query.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }

        return null;
    }

    private final BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();

    @Override
    public boolean addUser(User u) {
        u.setPassword(crypt.encode(u.getPassword()));
        em.persist(u);
        return true;
    }
}
