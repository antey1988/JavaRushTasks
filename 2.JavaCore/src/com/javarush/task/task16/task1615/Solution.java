package com.javarush.task.task16.task1615;

/* 
Аэропорт
*/

public class Solution {
    public static volatile Runway RUNWAY1 = new Runway();   //1 взлетная полоса
    public static volatile Runway RUNWAY2 = new Runway();   //2 взлетная полоса

    public static void main(String[] args) throws InterruptedException {
        Plane plane1 = new Plane("Самолет #1", 200);
//        Plane plane4 = new Plane("Самолет #4", 200);
        Plane plane2 = new Plane("Самолет #2");
        Plane plane3 = new Plane("Самолет #3");
        Plane plane5 = new Plane("Самолет #5");
    }

    private static void waiting() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    private static void takingOff(Plane plane) {
        //fix this method - исправь этот метод
        try {
            if (plane.tonaj > 100) Thread.sleep(300);
            else Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    public static class Plane extends Thread {
        private int tonaj;
        public Plane(String name) {
            super(name);
            start();
        }

        public Plane(String name, int tonaj) {
            super(name);
            this.tonaj = tonaj;
            start();
        }

        public void run() {
            boolean isAlreadyTakenOff = false;
            while (!isAlreadyTakenOff) {
                boolean fisrtRunwayIsFree = RUNWAY1.trySetTakingOffPlane(this);
                if (fisrtRunwayIsFree) {    //если 1 взлетная полоса свободна, занимаем ее
                    System.out.println(getName() + " взлетает с полосы 1");
                    takingOff(this);//взлетает
                    System.out.println(getName() + " уже в небе");
                    isAlreadyTakenOff = true;
                    RUNWAY1.setTakingOffPlane(null);
                    break;
                }

                boolean secondRunwayIsFree = RUNWAY2.trySetTakingOffPlane(this);
                if (secondRunwayIsFree) {    //если 2 взлетная полоса свободна, занимаем ее
                    System.out.println(getName() + " взлетает с полосы 2");
                    takingOff(this);//взлетает
                    System.out.println(getName() + " уже в небе");
                    isAlreadyTakenOff = true;
                    RUNWAY2.setTakingOffPlane(null);
                    break;
                }
//                если взлетные полосы заняты самолетами
                System.out.println(getName() + " ожидает");
                waiting(); //ожидает


                /*if (RUNWAY.trySetTakingOffPlane(this)) {    //если взлетная полоса свободна, занимаем ее
                    System.out.println(getName() + " взлетает");
                    takingOff();//взлетает
                    System.out.println(getName() + " уже в небе");
                    isAlreadyTakenOff = true;
                    RUNWAY.setTakingOffPlane(null);
                } else if (!this.equals(RUNWAY.getTakingOffPlane())) {  //если взлетная полоса занята самолетом
                    System.out.println(getName() + " ожидает");
                    waiting(); //ожидает
                }*/
            }
        }
    }

    public static class Runway { //взлетная полоса
        private Thread t;

        public Thread getTakingOffPlane() {
            return t;
        }

        public void setTakingOffPlane(Thread t) {
            synchronized (this) {
                this.t = t;
            }
        }

        public boolean trySetTakingOffPlane(Thread t) {
            synchronized (this) {
                if (this.t == null) {
                    this.t = t;
                    return true;
                }
                return false;
            }
        }
    }
}

