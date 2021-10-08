package com.learnkafka.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class LibraryEventTest {
    @Test
    void testBuilder() {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by builder()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        LibraryEvent.builder();
    }

    @Test
    void testCanEqual() {
        assertFalse((new LibraryEvent()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        LibraryEvent libraryEvent = new LibraryEvent();
        assertTrue(libraryEvent.canEqual(new LibraryEvent()));
    }

    @Test
    void testConstructor() {
        LibraryEvent actualLibraryEvent = new LibraryEvent();
        Book book = new Book();
        actualLibraryEvent.setBook(book);
        actualLibraryEvent.setLibraryEventId(123);
        actualLibraryEvent.setLibraryEventType(LibraryEventType.NEW);
        assertSame(book, actualLibraryEvent.getBook());
        assertEquals(123, actualLibraryEvent.getLibraryEventId().intValue());
        assertEquals(LibraryEventType.NEW, actualLibraryEvent.getLibraryEventType());
        assertEquals("LibraryEvent(libraryEventId=123, libraryEventType=NEW, book=Book(bookId=null, bookName=null,"
                + " bookAuthor=null))", actualLibraryEvent.toString());
    }

    @Test
    void testConstructor2() {
        Book book = new Book();
        LibraryEvent actualLibraryEvent = new LibraryEvent(123, LibraryEventType.NEW, book);
        Book book1 = new Book();
        actualLibraryEvent.setBook(book1);
        actualLibraryEvent.setLibraryEventId(123);
        actualLibraryEvent.setLibraryEventType(LibraryEventType.NEW);
        Book book2 = actualLibraryEvent.getBook();
        assertSame(book1, book2);
        assertEquals(book, book2);
        assertEquals(123, actualLibraryEvent.getLibraryEventId().intValue());
        assertEquals(LibraryEventType.NEW, actualLibraryEvent.getLibraryEventType());
        assertEquals("LibraryEvent(libraryEventId=123, libraryEventType=NEW, book=Book(bookId=null, bookName=null,"
                + " bookAuthor=null))", actualLibraryEvent.toString());
    }

    @Test
    void testEquals() {
        assertFalse((new LibraryEvent()).equals(null));
        assertFalse((new LibraryEvent()).equals("Different type to LibraryEvent"));
    }

    @Test
    void testEquals2() {
        LibraryEvent libraryEvent = new LibraryEvent();
        assertTrue(libraryEvent.equals(libraryEvent));
        int expectedHashCodeResult = libraryEvent.hashCode();
        assertEquals(expectedHashCodeResult, libraryEvent.hashCode());
    }

    @Test
    void testEquals3() {
        LibraryEvent libraryEvent = new LibraryEvent();
        LibraryEvent libraryEvent1 = new LibraryEvent();
        assertTrue(libraryEvent.equals(libraryEvent1));
        int expectedHashCodeResult = libraryEvent.hashCode();
        assertEquals(expectedHashCodeResult, libraryEvent1.hashCode());
    }

    @Test
    void testEquals4() {
        LibraryEvent libraryEvent = new LibraryEvent(123, LibraryEventType.NEW, new Book());
        assertFalse(libraryEvent.equals(new LibraryEvent()));
    }

    @Test
    void testEquals5() {
        LibraryEvent libraryEvent = new LibraryEvent();
        assertFalse(libraryEvent.equals(new LibraryEvent(123, LibraryEventType.NEW, new Book())));
    }

    @Test
    void testEquals6() {
        LibraryEvent libraryEvent = new LibraryEvent(null, LibraryEventType.NEW, new Book());
        assertFalse(libraryEvent.equals(new LibraryEvent()));
    }

    @Test
    void testEquals7() {
        LibraryEvent libraryEvent = new LibraryEvent(123, LibraryEventType.NEW, new Book());
        LibraryEvent libraryEvent1 = new LibraryEvent(123, LibraryEventType.NEW, new Book());

        assertTrue(libraryEvent.equals(libraryEvent1));
        int expectedHashCodeResult = libraryEvent.hashCode();
        assertEquals(expectedHashCodeResult, libraryEvent1.hashCode());
    }

    @Test
    void testEquals8() {
        LibraryEvent libraryEvent = new LibraryEvent();
        assertFalse(libraryEvent.equals(new LibraryEvent(null, LibraryEventType.NEW, new Book())));
    }

    @Test
    void testEquals9() {
        LibraryEvent libraryEvent = new LibraryEvent(null, null, new Book());
        assertFalse(libraryEvent.equals(new LibraryEvent()));
    }

    @Test
    void testEquals10() {
        LibraryEvent libraryEvent = new LibraryEvent(123, LibraryEventType.NEW, null);
        assertFalse(libraryEvent.equals(new LibraryEvent(123, LibraryEventType.NEW, new Book())));
    }

    @Test
    void testEquals11() {
        LibraryEvent libraryEvent = new LibraryEvent(123, LibraryEventType.NEW, mock(Book.class));
        assertFalse(libraryEvent.equals(new LibraryEvent(123, LibraryEventType.NEW, new Book())));
    }

    @Test
    void testEquals12() {
        LibraryEvent libraryEvent = new LibraryEvent(123, LibraryEventType.NEW, new Book());
        Book book = mock(Book.class);
        when(book.getBookId()).thenReturn(123);
        when(book.canEqual((Object) any())).thenReturn(true);
        assertFalse(libraryEvent.equals(new LibraryEvent(123, LibraryEventType.NEW, book)));
    }
}

