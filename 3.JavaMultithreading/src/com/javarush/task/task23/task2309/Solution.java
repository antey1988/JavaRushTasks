package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.util.List;


public class Solution {

    public List<User> getUsers() {
        AbstractDbSelectExecutor<User> abstractDbSelectExecutor = new AbstractDbSelectExecutor<User>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM USER";
            }
        };
        return abstractDbSelectExecutor.execute();
    }

    public List<Location> getLocations() {
        AbstractDbSelectExecutor<Location> abstractDbSelectExecutor = new AbstractDbSelectExecutor<Location>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM LOCATION";
            }
        };
        return abstractDbSelectExecutor.execute();
    }

    public List<Server> getServers() {
        AbstractDbSelectExecutor<Server> abstractDbSelectExecutor = new AbstractDbSelectExecutor<Server>() {
            @Override
            public String getQuery() {
                return null;
            }
        };
        return abstractDbSelectExecutor.execute();
    }

    public List<Subject> getSubjects() {
        AbstractDbSelectExecutor<Subject> abstractDbSelectExecutor = new AbstractDbSelectExecutor<Subject>() {
            @Override
            public String getQuery() {
                return null;
            }
        };
        return abstractDbSelectExecutor.execute();
    }

    public List<Subscription> getSubscriptions() {
        AbstractDbSelectExecutor<Subscription> abstractDbSelectExecutor = new AbstractDbSelectExecutor<Subscription>() {
            @Override
            public String getQuery() {
                return null;
            }
        };
        return abstractDbSelectExecutor.execute();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }
}
