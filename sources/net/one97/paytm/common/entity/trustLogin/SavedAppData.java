package net.one97.paytm.common.entity.trustLogin;

import java.io.Serializable;
import java.util.ArrayList;

public class SavedAppData implements Serializable {
    ArrayList<BuildDataList> data;

    public ArrayList<BuildDataList> getData() {
        return this.data;
    }

    public class BuildDataList implements Serializable {
        ArrayList<AppData> app_data;
        String build_variant;

        public BuildDataList() {
        }

        public String getBuildvariant() {
            return this.build_variant;
        }

        public ArrayList<AppData> getApp_data() {
            return this.app_data;
        }
    }

    public class AppData implements Serializable {
        String app_client_id;
        String app_name;
        String app_package_name;
        String sha1_signature;

        public AppData() {
        }

        public String getApp_name() {
            return this.app_name;
        }

        public String getApp_package_name() {
            return this.app_package_name;
        }

        public String getApp_client_id() {
            return this.app_client_id;
        }

        public String getSha1_signature() {
            return this.sha1_signature;
        }
    }
}
