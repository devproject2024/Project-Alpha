package com.google.firebase.iid;

import com.google.firebase.iid.aw;

final /* synthetic */ class ax implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final aw.a f38852a;

    ax(aw.a aVar) {
        this.f38852a = aVar;
    }

    public final void run() {
        aw.a aVar = this.f38852a;
        String action = aVar.f38850a.getAction();
        StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
        sb.append("Service took too long to process intent: ");
        sb.append(action);
        sb.append(" App may get closed.");
        aVar.a();
    }
}
