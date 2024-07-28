package com.alipay.mobile.nebulaappcenter.dbbean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "nebula_app_install")
public class H5AppInstallBean {
    public static final String COL_APP_ID = "install_appId";
    @DatabaseField
    private String installPath;
    @DatabaseField
    private String install_appId;
    @DatabaseField(generatedId = true, index = true, unique = true)
    private int install_id;
    @DatabaseField
    private String install_version;

    public String getInstallPath() {
        return this.installPath;
    }

    public void setInstallPath(String str) {
        this.installPath = str;
    }

    public String getInstall_appId() {
        return this.install_appId;
    }

    public void setInstall_appId(String str) {
        this.install_appId = str;
    }

    public String getInstall_version() {
        return this.install_version;
    }

    public void setInstall_version(String str) {
        this.install_version = str;
    }

    public int getInstall_id() {
        return this.install_id;
    }

    public void setInstall_id(int i2) {
        this.install_id = i2;
    }
}
