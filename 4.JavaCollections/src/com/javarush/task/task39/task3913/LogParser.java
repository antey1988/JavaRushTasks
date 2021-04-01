package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.*;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path logDir;
    private List<LogEvent> logs = new ArrayList<>();

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    private static class LogEvent {
        String IP;
        String user;
        Date date;
        Event event;
        int number;
        Status status;

        public LogEvent(String IP, String user, Date date, Event event, int number, Status status) {
            this.IP = IP;
            this.user = user;
            this.date = date;
            this.number = number;
            this.event = event;
            this.status = status;
        }
    }
    //парсинг лога в список объектов LogEvent
    private void LogsToList() {
        logs.clear();
        File[] files = logDir.toFile().listFiles();
        for (File file : files) {
            if (file.getName().endsWith(".log")) {
                try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
                    String string;
                    while ((string = br.readLine()) != null) {
                        String[] words = string.split("\\s");
                        int lastindex = words.length -1 ;
                        Status st = StringToStatus(words[lastindex]);
                        lastindex--;

                        int num;
                        try {
                            num = Integer.parseInt(words[lastindex]);
                            lastindex--;
                        } catch (NumberFormatException e) {
                            num = -1;
                        }

                        Event ev = StringToEvent(words[lastindex]);
                        lastindex--;

                        String DateTime = words[lastindex-1] + " " + words[lastindex];
                        Date date = StringToDate(DateTime);
                        lastindex -= 2;

                        String user = words[1];
                        for(int i = 2; i <= lastindex; i++) {
                            user += " " + words[i];
                        }

                        logs.add(new LogEvent(words[0], user, date, ev, num, st));
                    }
                } catch (IOException e) {
                    System.out.println("Не возможнос прочесть данные из файла");
                }
            }
        }
    }

    //формирование списка событий удовлетвоящие всем фильтрам
    private List<LogEvent> FilterForIPUserEventTaskStatusDate(String ip, String user, Event event, int task, Status status, Date after, Date before) {
        if (logs.isEmpty()) LogsToList();
        List<LogEvent> filterlogs = new ArrayList<>();
        Date date_after = (after == null) ? new Date(0, 0, 1) : after;
        Date date_before = (before == null) ? new Date(1000, 0, 1) : before;

        for (LogEvent logevent : logs) {
            boolean ThisIp = (ip == null || ip.equals(logevent.IP));
            boolean ThisUser = (user == null || user.equals(logevent.user));
            boolean ThisEvent = (event == null || event.equals(logevent.event));
            boolean ThisTask = (task == -1 || task == logevent.number);
            boolean ThisStatus = (status == null || status.equals(logevent.status));

            if (ThisTask && ThisEvent && ThisStatus && ThisIp && ThisUser) {
                /*if (!ldt_after.isAfter(logevent.date) && !ldt_before.isBefore(logevent.date)) {
                    dates.add(Date.from(logevent.date.atZone(ZoneId.systemDefault()).toInstant()));
                }*/
                if (after == null && before == null) filterlogs.add(logevent);
                else if(after == null && !date_before.before(logevent.date)) filterlogs.add(logevent);
                else if(before == null && !date_after.after(logevent.date)) filterlogs.add(logevent);
                else if(!date_after.after(logevent.date) && !date_before.before(logevent.date)) filterlogs.add(logevent);
            }
        }
        return filterlogs;
    }




    //интерфейс IPQUery
    private Set<String> IPbyFilter(String user, Event event, Status status, Date after, Date before) {
        Set<String> ip = new TreeSet<>();
        for (LogEvent logEvent : FilterForIPUserEventTaskStatusDate(null, user, event, -1, status, after, before)) {
            ip.add(logEvent.IP);
        }
        return ip;
    }

    private Set<String> getAllIps() {
        return IPbyFilter(null, null, null, null, null);
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return IPbyFilter(null, null, null, after, before);
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return IPbyFilter(user, null, null, after, before);
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return IPbyFilter(null, event, null, after, before);
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return IPbyFilter(null, null, status, after, before);
    }




    //интерфейс UserQuery
    private Set<String> UserbyFilter(String ip, Event event, int task, Status status, Date after, Date before) {
        Set<String> user = new TreeSet<>();
        for (LogEvent logEvent : FilterForIPUserEventTaskStatusDate(ip, null, event, task, status, after, before)) {
            user.add(logEvent.user);
        }
        return user;
    }

    @Override
    public Set<String> getAllUsers() {
        return UserbyFilter(null, null, -1, null, null, null);
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return UserbyFilter(null, null, -1, null, after, before).size();
    }

    private Set<String> getUsersForDate(Date after, Date before) {
        return UserbyFilter(null, null, -1, null, after, before);
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<String> eventtask = new TreeSet<>();
        for (LogEvent logEvent : FilterForIPUserEventTaskStatusDate(null, user, null, -1, null, after, before)) {
            eventtask.add("" + logEvent.event + logEvent.number);
        }
        return eventtask.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return UserbyFilter(ip, null, -1, null, after, before);
    }


    private Set<String> getUsersForEvent(Event event, int task, Date after, Date before) {
        return UserbyFilter(null, event, task, null, after, before);
    }

    private Set<String> getUsersForStatus(Status status, Date after, Date before) {
        return UserbyFilter(null, null, -1, status, after, before);
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return getUsersForEvent(Event.LOGIN, - 1, after, before);
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return getUsersForEvent(Event.DOWNLOAD_PLUGIN, -1, after, before);
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return getUsersForEvent(Event.WRITE_MESSAGE, -1, after, before);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return getUsersForEvent(Event.SOLVE_TASK, -1, after, before);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return getUsersForEvent(Event.SOLVE_TASK, task, after, before);
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return getUsersForEvent(Event.DONE_TASK, -1, after, before);
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return getUsersForEvent(Event.DONE_TASK, task, after, before);
    }




    //интерфейс DateQuery
    private Set<Date> DatebyFilter(String ip, String user, Event event, int task, Status status, Date after, Date before) {
        Set<Date> dates = new TreeSet<>();
        for (LogEvent logEvent : FilterForIPUserEventTaskStatusDate(ip, user, event, task, status, after, before)) {
            dates.add(logEvent.date);
        }
        return dates;
    }

    private Set<Date> getAllDates() {
        return DatebyFilter(null, null,null,-1,null,null,null);
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return DatebyFilter(null, user, event, -1, null, after, before);
    }

    private Set<Date> getDatesForIp(String ip, Date after, Date before) {
        return DatebyFilter(ip, null, null, -1, null, after, before);
    }

    private Set<Date> getDatesForStatus(Status status, Date after, Date before) {
        return DatebyFilter(null, null, null, -1, status, after, before);
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return DatebyFilter(null,null, null, -1, Status.FAILED, after, before);
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return DatebyFilter(null, null, null, -1, Status.ERROR, after, before);
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Set<Date> dates = DatebyFilter(null, user, Event.LOGIN, -1, Status.OK, after, before);
        if (!dates.isEmpty()) return dates.iterator().next();
        else return null;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Set<Date> dates = DatebyFilter(null, user, Event.SOLVE_TASK, task, null, after, before);
        if (!dates.isEmpty()) return dates.iterator().next();
        else return null;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Set<Date> dates = DatebyFilter(null, user, Event.DONE_TASK, task, null, after, before);
        if (!dates.isEmpty()) return dates.iterator().next();
        else return null;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return DatebyFilter(null, user, Event.WRITE_MESSAGE, -1, Status.OK, after, before);
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return DatebyFilter(null, user, Event.DOWNLOAD_PLUGIN, -1, Status.OK, after, before);
    }




    //интерфейс EventQuery
    private Set<Event> EventbyFilter(String ip, String user, int task, Status status, Date after, Date before) {
        Set<Event> events = new TreeSet<>();
        for (LogEvent logEvent : FilterForIPUserEventTaskStatusDate(ip, user, null, task, status, after, before)) {
            events.add(logEvent.event);
        }
        return events;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return EventbyFilter(null, null, -1, null, after, before);
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return EventbyFilter(ip, null, -1, null, after, before);
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return EventbyFilter(null, user, -1, null, after, before);
    }

    private Set<Event> getEventsForStatus(Status status, Date after, Date before) {
        return EventbyFilter(null, null, -1, status, after, before);
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return EventbyFilter(null, null, -1, Status.FAILED, after, before);
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return EventbyFilter(null, null, -1, Status.ERROR, after, before);
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int n;
        try {
            n = getAllSolvedTasksAndTheirNumber(after, before).get(task);
        } catch (NullPointerException e) {
            n = 0;
        }
        return n;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int n;
        try {
            n = getAllDoneTasksAndTheirNumber(after, before).get(task);
        } catch (NullPointerException e) {
            n = 0;
        }
        return n;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> tasks = new HashMap<>();
        for (LogEvent logEvent : FilterForIPUserEventTaskStatusDate(null, null, Event.SOLVE_TASK, -1, null, after, before)) {
            int count;
            try {
                count = tasks.get(logEvent.number);
                count++;
            } catch (NullPointerException e) {
                count = 1;
            }
            tasks.put(logEvent.number, count);
        }
        return tasks;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> tasks = new HashMap<>();
        for (LogEvent logEvent : FilterForIPUserEventTaskStatusDate(null, null, Event.DONE_TASK, -1, null, after, before)) {
            int count;
            try {
                count = tasks.get(logEvent.number);
                count++;
            } catch (NullPointerException e) {
                count = 1;
            }
            tasks.put(logEvent.number, count);
        }
        return tasks;
    }

    //
    private Set<Status> StatusbyFilter(String ip, String user, Event event,  Date after, Date before) {
        Set<Status> status = new TreeSet<>();
        for (LogEvent logEvent : FilterForIPUserEventTaskStatusDate(ip, user, event, -1, null, after, before)) {
            status.add(logEvent.status);
        }
        return status;
    }


    //
    private Set<Status> getStatusForDate(Date after, Date before) {
        return StatusbyFilter(null, null, null, after, before);
    }

    private Set<Status> getStatusForIp(String ip, Date after, Date before) {
        return StatusbyFilter(ip, null, null, after, before);
    }

    private Set<Status> getStatusForUser(String user, Date after, Date before) {
        return StatusbyFilter(null, user, null, after, before);
    }

    private Set<Status> getStatusForEvent(Event event, Date after, Date before) {
        return StatusbyFilter(null, null, event, after, before);
    }

    //QLQuery
    @Override
    public Set<Object> execute(String query) {
        Set<? extends Object> set = null;
        String[] words = query.split("\"");
        if (words.length == 1) {
            set = executeAll(query);
        }
        else if (words.length == 2 || words.length == 6) {
            set = executeParam(query);
        }
        return (Set<Object>) set;
    }

    private Set<Object> executeParam(String query) {
        Set<? extends Object> set = null;
        String[] words = query.split("\"");
        String value = words[1];
        Date after;
        Date before;
        try {
            after = StringToDate(words[3]);
            before = StringToDate(words[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            after = null;
            before = null;
        }
        words = words[0].split("\\s");
        if (words.length != 5) {
            System.out.println("Не верно введен аргумент функции. " +
                    "Формат аргумента должен иметь следующий вид get field1 for field2 = \"value1\"");
            return (Set<Object>) set;
        }
        String field1 = words[1];
        String field2 = words[3];
        if (field1.equals("ip")) {
            if (field2.equals("user")) {
                set = getIPsForUser(value, after, before);
            } else if (field2.equals("date")) {
                Date date = StringToDate(value);
                if ((after == null && before == null) || (date.after(after) && date.before(before))) {
                   set = getUniqueIPs(date, date);
                }
            } else if (field2.equals("event")) {
                Event event = StringToEvent(value);
                set = getIPsForEvent(event, after, before);
            } else if (field2.equals("status")) {
                Status status = StringToStatus(value);
                set = getIPsForStatus(status, after, before);
            }
        } else if (field1.equals("user")) {
            if (field2.equals("ip")) {
                set = getUsersForIP(value, after, before);
            } else if (field2.equals("date")) {
                Date date = StringToDate(value);
                if ((after == null && before == null) || (date.after(after) && date.before(before))) {
                    set = getUsersForDate(date, date);
                }
            } else if (field2.equals("event")) {
                Event event = StringToEvent(value);
                set = getUsersForEvent(event,-1, after, before);
            } else if (field2.equals("status")) {
                Status status = StringToStatus(value);
                set = getUsersForStatus(status,after, before);
            }
        } else if (field1.equals("date")) {
            if (field2.equals("ip")) {
                set = getDatesForIp(value, after, before);
            } else if (field2.equals("user")) {
                set = getDatesForUserAndEvent(value, null, after, before);
            } else if (field2.equals("event")) {
                Event event = StringToEvent(value);
                set = getDatesForUserAndEvent(null, event, after, before);
            } else if (field2.equals("status")) {
                Status status = StringToStatus(value);
                set = getDatesForStatus(status, after, before);
            }
        } else if (field1.equals("event")) {
            if (field2.equals("ip")) {
                set = getEventsForIP(value, after, before);
            } else if (field2.equals("user")) {
                set = getEventsForUser(value, after, before);
            } else if (field2.equals("date")) {
                Date date = StringToDate(value);
                if ((after == null && before == null) || (date.after(after) && date.before(before))) {
                    set = getAllEvents(date,date);
                }
            } else if (field2.equals("status")) {
                Status status = StringToStatus(value);
                set = getEventsForStatus(status,after, before);
            }
        } else if (field1.equals("status")) {
            if (field2.equals("ip")) {
                set = getStatusForIp(value, after, before);
            } else if (field2.equals("user")) {
                set = getStatusForUser(value, after, before);
            } else if (field2.equals("date")) {
                Date date = StringToDate(value);
                if ((after == null && before == null) || (date.after(after) && date.before(before))) {
                    set = getStatusForDate(date,date);
                }
            } else if (field2.equals("event")) {
                Event event = StringToEvent(value);
                set = getStatusForEvent(event,after, before);
            }
        }
        return (Set<Object>) set;
    }

    public Date StringToDate(String string) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date date = null;
//        LocalDateTime ldt = null;
        try {
            date = sdf.parse(string);
//            ldt = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        }  catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    private Event StringToEvent(String string) {
        Event ev;
        switch (string) {
            case "LOGIN":
                ev = Event.LOGIN;
                break;
            case "DOWNLOAD_PLUGIN":
                ev = Event.DOWNLOAD_PLUGIN;
                break;
            case "WRITE_MESSAGE":
                ev = Event.WRITE_MESSAGE;
                break;
            case "SOLVE_TASK":
                ev = Event.SOLVE_TASK;
                break;
            case "DONE_TASK":
                ev = Event.DONE_TASK;
                break;
            default:
                ev = null;
        }
        return  ev;
    }
    private Status StringToStatus(String string) {
        Status st;
        switch (string) {
            case "OK":
                st = Status.OK;
                break;
            case "FAILED":
                st = Status.FAILED;
                break;
            case "ERROR":
                st = Status.ERROR;
                break;
            default:
                st = null;
        }
        return st;
    }

    private Set<Object> executeAll(String query) {
        Set<? extends Object> set;
        switch (query) {
            case "get ip":
                set = getAllIps();
                break;
            case "get user":
                set = getAllUsers();
                break;
            case "get date":
                set = getAllDates();
                break;
            case "get event":
                set = getAllEvents(null, null);
                break;
            case "get status":
                set = getStatusForDate(null, null);
                break;
            default: set = null;
        }
        return (Set<Object>) set;
    }
}