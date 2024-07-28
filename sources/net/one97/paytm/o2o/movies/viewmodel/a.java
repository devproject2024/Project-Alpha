package net.one97.paytm.o2o.movies.viewmodel;

import android.app.Activity;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.android.volley.RequestQueue;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.common.entity.movies.CJRMovieEntertainmentModel;
import net.one97.paytm.common.entity.movies.CJRMoviesCastCrewItem;
import net.one97.paytm.common.entity.movies.CJRMoviesCastCrewList;
import net.one97.paytm.o2o.movies.common.movies.CJRMovieUpvoteResponse;
import net.one97.paytm.o2o.movies.common.movies.CJRMoviesContentCastCrewModel;
import net.one97.paytm.o2o.movies.entity.CJRAboutMovieVideoModel;
import net.one97.paytm.o2o.movies.entity.SentimentInterestedItem;

public final class a extends ai {

    /* renamed from: a  reason: collision with root package name */
    public y<k<List<g>>> f76005a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<k<j>> f76006b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public boolean f76007c;

    /* renamed from: d  reason: collision with root package name */
    public k<j> f76008d;

    public enum d {
        NETWORK,
        SERVER,
        CUSTOM
    }

    public enum h {
        BANNER,
        SYNOPSIS,
        INTEREST,
        LIKEDISLIKE,
        VIDEO,
        GALLERY,
        BLOG,
        LEAD_CAST
    }

    public enum l {
        SUCCESS,
        ERROR,
        LOADING,
        NONE
    }

    public static void a(com.paytm.network.a aVar) {
        kotlin.g.b.k.c(aVar, "requestPayload");
        aVar.a();
    }

