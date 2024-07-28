package com.google.android.gms.common;

import android.content.Intent;

public class k extends Exception {
    private final Intent mIntent;

    public k(String str, Intent intent) {
        super(str);
        this.mIntent = intent;
    }

    public Intent getIntent() {
        return new Intent(this.mIntent);
    }
}
