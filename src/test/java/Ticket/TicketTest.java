package Ticket;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    void constructor(){
        assertThrows(IllegalArgumentException.class, ()-> new Ticket(100,0));
        assertThrows(IllegalArgumentException.class, ()-> new Ticket(100,-1));
        assertThrows(IllegalArgumentException.class, ()-> new Ticket(0,25));
        assertThrows(IllegalArgumentException.class, ()-> new Ticket(-10,25));
        assertThrows(IllegalArgumentException.class, ()-> new Ticket(-10,-25));
        assertThrows(IllegalArgumentException.class, ()-> new Ticket(0,0));
        assertDoesNotThrow(() -> new Ticket(100,20));
    }

    @Test
    void finalPrice() {
        Ticket ticket1 = new Ticket(100, 25);
        Ticket ticket2 = new Ticket(100, 15);
        Ticket ticket3 = new Ticket(100, 68);
        assertEquals(21, ticket1.finalPrice());
        assertEquals(16.8, ticket2.finalPrice());
        assertEquals(12.6, ticket3.finalPrice());
    }
}