package Ticket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

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
        assertEquals(new BigDecimal("21.00"), ticket1.finalPrice());
        assertEquals(new BigDecimal("16.80"), ticket2.finalPrice());
        assertEquals(new BigDecimal("12.60"), ticket3.finalPrice());
    }
}