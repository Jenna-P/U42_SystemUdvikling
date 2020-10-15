package Tutorial;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    public void testPerson() {
        Person p1 = new Person();
        assertEquals("unknown name", p1.getName());
        assertEquals(3,p1.getMaximumBooks());
    }

    @org.junit.jupiter.api.Test
    void setName() {
    }

    @org.junit.jupiter.api.Test
    void setMaximumBooks() {
    }

    @Test
    void testSetName() {
        Person p2 = new Person();
        p2.setName("Fred");
        assertEquals("Fred", p2.getName());
    }

    @Test
    void testSetMaximumBooks() {
        Person p3 = new Person();
        p3.setMaximumBooks(3);
        assertEquals(3,p3.getMaximumBooks());

    }
    public void testToString() {
        Person p4 = new Person();
        p4.setName("Fred Flintstone");
        p4.setMaximumBooks(7);
        String testString = "Fred Flintstone (7 books)";
        assertEquals(testString, p4.toString());
    }
}