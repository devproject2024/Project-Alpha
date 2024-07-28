package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.google.gson.b;
import com.google.gson.d;
import com.google.gson.f;
import com.google.gson.g;
import com.google.gson.internal.Excluder;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.l;
import com.google.gson.n;
import com.google.gson.p;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.t;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallation;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.AllCommunitiesResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CarouselDataObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CommunityFeedSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.ImageSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.UserPostSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.UserSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.InstallUpdateForMoEngage;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.GsonConverter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.RxSharedPreferences;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AnnotationExclusionStrategy;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.DateUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.networkutills.NetworkUtil;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SheroesAppModule {
    static final long CACHE_SIZE = 10485760;
    /* access modifiers changed from: private */
    public static final String[] DATE_FORMATS = {"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "yyyy-MM-dd"};
    private static f sGson;
    File cacheFile;
    Context mApplication;

    /* access modifiers changed from: package-private */
    public Context providesApplication() {
        return this.mApplication;
    }

    public SheroesAppModule(File file, Context context) {
        this.cacheFile = file;
        this.mApplication = context;
    }

    public Interceptor provideInterceptor(final Preference<LoginResponse> preference) {
        return new Interceptor() {
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request.Builder newBuilder = chain.request().newBuilder();
                Preference preference = preference;
                if (preference != null && preference.isSet()) {
                    newBuilder.header("Content-Type", "application/json").header("Authorization", ((LoginResponse) preference.get()).getToken());
                }
                newBuilder.header(ContactsConstant.USER_AGENT, SheroesAppModule.getUserAgent(SheroesSdk.getApplicationContext()));
                newBuilder.header("X-app-version-code", SheroesAppModule.getAppVersionCode(SheroesSdk.getApplicationContext()));
                newBuilder.header("X-Sheroes-API-Key", SheroesSdk.getSheroesAPIKey());
                if (NetworkUtil.isConnected(SheroesAppModule.this.mApplication)) {
                    newBuilder.addHeader("Cache-Control", "public, max-age=0");
                } else {
                    newBuilder.addHeader("Cache-Control", "public, only-if-cached, max-stale=1209600");
                }
                Response proceed = chain.proceed(newBuilder.build());
                proceed.cacheResponse();
                return proceed;
            }
        };
    }

    private static f initGSONSerializers() {
        RuntimeTypeAdapterFactory<FeedDetail> registerSubtype = RuntimeTypeAdapterFactory.of(FeedDetail.class, "sub_type").registerSubtype(UserSolrObj.class, AppConstants.USER_SUB_TYPE).registerSubtype(CommunityFeedSolrObj.class, AppConstants.FEED_COMMUNITY).registerSubtype(UserPostSolrObj.class, AppConstants.FEED_COMMUNITY_POST).registerSubtype(CarouselDataObj.class, AppConstants.CAROUSEL_SUB_TYPE).registerSubtype(ImageSolrObj.class, AppConstants.IMAGE_SUBTYPE);
        g gVar = new g();
        gVar.f39466d = DATE_FORMATS[0];
        g a2 = gVar.a(Date.class, new DateDeserializer());
        a2.f39465c.add(registerSubtype);
        return a2.a();
    }

    static class DateDeserializer implements k<Date>, t<Date> {
        private DateDeserializer() {
        }

        public Date deserialize(l lVar, Type type, j jVar) throws p {
            if (TextUtils.isEmpty(lVar.c())) {
                return null;
            }
            String[] access$300 = SheroesAppModule.DATE_FORMATS;
            int length = access$300.length;
            int i2 = 0;
            while (i2 < length) {
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(access$300[i2], Locale.US);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    return simpleDateFormat.parse(lVar.c());
                } catch (ParseException unused) {
                    i2++;
                }
            }
            return null;
        }

        public l serialize(Date date, Type type, s sVar) {
            if (date == null) {
                return n.f39635a;
            }
            return new r(DateUtil.toDateOnlyString(date));
        }
    }

    public f provideGson() {
        g gVar = new g();
        gVar.f39464b = d.LOWER_CASE_WITH_UNDERSCORES;
        b[] bVarArr = {new AnnotationExclusionStrategy()};
        for (int i2 = 0; i2 <= 0; i2++) {
            b bVar = bVarArr[0];
            Excluder excluder = gVar.f39463a;
            Excluder a2 = excluder.clone();
            a2.f39478f = new ArrayList(excluder.f39478f);
            a2.f39478f.add(bVar);
            a2.f39479g = new ArrayList(excluder.f39479g);
            a2.f39479g.add(bVar);
            gVar.f39463a = a2;
        }
        return gVar.a();
    }

    public DateUtil provideDateUtil() {
        return DateUtil.getInstance();
    }

    public AppUtils provideAppUtil() {
        return AppUtils.getInstance();
    }

    public RxSharedPreferences provideRxSharedPreferences() {
        return RxSharedPreferences.create(this.mApplication.getSharedPreferences(AppConstants.SHEROES_PREFERENCE, 0));
    }

    public Preference<LoginResponse> provideTokenPref(RxSharedPreferences rxSharedPreferences, f fVar) {
        return rxSharedPreferences.getObject(AppConstants.SHEROES_AUTH_TOKEN, new LoginResponse(), new GsonConverter(fVar, LoginResponse.class));
    }

    public Preference<AllCommunitiesResponse> provideAllCommunities(RxSharedPreferences rxSharedPreferences, f fVar) {
        return rxSharedPreferences.getObject(AppConstants.ALL_COMMUNITY_LIST, new AllCommunitiesResponse(), new GsonConverter(fVar, AllCommunitiesResponse.class));
    }

    public Preference<Configuration> provideConfiguration(RxSharedPreferences rxSharedPreferences, f fVar) {
        return rxSharedPreferences.getObject(AppConstants.CONFIG_KEY, new Configuration(), new GsonConverter(fVar, Configuration.class));
    }

    public Preference<AppInstallation> provideAppInstallation(RxSharedPreferences rxSharedPreferences, f fVar) {
        return rxSharedPreferences.getObject(AppConstants.APP_INSTALLATION, new AppInstallation(), new GsonConverter(fVar, AppInstallation.class));
    }

    public Preference<InstallUpdateForMoEngage> provideInstallUpdatePref(RxSharedPreferences rxSharedPreferences, f fVar) {
        return rxSharedPreferences.getObject(AppConstants.INSTALL_UPDATE, new InstallUpdateForMoEngage(), new GsonConverter(fVar, InstallUpdateForMoEngage.class));
    }

    /* access modifiers changed from: package-private */
    public OkHttpClient provideOkHttpClient(Interceptor interceptor) {
        Cache cache;
        try {
            cache = new Cache(this.cacheFile, CACHE_SIZE);
        } catch (Exception e2) {
            e2.printStackTrace();
            cache = null;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(180, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS).addInterceptor(interceptor).cache(cache);
        return builder.build();
    }

    public static f ensureGson() {
        if (sGson == null) {
            sGson = initGSONSerializers();
        }
        return sGson;
    }

    /* access modifiers changed from: package-private */
    public Retrofit provideSheroesNetworkCall(OkHttpClient okHttpClient, f fVar) {
        return new Retrofit.Builder().baseUrl("https://services.sheroes.in/").client(okHttpClient).addConverterFactory(GsonConverterFactory.create(ensureGson())).addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build();
    }

    public SheroesAppServiceApi providesApiService(Retrofit retrofit) {
        return (SheroesAppServiceApi) retrofit.create(SheroesAppServiceApi.class);
    }

    /* access modifiers changed from: private */
    public static String getUserAgent(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            String deviceName = CommonUtil.getDeviceName();
            String str2 = Build.VERSION.RELEASE;
            return AppConstants.APP_NAME + "/6.7.9/Android/" + str2 + "/" + deviceName;
        } catch (PackageManager.NameNotFoundException unused) {
            return AppConstants.APP_NAME;
        }
    }

    /* access modifiers changed from: private */
    public static String getAppVersionCode(Context context) {
        try {
            return Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            return "0";
        }
    }
}
