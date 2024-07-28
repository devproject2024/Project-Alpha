package com.paytm.android.chat.network;

public interface UrlProfileList {
    public static final String ADD_BLOCK_USER = "/api/user/block/add";
    public static final String BASE_URL = "https://digitalproxy.paytm.com/pcchat";
    public static final String DEL_BLOCK_USER = "/api/user/block/delete";
    public static final String GET_BLOCK_USERLIST = "/api/user/block/list";
    public static final String GET_FRIEND_LIST = "/api/user/getFriendsList";
    public static final String GET_USER_INFO = "/api/user/get";
    public static final String GET_USER_INFO_BY_ID = "/api/user/getUserInfoByUserIds";
    public static final String GET_USER_SETTINGS = "/api/user/setting/get";
    public static final String MSG_NOTIFY = "/api/user/messageNotify";
    public static final String REGIST_SENDBIRD_V2 = "/v2/api/user/registerSendBird";
    public static final String REGIST_USER = "/api/user/register";
    public static final String UPDATE_USER_INFO = "/api/user/update";
    public static final String UPDATE_USER_SETTINGS = "/api/user/setting/update";
    public static final String UPLOAD_USER_IMAGE = "/api/user/image/upload";
}
