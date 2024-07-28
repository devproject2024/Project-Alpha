package com.paytm.notification.models.request;

import com.google.gson.a.c;

public final class DeviceDetails {
    @c(a = "brand")
    private String brand;
    @c(a = "category")
    private String category;
    @c(a = "client")
    private String client;
    @c(a = "identifier")
    private String identifier;
    @c(a = "imei")
    private String imei;
    @c(a = "language")
    private String language;
    @c(a = "manufacturer")
    private String manufacturer;
    @c(a = "model")
    private String model;
    @c(a = "name")
    private String name;
    @c(a = "os")
    private String os;
    @c(a = "osVersion")
    private String osVersion;
    @c(a = "platform")
    private String platform;
    @c(a = "screenResolution")
    private String screenResolution;
    @c(a = "version")
    private String version;

    public final String getPlatform() {
        return this.platform;
    }

    public final void setPlatform(String str) {
        this.platform = str;
    }

    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getBrand() {
        return this.brand;
    }

    public final void setBrand(String str) {
        this.brand = str;
    }

    public final String getModel() {
        return this.model;
    }

    public final void setModel(String str) {
        this.model = str;
    }

    public final String getImei() {
        return this.imei;
    }

    public final void setImei(String str) {
        this.imei = str;
    }

    public final String getCategory() {
        return this.category;
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    public final String getScreenResolution() {
        return this.screenResolution;
    }

    public final void setScreenResolution(String str) {
        this.screenResolution = str;
    }

    public final String getOs() {
        return this.os;
    }

    public final void setOs(String str) {
        this.os = str;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final void setOsVersion(String str) {
        this.osVersion = str;
    }

    public final String getClient() {
        return this.client;
    }

    public final void setClient(String str) {
        this.client = str;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final void setIdentifier(String str) {
        this.identifier = str;
    }

    public final String toString() {
        return "DeviceDetails(manufacturer=" + this.manufacturer + ", name=" + this.name + ", brand=" + this.brand + ", model=" + this.model + ", osVersion=" + this.osVersion + ')';
    }
}
