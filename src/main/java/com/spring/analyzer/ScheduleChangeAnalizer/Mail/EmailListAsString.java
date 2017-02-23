package com.spring.analyzer.ScheduleChangeAnalizer.Mail;

import com.spring.structure.booking.Booking;

import java.util.List;

/**
 * Created by Cyprian on 2017-02-06.
 */
public class EmailListAsString {


    private EmailList emailList;
    private StringBuilder list;

    public EmailListAsString(EmailList emailList, StringBuilder list) {
        System.out.println("Wkladam beany do konstruktora EmailListAsString");
        this.emailList = emailList;
        this.list = list;
    }

    public String createAdresses(Booking booking) {

        for (String adress : emailAdressesList(booking)) {
            list.append(adress);
            list.append(", ");
        }
        String stringAdressesList = list.toString();
        return stringAdressesList;
    }

    private List<String> emailAdressesList(Booking booking) {
        return emailList.createEmailAdressesList(booking);

    }
}
