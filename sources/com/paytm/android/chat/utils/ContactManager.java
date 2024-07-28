package com.paytm.android.chat.utils;

import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.greendao.gen.SyncContactBeanDao;
import com.paytm.android.chat.bean.RegistrationStatus;
import com.paytm.android.chat.bean.daobean.SyncContactBean;
import com.paytm.android.chat.bean.jsonbean.UsersInfoJsonBean;
import com.paytm.android.chat.data.models.users.payments.GetUserInfoByIdsResponse;
import com.paytm.android.chat.utils.ContactManager;
import com.paytm.network.model.NetworkCustomError;
import easypay.manager.Constants;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.d.g;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

public class ContactManager {
    private static Object lock = new Object();
    private IMCache<String, SyncContactBean> imCacheId = new IMCache<>(Constants.EASY_PAY_GENERIC_CALLBACK);
    private IMCache<String, SyncContactBean> imCachePhone = new IMCache<>(Constants.EASY_PAY_GENERIC_CALLBACK);
    private final SyncContactBeanDao syncContactBeanDao = DatabaseManager.getDaoSession().getSyncContactBeanDao();

    public interface FetchUserInfo {
        y<GetUserInfoByIdsResponse> fetch(String str);
    }

    public interface UserInfoCallBack {
        void back(String str, String str2);
    }

    public interface UserPhoneCallBack {
        void back(String str);
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static ContactManager f42338a;
    }

    static /* synthetic */ void lambda$getUserPhone$2(Throwable th) throws Throwable {
    }

    private ContactManager() {
    }

    public void addContact(SyncContactBean syncContactBean) {
        if (syncContactBean != null && !TextUtils.isEmpty(syncContactBean.getContactPhone())) {
            SyncContactBean searchContactByPhone = searchContactByPhone(syncContactBean.getContactPhone());
            if (searchContactByPhone != null) {
                searchContactByPhone.setContactPic(syncContactBean.getContactPic());
                searchContactByPhone.setContactName(syncContactBean.getContactName());
                upContact(searchContactByPhone);
                return;
            }
            syncContactBean.setSelfId(SharedPreferencesUtil.getUserId());
            SyncContactBeanDao syncContactBeanDao2 = this.syncContactBeanDao;
            if (syncContactBeanDao2 != null) {
                syncContactBeanDao2.insertOrReplace(syncContactBean);
            }
            if (!TextUtils.isEmpty(syncContactBean.getContactPhone())) {
                this.imCachePhone.put(syncContactBean.getContactPhone(), syncContactBean);
            }
            if (!TextUtils.isEmpty(syncContactBean.getSendbirdId())) {
                this.imCacheId.put(syncContactBean.getSendbirdId(), syncContactBean);
            }
        }
    }

    public void upContact(SyncContactBean syncContactBean) {
        if (syncContactBean != null) {
            syncContactBean.setSelfId(SharedPreferencesUtil.getUserId());
            SyncContactBeanDao syncContactBeanDao2 = this.syncContactBeanDao;
            if (syncContactBeanDao2 != null) {
                syncContactBeanDao2.insertOrReplace(syncContactBean);
            }
            if (!TextUtils.isEmpty(syncContactBean.getContactPhone())) {
                this.imCachePhone.put(syncContactBean.getContactPhone(), syncContactBean);
            }
            if (!TextUtils.isEmpty(syncContactBean.getSendbirdId())) {
                this.imCacheId.put(syncContactBean.getSendbirdId(), syncContactBean);
            }
        }
    }

    public void clearAll() {
        clearContactsCache();
        cleaContactsdDb();
    }

    public void clearContactsCache() {
        this.imCachePhone.clear();
        this.imCacheId.clear();
    }

    public void cleaContactsdDb() {
        this.syncContactBeanDao.deleteAll();
    }

    public void clearContact(SyncContactBean syncContactBean) {
        if (syncContactBean != null) {
            SyncContactBeanDao syncContactBeanDao2 = this.syncContactBeanDao;
            if (syncContactBeanDao2 != null) {
                syncContactBeanDao2.delete(syncContactBean);
            }
            this.imCachePhone.remove(syncContactBean.getContactPhone());
            this.imCacheId.remove(syncContactBean.getSendbirdId());
        }
    }

    public void clearContact(String str) {
        SyncContactBean searchContactDBByUrl = searchContactDBByUrl(str);
        if (searchContactDBByUrl != null) {
            this.imCachePhone.remove(searchContactDBByUrl.getContactPhone());
            this.imCacheId.remove(searchContactDBByUrl.getSendbirdId());
            SyncContactBeanDao syncContactBeanDao2 = this.syncContactBeanDao;
            if (syncContactBeanDao2 != null) {
                syncContactBeanDao2.delete(searchContactDBByUrl);
            }
        }
    }

