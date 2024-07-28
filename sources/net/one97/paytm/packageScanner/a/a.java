package net.one97.paytm.packageScanner.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.packageScanner.RemoteAppDataModel;
import net.one97.paytm.paytm_finance.R;

public final class a extends RecyclerView.a<C1063a> {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<RemoteAppDataModel> f57032a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f57033b;

    public a(Context context, ArrayList<RemoteAppDataModel> arrayList) {
        this.f57033b = context;
        this.f57032a = arrayList;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C1063a aVar = (C1063a) vVar;
        k.c(aVar, "holder");
        ArrayList<RemoteAppDataModel> arrayList = this.f57032a;
        RemoteAppDataModel remoteAppDataModel = arrayList != null ? arrayList.get(i2) : null;
        if (remoteAppDataModel != null && this.f57033b != null) {
            k.c(remoteAppDataModel, "appDataModel");
            TextView textView = aVar.f57034a;
            String b2 = aVar.f57036c.b(remoteAppDataModel.getPckg_name());
            if (b2 == null) {
                b2 = remoteAppDataModel.getAppname();
            }
            textView.setText(b2);
            aVar.f57035b.setImageDrawable(aVar.f57036c.a(remoteAppDataModel.getPckg_name()));
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.remote_app_layout, viewGroup, false);
        k.a((Object) inflate, "view");
        return new C1063a(this, inflate);
    }

    public final int getItemCount() {
        ArrayList<RemoteAppDataModel> arrayList = this.f57032a;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* renamed from: net.one97.paytm.packageScanner.a.a$a  reason: collision with other inner class name */
    public final class C1063a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f57034a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f57035b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a f57036c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1063a(a aVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f57036c = aVar;
            View findViewById = view.findViewById(R.id.app_name);
            k.a((Object) findViewById, "itemView.findViewById(R.id.app_name)");
            this.f57034a = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.app_icon);
            k.a((Object) findViewById2, "itemView.findViewById(R.id.app_icon)");
            this.f57035b = (ImageView) findViewById2;
        }
    }

    private Drawable a(String str) {
        PackageManager packageManager;
        try {
            Context context = this.f57033b;
            if (context == null || (packageManager = context.getPackageManager()) == null) {
                return null;
            }
            return packageManager.getApplicationIcon(str);
        } catch (PackageManager.NameNotFoundException e2) {
            q.b(e2.getMessage());
            Context context2 = this.f57033b;
            if (context2 != null) {
                return b.a(context2, (int) R.drawable.placeholder_quick_default);
            }
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0005, code lost:
        r1 = r1.getPackageManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String b(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            android.content.Context r1 = r3.f57033b     // Catch:{ NameNotFoundException -> 0x0027 }
            if (r1 == 0) goto L_0x0011
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0027 }
            if (r1 == 0) goto L_0x0011
            r2 = 0
            android.content.pm.ApplicationInfo r4 = r1.getApplicationInfo(r4, r2)     // Catch:{ NameNotFoundException -> 0x0027 }
            goto L_0x0012
        L_0x0011:
            r4 = r0
        L_0x0012:
            android.content.Context r1 = r3.f57033b     // Catch:{ NameNotFoundException -> 0x0027 }
            if (r1 == 0) goto L_0x0021
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0027 }
            if (r1 == 0) goto L_0x0021
            java.lang.CharSequence r4 = r1.getApplicationLabel(r4)     // Catch:{ NameNotFoundException -> 0x0027 }
            goto L_0x0022
        L_0x0021:
            r4 = r0
        L_0x0022:
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ NameNotFoundException -> 0x0027 }
            return r4
        L_0x0027:
            r4 = move-exception
            java.lang.String r4 = r4.getMessage()
            com.paytm.utility.q.b(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.packageScanner.a.a.b(java.lang.String):java.lang.String");
    }
}
