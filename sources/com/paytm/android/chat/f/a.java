package com.paytm.android.chat.f;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.KeyList;
import com.paytm.utility.q;
import com.sendbird.android.constant.StringSet;
import com.zhihu.matisse.b;
import com.zhihu.matisse.c;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.ui.SelectedPreviewActivity;
import exfilepicker.a;
import exfilepicker.data.ExFilePickerResult;
import exfilepicker.ui.activity.ExFilePickerActivity;
import exfilepicker.ui.activity.LocalAudioListActivity;
import exfilepicker.ui.adapter.AudioListAdapter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f42023a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static int f42024b = 9;

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f42025c = {"3gp", "mp3", "mp4", "mkv", "m4a", "aac", "flac", "mid", "wav", "ogg", "imy", "rtttl", "rtx", StringSet.ts, "webm"};

    public static void a(Activity activity, String str) {
        exfilepicker.a aVar = new exfilepicker.a();
        aVar.f46120g = a.C0777a.FILES;
        aVar.l = str;
        Intent intent = new Intent(activity, ExFilePickerActivity.class);
        intent.putExtra("CAN_CHOOSE_ONLY_ONE_ITEM", aVar.f46114a);
        intent.putExtra("SHOW_ONLY_EXTENSIONS", aVar.f46115b);
        intent.putExtra("EXCEPT_EXTENSIONS", aVar.f46116c);
        intent.putExtra("IS_NEW_FOLDER_BUTTON_DISABLED", aVar.f46117d);
        intent.putExtra("IS_SORT_BUTTON_DISABLED", aVar.f46118e);
        intent.putExtra("IS_QUIT_BUTTON_ENABLED", aVar.f46119f);
        intent.putExtra("CHOICE_TYPE", aVar.f46120g);
        intent.putExtra("SORTING_TYPE", aVar.f46121h);
        intent.putExtra("START_DIRECTORY", aVar.f46122i);
        intent.putExtra("USE_FIRST_ITEM_AS_UP_ENABLED", aVar.j);
        intent.putExtra("HIDE_HIDDEN_FILES", aVar.k);
        intent.putExtra("RECEIVER_NAME", aVar.l);
        activity.startActivityForResult(intent, KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_FILE);
    }

    public static void a(Activity activity) {
        com.zhihu.matisse.a a2 = com.zhihu.matisse.a.a(activity);
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.grid_expected_size);
        c c2 = a2.a(b.ofImage(), false).a().a(true).a((com.zhihu.matisse.c.a) new b()).a(f42024b).b().d().c();
        c2.f45721a.o = 1.0f;
        c2.b(dimensionPixelSize).a((com.zhihu.matisse.b.a) new c()).c(KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_MEDIA);
    }

    public static void b(Activity activity) {
        c a2 = com.zhihu.matisse.a.a(activity).a(b.ofImage(), true);
        a2.f45721a.f45781d = R.style.Matisse_Zhihu;
        c a3 = a2.a(false).a((com.zhihu.matisse.c.a) new b()).a(1);
        a3.f45721a.x = true;
        c a4 = a3.a();
        a4.f45721a.r = new com.zhihu.matisse.d.c() {
            public final void a(List<String> list) {
                for (String str : list) {
                    String str2 = a.f42023a;
                    q.a("media path:[" + str + "]");
                }
            }
        };
        a4.b().d().c().b(activity.getResources().getDimensionPixelSize(R.dimen.grid_expected_size)).a((com.zhihu.matisse.b.a) new c()).c(304);
    }

    public static void c(Activity activity) {
        activity.startActivityForResult(new Intent(activity, LocalAudioListActivity.class), KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_AUDIO);
    }

    public static String a(Intent intent) {
        ExFilePickerResult a2 = ExFilePickerResult.a(intent);
        if (a2 == null || a2.f46127c <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < a2.f46127c; i2++) {
            sb.append(a2.f46126b.get(i2));
            if (i2 < a2.f46127c - 1) {
                sb.append(", ");
            }
        }
        return a2.f46125a + sb.toString();
    }

    public static List<Item> d(Intent intent) {
        return intent.getParcelableArrayListExtra("wholesome_items");
    }

    public static List<AudioListAdapter.AudioInfo> e(Intent intent) {
        return intent.getParcelableArrayListExtra("extra_result_audio_path");
    }

    public static void a(Activity activity, int i2, ArrayList<com.zhihu.matisse.a.a> arrayList) {
        Item item;
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.zhihu.matisse.a.a> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            com.zhihu.matisse.a.a next = it2.next();
            if (next.f45718d == null || !new File(next.f45718d).exists()) {
                if (next.f45717c == null || next.f45717c.isEmpty()) {
                    item = new Item(Uri.parse(next.f45716b), next.f45716b, next.f45719e, next.f45715a);
                } else {
                    item = new Item(Uri.parse(next.f45717c), next.f45716b, next.f45719e, next.f45715a);
                }
                arrayList2.add(item);
            } else {
                arrayList2.add(new Item(Uri.fromFile(new File(next.f45718d))));
            }
        }
        com.zhihu.matisse.internal.entity.c.a().f45782e = -1;
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("state_selection", new ArrayList(arrayList2));
        bundle.putInt("CURRENT_POSITION", i2);
        Intent intent = new Intent(activity, SelectedPreviewActivity.class);
        intent.putExtra("extra_default_bundle", bundle);
        intent.putExtra("extra_preview_only", true);
        activity.startActivityForResult(intent, 306);
    }

    public static final String a(Context context) {
        return context.getPackageName() + ".provider";
    }

    public static List<Uri> b(Intent intent) {
        return intent.getParcelableArrayListExtra("extra_result_selection");
    }

    public static List<String> c(Intent intent) {
        return intent.getStringArrayListExtra("extra_result_selection_path");
    }
}
