package com.sendbird.android;

import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;

public class MessageMetaArray {
    private String mKey;
    private List<String> mValue;

    public MessageMetaArray(String str) {
        this.mKey = str;
        this.mValue = new ArrayList();
    }

    public MessageMetaArray(String str, List<String> list) {
        this.mKey = str;
        this.mValue = new ArrayList(list);
    }

    public String getKey() {
        return this.mKey;
    }

    public List<String> getValue() {
        return new ArrayList(this.mValue);
    }

    public synchronized void addValue(String str) {
        this.mValue.add(str);
    }

    public void addValue(List<String> list) {
        for (String addValue : list) {
            addValue(addValue);
        }
    }

    public synchronized void removeValue(String str) {
        this.mValue.remove(str);
    }

    /* access modifiers changed from: package-private */
    public synchronized void setValue(List<String> list) {
        this.mValue = list;
    }

    /* access modifiers changed from: package-private */
    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("key", this.mKey);
        JsonArray jsonArray = new JsonArray();
        for (String add : this.mValue) {
            jsonArray.add(add);
        }
        jsonObject.add("value", jsonArray);
        return jsonObject;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        MessageMetaArray messageMetaArray = (MessageMetaArray) obj;
        String str = this.mKey;
        if (str == null) {
            return false;
        }
        return str.equals(messageMetaArray.mKey);
    }

    public int hashCode() {
        return p.a(this.mKey);
    }

    public String toString() {
        return "MessageMetaArray{mKey='" + this.mKey + '\'' + ", mValue=" + this.mValue + '}';
    }
}
