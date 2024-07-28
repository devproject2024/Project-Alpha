package com.paytmmall.clpartifact.widgets.component.smarticongrid;

import android.content.Context;
import android.text.TextUtils;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.List;
import java.util.TreeMap;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class GTMDataController {
    public static final Companion Companion = new Companion((g) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final TreeMap<String, String> getMappedItemsForGA(String str, String str2, String str3, String str4, int i2, String str5, int i3, String str6, String str7, int i4) {
            StringBuilder sb;
            TreeMap<String, String> treeMap = new TreeMap<>();
            if (str == null) {
                str = "";
            }
            treeMap.put("id", str);
            if (TextUtils.isEmpty(str5)) {
                if (str2 == null) {
                    str2 = "";
                }
            } else if (str2 == null) {
                str2 = "_".concat(String.valueOf(str5));
            }
            treeMap.put("name", str2);
            if (!TextUtils.isEmpty(str3)) {
                str4 = str3 + '/' + str4;
            } else if (str4 == null) {
                str4 = "";
            }
            treeMap.put("creative", str4);
            if (i3 == -1) {
                sb = new StringBuilder("slot_");
                sb.append(i2 + 1);
            } else {
                sb = new StringBuilder("slot_");
                sb.append(i2 + 1);
                sb.append("_");
                sb.append(i3);
                sb.append("_");
                sb.append(i4);
            }
            treeMap.put(CLPConstants.ARGUMENT_KEY_POSITION, sb.toString());
            if (!TextUtils.isEmpty(str6)) {
                if (str6 == null) {
                    str6 = "";
                }
                treeMap.put("dimension40", str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                if (str7 == null) {
                    str7 = "";
                }
                treeMap.put("label", str7);
            }
            return treeMap;
        }

        public static /* synthetic */ void addToQueue$default(Companion companion, List list, Context context, String str, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                str = "";
            }
            companion.addToQueue(list, context, str);
        }

        public final void addToQueue(List<TreeMap<String, String>> list, Context context, String str) {
            k.c(list, "maps");
            k.c(str, "promotionName");
            if (CLPArtifact.isCLPListenerAvailable()) {
                CLPArtifact instance = CLPArtifact.getInstance();
                k.a((Object) instance, "CLPArtifact.getInstance()");
                instance.getCommunicationListener().addEventToQueue(context, list, str);
            }
        }
    }
}
