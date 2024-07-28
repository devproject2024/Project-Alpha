package com.alipay.mobile.nebulacore.wallet;

import com.alibaba.a.e;

public class H5JsApiConfigModel {
    private AllBean all;
    private boolean enable;
    private e every;

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public AllBean getAll() {
        return this.all;
    }

    public void setAll(AllBean allBean) {
        this.all = allBean;
    }

    public e getEvery() {
        return this.every;
    }

    public void setEvery(e eVar) {
        this.every = eVar;
    }

    public static class AllBean {

        /* renamed from: in  reason: collision with root package name */
        private boolean f14968in;
        private int maxLength;
        private boolean out;

        public boolean isIn() {
            return this.f14968in;
        }

        public void setIn(boolean z) {
            this.f14968in = z;
        }

        public boolean isOut() {
            return this.out;
        }

        public void setOut(boolean z) {
            this.out = z;
        }

        public int getMaxLength() {
            return this.maxLength;
        }

        public void setMaxLength(int i2) {
            this.maxLength = i2;
        }
    }
}
