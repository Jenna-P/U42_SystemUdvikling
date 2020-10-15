package Tutorial;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
//import static org.junit.jupiter.api.AssertFalse.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyLibraryTest {

    Book b1;
    Book b2;
    Person p1;
    Person p2;
    MyLibrary m1;

    @Test
    public void testMyLibrary(){
        MyLibrary m1 = new MyLibrary("Test");
        assertEquals("Test",m1.name);
        assertTrue(m1.books instanceof ArrayList);
        assertTrue(m1.people instanceof ArrayList);

    }
    public void setup(){
        //Creat objects
        b1 = new Book("Book1");
        b2 = new Book("Book2");

        p1 = new Person();
        p2 = new Person();
        p1.setName("Fred");
        p2.setName("Sue");

        m1 = new MyLibrary("Test");

    }

    public void testAddBook() {
        //create test object
        setup();
        //test initial size is o
        assertEquals(0, m1.getBooks().size());

        m1.addBook(b1);
        m1.addBook(b2);

        assertEquals(2, m1.getBooks().size());
        assertEquals(0, m1.getBooks().indexOf(b1));
        assertEquals(1, m1.getBooks().indexOf(b2));

        m1.removeBook(b1);
        assertEquals(1, m1.getBooks().size());
        assertEquals(0, m1.getBooks().indexOf(b2));

        m1.removeBook(b2);
        assertEquals(0, m1.getBooks().size());

    }
    public void testCheckout() {
        //set up objects
        setup();

        addItems();

        assertTrue(m1.checkout(b1,p1), "Book did not check out correctly");
        assertEquals("Fred", b1.getPerson().getName());
       assertFalse("Book was already checked out", m1.checkout(b1,p2));
        assertTrue(m1.checkIn(b1), "Book check in failed");

        assertFalse("Book was already checked in", m1.checkIn(b1));
        assertFalse("Book was never checked out", m1.checkIn(b2));

        //additional test for maximumbooks
        setup();
        p1.setMaximumBooks(1);
        addItems();

        assertTrue(m1.checkout(b2,p1), "First book did not check out");
        assertFalse("Second book should not have checked out", m1.checkout(b1,p1));

    }

    private void addItems() {
        m1.addBook(b1);
        m1.addBook(b2);
        m1.addPerson(p1);
        m1.addPerson(p2);
    }

    public void testGetBooksForPerson(){
        setup();
        addItems();

        assertEquals(0,m1.getBooksForPerson(p1).size());

        m1.checkout(b1,p1);

        ArrayList<Book> testBooks = m1.getBooksForPerson(p1);
        assertEquals(1, testBooks.size());
        assertEquals(0, testBooks.indexOf(b1));

        m1.checkout(b2,p1);
        testBooks = m1.getBooksForPerson(p1);
        assertEquals(2, testBooks.size());
        assertEquals(1, testBooks.indexOf(b2));


    }

    public void testGetAvailableBooks() {
        setup();
        addItems();
        ArrayList<Book> testBooks = m1.getAvailableBooks();
        assertEquals(2, testBooks.size());
        assertEquals(1, testBooks.indexOf(b2));

        m1.checkout(b1,p1);
        testBooks = m1.getAvailableBooks();
        assertEquals(1, testBooks.size());
        assertEquals(0, testBooks.indexOf(b2));

        m1.checkout(b2,p1);
        testBooks = m1.getAvailableBooks();
        assertEquals(0, testBooks.size());

    }

    public void testGetUnavailableBooks(){
        setup();
        addItems();

        assertEquals(0,m1.getUnavailableBooks().size());

        m1.checkout(b1,p1);

        ArrayList<Book> testBooks = m1.getUnavailableBooks();
        assertEquals(1, testBooks.size());
        assertEquals(0, testBooks.indexOf(b1));

        m1.checkout(b2,p2);
        testBooks = m1.getUnavailableBooks();
        assertEquals(2, testBooks.size());
        assertEquals(1, testBooks.indexOf(b2));


    }

    public void testToSting(){
        setup();
        addItems();
        assertEquals("Test : 2 books ; 2 people." , m1.toString());
    }

}