    public final void a(NetworkCustomError networkCustomError) {
        if (networkCustomError instanceof NetworkCustomError) {
            String alertMessage = networkCustomError.getAlertMessage();
            String str = "";
            if (alertMessage == null) {
                alertMessage = str;
            }
            String alertTitle = networkCustomError.getAlertTitle();
            if (alertTitle != null) {
                str = alertTitle;
            }
            this.f76005a.postValue(new k(l.ERROR, null, new c(d.CUSTOM, new Throwable(networkCustomError), str, alertMessage)));
            return;
        }
        this.f76005a.postValue(new k(l.ERROR, null, (c) null));
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRMoviesContentCastCrewModel) {
            CJRMoviesContentCastCrewModel cJRMoviesContentCastCrewModel = (CJRMoviesContentCastCrewModel) iJRPaytmDataModel;
            if (cJRMoviesContentCastCrewModel.getContentId() != null) {
                List arrayList = new ArrayList();
                arrayList.add(a(cJRMoviesContentCastCrewModel));
                arrayList.add(b(cJRMoviesContentCastCrewModel));
                arrayList.add(c(cJRMoviesContentCastCrewModel));
                arrayList.add(d(cJRMoviesContentCastCrewModel));
                arrayList.add(e(cJRMoviesContentCastCrewModel));
                arrayList.add(f(cJRMoviesContentCastCrewModel));
                this.f76005a.postValue(new k(l.SUCCESS, kotlin.a.k.d(arrayList)));
                k<j> kVar = this.f76008d;
                if (kVar != null) {
                    this.f76006b.postValue(kVar);
                    return;
                } else {
                    this.f76007c = true;
                    return;
                }
            }
        }
        this.f76005a.postValue(new k(l.ERROR, null, (c) null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b9, code lost:
        r0 = (r0 = (net.one97.paytm.o2o.movies.common.movies.CJRMovieMainBannerVideo) kotlin.a.k.d(r0)).getUrl();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static net.one97.paytm.o2o.movies.viewmodel.a.C1499a a(net.one97.paytm.o2o.movies.common.movies.CJRMoviesContentCastCrewModel r16) {
        /*
            int r0 = r16.getRuntime()
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0022
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r2 = r16.getRuntime()
            java.lang.String r2 = net.one97.paytm.o2o.movies.utils.n.a((int) r2)
            r0.append(r2)
            r2 = 124(0x7c, float:1.74E-43)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            java.util.ArrayList r2 = r16.getLanguage()
            if (r2 == 0) goto L_0x0036
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r2 = kotlin.a.k.d(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r6 = r2
            goto L_0x0037
        L_0x0036:
            r6 = r1
        L_0x0037:
            java.util.ArrayList r2 = r16.getGenre()
            if (r2 == 0) goto L_0x004e
            r7 = r2
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 63
            java.lang.String r2 = kotlin.a.k.a((java.lang.Iterable) r7, (java.lang.CharSequence) r8, (java.lang.CharSequence) r9, (java.lang.CharSequence) r10, (int) r11, (java.lang.CharSequence) r12, (kotlin.g.a.b) r13, (int) r14)
            if (r2 != 0) goto L_0x004f
        L_0x004e:
            r2 = r1
        L_0x004f:
            java.lang.String r3 = r16.getCertification()
            java.lang.String r4 = " | "
            if (r3 == 0) goto L_0x0061
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r3 = r4.concat(r3)
            if (r3 != 0) goto L_0x0062
        L_0x0061:
            r3 = r1
        L_0x0062:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r0)
            r5.append(r6)
            r5.append(r4)
            r5.append(r2)
            r5.append(r3)
            java.lang.String r7 = r5.toString()
            net.one97.paytm.common.entity.movies.CJRMoviesCastCrewList r0 = r16.getmCjrMoviesCastList()
            if (r0 == 0) goto L_0x009e
            java.util.ArrayList r0 = r0.getCastCrewList()
            if (r0 == 0) goto L_0x009e
            r8 = r0
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            net.one97.paytm.o2o.movies.viewmodel.a$t r0 = net.one97.paytm.o2o.movies.viewmodel.a.t.INSTANCE
            r14 = r0
            kotlin.g.a.b r14 = (kotlin.g.a.b) r14
            r15 = 31
            java.lang.String r0 = kotlin.a.k.a((java.lang.Iterable) r8, (java.lang.CharSequence) r9, (java.lang.CharSequence) r10, (java.lang.CharSequence) r11, (int) r12, (java.lang.CharSequence) r13, (kotlin.g.a.b) r14, (int) r15)
            if (r0 != 0) goto L_0x009c
            goto L_0x009e
        L_0x009c:
            r8 = r0
            goto L_0x009f
        L_0x009e:
            r8 = r1
        L_0x009f:
            java.lang.String r0 = r16.getmMovie_name()
            if (r0 != 0) goto L_0x00a7
            r4 = r1
            goto L_0x00a8
        L_0x00a7:
            r4 = r0
        L_0x00a8:
            java.util.ArrayList r0 = r16.getMain_banner_video()
            r1 = 0
            if (r0 == 0) goto L_0x00c5
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = kotlin.a.k.d(r0)
            net.one97.paytm.o2o.movies.common.movies.CJRMovieMainBannerVideo r0 = (net.one97.paytm.o2o.movies.common.movies.CJRMovieMainBannerVideo) r0
            if (r0 == 0) goto L_0x00c5
            java.lang.String r0 = r0.getUrl()
            if (r0 == 0) goto L_0x00c5
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.a.d.a(r0)
            r9 = r0
            goto L_0x00c6
        L_0x00c5:
            r9 = r1
        L_0x00c6:
            java.util.ArrayList r0 = r16.getMain_banner_video()
            if (r0 == 0) goto L_0x00e1
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = kotlin.a.k.d(r0)
            net.one97.paytm.o2o.movies.common.movies.CJRMovieMainBannerVideo r0 = (net.one97.paytm.o2o.movies.common.movies.CJRMovieMainBannerVideo) r0
            if (r0 == 0) goto L_0x00e1
            java.lang.String r0 = r0.getUrl2()
            if (r0 == 0) goto L_0x00e1
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.a.d.a(r0)
            goto L_0x00e2
        L_0x00e1:
            r0 = r1
        L_0x00e2:
            java.lang.String r0 = com.paytm.utility.b.e((java.lang.String) r0)
            if (r0 != 0) goto L_0x0106
            java.util.ArrayList r0 = r16.getMain_banner_video()
            if (r0 == 0) goto L_0x0102
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = kotlin.a.k.d(r0)
            net.one97.paytm.o2o.movies.common.movies.CJRMovieMainBannerVideo r0 = (net.one97.paytm.o2o.movies.common.movies.CJRMovieMainBannerVideo) r0
            if (r0 == 0) goto L_0x0102
            java.lang.String r0 = r0.getUrl2()
            if (r0 == 0) goto L_0x0102
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.a.d.a(r0)
        L_0x0102:
            java.lang.String r0 = com.paytm.utility.b.f((java.lang.String) r1)
        L_0x0106:
            r10 = r0
            net.one97.paytm.o2o.movies.viewmodel.a$a r0 = new net.one97.paytm.o2o.movies.viewmodel.a$a
            java.lang.String r5 = r16.getmMovie_id()
            java.lang.String r1 = "response.getmMovie_id()"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.viewmodel.a.a(net.one97.paytm.o2o.movies.common.movies.CJRMoviesContentCastCrewModel):net.one97.paytm.o2o.movies.viewmodel.a$a");
    }

    static final class t extends kotlin.g.b.l implements kotlin.g.a.b<CJRMoviesCastCrewItem, String> {
        public static final t INSTANCE = new t();

        t() {
            super(1);
        }

        public final String invoke(CJRMoviesCastCrewItem cJRMoviesCastCrewItem) {
            kotlin.g.b.k.a((Object) cJRMoviesCastCrewItem, "item");
            String name = cJRMoviesCastCrewItem.getName();
            kotlin.g.b.k.a((Object) name, "item.name");
            return name;
        }
    }

    private static m b(CJRMoviesContentCastCrewModel cJRMoviesContentCastCrewModel) {
        String str = cJRMoviesContentCastCrewModel.getmMovie_name();
        if (str == null) {
            str = "";
        }
        String str2 = cJRMoviesContentCastCrewModel.getmTitle();
        if (str2 == null) {
            str2 = "";
        }
        String str3 = cJRMoviesContentCastCrewModel.getmSummary();
        if (str3 == null) {
            str3 = "";
        }
        return new m(str, str2, str3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r2 = r10.getUserInput();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.one97.paytm.o2o.movies.viewmodel.a.f a(net.one97.paytm.o2o.movies.entity.SentimentInterestedItem r10) {
        /*
            r0 = 1
            java.lang.String r1 = "yes"
            if (r10 == 0) goto L_0x0011
            java.lang.String r2 = r10.getUserInput()
            if (r2 == 0) goto L_0x0011
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r1, (boolean) r0)
            goto L_0x0012
        L_0x0011:
            r2 = 0
        L_0x0012:
            net.one97.paytm.o2o.movies.viewmodel.a$f r9 = new net.one97.paytm.o2o.movies.viewmodel.a$f
            if (r10 == 0) goto L_0x0024
            java.util.HashMap r10 = r10.getCountInfo()
            if (r10 == 0) goto L_0x0024
            java.lang.Object r10 = r10.get(r1)
            java.lang.Long r10 = (java.lang.Long) r10
            if (r10 != 0) goto L_0x002a
        L_0x0024:
            r3 = 0
            java.lang.Long r10 = java.lang.Long.valueOf(r3)
        L_0x002a:
            long r4 = r10.longValue()
            r6 = r2 ^ 1
            r7 = 0
            r8 = 1
            r3 = r9
            r3.<init>(r4, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.viewmodel.a.a(net.one97.paytm.o2o.movies.entity.SentimentInterestedItem):net.one97.paytm.o2o.movies.viewmodel.a$f");
    }

    private static n c(CJRMoviesContentCastCrewModel cJRMoviesContentCastCrewModel) {
        String videoHeading = cJRMoviesContentCastCrewModel.getVideoHeading();
        if (videoHeading == null) {
            videoHeading = "";
        }
        Integer contentId = cJRMoviesContentCastCrewModel.getContentId();
        kotlin.g.b.k.a((Object) contentId, "response.contentId");
        int intValue = contentId.intValue();
        ArrayList<CJRAboutMovieVideoModel> videoList = cJRMoviesContentCastCrewModel.getVideoList();
        if (videoList == null) {
            videoList = new ArrayList<>();
        }
        return new n(videoHeading, intValue, videoList);
    }

    private static e d(CJRMoviesContentCastCrewModel cJRMoviesContentCastCrewModel) {
        String postersHeading = cJRMoviesContentCastCrewModel.getPostersHeading();
        if (postersHeading == null) {
            postersHeading = "";
        }
        ArrayList<String> galleryList = cJRMoviesContentCastCrewModel.getGalleryList();
        if (galleryList == null) {
            galleryList = new ArrayList<>();
        }
        return new e(postersHeading, galleryList);
    }

    private static b e(CJRMoviesContentCastCrewModel cJRMoviesContentCastCrewModel) {
        String blogHeading = cJRMoviesContentCastCrewModel.getBlogHeading();
        if (blogHeading == null) {
            blogHeading = "";
        }
        ArrayList<CJRMovieEntertainmentModel> entertainmentModels = cJRMoviesContentCastCrewModel.getEntertainmentModels();
        if (entertainmentModels == null) {
            entertainmentModels = new ArrayList<>();
        }
        return new b(blogHeading, entertainmentModels);
    }

    private static i f(CJRMoviesContentCastCrewModel cJRMoviesContentCastCrewModel) {
        String str;
        ArrayList<CJRMoviesCastCrewItem> arrayList;
        CJRMoviesCastCrewList cJRMoviesCastCrewList = cJRMoviesContentCastCrewModel.getmCjrMoviesCastList();
        if (cJRMoviesCastCrewList == null || (str = cJRMoviesCastCrewList.getTitle()) == null) {
            str = "";
        }
        CJRMoviesCastCrewList cJRMoviesCastCrewList2 = cJRMoviesContentCastCrewModel.getmCjrMoviesCastList();
        if (cJRMoviesCastCrewList2 == null || (arrayList = cJRMoviesCastCrewList2.getCastCrewList()) == null) {
            arrayList = new ArrayList<>();
        }
        return new i(str, arrayList, cJRMoviesContentCastCrewModel.isActorClickable());
    }

    public final void a(Activity activity, String str) {
        j jVar;
        f fVar;
        Activity activity2 = activity;
        String str2 = str;
        kotlin.g.b.k.c(activity2, "context");
        kotlin.g.b.k.c(str2, "selectedCode");
        k value = this.f76006b.getValue();
        if (!(value == null || (jVar = (j) value.f76037b) == null)) {
            f fVar2 = jVar.f76034a;
            if (fVar2 != null) {
                fVar = f.a(fVar2, 0, false, false, false, 7);
            } else {
                fVar = null;
            }
            SentimentInterestedItem sentimentInterestedItem = jVar.f76035b;
            this.f76006b.postValue(new k(l.LOADING, j.a(fVar, sentimentInterestedItem != null ? SentimentInterestedItem.copy$default(sentimentInterestedItem, (String) null, (Boolean) null, (HashMap) null, (String) null, 15, (Object) null) : null), (c) null));
        }
        net.one97.paytm.o2o.movies.utils.j.a(activity2, str2, new s(this), "interested", H5AppHandler.CHECK_VALUE);
    }

    public static final class s implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f76056a;

        s(a aVar) {
            this.f76056a = aVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            j jVar;
            f fVar;
            k value = this.f76056a.f76006b.getValue();
            if (value != null && (jVar = (j) value.f76037b) != null) {
                f fVar2 = jVar.f76034a;
                if (fVar2 != null) {
                    fVar = f.a(fVar2, 0, true, false, true, 1);
                } else {
                    fVar = null;
                }
                SentimentInterestedItem sentimentInterestedItem = jVar.f76035b;
                this.f76056a.f76006b.postValue(new k(l.ERROR, j.a(fVar, sentimentInterestedItem != null ? SentimentInterestedItem.copy$default(sentimentInterestedItem, (String) null, (Boolean) null, (HashMap) null, (String) null, 15, (Object) null) : null), (c) null));
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            j jVar;
            f fVar;
            k value = this.f76056a.f76006b.getValue();
            if (value != null && (jVar = (j) value.f76037b) != null && (iJRPaytmDataModel instanceof CJRMovieUpvoteResponse)) {
                if (jVar.f76034a != null) {
                    f fVar2 = jVar.f76034a;
                    if (fVar2 == null) {
                        kotlin.g.b.k.a();
                    }
                    fVar = f.a(fVar2.f76026a + 1, false, true, false);
                } else {
                    fVar = null;
                }
                SentimentInterestedItem sentimentInterestedItem = jVar.f76035b;
                this.f76056a.f76006b.postValue(new k(l.SUCCESS, j.a(fVar, sentimentInterestedItem != null ? SentimentInterestedItem.copy$default(sentimentInterestedItem, (String) null, (Boolean) null, (HashMap) null, (String) null, 15, (Object) null) : null), (c) null));
            }
        }
    }

    public static final class q implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f76050a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f76051b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f76052c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f76053d;

        q(a aVar, Activity activity, int i2, String str) {
            this.f76050a = aVar;
            this.f76051b = activity;
            this.f76052c = i2;
            this.f76053d = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0038, code lost:
            r2 = (net.one97.paytm.o2o.movies.viewmodel.a.j) (r2 = r2.getValue()).f76037b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r5) {
            /*
                r4 = this;
                java.lang.String r0 = "ijrPaytmDataModel"
                kotlin.g.b.k.c(r5, r0)
                android.app.Activity r5 = r4.f76051b
                android.content.Context r5 = (android.content.Context) r5
                int r0 = net.one97.paytm.o2o.movies.R.string.thanks_for_interest
                r1 = 0
                android.widget.Toast r5 = android.widget.Toast.makeText(r5, r0, r1)
                r5.show()
                net.one97.paytm.o2o.movies.viewmodel.a r5 = r4.f76050a
                int r0 = r4.f76052c
                r2 = 1
                r3 = 2
                if (r0 == r3) goto L_0x001c
                r1 = 1
            L_0x001c:
                java.lang.String r0 = "liked"
                net.one97.paytm.o2o.movies.viewmodel.a.a(r5, r0, r2, r1)
                net.one97.paytm.o2o.movies.viewmodel.a r5 = r4.f76050a
                androidx.lifecycle.y<net.one97.paytm.o2o.movies.viewmodel.a$k<net.one97.paytm.o2o.movies.viewmodel.a$j>> r5 = r5.f76006b
                net.one97.paytm.o2o.movies.viewmodel.a$k r0 = new net.one97.paytm.o2o.movies.viewmodel.a$k
                net.one97.paytm.o2o.movies.viewmodel.a$l r1 = net.one97.paytm.o2o.movies.viewmodel.a.l.SUCCESS
                net.one97.paytm.o2o.movies.viewmodel.a r2 = r4.f76050a
                androidx.lifecycle.y<net.one97.paytm.o2o.movies.viewmodel.a$k<net.one97.paytm.o2o.movies.viewmodel.a$j>> r2 = r2.f76006b
                r3 = 0
                if (r2 == 0) goto L_0x0043
                java.lang.Object r2 = r2.getValue()
                net.one97.paytm.o2o.movies.viewmodel.a$k r2 = (net.one97.paytm.o2o.movies.viewmodel.a.k) r2
                if (r2 == 0) goto L_0x0043
                T r2 = r2.f76037b
                net.one97.paytm.o2o.movies.viewmodel.a$j r2 = (net.one97.paytm.o2o.movies.viewmodel.a.j) r2
                if (r2 == 0) goto L_0x0043
                net.one97.paytm.o2o.movies.viewmodel.a$j r2 = net.one97.paytm.o2o.movies.viewmodel.a.j.a(r2.f76034a, r2.f76035b)
                goto L_0x0044
            L_0x0043:
                r2 = r3
            L_0x0044:
                r0.<init>(r1, r2, r3)
                r5.postValue(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.viewmodel.a.q.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
            r0 = (net.one97.paytm.o2o.movies.viewmodel.a.j) (r0 = r0.getValue()).f76037b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleErrorCode(int r3, com.paytm.network.model.IJRPaytmDataModel r4, com.paytm.network.model.NetworkCustomError r5) {
            /*
                r2 = this;
                java.lang.String r3 = "ijrPaytmDataModel"
                kotlin.g.b.k.c(r4, r3)
                java.lang.String r3 = "networkCustomError"
                kotlin.g.b.k.c(r5, r3)
                net.one97.paytm.o2o.movies.viewmodel.a r3 = r2.f76050a
                androidx.lifecycle.y<net.one97.paytm.o2o.movies.viewmodel.a$k<net.one97.paytm.o2o.movies.viewmodel.a$j>> r3 = r3.f76006b
                if (r3 == 0) goto L_0x0047
                java.lang.Object r3 = r3.getValue()
                net.one97.paytm.o2o.movies.viewmodel.a$k r3 = (net.one97.paytm.o2o.movies.viewmodel.a.k) r3
                if (r3 == 0) goto L_0x0047
                T r3 = r3.f76037b
                net.one97.paytm.o2o.movies.viewmodel.a$j r3 = (net.one97.paytm.o2o.movies.viewmodel.a.j) r3
                if (r3 == 0) goto L_0x0047
                net.one97.paytm.o2o.movies.viewmodel.a r3 = r2.f76050a
                androidx.lifecycle.y<net.one97.paytm.o2o.movies.viewmodel.a$k<net.one97.paytm.o2o.movies.viewmodel.a$j>> r3 = r3.f76006b
                net.one97.paytm.o2o.movies.viewmodel.a$k r4 = new net.one97.paytm.o2o.movies.viewmodel.a$k
                net.one97.paytm.o2o.movies.viewmodel.a$l r5 = net.one97.paytm.o2o.movies.viewmodel.a.l.ERROR
                net.one97.paytm.o2o.movies.viewmodel.a r0 = r2.f76050a
                androidx.lifecycle.y<net.one97.paytm.o2o.movies.viewmodel.a$k<net.one97.paytm.o2o.movies.viewmodel.a$j>> r0 = r0.f76006b
                r1 = 0
                if (r0 == 0) goto L_0x0040
                java.lang.Object r0 = r0.getValue()
                net.one97.paytm.o2o.movies.viewmodel.a$k r0 = (net.one97.paytm.o2o.movies.viewmodel.a.k) r0
                if (r0 == 0) goto L_0x0040
                T r0 = r0.f76037b
                net.one97.paytm.o2o.movies.viewmodel.a$j r0 = (net.one97.paytm.o2o.movies.viewmodel.a.j) r0
                if (r0 == 0) goto L_0x0040
                net.one97.paytm.o2o.movies.viewmodel.a$j r0 = net.one97.paytm.o2o.movies.viewmodel.a.j.a(r0.f76034a, r0.f76035b)
                goto L_0x0041
            L_0x0040:
                r0 = r1
            L_0x0041:
                r4.<init>(r5, r0, r1)
                r3.postValue(r4)
            L_0x0047:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.viewmodel.a.q.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
        }
    }

    public final void a(int i2, String str, Activity activity) {
        kotlin.g.b.k.c(str, "mMovieCode");
        kotlin.g.b.k.c(activity, "context");
        if (i2 != 1) {
            net.one97.paytm.o2o.movies.utils.j.a(activity, str, new q(this, activity, i2, str), "sentiment", "liked");
        } else if (i2 == 1) {
            net.one97.paytm.o2o.movies.utils.j.a(activity, str, (com.paytm.network.listener.b) new r(this, str), "sentiment");
        }
    }

    public static final class r implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f76054a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f76055b;

        r(a aVar, String str) {
            this.f76054a = aVar;
            this.f76055b = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0025, code lost:
            r2 = (net.one97.paytm.o2o.movies.viewmodel.a.j) (r2 = r2.getValue()).f76037b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r5) {
            /*
                r4 = this;
                java.lang.String r0 = "ijrPaytmDataModel"
                kotlin.g.b.k.c(r5, r0)
                net.one97.paytm.o2o.movies.viewmodel.a r5 = r4.f76054a
                java.lang.String r0 = "liked"
                r1 = 0
                r2 = 1
                net.one97.paytm.o2o.movies.viewmodel.a.a(r5, r0, r1, r2)
                net.one97.paytm.o2o.movies.viewmodel.a r5 = r4.f76054a
                androidx.lifecycle.y<net.one97.paytm.o2o.movies.viewmodel.a$k<net.one97.paytm.o2o.movies.viewmodel.a$j>> r5 = r5.f76006b
                net.one97.paytm.o2o.movies.viewmodel.a$k r0 = new net.one97.paytm.o2o.movies.viewmodel.a$k
                net.one97.paytm.o2o.movies.viewmodel.a$l r1 = net.one97.paytm.o2o.movies.viewmodel.a.l.SUCCESS
                net.one97.paytm.o2o.movies.viewmodel.a r2 = r4.f76054a
                androidx.lifecycle.y<net.one97.paytm.o2o.movies.viewmodel.a$k<net.one97.paytm.o2o.movies.viewmodel.a$j>> r2 = r2.f76006b
                r3 = 0
                if (r2 == 0) goto L_0x0030
                java.lang.Object r2 = r2.getValue()
                net.one97.paytm.o2o.movies.viewmodel.a$k r2 = (net.one97.paytm.o2o.movies.viewmodel.a.k) r2
                if (r2 == 0) goto L_0x0030
                T r2 = r2.f76037b
                net.one97.paytm.o2o.movies.viewmodel.a$j r2 = (net.one97.paytm.o2o.movies.viewmodel.a.j) r2
                if (r2 == 0) goto L_0x0030
                net.one97.paytm.o2o.movies.viewmodel.a$j r2 = net.one97.paytm.o2o.movies.viewmodel.a.j.a(r2.f76034a, r2.f76035b)
                goto L_0x0031
            L_0x0030:
                r2 = r3
            L_0x0031:
                r0.<init>(r1, r2, r3)
                r5.postValue(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.viewmodel.a.r.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
            r0 = (net.one97.paytm.o2o.movies.viewmodel.a.j) (r0 = r0.getValue()).f76037b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleErrorCode(int r3, com.paytm.network.model.IJRPaytmDataModel r4, com.paytm.network.model.NetworkCustomError r5) {
            /*
                r2 = this;
                java.lang.String r3 = "ijrPaytmDataModel"
                kotlin.g.b.k.c(r4, r3)
                java.lang.String r3 = "networkCustomError"
                kotlin.g.b.k.c(r5, r3)
                net.one97.paytm.o2o.movies.viewmodel.a r3 = r2.f76054a
                androidx.lifecycle.y<net.one97.paytm.o2o.movies.viewmodel.a$k<net.one97.paytm.o2o.movies.viewmodel.a$j>> r3 = r3.f76006b
                if (r3 == 0) goto L_0x0047
                java.lang.Object r3 = r3.getValue()
                net.one97.paytm.o2o.movies.viewmodel.a$k r3 = (net.one97.paytm.o2o.movies.viewmodel.a.k) r3
                if (r3 == 0) goto L_0x0047
                T r3 = r3.f76037b
                net.one97.paytm.o2o.movies.viewmodel.a$j r3 = (net.one97.paytm.o2o.movies.viewmodel.a.j) r3
                if (r3 == 0) goto L_0x0047
                net.one97.paytm.o2o.movies.viewmodel.a r3 = r2.f76054a
                androidx.lifecycle.y<net.one97.paytm.o2o.movies.viewmodel.a$k<net.one97.paytm.o2o.movies.viewmodel.a$j>> r3 = r3.f76006b
                net.one97.paytm.o2o.movies.viewmodel.a$k r4 = new net.one97.paytm.o2o.movies.viewmodel.a$k
                net.one97.paytm.o2o.movies.viewmodel.a$l r5 = net.one97.paytm.o2o.movies.viewmodel.a.l.ERROR
                net.one97.paytm.o2o.movies.viewmodel.a r0 = r2.f76054a
                androidx.lifecycle.y<net.one97.paytm.o2o.movies.viewmodel.a$k<net.one97.paytm.o2o.movies.viewmodel.a$j>> r0 = r0.f76006b
                r1 = 0
                if (r0 == 0) goto L_0x0040
                java.lang.Object r0 = r0.getValue()
                net.one97.paytm.o2o.movies.viewmodel.a$k r0 = (net.one97.paytm.o2o.movies.viewmodel.a.k) r0
                if (r0 == 0) goto L_0x0040
                T r0 = r0.f76037b
                net.one97.paytm.o2o.movies.viewmodel.a$j r0 = (net.one97.paytm.o2o.movies.viewmodel.a.j) r0
                if (r0 == 0) goto L_0x0040
                net.one97.paytm.o2o.movies.viewmodel.a$j r0 = net.one97.paytm.o2o.movies.viewmodel.a.j.a(r0.f76034a, r0.f76035b)
                goto L_0x0041
            L_0x0040:
                r0 = r1
            L_0x0041:
                r4.<init>(r5, r0, r1)
                r3.postValue(r4)
            L_0x0047:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.viewmodel.a.r.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
        }
    }

    public static final class o implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f76045a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f76046b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f76047c;

        o(a aVar, int i2, String str) {
            this.f76045a = aVar;
            this.f76046b = i2;
            this.f76047c = str;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k value;
            j jVar;
            kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            a.a(this.f76045a, "disliked", true, this.f76046b != 1);
            y<k<j>> yVar = this.f76045a.f76006b;
            l lVar = l.SUCCESS;
            y<k<j>> yVar2 = this.f76045a.f76006b;
            yVar.postValue(new k(lVar, (yVar2 == null || (value = yVar2.getValue()) == null || (jVar = (j) value.f76037b) == null) ? null : j.a(jVar.f76034a, jVar.f76035b), (c) null));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
            r0 = (net.one97.paytm.o2o.movies.viewmodel.a.j) (r0 = r0.getValue()).f76037b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleErrorCode(int r3, com.paytm.network.model.IJRPaytmDataModel r4, com.paytm.network.model.NetworkCustomError r5) {
            /*
                r2 = this;
                java.lang.String r3 = "ijrPaytmDataModel"
                kotlin.g.b.k.c(r4, r3)
                java.lang.String r3 = "networkCustomError"
                kotlin.g.b.k.c(r5, r3)
                net.one97.paytm.o2o.movies.viewmodel.a r3 = r2.f76045a
                androidx.lifecycle.y<net.one97.paytm.o2o.movies.viewmodel.a$k<net.one97.paytm.o2o.movies.viewmodel.a$j>> r3 = r3.f76006b
                if (r3 == 0) goto L_0x0047
                java.lang.Object r3 = r3.getValue()
                net.one97.paytm.o2o.movies.viewmodel.a$k r3 = (net.one97.paytm.o2o.movies.viewmodel.a.k) r3
                if (r3 == 0) goto L_0x0047
                T r3 = r3.f76037b
                net.one97.paytm.o2o.movies.viewmodel.a$j r3 = (net.one97.paytm.o2o.movies.viewmodel.a.j) r3
                if (r3 == 0) goto L_0x0047
                net.one97.paytm.o2o.movies.viewmodel.a r3 = r2.f76045a
                androidx.lifecycle.y<net.one97.paytm.o2o.movies.viewmodel.a$k<net.one97.paytm.o2o.movies.viewmodel.a$j>> r3 = r3.f76006b
                net.one97.paytm.o2o.movies.viewmodel.a$k r4 = new net.one97.paytm.o2o.movies.viewmodel.a$k
                net.one97.paytm.o2o.movies.viewmodel.a$l r5 = net.one97.paytm.o2o.movies.viewmodel.a.l.ERROR
                net.one97.paytm.o2o.movies.viewmodel.a r0 = r2.f76045a
                androidx.lifecycle.y<net.one97.paytm.o2o.movies.viewmodel.a$k<net.one97.paytm.o2o.movies.viewmodel.a$j>> r0 = r0.f76006b
                r1 = 0
                if (r0 == 0) goto L_0x0040
                java.lang.Object r0 = r0.getValue()
                net.one97.paytm.o2o.movies.viewmodel.a$k r0 = (net.one97.paytm.o2o.movies.viewmodel.a.k) r0
                if (r0 == 0) goto L_0x0040
                T r0 = r0.f76037b
                net.one97.paytm.o2o.movies.viewmodel.a$j r0 = (net.one97.paytm.o2o.movies.viewmodel.a.j) r0
                if (r0 == 0) goto L_0x0040
                net.one97.paytm.o2o.movies.viewmodel.a$j r0 = net.one97.paytm.o2o.movies.viewmodel.a.j.a(r0.f76034a, r0.f76035b)
                goto L_0x0041
            L_0x0040:
                r0 = r1
            L_0x0041:
                r4.<init>(r5, r0, r1)
                r3.postValue(r4)
            L_0x0047:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.viewmodel.a.o.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
        }
    }

    public final void b(int i2, String str, Activity activity) {
        kotlin.g.b.k.c(str, "mMovieCode");
        kotlin.g.b.k.c(activity, "context");
        if (i2 != 2) {
            net.one97.paytm.o2o.movies.utils.j.a(activity, str, new o(this, i2, str), "sentiment", "disliked");
        } else if (i2 == 2) {
            net.one97.paytm.o2o.movies.utils.j.a(activity, str, (com.paytm.network.listener.b) new p(this, str), "sentiment");
        }
    }

    public static final class p implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f76048a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f76049b;

        p(a aVar, String str) {
            this.f76048a = aVar;
            this.f76049b = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0025, code lost:
            r2 = (net.one97.paytm.o2o.movies.viewmodel.a.j) (r2 = r2.getValue()).f76037b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r5) {
            /*
                r4 = this;
                java.lang.String r0 = "ijrPaytmDataModel"
                kotlin.g.b.k.c(r5, r0)
                net.one97.paytm.o2o.movies.viewmodel.a r5 = r4.f76048a
                java.lang.String r0 = "disliked"
                r1 = 0
                r2 = 1
                net.one97.paytm.o2o.movies.viewmodel.a.a(r5, r0, r1, r2)
                net.one97.paytm.o2o.movies.viewmodel.a r5 = r4.f76048a
                androidx.lifecycle.y<net.one97.paytm.o2o.movies.viewmodel.a$k<net.one97.paytm.o2o.movies.viewmodel.a$j>> r5 = r5.f76006b
                net.one97.paytm.o2o.movies.viewmodel.a$k r0 = new net.one97.paytm.o2o.movies.viewmodel.a$k
                net.one97.paytm.o2o.movies.viewmodel.a$l r1 = net.one97.paytm.o2o.movies.viewmodel.a.l.SUCCESS
                net.one97.paytm.o2o.movies.viewmodel.a r2 = r4.f76048a
                androidx.lifecycle.y<net.one97.paytm.o2o.movies.viewmodel.a$k<net.one97.paytm.o2o.movies.viewmodel.a$j>> r2 = r2.f76006b
                r3 = 0
                if (r2 == 0) goto L_0x0030
                java.lang.Object r2 = r2.getValue()
                net.one97.paytm.o2o.movies.viewmodel.a$k r2 = (net.one97.paytm.o2o.movies.viewmodel.a.k) r2
                if (r2 == 0) goto L_0x0030
                T r2 = r2.f76037b
                net.one97.paytm.o2o.movies.viewmodel.a$j r2 = (net.one97.paytm.o2o.movies.viewmodel.a.j) r2
                if (r2 == 0) goto L_0x0030
                net.one97.paytm.o2o.movies.viewmodel.a$j r2 = net.one97.paytm.o2o.movies.viewmodel.a.j.a(r2.f76034a, r2.f76035b)
                goto L_0x0031
            L_0x0030:
                r2 = r3
            L_0x0031:
                r0.<init>(r1, r2, r3)
                r5.postValue(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.viewmodel.a.p.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
            r0 = (net.one97.paytm.o2o.movies.viewmodel.a.j) (r0 = r0.getValue()).f76037b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleErrorCode(int r3, com.paytm.network.model.IJRPaytmDataModel r4, com.paytm.network.model.NetworkCustomError r5) {
            /*
                r2 = this;
                java.lang.String r3 = "ijrPaytmDataModel"
                kotlin.g.b.k.c(r4, r3)
                java.lang.String r3 = "networkCustomError"
                kotlin.g.b.k.c(r5, r3)
                net.one97.paytm.o2o.movies.viewmodel.a r3 = r2.f76048a
                androidx.lifecycle.y<net.one97.paytm.o2o.movies.viewmodel.a$k<net.one97.paytm.o2o.movies.viewmodel.a$j>> r3 = r3.f76006b
                if (r3 == 0) goto L_0x0047
                java.lang.Object r3 = r3.getValue()
                net.one97.paytm.o2o.movies.viewmodel.a$k r3 = (net.one97.paytm.o2o.movies.viewmodel.a.k) r3
                if (r3 == 0) goto L_0x0047
                T r3 = r3.f76037b
                net.one97.paytm.o2o.movies.viewmodel.a$j r3 = (net.one97.paytm.o2o.movies.viewmodel.a.j) r3
                if (r3 == 0) goto L_0x0047
                net.one97.paytm.o2o.movies.viewmodel.a r3 = r2.f76048a
                androidx.lifecycle.y<net.one97.paytm.o2o.movies.viewmodel.a$k<net.one97.paytm.o2o.movies.viewmodel.a$j>> r3 = r3.f76006b
                net.one97.paytm.o2o.movies.viewmodel.a$k r4 = new net.one97.paytm.o2o.movies.viewmodel.a$k
                net.one97.paytm.o2o.movies.viewmodel.a$l r5 = net.one97.paytm.o2o.movies.viewmodel.a.l.ERROR
                net.one97.paytm.o2o.movies.viewmodel.a r0 = r2.f76048a
                androidx.lifecycle.y<net.one97.paytm.o2o.movies.viewmodel.a$k<net.one97.paytm.o2o.movies.viewmodel.a$j>> r0 = r0.f76006b
                r1 = 0
                if (r0 == 0) goto L_0x0040
                java.lang.Object r0 = r0.getValue()
                net.one97.paytm.o2o.movies.viewmodel.a$k r0 = (net.one97.paytm.o2o.movies.viewmodel.a.k) r0
                if (r0 == 0) goto L_0x0040
                T r0 = r0.f76037b
                net.one97.paytm.o2o.movies.viewmodel.a$j r0 = (net.one97.paytm.o2o.movies.viewmodel.a.j) r0
                if (r0 == 0) goto L_0x0040
                net.one97.paytm.o2o.movies.viewmodel.a$j r0 = net.one97.paytm.o2o.movies.viewmodel.a.j.a(r0.f76034a, r0.f76035b)
                goto L_0x0041
            L_0x0040:
                r0 = r1
            L_0x0041:
                r4.<init>(r5, r0, r1)
                r3.postValue(r4)
            L_0x0047:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.viewmodel.a.p.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
        }
    }

    public static class g {

        /* renamed from: h  reason: collision with root package name */
        public final h f76030h;

        public g(h hVar) {
            kotlin.g.b.k.c(hVar, "type");
            this.f76030h = hVar;
        }
    }

    /* renamed from: net.one97.paytm.o2o.movies.viewmodel.a$a  reason: collision with other inner class name */
    public static final class C1499a extends g {

        /* renamed from: a  reason: collision with root package name */
        public final String f76010a;

        /* renamed from: b  reason: collision with root package name */
        public final String f76011b;

        /* renamed from: c  reason: collision with root package name */
        public final String f76012c;

        /* renamed from: d  reason: collision with root package name */
        public final String f76013d;

        /* renamed from: e  reason: collision with root package name */
        public final String f76014e;

        /* renamed from: f  reason: collision with root package name */
        public final String f76015f;

        /* renamed from: g  reason: collision with root package name */
        public final String f76016g;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C1499a)) {
                return false;
            }
            C1499a aVar = (C1499a) obj;
            return kotlin.g.b.k.a((Object) this.f76010a, (Object) aVar.f76010a) && kotlin.g.b.k.a((Object) this.f76011b, (Object) aVar.f76011b) && kotlin.g.b.k.a((Object) this.f76012c, (Object) aVar.f76012c) && kotlin.g.b.k.a((Object) this.f76013d, (Object) aVar.f76013d) && kotlin.g.b.k.a((Object) this.f76014e, (Object) aVar.f76014e) && kotlin.g.b.k.a((Object) this.f76015f, (Object) aVar.f76015f) && kotlin.g.b.k.a((Object) this.f76016g, (Object) aVar.f76016g);
        }

