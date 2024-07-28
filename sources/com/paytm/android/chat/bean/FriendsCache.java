package com.paytm.android.chat.bean;

import java.util.HashMap;

public class FriendsCache {
    HashMap<String, Long> hashMap = new HashMap<>();

    public FriendsCache(HashMap<String, Long> hashMap2) {
        this.hashMap = hashMap2;
    }

    public HashMap<String, Long> getHashMap() {
        return this.hashMap;
    }

    public void setHashMap(HashMap<String, Long> hashMap2) {
        this.hashMap = hashMap2;
    }

    public void putIfNotExist(String str, Long l) {
        if (!this.hashMap.containsKey(str)) {
            this.hashMap.put(str, l);
        }
    }
}
