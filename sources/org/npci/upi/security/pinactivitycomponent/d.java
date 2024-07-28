package org.npci.upi.security.pinactivitycomponent;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class d extends Exception {

    /* renamed from: a  reason: collision with root package name */
    String f72977a = "CLException";

    /* renamed from: b  reason: collision with root package name */
    private String f72978b;

    /* renamed from: c  reason: collision with root package name */
    private String f72979c;

    /* renamed from: d  reason: collision with root package name */
    private Context f72980d;

    public d(Context context, String str, String str2) {
        this.f72978b = str;
        this.f72979c = str2;
        this.f72980d = context;
        a(context, str2);
    }

    public d(Context context, String str, String str2, Throwable th) {
        super(th);
        this.f72978b = str;
        this.f72979c = str2;
        this.f72980d = context;
        a(context, str2);
    }

    public String a() {
        return this.f72979c;
    }

    public void a(Context context, String str) {
        InputStream inputStream;
        Properties properties = new Properties();
        try {
            inputStream = context.getAssets().open("cl-messages_en_us.properties");
        } catch (IOException e2) {
            e2.getLocalizedMessage();
            inputStream = null;
        }
        try {
            properties.load(inputStream);
        } catch (IOException e3) {
            e3.getLocalizedMessage();
        }
        properties.getProperty(str);
        String string = context.getResources().getString(R.string.error_msg);
        Activity activity = (Activity) context;
        ((RelativeLayout) activity.findViewById(R.id.error_layout)).setVisibility(0);
        ((TextView) activity.findViewById(R.id.error_message)).setText(string);
    }
}
