package com.techelevator.dao;

import com.techelevator.authentication.SessionAuthProvider;
import com.techelevator.model.Account;
import com.techelevator.model.User;
import com.techelevator.model.UserDao;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.http.HttpSession;

import javax.sql.DataSource;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JdbcCreateAccountDaoTest {
    private JdbcCreateAccountDao createAccountDao;
    private JdbcTemplate mockedJdbcTemplate;

    @Before
    public void before() {
        mockedJdbcTemplate = mock(JdbcTemplate.class);
        createAccountDao = new JdbcCreateAccountDao();
        createAccountDao.setJdbcTemplate(mockedJdbcTemplate);
    }

    @Test
    public void testCheckAccountExists() {
        // String sql = "SELECT user_id FROM user_profile WHERE user_id = ?;";
       // when(mockedJdbcTemplate.queryForObject(sql, Long.class, 1l)).thenReturn(1l);
        when(mockedJdbcTemplate.queryForObject(anyString(), any(Class.class), anyLong())).thenReturn(1l);
        long actualResult = createAccountDao.checkAccountExists(1l);
        assertEquals(actualResult, 1l);
    }

    @Test
    public void testCheckAccountExistsIfNot() {
        when(mockedJdbcTemplate.queryForObject(anyString(), any(Class.class), anyLong())).thenReturn(0l);
        long actualResult = createAccountDao.checkAccountExists(1l);
        assertEquals(actualResult, 0l);
    }

    @Test
    public void testCreateAccount(){

          when(mockedJdbcTemplate.queryForObject(anyString(), any(Class.class),
                  anyString(), anyString(), anyString(),any(byte[].class), anyString(), anyLong() )).thenReturn(1l);
          Account account = new Account();
          long actualResult = createAccountDao.createAccount(account);
          assertEquals(actualResult, 1l);
    }

}
