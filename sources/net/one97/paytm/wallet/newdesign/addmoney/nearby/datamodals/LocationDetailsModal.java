package net.one97.paytm.wallet.newdesign.addmoney.nearby.datamodals;

import java.io.Serializable;

public class LocationDetailsModal implements Serializable {
    public String address;
    public Results result;
    public String status;

    public class Results implements Serializable {
        public Geometry geometry;

        public Results() {
        }
    }

    public class Geometry implements Serializable {
        public Locations location;
        public String place_id;
        public ViewPort viewport;

        public Geometry() {
        }
    }

    public class ViewPort implements Serializable {
        public Locations northeast;
        public Locations southwest;

        public ViewPort() {
        }
    }

    public class Locations implements Serializable {
        public String lat;
        public String lng;

        public Locations() {
        }
    }
}
