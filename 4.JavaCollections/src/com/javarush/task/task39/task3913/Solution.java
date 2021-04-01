package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

public class Solution {
    public static void main(String[] args)  {
//        LogParser logParser = new LogParser(Paths.get("c:/logs/"));
        LogParser logParser =
                new LogParser(Paths.get(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task39/task3913/logs/"));
        /*System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
        System.out.println(logParser.getIPsForStatus(Status.FAILED, null, null));
        System.out.println(logParser.getIPsForEvent(Event.SOLVE_TASK,null, null));*/

       /* System.out.println(logParser.getAllUsers());
        System.out.println(logParser.getNumberOfUsers(new Date(2013 - 1900,01,01), new Date()));
        System.out.println(logParser.getNumberOfUsers(null,null));
        System.out.println(logParser.getNumberOfUserEvents("Vasya Pupkin", new Date(2012 - 1900,01,01), new Date()));
        System.out.println(logParser.getNumberOfUserEvents("Vasya Pupkin",null, null));
        System.out.println(logParser.getNumberOfUserEvents("AF Pupkin",null, null));
        System.out.println(logParser.getUsersForIP("127.0.0.1",new Date(), null));

        System.out.println(logParser.getLoggedUsers(new Date(), null));
        System.out.println(logParser.getLoggedUsers( null, new Date()));
        System.out.println(logParser.getLoggedUsers( null, null));

        System.out.println(logParser.getDownloadedPluginUsers(new Date(), null));
        System.out.println(logParser.getDownloadedPluginUsers( null, new Date()));
        System.out.println(logParser.getDownloadedPluginUsers( null, null));

        System.out.println(logParser.getWroteMessageUsers(new Date(), null));
        System.out.println(logParser.getWroteMessageUsers( null, new Date()));
        System.out.println(logParser.getWroteMessageUsers( null, null));

        System.out.println(logParser.getSolvedTaskUsers(new Date(), null));
        System.out.println(logParser.getSolvedTaskUsers( null, new Date()));
        System.out.println(logParser.getSolvedTaskUsers( null, null));

        System.out.println(logParser.getSolvedTaskUsers(new Date(), null, 1));
        System.out.println(logParser.getSolvedTaskUsers( null, new Date(), 1));
        System.out.println(logParser.getSolvedTaskUsers( null, null, 1));

        System.out.println(logParser.getDateWhenUserDoneTask("Eduard Petrovich Morozko", 48, null, null));*/

        /*System.out.println(logParser.getNumberOfAllEvents(new Date(), null));
        System.out.println(logParser.getNumberOfAllEvents( null, new Date()));
        System.out.println(logParser.getNumberOfAllEvents( null, null));
        System.out.println();
        System.out.println(logParser.getAllEvents(new Date(), null));
        System.out.println(logParser.getAllEvents( null, new Date()));
        System.out.println(logParser.getAllEvents( null, null));
        System.out.println();
        System.out.println(logParser.getEventsForIP("127.0.0.1", new Date(), null));
        System.out.println(logParser.getEventsForIP( "127.0.0.1", null, new Date()));
        System.out.println(logParser.getEventsForIP( "127.0.0.1", null, null));
        System.out.println();
        System.out.println(logParser.getEventsForUser("Amigo", new Date(), null));
        System.out.println(logParser.getEventsForUser( "Amigo", null, new Date()));
        System.out.println(logParser.getEventsForUser( "Amigo", null, null));
        System.out.println();
        System.out.println(logParser.getFailedEvents(new Date(), null));
        System.out.println(logParser.getFailedEvents( null, new Date()));
        System.out.println(logParser.getFailedEvents( null, null));
        System.out.println();
        System.out.println(logParser.getErrorEvents(new Date(), null));
        System.out.println(logParser.getErrorEvents( null, new Date()));
        System.out.println(logParser.getErrorEvents( null, null));
        System.out.println();
        System.out.println(logParser.getAllSolvedTasksAndTheirNumber(new Date(), null));
        System.out.println(logParser.getAllSolvedTasksAndTheirNumber( null, new Date()));
        System.out.println(logParser.getAllSolvedTasksAndTheirNumber( null, null));

        System.out.println();
        System.out.println(logParser.getNumberOfAttemptToSolveTask(18,new Date(), null));
        System.out.println(logParser.getNumberOfAttemptToSolveTask(18, null, new Date()));
        System.out.println(logParser.getNumberOfAttemptToSolveTask(18, null, null));

        System.out.println();
        System.out.println(logParser.getNumberOfSuccessfulAttemptToSolveTask(15,new Date(), null));
        System.out.println(logParser.getNumberOfSuccessfulAttemptToSolveTask(15, null, new Date()));
        System.out.println(logParser.getNumberOfSuccessfulAttemptToSolveTask(15, null, null));*/

//        System.out.println(Arrays.toString("get ip for user = \"dfgd\" and date between \"dgd\" and \"dgd\"".split("\"")));

        /*System.out.println(logParser.execute("get ip"));
        System.out.println(logParser.execute("get user"));
        System.out.println(logParser.execute("get date"));
        System.out.println(logParser.execute("get event"));
        System.out.println(logParser.execute("get status"));*/
        /*System.out.println(logParser.execute("get ip for user = \"Amigo\""));
        System.out.println(logParser.execute("get date for user = \"Amigo\""));
        System.out.println(logParser.execute("get event for user = \"Amigo\""));
        System.out.println(logParser.execute("get status for user = \"Amigo\""));*/

        /*System.out.println(logParser.execute("get user for ip = \"127.0.0.1\""));
        System.out.println(logParser.execute("get date for ip = \"127.0.0.1\""));
        System.out.println(logParser.execute("get event for ip = \"127.0.0.1\""));
        System.out.println(logParser.execute("get status for ip = \"127.0.0.1\""));*/

        /*System.out.println(logParser.execute("get ip for date = \"30.01.2014 12:56:22\""));
        System.out.println(logParser.execute("get user for date = \"30.01.2014 12:56:22\""));
        System.out.println(logParser.execute("get event for date = \"30.01.2014 12:56:22\""));
        System.out.println(logParser.execute("get status for date = \"30.01.2014 12:56:22\""));

        System.out.println(logParser.execute("get ip for event = \"SOLVE_TASK\""));
        System.out.println(logParser.execute("get user for event = \"SOLVE_TASK\""));
        System.out.println(logParser.execute("get date for event = \"SOLVE_TASK\""));
        System.out.println(logParser.execute("get status for event = \"SOLVE_TASK\""));

        System.out.println(logParser.execute("get ip for status = \"OK\""));
        System.out.println(logParser.execute("get user for status = \"OK\""));
        System.out.println(logParser.execute("get date for status = \"OK\""));
        System.out.println(logParser.execute("get event for status = \"OK\""));*/

//        System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
        System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2001 0:00:00\" and \"03.01.2022 23:59:59\""));
        System.out.println(logParser.execute("get date for user = \"Amigo\" and date between \"11.12.2001 0:00:00\" and \"03.01.2022 23:59:59\""));
        System.out.println(logParser.execute("get event for user = \"Amigo\" and date between \"11.12.2001 0:00:00\" and \"03.01.2022 23:59:59\""));
        System.out.println(logParser.execute("get status for user = \"Amigo\" and date between \"11.12.2001 0:00:00\" and \"03.01.2022 23:59:59\""));
        System.out.println();
        System.out.println(logParser.execute("get user for ip = \"127.0.0.1\" and date between \"11.12.2001 0:00:00\" and \"03.01.2022 23:59:59\""));
        System.out.println(logParser.execute("get date for ip = \"127.0.0.1\" and date between \"11.12.2001 0:00:00\" and \"14.10.2021 11:38:21\""));
        System.out.println(logParser.execute("get event for ip = \"127.0.0.1\" and date between \"11.12.2001 0:00:00\" and \"03.01.2022 23:59:59\""));
        System.out.println(logParser.execute("get status for ip = \"127.0.0.1\" and date between \"11.12.2001 0:00:00\" and \"03.01.2022 23:59:59\""));
        System.out.println();
        System.out.println(logParser.execute("get user for date = \"12.12.2013 21:56:30\" and date between \"11.12.2001 0:00:00\" and \"03.01.2022 23:59:59\""));
        System.out.println(logParser.execute("get ip for date = \"12.12.2013 21:56:30\" and date between \"11.12.2001 0:00:00\" and \"14.10.2021 11:38:21\""));
        System.out.println(logParser.execute("get event for date = \"12.12.2013 21:56:30\" and date between \"11.12.2001 0:00:00\" and \"03.01.2022 23:59:59\""));
        System.out.println(logParser.execute("get status for date = \"12.12.2013 21:56:30\" and date between \"11.12.2001 0:00:00\" and \"03.01.2022 23:59:59\""));
        System.out.println();
        System.out.println(logParser.execute("get user for event = \"DONE_TASK\" and date between \"11.12.2001 0:00:00\" and \"03.01.2022 23:59:59\""));
        System.out.println(logParser.execute("get ip for event = \"DONE_TASK\" and date between \"11.12.2001 0:00:00\" and \"14.10.2021 11:38:21\""));
        System.out.println(logParser.execute("get date for event = \"DONE_TASK\" and date between \"11.12.2001 0:00:00\" and \"03.01.2022 23:59:59\""));
        System.out.println(logParser.execute("get status for event = \"DONE_TASK\" and date between \"11.12.2001 0:00:00\" and \"03.01.2022 23:59:59\""));
        System.out.println();
        System.out.println(logParser.execute("get user for status = \"OK\" and date between \"11.12.2001 0:00:00\" and \"03.01.2022 23:59:59\""));
        System.out.println(logParser.execute("get ip for status = \"OK\" and date between \"11.12.2001 0:00:00\" and \"14.10.2021 11:38:21\""));
        System.out.println(logParser.execute("get date for status = \"OK\" and date between \"11.12.2001 0:00:00\" and \"03.01.2022 23:59:59\""));
        System.out.println(logParser.execute("get event for status = \"OK\" and date between \"11.12.2001 0:00:00\" and \"03.01.2022 23:59:59\""));
        System.out.println();

//        System.out.println(new Date(logParser.StringToDate("01.01.1970 03:00:00").getTime() + 1));

    }
}