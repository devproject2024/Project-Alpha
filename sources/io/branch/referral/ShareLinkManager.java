package io.branch.referral;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;

final class ShareLinkManager {

    /* renamed from: b  reason: collision with root package name */
    private static int f46408b = 100;

    /* renamed from: c  reason: collision with root package name */
    private static int f46409c = 2;

    /* renamed from: a  reason: collision with root package name */
    a f46410a;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public h f46411d;

    class MoreShareItem extends ResolveInfo {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ShareLinkManager f46413a;

        public CharSequence loadLabel(PackageManager packageManager) {
            return this.f46413a.f46411d.f46491b;
        }

        public Drawable loadIcon(PackageManager packageManager) {
            return this.f46413a.f46411d.f46490a;
        }
    }

    class CopyLinkItem extends ResolveInfo {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ShareLinkManager f46412a;

        public CharSequence loadLabel(PackageManager packageManager) {
            return this.f46412a.f46411d.f46493d;
        }

        public Drawable loadIcon(PackageManager packageManager) {
            return this.f46412a.f46411d.f46492c;
        }
    }
}
