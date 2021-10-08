package com.learnkafka.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BookTest {
    @Test
    void testBuilder() {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by builder()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        Book.builder();
    }

    @Test
    void testCanEqual() {
        assertFalse((new Book()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        Book book = new Book();
        assertTrue(book.canEqual(new Book()));
    }

    @Test
    void testConstructor() {
        Book actualBook = new Book();
        actualBook.setBookAuthor("JaneDoe");
        actualBook.setBookId(123);
        actualBook.setBookName("Book Name");
        assertEquals("JaneDoe", actualBook.getBookAuthor());
        assertEquals(123, actualBook.getBookId().intValue());
        assertEquals("Book Name", actualBook.getBookName());
        assertEquals("Book(bookId=123, bookName=Book Name, bookAuthor=JaneDoe)", actualBook.toString());
    }

    @Test
    void testConstructor2() {
        Book actualBook = new Book(123, "Book Name", "JaneDoe");
        actualBook.setBookAuthor("JaneDoe");
        actualBook.setBookId(123);
        actualBook.setBookName("Book Name");
        assertEquals("JaneDoe", actualBook.getBookAuthor());
        assertEquals(123, actualBook.getBookId().intValue());
        assertEquals("Book Name", actualBook.getBookName());
        assertEquals("Book(bookId=123, bookName=Book Name, bookAuthor=JaneDoe)", actualBook.toString());
    }

    @Test
    void testEquals() {
        assertFalse((new Book()).equals(null));
        assertFalse((new Book()).equals("Different type to Book"));
    }

    @Test
    void testEquals2() {
        Book book = new Book();
        assertTrue(book.equals(book));
        int expectedHashCodeResult = book.hashCode();
        assertEquals(expectedHashCodeResult, book.hashCode());
    }

    @Test
    void testEquals3() {
        Book book = new Book();
        Book book1 = new Book();
        assertTrue(book.equals(book1));
        int expectedHashCodeResult = book.hashCode();
        assertEquals(expectedHashCodeResult, book1.hashCode());
    }

    @Test
    void testEquals4() {
        Book book = new Book(123, "Book Name", "JaneDoe");
        assertFalse(book.equals(new Book()));
    }

    @Test
    void testEquals5() {
        Book book = new Book();
        assertFalse(book.equals(new Book(123, "Book Name", "JaneDoe")));
    }

    @Test
    void testEquals6() {
        Book book = new Book();
        book.setBookAuthor("JaneDoe");
        assertFalse(book.equals(new Book()));
    }

    @Test
    void testEquals7() {
        Book book = new Book(null, "Book Name", "JaneDoe");
        assertFalse(book.equals(new Book()));
    }

    @Test
    void testEquals8() {
        Book book = new Book(123, "Book Name", "JaneDoe");
        Book book1 = new Book(123, "Book Name", "JaneDoe");

        assertTrue(book.equals(book1));
        int expectedHashCodeResult = book.hashCode();
        assertEquals(expectedHashCodeResult, book1.hashCode());
    }

    @Test
    void testEquals9() {
        Book book = new Book();

        Book book1 = new Book();
        book1.setBookAuthor("JaneDoe");
        assertFalse(book.equals(book1));
    }

    @Test
    void testEquals10() {
        Book book = new Book();
        assertFalse(book.equals(new Book(null, "Book Name", "JaneDoe")));
    }
}

