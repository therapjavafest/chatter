package com.therapjavafest.chatter.web;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;

public class HomeControllerTest {

    private HomeController homeController;

    private HttpServletRequest mockRequest;
    private HttpServletResponse mockResponse;

    @Before
    public void setUp() throws Exception {
        mockRequest = mock(HttpServletRequest.class);
        mockResponse = mock(HttpServletResponse.class);
        homeController = new HomeController();
    }

    @Test
    public void testDoGet() throws Exception {
        ServletOutputStream mockOutput = mock(ServletOutputStream.class);

        when(mockResponse.getOutputStream()).thenReturn(mockOutput);

        homeController.doGet(mockRequest, mockResponse);

        verify(mockResponse).setContentType("plain/text");
        verify(mockOutput).println("Hello world!");
    }
}