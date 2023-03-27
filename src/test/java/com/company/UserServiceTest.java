package com.company;

import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.Country;
import com.company.entity.User;
import com.company.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {
    @Mock//yalanci userDao
    UserRepositoryCustom userDao;
    @InjectMocks
    UserServiceImpl userService;

    @BeforeClass
    public static void setUp(){
        System.out.println("set up called");
    }
    @Before
    public void before(){
        //Mock annotation-lari initialize edir
        MockitoAnnotations.initMocks(this);

        System.out.println("before called");

        //yeni bir list yaradiriq
        List<User> list = new ArrayList<>();
        //yeni User obyekti yaradiriq
        User u = new User();
        u.setName("test");
        u.setSurname("test");
        u.setEmail("test@test.com");
        u.setNationality(new Country(1));
        //useri liste elave edirik
        list.add(u);

        //testGivenNullThenGetAll()
        Mockito.when(userDao.getAll(null,null,null)).thenReturn(list);

        //testGivenParamsThenGetAllByFilter
        Mockito.when(userDao.getAll("test","test",1)).thenReturn(list);

        //testGivenNullFindByEmailAndPassword
        Mockito.when(userDao.findByUserEmailAndPassword(null,null)).thenReturn(null);
    }

    @Test
    public void testGivenNullThenGetAll() {
        List<User> list = userService.getAll(null, null, null);

        Assert.assertEquals("user size must be 1", 1, list.size());

        // en azi bir defe cagirilibmi getAll null methodu
        Mockito.verify(userDao, Mockito.atLeastOnce()).getAll(null,null,null);
    }

    @Test
    public void testGivenParamsThenGetAllByFilter() {
        List<User> list = userService.getAll("test", "test", 1);

        Assert.assertTrue("user size must be greater than 1", list.size()>0);

        User user = list.get(0);
        Assert.assertEquals("name wrong", "test", user.getName());
        Assert.assertEquals("surname wrong", "test", user.getSurname());
        Assert.assertEquals("nationality id wrong", 1L,(long) user.getNationality().getId());

        // en azi bir defe cagirilibmi getAll by filter methodu
        Mockito.verify(userDao, Mockito.atLeastOnce()).getAll("test", "test", 1);
    }

    @Test
    public void testGivenNullFindByEmailAndPassword() {
        User user = userService.findByUserEmailAndPassword(null, null);

        Assert.assertNull("user must be null", user);

        // en azi bir defe cagirilibmi findByUserEmailAndPassword methodu
        Mockito.verify(userDao, Mockito.atLeastOnce()).findByUserEmailAndPassword(null,null);
    }

}
