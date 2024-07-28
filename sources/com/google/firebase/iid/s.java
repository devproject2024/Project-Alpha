package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.a;
import java.io.IOException;

final /* synthetic */ class s implements a {

    /* renamed from: a  reason: collision with root package name */
    private final q f38889a;

    s(q qVar) {
        this.f38889a = qVar;
    }

    public final Object a(Task task) {
        Bundle bundle = (Bundle) task.a(IOException.class);
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string != null) {
                return string;
            }
            String string2 = bundle.getString("unregistered");
            if (string2 != null) {
                return string2;
            }
            String string3 = bundle.getString("error");
            if ("RST".equals(string3)) {
                throw new IOException("INSTANCE_ID_RESET");
            } else if (string3 != null) {
                throw new IOException(string3);
            } else {
                String valueOf = String.valueOf(bundle);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21);
                sb.append("Unexpected response: ");
                sb.append(valueOf);
                new Throwable();
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        } else {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }
}
