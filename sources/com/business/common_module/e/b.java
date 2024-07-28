package com.business.common_module.e;

import com.business.common_module.f.a;
import java.util.ArrayList;

public final class b extends a {
    static final long serialVersionUID = -9037250335033512094L;
    private boolean aggregator;
    private boolean betaAccess = false;
    private String createdOn;
    private String email;
    private String guid;
    private String id;
    private boolean isActive = true;
    private boolean isChild;
    private String isMerchant;
    private boolean isSelected = false;
    private String kybid;
    private String merchantType;
    private String mid;
    private boolean migrated;
    private String mobile;
    private String name;
    private String pgonly;
    private ArrayList<c> roles;
    private String type;
    private boolean walletOnly;

    public final boolean isChild() {
        return this.isChild;
    }

    public final void setMerchantType(String str) {
        this.merchantType = str;
    }

    public final void setActive(boolean z) {
        this.isActive = z;
    }

    public final void setCreatedOn(String str) {
        this.createdOn = str;
    }

    public final String getCreatedOn() {
        return this.createdOn;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final String getGuid() {
        return this.guid;
    }

    public final void setGuid(String str) {
        this.guid = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getIsMerchant() {
        return this.isMerchant;
    }

    public final void setIsMerchant(String str) {
        this.isMerchant = str;
    }

    public final String getPgonly() {
        return this.pgonly;
    }

    public final void setPgonly(String str) {
        this.pgonly = str;
    }

    public final boolean getAggregator() {
        return this.aggregator;
    }

    public final void setAggregator(boolean z) {
        this.aggregator = z;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final ArrayList<c> getRoles() {
        return this.roles;
    }

    public final void setRoles(ArrayList<c> arrayList) {
        this.roles = arrayList;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getMid() {
        return this.mid;
    }

    public final void setMid(String str) {
        this.mid = str;
    }

    public final boolean isMigrated() {
        return this.migrated;
    }

    public final void setMigrated(boolean z) {
        this.migrated = z;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getMobile() {
        return this.mobile;
    }

    public final void setMobile(String str) {
        this.mobile = str;
    }

    public final String getMerchantType() {
        return this.merchantType;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final boolean isWalletOnly() {
        return this.walletOnly;
    }

    public final boolean isAggregator() {
        return this.aggregator;
    }

    public final boolean isBetaAccess() {
        return this.betaAccess;
    }

    public final void setBetaAccess(boolean z) {
        this.betaAccess = z;
    }

    public final String getKybid() {
        return this.kybid;
    }

    public final void setKybid(String str) {
        this.kybid = str;
    }
}
