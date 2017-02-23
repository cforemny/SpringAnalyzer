package com.spring.factory;

import com.spring.structure.ticketing.Ticket;

/**
 * Created by pawel on 15.01.17.
 */
public class TicketFactory {

    public static Ticket createTicket(boolean paid) {
        return new Ticket(paid);
    }

}
