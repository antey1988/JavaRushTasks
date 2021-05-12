package com;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parser {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://yandex.ru/")
                .userAgent("Chrome/87.0.4280.88")
                .referrer("http://www.google.com")
                .get();
//        Elements listNews = doc.select("div#wd-_topnews-1.b-widget-data.b-wrapper.b-wrapper-");
        Elements listNews = doc.select(".news__panels.mix-tabber-slide2__panels");
        for (Element element : listNews.select("a")) {
            System.out.println(element.text());
        }
    }
}
