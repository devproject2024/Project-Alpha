package c.a.a;

import android.text.TextUtils;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    String f5602a;

    /* renamed from: b  reason: collision with root package name */
    String f5603b;

    /* renamed from: c  reason: collision with root package name */
    d f5604c;

    public m(String str, String str2) {
        if (str == null) {
            this.f5602a = "";
        } else {
            this.f5602a = str;
        }
        if (str2 == null) {
            this.f5603b = "";
        } else {
            this.f5603b = str2;
        }
    }

    public final boolean equals(Object obj) {
        m mVar;
        if (obj == null || !(obj instanceof m) || (mVar = (m) obj) == null || !TextUtils.equals(mVar.f5602a, this.f5602a) || !TextUtils.equals(mVar.f5603b, this.f5603b)) {
            return false;
        }
        return true;
    }
}