        public final int hashCode() {
            String str = this.f76010a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f76011b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f76012c;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.f76013d;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.f76014e;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.f76015f;
            int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.f76016g;
            if (str7 != null) {
                i2 = str7.hashCode();
            }
            return hashCode6 + i2;
        }

        public final String toString() {
            return "Banner(title=" + this.f76010a + ", movieCode=" + this.f76011b + ", language=" + this.f76012c + ", subtitleOne=" + this.f76013d + ", subTitleTwo=" + this.f76014e + ", headerImageUr=" + this.f76015f + ", youTubeId=" + this.f76016g + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1499a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            super(h.BANNER);
            kotlin.g.b.k.c(str, "title");
            kotlin.g.b.k.c(str2, "movieCode");
            kotlin.g.b.k.c(str3, "language");
            kotlin.g.b.k.c(str4, "subtitleOne");
            kotlin.g.b.k.c(str5, "subTitleTwo");
            this.f76010a = str;
            this.f76011b = str2;
            this.f76012c = str3;
            this.f76013d = str4;
            this.f76014e = str5;
            this.f76015f = str6;
            this.f76016g = str7;
        }
    }

    public static final class m extends g {

        /* renamed from: a  reason: collision with root package name */
        public final String f76039a;

        /* renamed from: b  reason: collision with root package name */
        public final String f76040b;

        /* renamed from: c  reason: collision with root package name */
        public final String f76041c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof m)) {
                return false;
            }
            m mVar = (m) obj;
            return kotlin.g.b.k.a((Object) this.f76039a, (Object) mVar.f76039a) && kotlin.g.b.k.a((Object) this.f76040b, (Object) mVar.f76040b) && kotlin.g.b.k.a((Object) this.f76041c, (Object) mVar.f76041c);
        }

        public final int hashCode() {
            String str = this.f76039a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f76040b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f76041c;
            if (str3 != null) {
                i2 = str3.hashCode();
            }
            return hashCode2 + i2;
        }

        public final String toString() {
            return "Synopsis(movieName=" + this.f76039a + ", title=" + this.f76040b + ", synopsisText=" + this.f76041c + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(String str, String str2, String str3) {
            super(h.SYNOPSIS);
            kotlin.g.b.k.c(str, "movieName");
            kotlin.g.b.k.c(str2, "title");
            kotlin.g.b.k.c(str3, "synopsisText");
            this.f76039a = str;
            this.f76040b = str2;
            this.f76041c = str3;
        }
    }

    public static final class f extends g {

        /* renamed from: a  reason: collision with root package name */
        public long f76026a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f76027b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f76028c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f76029d;

        public static f a(long j, boolean z, boolean z2, boolean z3) {
            return new f(j, z, z2, z3);
        }

        public static /* synthetic */ f a(f fVar, long j, boolean z, boolean z2, boolean z3, int i2) {
            if ((i2 & 1) != 0) {
                j = fVar.f76026a;
            }
            if ((i2 & 2) != 0) {
                z = fVar.f76027b;
            }
            if ((i2 & 4) != 0) {
                z2 = fVar.f76028c;
            }
            if ((i2 & 8) != 0) {
                z3 = fVar.f76029d;
            }
            return a(j, z, z2, z3);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.f76026a == fVar.f76026a && this.f76027b == fVar.f76027b && this.f76028c == fVar.f76028c && this.f76029d == fVar.f76029d;
        }

        public final int hashCode() {
            int hashCode = Long.valueOf(this.f76026a).hashCode() * 31;
            boolean z = this.f76027b;
            if (z) {
                z = true;
            }
            int i2 = (hashCode + (z ? 1 : 0)) * 31;
            boolean z2 = this.f76028c;
            if (z2) {
                z2 = true;
            }
            int i3 = (i2 + (z2 ? 1 : 0)) * 31;
            boolean z3 = this.f76029d;
            if (z3) {
                z3 = true;
            }
            return i3 + (z3 ? 1 : 0);
        }

        public final String toString() {
            return "Interest(voteCount=" + this.f76026a + ", isEnable=" + this.f76027b + ", fireGtmEvent=" + this.f76028c + ", makeEnableOrDisable=" + this.f76029d + ")";
        }

        public f(long j, boolean z, boolean z2, boolean z3) {
            super(h.INTEREST);
            this.f76026a = j;
            this.f76027b = z;
            this.f76028c = z2;
            this.f76029d = z3;
        }
    }

    public static final class j extends g {

        /* renamed from: a  reason: collision with root package name */
        public f f76034a;

        /* renamed from: b  reason: collision with root package name */
        public SentimentInterestedItem f76035b;

        public static j a(f fVar, SentimentInterestedItem sentimentInterestedItem) {
            return new j(fVar, sentimentInterestedItem);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return kotlin.g.b.k.a((Object) this.f76034a, (Object) jVar.f76034a) && kotlin.g.b.k.a((Object) this.f76035b, (Object) jVar.f76035b);
        }

        public final int hashCode() {
            f fVar = this.f76034a;
            int i2 = 0;
            int hashCode = (fVar != null ? fVar.hashCode() : 0) * 31;
            SentimentInterestedItem sentimentInterestedItem = this.f76035b;
            if (sentimentInterestedItem != null) {
                i2 = sentimentInterestedItem.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "LikeDisLike(interest=" + this.f76034a + ", sentiment=" + this.f76035b + ")";
        }

        public /* synthetic */ j() {
            this((f) null, (SentimentInterestedItem) null);
        }

        private j(f fVar, SentimentInterestedItem sentimentInterestedItem) {
            super(h.LIKEDISLIKE);
            this.f76034a = fVar;
            this.f76035b = sentimentInterestedItem;
        }
    }

    public static final class n extends g {

        /* renamed from: a  reason: collision with root package name */
        public final String f76042a;

        /* renamed from: b  reason: collision with root package name */
        public final List<CJRAboutMovieVideoModel> f76043b;

        /* renamed from: c  reason: collision with root package name */
        private final int f76044c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof n)) {
                return false;
            }
            n nVar = (n) obj;
            return kotlin.g.b.k.a((Object) this.f76042a, (Object) nVar.f76042a) && this.f76044c == nVar.f76044c && kotlin.g.b.k.a((Object) this.f76043b, (Object) nVar.f76043b);
        }

        public final int hashCode() {
            String str = this.f76042a;
            int i2 = 0;
            int hashCode = (((str != null ? str.hashCode() : 0) * 31) + Integer.valueOf(this.f76044c).hashCode()) * 31;
            List<CJRAboutMovieVideoModel> list = this.f76043b;
            if (list != null) {
                i2 = list.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "Videos(videoTitle=" + this.f76042a + ", contentId=" + this.f76044c + ", videoList=" + this.f76043b + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(String str, int i2, List<? extends CJRAboutMovieVideoModel> list) {
            super(h.VIDEO);
            kotlin.g.b.k.c(str, "videoTitle");
            kotlin.g.b.k.c(list, "videoList");
            this.f76042a = str;
            this.f76044c = i2;
            this.f76043b = list;
        }
    }

    public static final class e extends g {

        /* renamed from: a  reason: collision with root package name */
        public final String f76024a;

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f76025b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return kotlin.g.b.k.a((Object) this.f76024a, (Object) eVar.f76024a) && kotlin.g.b.k.a((Object) this.f76025b, (Object) eVar.f76025b);
        }

        public final int hashCode() {
            String str = this.f76024a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            List<String> list = this.f76025b;
            if (list != null) {
                i2 = list.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "Gallery(heading=" + this.f76024a + ", urlList=" + this.f76025b + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(String str, List<String> list) {
            super(h.GALLERY);
            kotlin.g.b.k.c(str, "heading");
            kotlin.g.b.k.c(list, "urlList");
            this.f76024a = str;
            this.f76025b = list;
        }
    }

    public static final class b extends g {

        /* renamed from: a  reason: collision with root package name */
        public final String f76018a;

        /* renamed from: b  reason: collision with root package name */
        public final List<CJRMovieEntertainmentModel> f76019b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return kotlin.g.b.k.a((Object) this.f76018a, (Object) bVar.f76018a) && kotlin.g.b.k.a((Object) this.f76019b, (Object) bVar.f76019b);
        }

        public final int hashCode() {
            String str = this.f76018a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            List<CJRMovieEntertainmentModel> list = this.f76019b;
            if (list != null) {
                i2 = list.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "Blog(heading=" + this.f76018a + ", urlList=" + this.f76019b + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str, List<? extends CJRMovieEntertainmentModel> list) {
            super(h.BLOG);
            kotlin.g.b.k.c(str, "heading");
            kotlin.g.b.k.c(list, "urlList");
            this.f76018a = str;
            this.f76019b = list;
        }
    }

    public static final class i extends g {

        /* renamed from: a  reason: collision with root package name */
        public final String f76031a;

        /* renamed from: b  reason: collision with root package name */
        public final List<CJRMoviesCastCrewItem> f76032b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f76033c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return kotlin.g.b.k.a((Object) this.f76031a, (Object) iVar.f76031a) && kotlin.g.b.k.a((Object) this.f76032b, (Object) iVar.f76032b) && this.f76033c == iVar.f76033c;
        }

        public final int hashCode() {
            String str = this.f76031a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            List<CJRMoviesCastCrewItem> list = this.f76032b;
            if (list != null) {
                i2 = list.hashCode();
            }
            int i3 = (hashCode + i2) * 31;
            boolean z = this.f76033c;
            if (z) {
                z = true;
            }
            return i3 + (z ? 1 : 0);
        }

        public final String toString() {
            return "LeadCast(heading=" + this.f76031a + ", leadCastList=" + this.f76032b + ", actorClickable=" + this.f76033c + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(String str, List<? extends CJRMoviesCastCrewItem> list, boolean z) {
            super(h.LEAD_CAST);
            kotlin.g.b.k.c(str, "heading");
            kotlin.g.b.k.c(list, "leadCastList");
            this.f76031a = str;
            this.f76032b = list;
            this.f76033c = z;
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final d f76020a;

        /* renamed from: b  reason: collision with root package name */
        public final String f76021b;

        /* renamed from: c  reason: collision with root package name */
        public final String f76022c;

        /* renamed from: d  reason: collision with root package name */
        private final Throwable f76023d;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return kotlin.g.b.k.a((Object) this.f76020a, (Object) cVar.f76020a) && kotlin.g.b.k.a((Object) this.f76023d, (Object) cVar.f76023d) && kotlin.g.b.k.a((Object) this.f76021b, (Object) cVar.f76021b) && kotlin.g.b.k.a((Object) this.f76022c, (Object) cVar.f76022c);
        }

        public final int hashCode() {
            d dVar = this.f76020a;
            int i2 = 0;
            int hashCode = (dVar != null ? dVar.hashCode() : 0) * 31;
            Throwable th = this.f76023d;
            int hashCode2 = (hashCode + (th != null ? th.hashCode() : 0)) * 31;
            String str = this.f76021b;
            int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f76022c;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return hashCode3 + i2;
        }

        public final String toString() {
            return "ErrorData(error=" + this.f76020a + ", throwable=" + this.f76023d + ", title=" + this.f76021b + ", detail=" + this.f76022c + ")";
        }

        public c(d dVar, Throwable th, String str, String str2) {
            kotlin.g.b.k.c(dVar, "error");
            kotlin.g.b.k.c(str, "title");
            kotlin.g.b.k.c(str2, "detail");
            this.f76020a = dVar;
            this.f76023d = th;
            this.f76021b = str;
            this.f76022c = str2;
        }
    }

    public static final class k<T> {

        /* renamed from: a  reason: collision with root package name */
        public final l f76036a;

        /* renamed from: b  reason: collision with root package name */
        public final T f76037b;

        /* renamed from: c  reason: collision with root package name */
        public final c f76038c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return kotlin.g.b.k.a((Object) this.f76036a, (Object) kVar.f76036a) && kotlin.g.b.k.a((Object) this.f76037b, (Object) kVar.f76037b) && kotlin.g.b.k.a((Object) this.f76038c, (Object) kVar.f76038c);
        }

        public final int hashCode() {
            l lVar = this.f76036a;
            int i2 = 0;
            int hashCode = (lVar != null ? lVar.hashCode() : 0) * 31;
            T t = this.f76037b;
            int hashCode2 = (hashCode + (t != null ? t.hashCode() : 0)) * 31;
            c cVar = this.f76038c;
            if (cVar != null) {
                i2 = cVar.hashCode();
            }
            return hashCode2 + i2;
        }

        public final String toString() {
            return "PYResponse(type=" + this.f76036a + ", data=" + this.f76037b + ", message=" + this.f76038c + ")";
        }

        public /* synthetic */ k(l lVar, Object obj) {
            this(lVar, obj, (c) null);
        }

        public k(l lVar, T t, c cVar) {
            kotlin.g.b.k.c(lVar, "type");
            this.f76036a = lVar;
            this.f76037b = t;
            this.f76038c = cVar;
        }
    }

    public static void a(RequestQueue requestQueue, com.paytm.network.a aVar) {
        kotlin.g.b.k.c(requestQueue, "requestQueue");
        kotlin.g.b.k.c(aVar, "networkCall");
        aVar.f42859c = false;
        aVar.a();
    }

    public static final /* synthetic */ void a(a aVar, String str, boolean z, boolean z2) {
        SentimentInterestedItem sentimentInterestedItem;
        k value = aVar.f76006b.getValue();
        if (value != null) {
            j jVar = (j) value.f76037b;
            Long l2 = null;
            if (jVar != null) {
                sentimentInterestedItem = jVar.f76035b;
            } else {
                sentimentInterestedItem = null;
            }
            if (sentimentInterestedItem != null) {
                HashMap<String, Long> countInfo = sentimentInterestedItem.getCountInfo();
                if (countInfo != null) {
                    l2 = countInfo.get(str);
                }
                if (l2 != null && z2) {
                    countInfo.put(str, Long.valueOf(l2.longValue() + ((long) (z ? 1 : -1))));
                }
                if (!z) {
                    str = "";
                }
                sentimentInterestedItem.setUserInput(str);
            }
        }
    }
}
