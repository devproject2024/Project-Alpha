package net.one97.paytm.feed.ui.feed.video;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.lifecycle.LiveData;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.repository.models.CreatedBy;
import net.one97.paytm.feed.repository.models.FeedDataMinimal;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.ui.feed.d;

public final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    LiveData<FeedDataMinimal> f35245a;

    /* renamed from: b  reason: collision with root package name */
    LiveData<FeedDataMinimal> f35246b;

    /* renamed from: net.one97.paytm.feed.ui.feed.video.a$a  reason: collision with other inner class name */
    static final class C0586a extends l implements b<String, x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $eventKey;
        final /* synthetic */ String $eventLabel;
        final /* synthetic */ String $eventName;
        final /* synthetic */ FeedGeneric $feedItem;
        final /* synthetic */ boolean $status;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0586a(String str, FeedGeneric feedGeneric, String str2, String str3, Context context, boolean z) {
            super(1);
            this.$eventName = str;
            this.$feedItem = feedGeneric;
            this.$eventKey = str2;
            this.$eventLabel = str3;
            this.$context = context;
            this.$status = z;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            if (str != null) {
                net.one97.paytm.feed.events.a aVar = net.one97.paytm.feed.events.a.f34284a;
                String str2 = this.$eventName;
                CreatedBy createdBy = this.$feedItem.getFeedGenericData().getCreatedBy();
                String str3 = null;
                Integer id = createdBy != null ? createdBy.getId() : null;
                if (id == null) {
                    k.a();
                }
                int intValue = id.intValue();
                CreatedBy createdBy2 = this.$feedItem.getFeedGenericData().getCreatedBy();
                String name = createdBy2 != null ? createdBy2.getName() : null;
                if (name == null) {
                    k.a();
                }
                net.one97.paytm.feed.events.a.a(str2, intValue, name, -1);
                if (!TextUtils.isEmpty(this.$eventKey)) {
                    net.one97.paytm.feed.events.a.a aVar2 = net.one97.paytm.feed.events.a.a.f34296a;
                    String str4 = this.$eventKey;
                    if (str4 == null) {
                        k.a();
                    }
                    String str5 = this.$eventLabel;
                    if (str5 == null) {
                        k.a();
                    }
                    CreatedBy createdBy3 = this.$feedItem.getFeedGenericData().getCreatedBy();
                    if (createdBy3 != null) {
                        str3 = createdBy3.getName();
                    }
                    if (str3 == null) {
                        k.a();
                    }
                    net.one97.paytm.feed.events.a.a.a(str4, str5, str3, "");
                    return;
                }
                return;
            }
            net.one97.paytm.feed.repository.db.a aVar3 = net.one97.paytm.feed.repository.db.a.f34614a;
            Context context = this.$context;
            CreatedBy createdBy4 = this.$feedItem.getFeedGenericData().getCreatedBy();
            if (createdBy4 == null) {
                k.a();
            }
            Integer id2 = createdBy4.getId();
            if (id2 == null) {
                k.a();
            }
            net.one97.paytm.feed.repository.db.a.a(context, id2.intValue(), !this.$status);
            Context context2 = this.$context;
            Toast.makeText(context2, context2.getString(R.string.feed_server_error), 0).show();
        }
    }

    static void a(Context context, FeedGeneric feedGeneric, String str, String str2, String str3, String str4, boolean z) {
        Context context2 = context;
        net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
        CreatedBy createdBy = feedGeneric.getFeedGenericData().getCreatedBy();
        if (createdBy == null) {
            k.a();
        }
        Integer id = createdBy.getId();
        if (id == null) {
            k.a();
        }
        net.one97.paytm.feed.repository.db.a.a(context, id.intValue(), z);
        net.one97.paytm.feed.c.a aVar2 = net.one97.paytm.feed.c.a.f34255a;
        net.one97.paytm.feed.repository.a.b a2 = net.one97.paytm.feed.c.a.a();
        CreatedBy createdBy2 = feedGeneric.getFeedGenericData().getCreatedBy();
        if (createdBy2 == null) {
            k.a();
        }
        Integer id2 = createdBy2.getId();
        if (id2 == null) {
            k.a();
        }
        String str5 = str;
        a2.b(context, str, id2.intValue(), (b<? super String, x>) new C0586a(str2, feedGeneric, str3, str4, context, z));
    }
}
