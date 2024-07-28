package com.paytm.contactsSdk.constant;

public final class NetworkConstant {
    public static final NetworkConstant INSTANCE = new NetworkConstant();
    public static final String URL_ADD_CONTACTS = "/cms/v1/contact/add";
    public static final String URL_DELETE_CONTACTS = "/cms/v1/contact/delete";
    public static final String URL_HEALTH = "/cms/v1/contact/health";
    public static final String URL_SEARCH_CONTACT = "/cms/v1/contact/search";

    private NetworkConstant() {
    }
}
