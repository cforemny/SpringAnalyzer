package com.spring;

import com.spring.analyzer.ScheduleChangeAnalizer.ScheduleChangeAnalyzer;
import com.spring.factory.BookingFactory;
import com.spring.structure.booking.Booking;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        ScheduleChangeAnalyzer scheduleChangeAnalyzer = (ScheduleChangeAnalyzer) context.getBean("scheduleChangeAnalyzer");
        Booking bookingForSCAnalyzer = BookingFactory.createBookingForSCAnalyzer();
        scheduleChangeAnalyzer.analyze(bookingForSCAnalyzer);


    }
}
