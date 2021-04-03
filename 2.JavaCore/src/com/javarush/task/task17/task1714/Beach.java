package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    @Override
    public synchronized int compareTo(Beach o) {
        return this.quality - o.quality - (int)(this.distance - o.distance);
    }



    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach firstBeach = new Beach("1", (float) 10.5, 5);
        Beach secondBeach = new Beach("2", (float) 10.0, 1);
        System.out.println(firstBeach.compareTo(secondBeach));
        System.out.println(secondBeach.compareTo(firstBeach));
    }
}
