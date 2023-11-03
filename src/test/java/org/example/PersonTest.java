package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    public void testChangeAgeSuccessful() {
        Person firstPerson = new Person(25, "Bob");
        firstPerson.changeName("Mart");
        assertEquals("Mart", firstPerson.getName());
    }

    @Test
    public void testCelebrateBirthday () {
        Person secondPerson = new Person(35, "Charlie");
        secondPerson.celebrateBirthday();
        assertEquals(36, secondPerson.getAge());
    }
}
