package com.ironman.entity;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void testGetTableName() {
        User u = new User();
        u.setFirstname("Akash");
        Assert.assertEquals("user",u.getTableName());
    }

}
