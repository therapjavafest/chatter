package com.therapjavafest.chatter.util;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DatabaseConnectionPoolTest {

    @Test
    public void testGetConnection() throws Exception {
        assertNotNull(DatabaseConnectionPool.getConnection());
    }
}