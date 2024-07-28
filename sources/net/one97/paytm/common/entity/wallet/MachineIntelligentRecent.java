package net.one97.paytm.common.entity.wallet;

import net.one97.paytm.common.entity.IJRDataModel;

public class MachineIntelligentRecent implements IJRDataModel {
    private Location location = new Location();
    private Timeofday timeOfDay = new Timeofday();
    private weekday weekday = new weekday();

    public weekday getWeekday() {
        return this.weekday;
    }

    public Location getLocation() {
        return this.location;
    }

    public Timeofday getTimeOfDay() {
        return this.timeOfDay;
    }

    public static class Location implements IJRDataModel {
        private double Latitudeweight = 0.0d;
        private int LongitudeCount = 0;
        private double Longitudeweight = 0.0d;
        private int latitudeCount = 0;

        public double getLatitudeweight() {
            return this.Latitudeweight;
        }

        public void setLatitudeweight(double d2) {
            this.Latitudeweight = d2;
        }

        public int getLatitudeCount() {
            return this.latitudeCount;
        }

        public void setLatitudeCount(int i2) {
            this.latitudeCount = i2;
        }

        public double getLongitudeweight() {
            return this.Longitudeweight;
        }

        public void setLongitudeweight(double d2) {
            this.Longitudeweight = d2;
        }

        public int getLongitudeCount() {
            return this.LongitudeCount;
        }

        public void setLongitudeCount(int i2) {
            this.LongitudeCount = i2;
        }
    }

    public static class weekday implements IJRDataModel {
        private int fri = 0;
        private int mon = 0;
        private int sat = 0;
        private int sun = 0;
        private int thus = 0;
        private int tues = 0;
        private int wed = 0;

        public int getSun() {
            return this.sun;
        }

        public void setSun(int i2) {
            this.sun = i2;
        }

        public int getMon() {
            return this.mon;
        }

        public void setMon(int i2) {
            this.mon = i2;
        }

        public int getTues() {
            return this.tues;
        }

        public void setTues(int i2) {
            this.tues = i2;
        }

        public int getWed() {
            return this.wed;
        }

        public void setWed(int i2) {
            this.wed = i2;
        }

        public int getThus() {
            return this.thus;
        }

        public void setThus(int i2) {
            this.thus = i2;
        }

        public int getFri() {
            return this.fri;
        }

        public void setFri(int i2) {
            this.fri = i2;
        }

        public int getSat() {
            return this.sat;
        }

        public void setSat(int i2) {
            this.sat = i2;
        }

        public void updateweekdaycount(weekday weekday, int i2) {
            if (i2 == 1) {
                weekday.setSun(weekday.getSun() + 1);
            } else if (i2 == 2) {
                weekday.setMon(weekday.getMon() + 1);
            } else if (i2 == 3) {
                weekday.setTues(weekday.getTues() + 1);
            } else if (i2 == 4) {
                weekday.setWed(weekday.getWed() + 1);
            } else if (i2 == 5) {
                weekday.setThus(weekday.getThus() + 1);
            } else if (i2 == 6) {
                weekday.setFri(weekday.getFri() + 1);
            } else if (i2 == 7) {
                weekday.setSat(weekday.getSat() + 1);
            }
        }
    }

    public static class Timeofday implements IJRDataModel {
        private int timeOfDayCount = 0;
        private double timeOfDayweight;

        public double getTimeOfDayweight() {
            return this.timeOfDayweight;
        }

        public void setTimeOfDayweight(double d2) {
            this.timeOfDayweight = d2;
        }

        public int getTimeOfDayCount() {
            return this.timeOfDayCount;
        }

        public void setTimeOfDayCount(int i2) {
            this.timeOfDayCount = i2;
        }
    }
}
