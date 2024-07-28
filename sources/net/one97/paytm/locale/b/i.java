package net.one97.paytm.locale.b;

import android.content.res.Resources;
import android.os.Build;
import android.text.Html;
import net.one97.paytm.common.b.d;
import net.one97.paytm.utils.r;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class i extends Resources {

    /* renamed from: a  reason: collision with root package name */
    private final c f53122a;

    i(Resources resources, c cVar) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f53122a = cVar;
    }

    public final String getString(int i2) throws Resources.NotFoundException {
        try {
            String a2 = a(i2);
            if (a2 != null) {
                return a2;
            }
        } catch (Exception e2) {
            r.a("RestringResources", "getString(id,formatArgs):  ", (Throwable) e2);
            a(i2, (String) null, e2.getClass().getSimpleName());
        }
        return super.getText(i2).toString();
    }

    public final String getString(int i2, Object... objArr) throws Resources.NotFoundException {
        String str;
        try {
            str = a(i2);
            if (str != null) {
                try {
                    return String.format(str, objArr);
                } catch (Exception e2) {
                    e = e2;
                    r.a("RestringResources", "getString(id,formatArgs):  ", (Throwable) e);
                    a(i2, str, e.getClass().getSimpleName());
                    return String.format(super.getText(i2).toString(), objArr);
                }
            }
        } catch (Exception e3) {
            e = e3;
            str = null;
            r.a("RestringResources", "getString(id,formatArgs):  ", (Throwable) e);
            a(i2, str, e.getClass().getSimpleName());
            return String.format(super.getText(i2).toString(), objArr);
        }
        return String.format(super.getText(i2).toString(), objArr);
    }

    public final String[] getStringArray(int i2) throws Resources.NotFoundException {
        try {
            String[] b2 = b(i2);
            if (b2 != null) {
                return b2;
            }
        } catch (Exception e2) {
            r.a("RestringResources", "getStringArray(id):  ", (Throwable) e2);
        }
        return super.getStringArray(i2);
    }

    public final CharSequence getText(int i2) throws Resources.NotFoundException {
        try {
            String a2 = a(i2);
            if (a2 != null) {
                return a(a2);
            }
        } catch (Resources.NotFoundException e2) {
            r.a("RestringResources", "getText(id):  ", (Throwable) e2);
        }
        return super.getText(i2);
    }

    public final CharSequence getText(int i2, CharSequence charSequence) {
        try {
            String a2 = a(i2);
            if (a2 != null) {
                return a(a2);
            }
        } catch (Resources.NotFoundException e2) {
            r.a("RestringResources", "getText(id,def):  ", (Throwable) e2);
        }
        return super.getText(i2, charSequence);
    }

    public final String getQuantityString(int i2, int i3) throws Resources.NotFoundException {
        try {
            String a2 = a(i2);
            if (a2 == null) {
                return super.getQuantityString(i2, i3);
            }
            try {
                JSONObject jSONObject = new JSONObject(a2);
                if (i3 == 0 && jSONObject.optString("zero") != null) {
                    return jSONObject.optString("zero");
                }
                if (i3 == 1 && jSONObject.optString("one") != null) {
                    return jSONObject.optString("one");
                }
                if (i3 == 2 && jSONObject.optString("two") != null) {
                    return jSONObject.optString("two");
                }
                if (i3 <= 10 && jSONObject.optString("few") != null) {
                    return jSONObject.optString("few");
                }
                if (i3 > 10 && jSONObject.optString("many") != null) {
                    return jSONObject.optString("many");
                }
                if (jSONObject.optString("other") != null) {
                    return jSONObject.optString("other");
                }
                return super.getQuantityString(i2, i3);
            } catch (JSONException e2) {
                r.a("RestringResources", "getQuantityString(id,quantity):  ", (Throwable) e2);
                return super.getQuantityString(i2, i3);
            }
        } catch (Resources.NotFoundException e3) {
            r.a("RestringResources", "getQuantityString(id,quantity):  ", (Throwable) e3);
            return super.getQuantityString(i2, i3);
        }
    }

    public final String getQuantityString(int i2, int i3, Object... objArr) throws Resources.NotFoundException {
        try {
            String a2 = a(i2);
            if (a2 == null) {
                return super.getQuantityString(i2, i3, objArr);
            }
            try {
                JSONObject jSONObject = new JSONObject(a2);
                if (i3 == 0 && jSONObject.optString("zero") != null) {
                    return jSONObject.optString("zero");
                }
                if (i3 == 1 && jSONObject.optString("one") != null) {
                    return jSONObject.optString("one");
                }
                if (i3 == 2 && jSONObject.optString("two") != null) {
                    return jSONObject.optString("two");
                }
                if (i3 <= 10 && jSONObject.optString("few") != null) {
                    return jSONObject.optString("few");
                }
                if (i3 > 10 && jSONObject.optString("many") != null) {
                    return jSONObject.optString("many");
                }
                if (jSONObject.optString("other") != null) {
                    return jSONObject.optString("other");
                }
                return super.getQuantityString(i2, i3, objArr);
            } catch (JSONException e2) {
                r.a("RestringResources", "getQuantityString(id,quantity,formatArgs):  ", (Throwable) e2);
                return super.getQuantityString(i2, i3, objArr);
            }
        } catch (Resources.NotFoundException e3) {
            r.a("RestringResources", "getQuantityString(id,quantity,formatArgs):  ", (Throwable) e3);
            return super.getQuantityString(i2, i3, objArr);
        }
    }

    private String a(int i2) throws Resources.NotFoundException {
        try {
            String a2 = this.f53122a.a(j.a(), getResourceEntryName(i2));
            return a2 == null ? d.b().a().getString(i2) : a2;
        } catch (Resources.NotFoundException unused) {
            return d.b().a().getString(i2);
        }
    }

    private String[] b(int i2) {
        String str;
        try {
            str = this.f53122a.a(j.a(), getResourceEntryName(i2));
        } catch (Resources.NotFoundException unused) {
            str = null;
        }
        if (str == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            String[] strArr = new String[jSONArray.length()];
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                strArr[i3] = (String) jSONArray.get(i3);
            }
            return strArr;
        } catch (JSONException unused2) {
            return null;
        }
    }

    private static CharSequence a(String str) {
        if (Build.VERSION.SDK_INT < 24) {
            return Html.fromHtml(str);
        }
        return Html.fromHtml(str, 63);
    }

    private void a(int i2, String str, String str2) {
        String valueOf = String.valueOf(i2);
        try {
            valueOf = getResourceEntryName(i2);
        } catch (Exception unused) {
        }
        d.a().a(valueOf, str, str2);
    }
}