    public SyncContactBean searchContactById(String str) {
        SyncContactBean syncContactBean = this.imCacheId.get(str);
        if (syncContactBean == null && (syncContactBean = searchContactDBByUid(str)) != null) {
            this.imCacheId.put(str, syncContactBean);
        }
        return syncContactBean;
    }

    public SyncContactBean searchContactByPhone(String str) {
        SyncContactBean syncContactBean = this.imCachePhone.get(str);
        if (syncContactBean == null && (syncContactBean = searchContactDBByPhone(str)) != null) {
            this.imCachePhone.put(str, syncContactBean);
        }
        return syncContactBean;
    }

    private SyncContactBean searchContactDBByUid(String str) {
        try {
            return (SyncContactBean) this.syncContactBeanDao.queryBuilder().where(SyncContactBeanDao.Properties.SelfId.eq(SharedPreferencesUtil.getUserId()), SyncContactBeanDao.Properties.SendbirdId.eq(str)).unique();
        } catch (Exception unused) {
            return null;
        }
    }

    private SyncContactBean searchContactDBByPhone(String str) {
        try {
            return (SyncContactBean) this.syncContactBeanDao.queryBuilder().where(SyncContactBeanDao.Properties.SelfId.eq(SharedPreferencesUtil.getUserId()), SyncContactBeanDao.Properties.ContactPhone.eq(str)).unique();
        } catch (Exception unused) {
            return null;
        }
    }

    public SyncContactBean searchContactDBByUrl(String str) {
        List list;
        try {
            QueryBuilder where = this.syncContactBeanDao.queryBuilder().where(SyncContactBeanDao.Properties.SelfId.eq(SharedPreferencesUtil.getUserId()), SyncContactBeanDao.Properties.ChannelUrl.eq(str));
            if (where == null || (list = where.list()) == null || list.size() <= 0) {
                return null;
            }
            return (SyncContactBean) list.get(0);
        } catch (Exception unused) {
            return null;
        }
    }

    public List<SyncContactBean> likeNameSearch(String str) {
        try {
            QueryBuilder queryBuilder = this.syncContactBeanDao.queryBuilder();
            Property property = SyncContactBeanDao.Properties.ContactName;
            WhereCondition like = property.like("%" + str + "%");
            Property property2 = SyncContactBeanDao.Properties.ContactPhone;
            return queryBuilder.whereOr(like, property2.like("%" + str + "%"), new WhereCondition[0]).orderAsc(SyncContactBeanDao.Properties.ContactName).list();
        } catch (Exception unused) {
            return null;
        }
    }

    public List<SyncContactBean> likeOnNameSearch(String str) {
        try {
            QueryBuilder queryBuilder = this.syncContactBeanDao.queryBuilder();
            Property property = SyncContactBeanDao.Properties.ContactName;
            return queryBuilder.where(property.like("%" + str + "%"), new WhereCondition[0]).orderAsc(SyncContactBeanDao.Properties.ContactName).list();
        } catch (Exception unused) {
            return null;
        }
    }

    public List<SyncContactBean> searchAll() {
        try {
            this.syncContactBeanDao.queryBuilder().where(SyncContactBeanDao.Properties.SelfId.eq(SharedPreferencesUtil.getUserId()), SyncContactBeanDao.Properties.ContactPhone.isNotNull(), SyncContactBeanDao.Properties.ContactName.isNotNull(), SyncContactBeanDao.Properties.ContactId.isNotNull());
            return this.syncContactBeanDao.queryBuilder().list();
        } catch (Exception unused) {
            return null;
        }
    }

    public void getUserPhone(RegistrationStatus registrationStatus, String str, String str2, FetchUserInfo fetchUserInfo, UserPhoneCallBack userPhoneCallBack) {
        if (str.startsWith(H5BridgeContext.INVALID_ID)) {
            userPhoneCallBack.back(str.substring(2));
            return;
        }
        SyncContactBean searchContactById = searchContactById(str);
        if (searchContactById == null || TextUtils.isEmpty(searchContactById.getContactPhone())) {
            try {
                if (registrationStatus != RegistrationStatus.NOT_ON_PAYTM) {
                    fetchUserInfo.fetch(str).b($$Lambda$ContactManager$2cASicz2riMTaw8zdAzrBCdwk.INSTANCE).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(new g(userPhoneCallBack) {
                        private final /* synthetic */ ContactManager.UserPhoneCallBack f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void accept(Object obj) {
                            ContactManager.this.lambda$getUserPhone$1$ContactManager(this.f$1, (Map.Entry) obj);
                        }
                    }, (g<? super Throwable>) $$Lambda$ContactManager$ybBzotDumlVeh2sBVDnqrBIrEQQ.INSTANCE);
                }
            } catch (Exception unused) {
            }
        } else {
            userPhoneCallBack.back(searchContactById.getContactPhone());
        }
    }

