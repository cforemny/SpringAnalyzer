package com.spring.analyzer.ScheduleChangeAnalizer;

import com.spring.analyzer.ScheduleChangeAnalizer.Mail.EmailListAsString;
import com.spring.analyzer.ScheduleChangeAnalizer.Mail.MailCreator;
import com.spring.structure.booking.Booking;

/**
 * Created by Cyprian on 2017-02-09.
 */
public class PrzykladowyPrzygotowywacz {


    private EmailListAsString emailListAsString;
    private MailCreator mailCreator;

    public PrzykladowyPrzygotowywacz(EmailListAsString emailListAsString, MailCreator mailCreator) {
        System.out.println("Wkladam do ksontruktora przykladowegoPrzygotowywacza beany emailListAsString i mailCreator");
        this.emailListAsString = emailListAsString;
        this.mailCreator = mailCreator;
    }

    public Wrapper przygotujPaczke(Booking booking) {

        return new Wrapper(emailListAsString.createAdresses(booking), "Tytuł wiadomości", mailCreator.preapreMessageToSend(booking));

    }
}
