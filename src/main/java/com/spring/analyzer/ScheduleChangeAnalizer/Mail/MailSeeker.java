package com.spring.analyzer.ScheduleChangeAnalizer.Mail;

import com.spring.analyzer.ScheduleChangeAnalizer.Schedule.ChangedSchedule;
import com.spring.structure.booking.Passenger;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * Created by Cyprian on 2017-01-31.
 */
public class MailSeeker {

    private MailSpliter mailSpliter;
    private ChangedSchedule changedSchedule;


    public MailSeeker(MailSpliter mailSpliter, ChangedSchedule changedSchedule) {
        System.out.println("Wkladam beany do konstruktora mailSeekera");
        this.mailSpliter = mailSpliter;
        this.changedSchedule = changedSchedule;
    }

    public String findMail(Passenger passenger) {
        if (changedSchedule.findSegmentInformation(passenger.getSegmentList())) {
            for (String passengerInformation : passenger.getPassengerInformation()) {
                if (passengerInformation.contains("mail"))
                    return mailSpliter.findMailInformatiom(passengerInformation);
            }
        }
        LOGGER.info("Bledny email");
        return null;
    }

}
