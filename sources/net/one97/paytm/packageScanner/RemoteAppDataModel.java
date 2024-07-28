package net.one97.paytm.packageScanner;

import androidx.recyclerview.widget.h;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class RemoteAppDataModel extends IJRPaytmDataModel {
    public static final a Companion = new a((byte) 0);
    /* access modifiers changed from: private */
    public static final h.c<RemoteAppDataModel> DIFF_CALLBACK = new b();
    private final String Appname;
    private final String pckg_name;

    public static /* synthetic */ RemoteAppDataModel copy$default(RemoteAppDataModel remoteAppDataModel, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = remoteAppDataModel.pckg_name;
        }
        if ((i2 & 2) != 0) {
            str2 = remoteAppDataModel.Appname;
        }
        return remoteAppDataModel.copy(str, str2);
    }

    public final String component1() {
        return this.pckg_name;
    }

    public final String component2() {
        return this.Appname;
    }

    public final RemoteAppDataModel copy(String str, String str2) {
        k.c(str, "pckg_name");
        k.c(str2, "Appname");
        return new RemoteAppDataModel(str, str2);
    }

    public final String toString() {
        return "RemoteAppDataModel(pckg_name=" + this.pckg_name + ", Appname=" + this.Appname + ")";
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public RemoteAppDataModel(String str, String str2) {
        k.c(str, "pckg_name");
        k.c(str2, "Appname");
        this.pckg_name = str;
        this.Appname = str2;
    }

    public final String getAppname() {
        return this.Appname;
    }

    public final String getPckg_name() {
        return this.pckg_name;
    }

    public static final class b extends h.c<RemoteAppDataModel> {
        b() {
        }

        public final /* synthetic */ boolean a(Object obj, Object obj2) {
            RemoteAppDataModel remoteAppDataModel = (RemoteAppDataModel) obj;
            RemoteAppDataModel remoteAppDataModel2 = (RemoteAppDataModel) obj2;
            k.c(remoteAppDataModel, "oldItem");
            k.c(remoteAppDataModel2, "newItem");
            return remoteAppDataModel.getPckg_name() == remoteAppDataModel2.getPckg_name();
        }

        public final /* synthetic */ boolean b(Object obj, Object obj2) {
            RemoteAppDataModel remoteAppDataModel = (RemoteAppDataModel) obj;
            RemoteAppDataModel remoteAppDataModel2 = (RemoteAppDataModel) obj2;
            k.c(remoteAppDataModel, "oldItem");
            k.c(remoteAppDataModel2, "newItem");
            return remoteAppDataModel.equals(remoteAppDataModel2);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        RemoteAppDataModel remoteAppDataModel = (RemoteAppDataModel) obj;
        return k.a((Object) remoteAppDataModel != null ? remoteAppDataModel.pckg_name : null, (Object) this.pckg_name);
    }

    public final int hashCode() {
        return this.pckg_name.hashCode();
    }
}
