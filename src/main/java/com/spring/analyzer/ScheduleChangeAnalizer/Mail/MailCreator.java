package com.spring.analyzer.ScheduleChangeAnalizer.Mail;

import com.spring.analyzer.ScheduleChangeAnalizer.Schedule.MessageCreator;
import com.spring.analyzer.ScheduleChangeAnalizer.activationCode.ActivationCodeCreator;
import com.spring.structure.booking.Booking;

/**
 * Created by Cyprian on 2017-02-09.
 */
public class MailCreator {
    private MessageCreator messageCreator;
    private ActivationCodeCreator activationCodeCreator;

    public MailCreator(MessageCreator messageCreator, ActivationCodeCreator activationCodeCreator) {
        System.out.println("Wkladam beany do konstruktora MailCreator");
        this.messageCreator = messageCreator;
        this.activationCodeCreator = activationCodeCreator;

    }

    public String preapreMessageToSend(Booking booking) {
        String messageAboutCanceledFlight = messageCreator.createMessageAboutCanceledFlight(booking.getPassengerList().get(0).getSegmentList());
        String messageAboutNewFlight = messageCreator.createMessageAboutNewFlight(booking.getPassengerList().get(0).getSegmentList());
        String activationCode = activationCodeCreator.createActivationCode(booking.getPassengerList());

        String message = new String(messageAboutCanceledFlight + messageAboutNewFlight + ". Kod aktywacyjny nowego lotu to: " + activationCode);

        return message;
    }


}
