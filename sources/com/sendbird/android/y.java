package com.sendbird.android;

import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

enum y {
    CATEGORY_NONE(0),
    USER_UNBLOCK(FileDownloadDefaultParamsKt.DOWNLOAD_DEFAULT_TIMEOUT),
    USER_BLOCK(20001),
    FRIEND_DISCOVERED(20900);
    
    private final int category;

    private y(int i2) {
        this.category = i2;
    }

    static y from(int i2) {
        for (y yVar : values()) {
            if (yVar.category == i2) {
                return yVar;
            }
        }
        return CATEGORY_NONE;
    }

    public final int getCategory() {
        return this.category;
    }
}
