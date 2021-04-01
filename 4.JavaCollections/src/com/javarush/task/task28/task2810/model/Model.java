package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.view.View;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private View view;
    private Provider[] providers;

    public Model(View view, Provider ... providers) {
        if (view == null) throw new IllegalArgumentException();
        if (providers== null || providers.length == 0) throw new IllegalArgumentException();

        this.view = view;
        this.providers = providers;
    }

    public void selectCity(String city) {
        List<Vacancy> vacancies = Arrays.stream(providers)
                .flatMap(provider -> provider.getJavaVacancies(city).stream())
                .collect(Collectors.toList());
        view.update(vacancies);
    }
}
