package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.navigation.s;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@s.b(a = "activity")
public final class a extends s<C0064a> {

    /* renamed from: b  reason: collision with root package name */
    private Context f3862b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f3863c;

    public static final class b implements s.a {

        /* renamed from: a  reason: collision with root package name */
        final int f3866a;

        /* renamed from: b  reason: collision with root package name */
        final androidx.core.app.b f3867b;
    }

    public final /* synthetic */ k a(k kVar, Bundle bundle, p pVar, s.a aVar) {
        Intent intent;
        int intExtra;
        C0064a aVar2 = (C0064a) kVar;
        if (aVar2.f3864a != null) {
            Intent intent2 = new Intent(aVar2.f3864a);
            if (bundle != null) {
                intent2.putExtras(bundle);
                String str = aVar2.f3865b;
                if (!TextUtils.isEmpty(str)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(str);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        if (bundle.containsKey(group)) {
                            matcher.appendReplacement(stringBuffer, "");
                            stringBuffer.append(Uri.encode(bundle.get(group).toString()));
                        } else {
                            throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill data pattern " + str);
                        }
                    }
                    matcher.appendTail(stringBuffer);
                    intent2.setData(Uri.parse(stringBuffer.toString()));
                }
            }
            boolean z = aVar instanceof b;
            if (z) {
                intent2.addFlags(((b) aVar).f3866a);
            }
            if (!(this.f3862b instanceof Activity)) {
                intent2.addFlags(268435456);
            }
            if (pVar != null && pVar.f3940a) {
                intent2.addFlags(536870912);
            }
            Activity activity = this.f3863c;
            if (!(activity == null || (intent = activity.getIntent()) == null || (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) == 0)) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
            }
            intent2.putExtra("android-support-navigation:ActivityNavigator:current", aVar2.f3921e);
            if (pVar != null) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", pVar.f3945f);
                intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", pVar.f3946g);
            }
            if (z) {
                androidx.core.app.b bVar = ((b) aVar).f3867b;
                if (bVar != null) {
                    androidx.core.app.a.a(this.f3862b, intent2, bVar.a());
                } else {
                    this.f3862b.startActivity(intent2);
                }
            } else {
                this.f3862b.startActivity(intent2);
            }
            if (pVar == null || this.f3863c == null) {
                return null;
            }
            int i2 = pVar.f3943d;
            int i3 = pVar.f3944e;
            if (i2 == -1 && i3 == -1) {
                return null;
            }
            if (i2 == -1) {
                i2 = 0;
            }
            if (i3 == -1) {
                i3 = 0;
            }
            this.f3863c.overridePendingTransition(i2, i3);
            return null;
        }
        throw new IllegalStateException("Destination " + aVar2.f3921e + " does not have an Intent set.");
    }

    public a(Context context) {
        this.f3862b = context;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                this.f3863c = (Activity) context;
                return;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
    }

    public final boolean a() {
        Activity activity = this.f3863c;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }

    /* renamed from: androidx.navigation.a$a  reason: collision with other inner class name */
    public static class C0064a extends k {

        /* renamed from: a  reason: collision with root package name */
        Intent f3864a;

        /* renamed from: b  reason: collision with root package name */
        String f3865b;

        /* access modifiers changed from: package-private */
        public final boolean a() {
            return false;
        }

        public C0064a(s<? extends C0064a> sVar) {
            super((s<? extends k>) sVar);
        }

        public final void a(Context context, AttributeSet attributeSet) {
            super.a(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.ActivityNavigator);
            String string = obtainAttributes.getString(R.styleable.ActivityNavigator_android_name);
            if (string != null) {
                ComponentName componentName = new ComponentName(context, a(context, string, Activity.class));
                if (this.f3864a == null) {
                    this.f3864a = new Intent();
                }
                this.f3864a.setComponent(componentName);
            }
            String string2 = obtainAttributes.getString(R.styleable.ActivityNavigator_action);
            if (this.f3864a == null) {
                this.f3864a = new Intent();
            }
            this.f3864a.setAction(string2);
            String string3 = obtainAttributes.getString(R.styleable.ActivityNavigator_data);
            if (string3 != null) {
                Uri parse = Uri.parse(string3);
                if (this.f3864a == null) {
                    this.f3864a = new Intent();
                }
                this.f3864a.setData(parse);
            }
            this.f3865b = obtainAttributes.getString(R.styleable.ActivityNavigator_dataPattern);
            obtainAttributes.recycle();
        }
    }

    public final /* synthetic */ k b() {
        return new C0064a(this);
    }
}
