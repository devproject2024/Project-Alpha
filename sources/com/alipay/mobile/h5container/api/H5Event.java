package com.alipay.mobile.h5container.api;

import android.app.Activity;
import android.content.Context;
import com.alibaba.a.e;

public class H5Event {
    public static final String TYPE_CALL = "call";
    public static final String TYPE_CALL_BACK = "callback";
    /* access modifiers changed from: private */
    public String action;
    /* access modifiers changed from: private */
    public H5CallBack callBack;
    /* access modifiers changed from: private */
    public boolean canceled;
    /* access modifiers changed from: private */
    public boolean dispatcherOnWorkThread;
    /* access modifiers changed from: private */
    public Error error;
    /* access modifiers changed from: private */
    public Object extra;
    /* access modifiers changed from: private */
    public String id;
    /* access modifiers changed from: private */
    public boolean keepCallback;
    /* access modifiers changed from: private */
    public e param;
    /* access modifiers changed from: private */
    public H5CoreNode target;
    /* access modifiers changed from: private */
    public String type;

    public enum Error {
        NONE,
        NOT_FOUND,
        INVALID_PARAM,
        UNKNOWN_ERROR,
        FORBIDDEN
    }

    private H5Event(Builder builder) {
        this.error = builder.error;
        this.action = builder.action;
        this.id = builder.id;
        this.canceled = builder.canceled;
        this.callBack = builder.callBack;
        this.type = builder.type;
        this.keepCallback = builder.keepCallback;
        this.param = builder.param;
        this.target = builder.target;
        this.extra = builder.extra;
        this.dispatcherOnWorkThread = builder.dispatcherOnWorkThread;
    }

    public boolean isDispatcherOnWorkThread() {
        return this.dispatcherOnWorkThread;
    }

    public void setDispatcherOnWorkThread(boolean z) {
        this.dispatcherOnWorkThread = z;
    }

    public H5CallBack getCallBack() {
        return this.callBack;
    }

    public void setCallBack(H5CallBack h5CallBack) {
        this.callBack = h5CallBack;
    }

    public final String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public final boolean isCanceled() {
        return this.canceled;
    }

    public final void cancel() {
        this.canceled = true;
    }

    public final H5CoreNode getTarget() {
        return this.target;
    }

    public final void setTarget(H5CoreNode h5CoreNode) {
        this.target = h5CoreNode;
    }

    public final Activity getActivity() {
        H5CoreNode h5CoreNode = this.target;
        if (!(h5CoreNode instanceof H5Page)) {
            return null;
        }
        H5Page h5Page = (H5Page) h5CoreNode;
        if (h5Page.getContext() == null) {
            return null;
        }
        Context context = h5Page.getContext().getContext();
        if (!(context instanceof Activity)) {
            return null;
        }
        return (Activity) context;
    }

    public final H5Page getH5page() {
        H5CoreNode h5CoreNode = this.target;
        if (!(h5CoreNode instanceof H5Page)) {
            return null;
        }
        return (H5Page) h5CoreNode;
    }

    public final String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public e getParam() {
        return this.param;
    }

    public void setParam(e eVar) {
        this.param = eVar;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public boolean isKeepCallback() {
        return this.keepCallback;
    }

    public void setKeepCallback(boolean z) {
        this.keepCallback = z;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public String action;
        /* access modifiers changed from: private */
        public H5CallBack callBack;
        /* access modifiers changed from: private */
        public boolean canceled;
        /* access modifiers changed from: private */
        public boolean dispatcherOnWorkThread;
        /* access modifiers changed from: private */
        public Error error = Error.NONE;
        /* access modifiers changed from: private */
        public Object extra;
        /* access modifiers changed from: private */
        public String id = ("native_" + System.currentTimeMillis());
        /* access modifiers changed from: private */
        public boolean keepCallback = false;
        /* access modifiers changed from: private */
        public e param;
        /* access modifiers changed from: private */
        public H5CoreNode target;
        /* access modifiers changed from: private */
        public String type = H5Event.TYPE_CALL;

        public Builder() {
        }

        public Builder(H5Event h5Event) {
            this.error = h5Event.error;
            this.action = h5Event.action;
            this.id = h5Event.id;
            this.canceled = h5Event.canceled;
            this.callBack = h5Event.callBack;
            this.type = h5Event.type;
            this.keepCallback = h5Event.keepCallback;
            this.param = h5Event.param;
            this.target = h5Event.target;
            this.extra = h5Event.extra;
            this.dispatcherOnWorkThread = h5Event.dispatcherOnWorkThread;
        }

        public Builder action(String str) {
            this.action = str;
            return this;
        }

        public Builder target(H5CoreNode h5CoreNode) {
            this.target = h5CoreNode;
            return this;
        }

        public Builder id(String str) {
            this.id = str;
            return this;
        }

        public Builder param(e eVar) {
            this.param = eVar;
            return this;
        }

        public Builder type(String str) {
            this.type = str;
            return this;
        }

        public Builder callback(H5CallBack h5CallBack) {
            this.callBack = h5CallBack;
            return this;
        }

        public Builder cancel(boolean z) {
            this.canceled = z;
            return this;
        }

        public Builder keepCallback(boolean z) {
            this.keepCallback = z;
            return this;
        }

        public Builder dispatcherOnWorkThread(boolean z) {
            this.dispatcherOnWorkThread = z;
            return this;
        }

        public Builder extra(Object obj) {
            this.extra = obj;
            return this;
        }

        public H5Event build() {
            return new H5Event(this);
        }
    }
}
