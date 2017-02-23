package com.spring.analyzer.ScheduleChangeAnalizer.Schedule;

import com.spring.structure.booking.Segment;

import java.util.List;

/**
 * Created by Cyprian on 2017-02-01.
 */
public class ChangedSchedule {

    public static final String SCHEDULE_CHANGE = "Schedule Change";

    public boolean findSegmentInformation(List<Segment> segmentList) {
        for (Segment segment : segmentList) {

            for (String segmentInformation : segment.getSegmentInformation()) {
                if (segmentInformation.equals(SCHEDULE_CHANGE)) {
                    return true;
                }
            }
        }
        return false;

    }
}
