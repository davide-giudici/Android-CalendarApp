package it.scalve.davidegiudici.myfirstapp;

import android.app.Application;
import android.test.ApplicationTestCase;

import junit.framework.Assert;

import org.junit.Test;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */

public class ApplicationTest{ // extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        //super(Application.class);
    }

    @Test
    public void test1() {
        Assert.assertEquals(true, false);

    }
}