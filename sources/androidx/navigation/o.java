package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.a.h;
import androidx.navigation.f;
import androidx.navigation.p;
import com.sendbird.android.constant.StringSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f3937a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private Context f3938b;

    /* renamed from: c  reason: collision with root package name */
    private t f3939c;

    public o(Context context, t tVar) {
        this.f3938b = context;
        this.f3939c = tVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0045 A[Catch:{ Exception -> 0x004f, all -> 0x004d }] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x001a A[Catch:{ Exception -> 0x004f, all -> 0x004d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.navigation.m a(int r7) {
        /*
            r6 = this;
            android.content.Context r0 = r6.f3938b
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.XmlResourceParser r1 = r0.getXml(r7)
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r1)
        L_0x000e:
            int r3 = r1.next()     // Catch:{ Exception -> 0x004f }
            r4 = 2
            if (r3 == r4) goto L_0x0018
            r5 = 1
            if (r3 != r5) goto L_0x000e
        L_0x0018:
            if (r3 != r4) goto L_0x0045
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x004f }
            androidx.navigation.k r2 = r6.a(r0, r1, r2, r7)     // Catch:{ Exception -> 0x004f }
            boolean r4 = r2 instanceof androidx.navigation.m     // Catch:{ Exception -> 0x004f }
            if (r4 == 0) goto L_0x002c
            androidx.navigation.m r2 = (androidx.navigation.m) r2     // Catch:{ Exception -> 0x004f }
            r1.close()
            return r2
        L_0x002c:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x004f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004f }
            java.lang.String r5 = "Root element <"
            r4.<init>(r5)     // Catch:{ Exception -> 0x004f }
            r4.append(r3)     // Catch:{ Exception -> 0x004f }
            java.lang.String r3 = "> did not inflate into a NavGraph"
            r4.append(r3)     // Catch:{ Exception -> 0x004f }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x004f }
            r2.<init>(r3)     // Catch:{ Exception -> 0x004f }
            throw r2     // Catch:{ Exception -> 0x004f }
        L_0x0045:
            org.xmlpull.v1.XmlPullParserException r2 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x004f }
            java.lang.String r3 = "No start tag found"
            r2.<init>(r3)     // Catch:{ Exception -> 0x004f }
            throw r2     // Catch:{ Exception -> 0x004f }
        L_0x004d:
            r7 = move-exception
            goto L_0x0074
        L_0x004f:
            r2 = move-exception
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch:{ all -> 0x004d }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x004d }
            java.lang.String r5 = "Exception inflating "
            r4.<init>(r5)     // Catch:{ all -> 0x004d }
            java.lang.String r7 = r0.getResourceName(r7)     // Catch:{ all -> 0x004d }
            r4.append(r7)     // Catch:{ all -> 0x004d }
            java.lang.String r7 = " line "
            r4.append(r7)     // Catch:{ all -> 0x004d }
            int r7 = r1.getLineNumber()     // Catch:{ all -> 0x004d }
            r4.append(r7)     // Catch:{ all -> 0x004d }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x004d }
            r3.<init>(r7, r2)     // Catch:{ all -> 0x004d }
            throw r3     // Catch:{ all -> 0x004d }
        L_0x0074:
            r1.close()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.o.a(int):androidx.navigation.m");
    }

    private k a(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i2) throws XmlPullParserException, IOException {
        int depth;
        k b2 = this.f3939c.a(xmlResourceParser.getName()).b();
        b2.a(this.f3938b, attributeSet);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                return b2;
            }
            if (next == 2 && depth <= depth2) {
                String name = xmlResourceParser.getName();
                if ("argument".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavArgument);
                    String string = obtainAttributes.getString(R.styleable.NavArgument_android_name);
                    if (string != null) {
                        f a2 = a(obtainAttributes, resources, i2);
                        if (b2.f3924h == null) {
                            b2.f3924h = new HashMap<>();
                        }
                        b2.f3924h.put(string, a2);
                        obtainAttributes.recycle();
                    } else {
                        throw new XmlPullParserException("Arguments must have a name");
                    }
                } else if ("deepLink".equals(name)) {
                    TypedArray obtainAttributes2 = resources.obtainAttributes(attributeSet, R.styleable.NavDeepLink);
                    String string2 = obtainAttributes2.getString(R.styleable.NavDeepLink_uri);
                    if (!TextUtils.isEmpty(string2)) {
                        String replace = string2.replace("${applicationId}", this.f3938b.getPackageName());
                        if (b2.f3922f == null) {
                            b2.f3922f = new ArrayList<>();
                        }
                        b2.f3922f.add(new i(replace));
                        obtainAttributes2.recycle();
                    } else {
                        throw new IllegalArgumentException("Every <deepLink> must include an app:uri");
                    }
                } else if ("action".equals(name)) {
                    a(resources, b2, attributeSet, xmlResourceParser, i2);
                } else if (StringSet.include.equals(name) && (b2 instanceof m)) {
                    TypedArray obtainAttributes3 = resources.obtainAttributes(attributeSet, R.styleable.NavInclude);
                    ((m) b2).a((k) a(obtainAttributes3.getResourceId(R.styleable.NavInclude_graph, 0)));
                    obtainAttributes3.recycle();
                } else if (b2 instanceof m) {
                    ((m) b2).a(a(resources, xmlResourceParser, attributeSet, i2));
                }
            }
        }
        return b2;
    }

    private static f a(TypedArray typedArray, Resources resources, int i2) throws XmlPullParserException {
        f.a aVar = new f.a();
        boolean z = false;
        aVar.f3881b = typedArray.getBoolean(R.styleable.NavArgument_nullable, false);
        TypedValue typedValue = f3937a.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            f3937a.set(typedValue);
        }
        String string = typedArray.getString(R.styleable.NavArgument_argType);
        int i3 = null;
        q a2 = string != null ? q.a(string, resources.getResourcePackageName(i2)) : null;
        if (typedArray.getValue(R.styleable.NavArgument_android_defaultValue, typedValue)) {
            if (a2 == q.f3955c) {
                if (typedValue.resourceId != 0) {
                    i3 = Integer.valueOf(typedValue.resourceId);
                } else if (typedValue.type == 16 && typedValue.data == 0) {
                    i3 = 0;
                } else {
                    throw new XmlPullParserException("unsupported value '" + typedValue.string + "' for " + a2.a() + ". Must be a reference to a resource.");
                }
            } else if (typedValue.resourceId != 0) {
                if (a2 == null) {
                    a2 = q.f3955c;
                    i3 = Integer.valueOf(typedValue.resourceId);
                } else {
                    throw new XmlPullParserException("unsupported value '" + typedValue.string + "' for " + a2.a() + ". You must use a \"" + q.f3955c.a() + "\" type to reference other resources.");
                }
            } else if (a2 == q.k) {
                i3 = typedArray.getString(R.styleable.NavArgument_android_defaultValue);
            } else {
                int i4 = typedValue.type;
                if (i4 == 3) {
                    String charSequence = typedValue.string.toString();
                    if (a2 == null) {
                        a2 = q.b(charSequence);
                    }
                    i3 = a2.a(charSequence);
                } else if (i4 == 4) {
                    a2 = a(typedValue, a2, (q) q.f3959g, string, "float");
                    i3 = Float.valueOf(typedValue.getFloat());
                } else if (i4 == 5) {
                    a2 = a(typedValue, a2, (q) q.f3954b, string, "dimension");
                    i3 = Integer.valueOf((int) typedValue.getDimension(resources.getDisplayMetrics()));
                } else if (i4 == 18) {
                    a2 = a(typedValue, a2, (q) q.f3961i, string, "boolean");
                    if (typedValue.data != 0) {
                        z = true;
                    }
                    i3 = Boolean.valueOf(z);
                } else if (typedValue.type < 16 || typedValue.type > 31) {
                    throw new XmlPullParserException("unsupported argument type " + typedValue.type);
                } else {
                    a2 = a(typedValue, a2, (q) q.f3954b, string, "integer");
                    i3 = Integer.valueOf(typedValue.data);
                }
            }
        }
        if (i3 != null) {
            aVar.a(i3);
        }
        if (a2 != null) {
            aVar.f3880a = a2;
        }
        return aVar.a();
    }

    private static q a(TypedValue typedValue, q qVar, q qVar2, String str, String str2) throws XmlPullParserException {
        if (qVar == null || qVar == qVar2) {
            return qVar != null ? qVar : qVar2;
        }
        throw new XmlPullParserException("Type is " + str + " but found " + str2 + ": " + typedValue.data);
    }

    private static void a(Resources resources, k kVar, AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int i2) throws IOException, XmlPullParserException {
        int depth;
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavAction);
        int resourceId = obtainAttributes.getResourceId(R.styleable.NavAction_android_id, 0);
        b bVar = new b(obtainAttributes.getResourceId(R.styleable.NavAction_destination, 0));
        p.a aVar = new p.a();
        aVar.f3947a = obtainAttributes.getBoolean(R.styleable.NavAction_launchSingleTop, false);
        aVar.a(obtainAttributes.getResourceId(R.styleable.NavAction_popUpTo, -1), obtainAttributes.getBoolean(R.styleable.NavAction_popUpToInclusive, false));
        aVar.f3950d = obtainAttributes.getResourceId(R.styleable.NavAction_enterAnim, -1);
        aVar.f3951e = obtainAttributes.getResourceId(R.styleable.NavAction_exitAnim, -1);
        aVar.f3952f = obtainAttributes.getResourceId(R.styleable.NavAction_popEnterAnim, -1);
        aVar.f3953g = obtainAttributes.getResourceId(R.styleable.NavAction_popExitAnim, -1);
        bVar.f3869b = aVar.a();
        Bundle bundle = new Bundle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next != 1 && ((depth = xmlResourceParser.getDepth()) >= depth2 || next != 3)) {
                if (next == 2 && depth <= depth2 && "argument".equals(xmlResourceParser.getName())) {
                    TypedArray obtainAttributes2 = resources.obtainAttributes(attributeSet, R.styleable.NavArgument);
                    String string = obtainAttributes2.getString(R.styleable.NavArgument_android_name);
                    if (string != null) {
                        f a2 = a(obtainAttributes2, resources, i2);
                        if (a2.f3877b) {
                            a2.a(string, bundle);
                        }
                        obtainAttributes2.recycle();
                    } else {
                        throw new XmlPullParserException("Arguments must have a name");
                    }
                }
            }
        }
        if (!bundle.isEmpty()) {
            bVar.f3870c = bundle;
        }
        if (!kVar.a()) {
            throw new UnsupportedOperationException("Cannot add action " + resourceId + " to " + kVar + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
        } else if (resourceId != 0) {
            if (kVar.f3923g == null) {
                kVar.f3923g = new h<>();
            }
            kVar.f3923g.b(resourceId, bVar);
            obtainAttributes.recycle();
        } else {
            throw new IllegalArgumentException("Cannot have an action with actionId 0");
        }
    }
}
