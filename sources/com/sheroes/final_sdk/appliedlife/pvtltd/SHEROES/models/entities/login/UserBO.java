package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login;

import com.google.gson.a.a;
import com.google.gson.a.c;
import org.parceler.Parcel;

@Parcel
public class UserBO {
    @c(a = "id")
    @a
    private long id;
    @c(a = "isActive")
    @a
    private boolean isActive;
    @c(a = "name")
    @a
    private String name;
    @c(a = "userSummary")
    @a
    private String userSummary;
    @a
    private int userTypeId;

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public int getUserTypeId() {
        return this.userTypeId;
    }

    public void setUserTypeId(int i2) {
        this.userTypeId = i2;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean z) {
        this.isActive = z;
    }

    public String getUserSummary() {
        return this.userSummary;
    }

    public void setUserSummary(String str) {
        this.userSummary = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean z) {
        this.isActive = z;
    }
}
