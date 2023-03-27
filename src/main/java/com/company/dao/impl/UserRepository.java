package com.company.dao.impl;

import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {
    User findByName(String name);

    List<User> findByNameAndSurname(String name, String surname);

    List<User> findByNameAndSurnameAndNationality(String name, String surname, Integer nationalityId);

    @Query(value = "select u from User u where u.email=?1")
    User findByEmail(String email);

    User findById(int id);

    public void deleteById(Integer id);

    User save(User u);
}
