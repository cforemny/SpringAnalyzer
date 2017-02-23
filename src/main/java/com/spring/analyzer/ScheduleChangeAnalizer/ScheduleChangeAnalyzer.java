package com.spring.analyzer.ScheduleChangeAnalizer;

import com.spring.analyzer.ScheduleChangeAnalizer.Mail.MailSender;
import com.spring.analyzer.ScheduleChangeAnalizer.Schedule.ChangedSchedule;
import com.spring.analyzer.util.Analyzer;
import com.spring.structure.booking.Booking;
import com.spring.structure.booking.Passenger;
import com.spring.structure.booking.Booking;
import org.apache.log4j.Logger;

/**
 * Created by Cyprian on 2017-02-07.
 */
public class ScheduleChangeAnalyzer implements Analyzer {

    private MailSender mailSender;
    private Logger logger = Logger.getLogger(ScheduleChangeAnalyzer.class);
    private PrzykladowyPrzygotowywacz przykladowyPrzygotowywacz;
    private ChangedSchedule changedSchedule;

    public ScheduleChangeAnalyzer(MailSender mailSender, PrzykladowyPrzygotowywacz przykladowyPrzygotowywacz, ChangedSchedule changedSchedule) {
        System.out.println("Wkladam do kosntruktora ScheduleChangeAnalyzera Beany mailSender, przykladowy przygvotowywacz i changedSchedule");
        this.mailSender = mailSender;
        this.przykladowyPrzygotowywacz = przykladowyPrzygotowywacz;
        this.changedSchedule = changedSchedule;
    }

    @Override
    public void analyze(Booking booking) {
        if (booking != null) {
            for (Passenger passenger : booking.getPassengerList()) {
                if (changedSchedule.findSegmentInformation(passenger.getSegmentList())) {
                    Wrapper wrapper = przykladowyPrzygotowywacz.przygotujPaczke(booking);

                    mailSender.preapreAndSendEmailToAllPassangersFromCanceledSegment(wrapper);
                    logger.info("Poszlo");
                    return;
                } else
                    logger.info("Nie znaleziono zadnych anulowanych lotow.");
            }

        } else {
            logger.info("Nullowy booking! Nieakceptowalne!");
        }
    }


}

