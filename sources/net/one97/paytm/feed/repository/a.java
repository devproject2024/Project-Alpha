package net.one97.paytm.feed.repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.feed.repository.models.comment.CommentResponse;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, ArrayList<CommentResponse>> f34358a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static final a f34359b = new a();

    /* renamed from: c  reason: collision with root package name */
    private static ArrayList<CommentResponse> f34360c = new ArrayList<>();

    private a() {
    }

    public static void a(String str, CommentResponse commentResponse) {
        k.c(str, "pID");
        k.c(commentResponse, "commentResponse");
        if (f34358a.containsKey(str)) {
            ArrayList<CommentResponse> arrayList = f34358a.get(str);
            if (arrayList == null) {
                k.a();
            }
            arrayList.add(commentResponse);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(commentResponse);
        f34358a.put(str, arrayList2);
    }

    public static ArrayList<CommentResponse> a(String str, ArrayList<CommentResponse> arrayList, boolean z) {
        k.c(str, "pID");
        k.c(arrayList, "serverList");
        if (!f34358a.containsKey(str) || !z) {
            return new ArrayList<>(kotlin.a.k.a(arrayList, new b()));
        }
        ArrayList arrayList2 = f34358a.get(str);
        if (arrayList2 == null) {
            k.a();
        }
        arrayList2.addAll(arrayList);
        HashSet hashSet = new HashSet();
        ArrayList arrayList3 = new ArrayList();
        for (Object next : arrayList2) {
            if (hashSet.add(((CommentResponse) next).getId())) {
                arrayList3.add(next);
            }
        }
        return new ArrayList<>(kotlin.a.k.a(arrayList3, new C0561a()));
    }

    public static void a(ArrayList<CommentResponse> arrayList) {
        k.c(arrayList, "list");
        f34360c = arrayList;
    }

    public static ArrayList<CommentResponse> a() {
        return f34360c;
    }

    public static void b() {
        f34358a = new HashMap<>();
    }

    /* renamed from: net.one97.paytm.feed.repository.a$a  reason: collision with other inner class name */
    public static final class C0561a<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            a aVar = a.f34359b;
            a aVar2 = a.f34359b;
            return kotlin.b.a.a(Long.valueOf(a.a(((CommentResponse) t2).getCreatedAt())), Long.valueOf(a.a(((CommentResponse) t).getCreatedAt())));
        }
    }

    public static final class b<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            a aVar = a.f34359b;
            a aVar2 = a.f34359b;
            return kotlin.b.a.a(Long.valueOf(a.a(((CommentResponse) t2).getCreatedAt())), Long.valueOf(a.a(((CommentResponse) t).getCreatedAt())));
        }
    }

    public static final /* synthetic */ long a(String str) {
        Date parse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(str);
        k.a((Object) parse, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
        return parse.getTime();
    }
}
