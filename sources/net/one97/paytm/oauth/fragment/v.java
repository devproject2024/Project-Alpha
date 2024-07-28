package net.one97.paytm.oauth.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.b;
import net.one97.paytm.oauth.utils.p;

public class v extends h {

    /* renamed from: a  reason: collision with root package name */
    private String f56631a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f56632b;

    public View a(int i2) {
        if (this.f56632b == null) {
            this.f56632b = new HashMap();
        }
        View view = (View) this.f56632b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56632b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void a() {
        HashMap hashMap = this.f56632b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public static /* synthetic */ void a(String str, String str2, String str3, ArrayList arrayList, int i2) {
        if ((i2 & 8) != 0) {
            arrayList = new ArrayList();
        }
        a(str, str2, str3, (ArrayList<String>) arrayList, (String) null);
    }

    protected static void a(String str, String str2, String str3, ArrayList<String> arrayList, String str4) {
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str2, "category");
        k.c(str3, "action");
        k.c(arrayList, "labels");
        b b2 = OauthModule.b();
        b b3 = OauthModule.b();
        k.a((Object) b3, "OauthModule.getOathDataProvider()");
        b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), str2, str3, arrayList, str4, str, p.f56796a);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        String str = null;
        this.f56631a = arguments != null ? arguments.getString(p.f56797b, "") : null;
        if (TextUtils.isEmpty(this.f56631a)) {
            FragmentActivity requireActivity = requireActivity();
            k.a((Object) requireActivity, "requireActivity()");
            Intent intent = requireActivity.getIntent();
            k.a((Object) intent, "requireActivity().intent");
            Bundle extras = intent.getExtras();
            if (extras != null) {
                str = extras.getString(p.f56797b, "");
            }
            this.f56631a = str;
        }
    }

    public final String c() {
        String str = this.f56631a;
        return str == null ? "" : str;
    }
}
