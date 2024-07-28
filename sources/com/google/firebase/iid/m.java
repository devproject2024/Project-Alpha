package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.ai;

final /* synthetic */ class m implements ai.a {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseInstanceId f38872a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38873b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38874c;

    /* renamed from: d  reason: collision with root package name */
    private final String f38875d;

    m(FirebaseInstanceId firebaseInstanceId, String str, String str2, String str3) {
        this.f38872a = firebaseInstanceId;
        this.f38873b = str;
        this.f38874c = str2;
        this.f38875d = str3;
    }

    public final Task a() {
        FirebaseInstanceId firebaseInstanceId = this.f38872a;
        String str = this.f38873b;
        String str2 = this.f38874c;
        String str3 = this.f38875d;
        q qVar = firebaseInstanceId.f38776f;
        return qVar.a(qVar.a(str, str2, str3, new Bundle())).a(firebaseInstanceId.f38773c, new n(firebaseInstanceId, str2, str3, str));
    }
}
