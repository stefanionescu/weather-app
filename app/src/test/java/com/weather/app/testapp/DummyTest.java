package com.weather.app.testapp;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
@SmallTest
public class DummyTest {

    @Test
    public void multiply(){

        assertEquals(4, 2*2);

    }

}
