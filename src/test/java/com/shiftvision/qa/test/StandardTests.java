package com.shiftvision.qa.test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("A special test scenario")
public class StandardTests {

    @BeforeAll
    public static void initAll() {
        System.out.println("BeforeAll...");
    }

    @BeforeEach
    public void init() {
        System.out.println("BeforeEach...");
    }

    @Test
    @DisplayName("Custom test name containing spaces")
    public void succeedingTest() {
        System.out.println("Test - succeedingTest");
    }

    @Test
    public void failingTest() {
        System.out.println("Test - failingTest");
        fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes")
    public void skippedTest() {
        System.out.println("Test - skippedTest");
        // not executed
    }

    @Test
    public void abortedTest() {
        System.out.println("Test - abortedTest");
        assumeTrue("abc".contains("Z"));
       // fail("test should have been aborted");
    }

    @Test
    public void firstNameTest(){
        String name = "Iftekhar Ivaan";
        assertTrue(name.startsWith("Iftekhar"));
    }
    @Test
    public void fullNameTest1(){
        String name = "Iftekhar Ivaan";
        assertTrue(name.startsWith("Iftekharx"));
        assertTrue(name.endsWith("Ivaanx"));
    }

    @Test
    public void fullNameTest2(){
        String name = "Iftekhar Ivaan";
        assertAll("full name",
                () -> assertTrue(name.startsWith("Iftekharx")),
                () -> assertTrue(name.endsWith("Ivaanx"))
        );
    }

    @AfterEach
    public void tearDown() {
        System.out.println("AfterEach...");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("AfterAll...");
    }

}
