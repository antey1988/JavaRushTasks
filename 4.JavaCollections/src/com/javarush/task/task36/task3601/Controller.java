package com.javarush.task.task36.task3601;

import java.util.List;

public class Controller {
    private Model service = new Model();
    public List<String> onShowDataList() {
        return service.getStringDataList();
    }
}
