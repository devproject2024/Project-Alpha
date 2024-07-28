package com.business.common_module;

import android.view.View;

public abstract class a implements View.OnClickListener {
    private final int coolDownTimer = 1000;
    private long initTime;

    public abstract void executeOnClick(View view);

    public void onClick(View view) {
        if (view != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.initTime >= ((long) this.coolDownTimer)) {
                this.initTime = currentTimeMillis;
                executeOnClick(view);
            }
        }
    }
}