    static /* synthetic */ Map.Entry lambda$getUserPhone$0(GetUserInfoByIdsResponse getUserInfoByIdsResponse) throws Throwable {
        if (getUserInfoByIdsResponse.getData() != null) {
            Map<String, UsersInfoJsonBean> map = getUserInfoByIdsResponse.getData().getMap();
            Map.Entry entry = null;
            if (map == null || map.size() <= 0) {
                return new AbstractMap.SimpleEntry("0", (Object) null);
            }
            Iterator<Map.Entry<String, UsersInfoJsonBean>> it2 = map.entrySet().iterator();
            if (it2.hasNext()) {
                entry = it2.next();
            }
            return entry;
        }
        NetworkCustomError networkCustomError = new NetworkCustomError();
        networkCustomError.setStatusCode(getUserInfoByIdsResponse.getStatusCode());
        throw networkCustomError;
    }

    public /* synthetic */ void lambda$getUserPhone$1$ContactManager(UserPhoneCallBack userPhoneCallBack, Map.Entry entry) throws Throwable {
        String str = (String) entry.getKey();
        UsersInfoJsonBean usersInfoJsonBean = (UsersInfoJsonBean) entry.getValue();
        if (usersInfoJsonBean != null && usersInfoJsonBean.getPhoneNumber() != null) {
            userPhoneCallBack.back(usersInfoJsonBean.getPhoneNumber());
            SyncContactBean searchContactById = searchContactById(str);
            if (searchContactById == null) {
                SyncContactBean syncContactBean = new SyncContactBean();
                syncContactBean.setSelfId(SharedPreferencesUtil.getUserId());
                syncContactBean.setPtId(usersInfoJsonBean.getPhoneNumber());
                syncContactBean.setSendbirdId(str);
                syncContactBean.setContactPhone(usersInfoJsonBean.getPhoneNumber());
                syncContactBean.setIsPaytm(usersInfoJsonBean.isPfuser());
                getInstance().addContact(syncContactBean);
                return;
            }
            searchContactById.setPtName(usersInfoJsonBean.getPfName());
            searchContactById.setContactPhone(usersInfoJsonBean.getPhoneNumber());
            upContact(searchContactById);
        }
    }

    public void getUserInfo(String str, String str2, UserInfoCallBack userInfoCallBack) {
        SyncContactBean searchContactById = searchContactById(str);
        if (searchContactById != null) {
            if (!TextUtils.isEmpty(searchContactById.getContactName())) {
                str2 = searchContactById.getContactName();
            }
            String str3 = null;
            if (!TextUtils.isEmpty(searchContactById.getContactPic())) {
                str3 = searchContactById.getContactPic();
            } else if (!TextUtils.isEmpty(searchContactById.getPtPic())) {
                str3 = searchContactById.getPtPic();
            }
            userInfoCallBack.back(str2, str3);
        }
    }

    public void getUserInfoByChannurl(String str, String str2, UserInfoCallBack userInfoCallBack) {
        SyncContactBean searchContactByPhone = searchContactByPhone(str);
        if (searchContactByPhone != null) {
            if (!TextUtils.isEmpty(searchContactByPhone.getContactName())) {
                str2 = searchContactByPhone.getContactName();
            }
            String str3 = null;
            if (!TextUtils.isEmpty(searchContactByPhone.getContactPic())) {
                str3 = searchContactByPhone.getContactPic();
            } else if (!TextUtils.isEmpty(searchContactByPhone.getPtPic())) {
                str3 = searchContactByPhone.getPtPic();
            }
            userInfoCallBack.back(str2, str3);
        }
    }

    public void getUserInfoByPhone(String str, String str2, UserInfoCallBack userInfoCallBack) {
        SyncContactBean searchContactByPhone = searchContactByPhone(str);
        if (searchContactByPhone != null) {
            if (!TextUtils.isEmpty(searchContactByPhone.getContactName())) {
                str2 = searchContactByPhone.getContactName();
            }
            String str3 = null;
            if (!TextUtils.isEmpty(searchContactByPhone.getContactPic())) {
                str3 = searchContactByPhone.getContactPic();
            } else if (!TextUtils.isEmpty(searchContactByPhone.getPtPic())) {
                str3 = searchContactByPhone.getPtPic();
            }
            userInfoCallBack.back(str2, str3);
        }
    }

    public static ContactManager getInstance() {
        if (a.f42338a == null) {
            synchronized (lock) {
                if (a.f42338a == null) {
                    a.f42338a = new ContactManager();
                }
            }
        }
        return a.f42338a;
    }
}
