package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements  Strategy {

    //    private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data2.html";
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();

        int page = 0;

        try {
            while (true) {
                Document document = getDocument(searchString, page);

                Elements elements = document.getElementsByClass("job");
//                if (elements.size() == 0) break;
                if (elements.isEmpty()) break;

                for (Element element : elements) {

                    Elements links = element.getElementsByClass("title").get(0).getElementsByTag("a");
                    Elements locations = element.getElementsByClass("location");
                    Elements company = element.getElementsByClass("companyName");
                    Elements salary = element.getElementsByClass("count");

                    Vacancy vacancy = new Vacancy();
                    vacancy.setSiteName("moikrug.ru");
                    vacancy.setTitle(links.get(0).text());
                    vacancy.setUrl("http://moikrug.ru" + links.get(0).attr("href"));
                    vacancy.setCity(locations.size() > 0 ? locations.get(0).text() : "");
                    vacancy.setCompanyName(company.get(0).text());
                    vacancy.setSalary(salary.size() > 0 ?salary.get(0).text() : "");

                    vacancies.add(vacancy);
                }
                page++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.62 Safari/537.36")
                .referrer("http://moikrug.ru/")
                .get();
    }
}

