package com.spring.analyzer.ScheduleChangeAnalizer.activationCode;

import com.spring.analyzer.ScheduleChangeAnalizer.Schedule.ChangedSchedule;
import com.spring.structure.booking.Passenger;

import java.util.List;

/**
 * Created by Cyprian on 2017-02-09.
 */
public class ActivationCodeCreator {


    private ChangedSchedule changedSchedule;
    private NameFirstLetter nameFirstLetter;
    private StringBuilder activationCode;


    public ActivationCodeCreator(ChangedSchedule changedSchedule, NameFirstLetter nameFirstLetter, StringBuilder activationCode) {
        System.out.println("Wkladam beany do construktora ActivationCodeCreator");
        this.changedSchedule = changedSchedule;
        this.nameFirstLetter = nameFirstLetter;
        this.activationCode = activationCode;
    }

    public String createActivationCode(List<Passenger> passengerList) {

        for (Passenger passenger : passengerList) {
            if (changedSchedule.findSegmentInformation(passenger.getSegmentList())) {
                char firstLetterOfPassengersName = nameFirstLetter.getFirstletterOfPassengersName(passenger);
                activationCode.append(firstLetterOfPassengersName);

            }

        }
        String activationCodeAsString = activationCode.toString();
        return activationCodeAsString;
    }
}
