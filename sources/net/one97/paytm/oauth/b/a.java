package net.one97.paytm.oauth.b;

import kotlin.g.b.k;
import net.one97.paytm.upi.util.UpiConstantServiceApi;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f52572a = new a();

    private a() {
    }

    public static String a(String str, boolean z) {
        String str2 = str;
        k.c(str2, "key");
        if (z) {
            switch (str.hashCode()) {
                case -2134198467:
                    if (str2.equals("oauthDebVmnNumbers")) {
                        return "airtel=8826999388";
                    }
                    break;
                case -2106100499:
                    if (str2.equals("oauthUserVerificationInit")) {
                        return "https://accounts-staging.paytm.in/v2/user/verification/init";
                    }
                    break;
                case -2104286796:
                    if (str2.equals("oauthTokenUpgradeSv1")) {
                        return "https://accounts-staging.paytm.in/oauth2/token/upgrade/sv1";
                    }
                    break;
                case -2091434111:
                    if (str2.equals("updatePhoneV2")) {
                        return "https://accounts-staging.paytm.in/v2/user/phone";
                    }
                    break;
                case -1984296405:
                    if (str2.equals("OauthsendOTPUserEmailV4SV1")) {
                        return "https://accounts-staging.paytm.in/v4/user/email/sv1";
                    }
                    break;
                case -1620930780:
                    if (str2.equals("oauthValidatePasswordV2")) {
                        return "https://accounts-staging.paytm.in/v2/simple/login/validate/password ";
                    }
                    break;
                case -1593260998:
                    if (str2.equals("signUpPopUpIntervals")) {
                        return "1,3,5";
                    }
                    break;
                case -1585205622:
                    if (str2.equals("oauthdevicebindingclaimSv1")) {
                        return "https://accounts-staging.paytm.in/devicebinding/claim/sv1";
                    }
                    break;
                case -1505111067:
                    if (str2.equals("getalltokens")) {
                        return "https://accounts-staging.paytm.in/oauth2/usertokens";
                    }
                    break;
                case -1481582551:
                    if (str2.equals("simChangePopUpIntervals")) {
                        return "1,3,5";
                    }
                    break;
                case -1346191622:
                    if (str2.equals("simple_auth_init")) {
                        return "https://accounts-staging.paytm.in/simple/login/init";
                    }
                    break;
                case -1339959762:
                    if (str2.equals("simple_auth_validate_pwd_url")) {
                        return "https://accounts-staging.paytm.in/simple/login/validate/password";
                    }
                    break;
                case -1311435322:
                    if (str2.equals("oauthdevicebindinginitSv1")) {
                        return "https://accounts-staging.paytm.in/devicebinding/init/sv1";
                    }
                    break;
                case -1285833062:
                    if (str2.equals("encryptedTokenUrl")) {
                        return "https://staging.paytm.com/v1/user/token/enc/generate";
                    }
                    break;
                case -1133177443:
                    if (str2.equals("oauthLocationRollOutSet")) {
                        return "[0,1,2,7,8,11,12,13,18,19]";
                    }
                    break;
                case -1079153376:
                    if (str2.equals("oauthVerifyCard")) {
                        return "https://accounts-staging.paytm.in/user/asset/verify/cardDetails";
                    }
                    break;
                case -1078240890:
                    if (str2.equals("forgetpasswordSv1")) {
                        return "https://accounts-staging.paytm.in/forgetpassword/sv1";
                    }
                    break;
                case -1077183439:
                    if (str2.equals("simple_auth_otp_url")) {
                        return "https://accounts-staging.paytm.in/simple/login/resend/otp";
                    }
                    break;
                case -1050172292:
                    if (str2.equals("oauthDebAutoReadOtpVersion")) {
                        return "8.16.2";
                    }
                    break;
                case -968476917:
                    if (str2.equals("mergeChallenge")) {
                        return "https://accounts-staging.paytm.in/merge/challenge";
                    }
                    break;
                case -965150836:
                    if (str2.equals("oauthauthorizeinitSv1")) {
                        return "https://accounts-staging.paytm.in/oauth2/authorize/init/sv1";
                    }
                    break;
                case -897350079:
                    if (str2.equals("userPhoneV4")) {
                        return "https://accounts-staging.paytm.in/v4/user/phone";
                    }
                    break;
                case -845623405:
                    if (str2.equals("validateOtpV4")) {
                        return "https://accounts-staging.paytm.in/v4/api/validate/otp";
                    }
                    break;
                case -760533911:
                    if (str2.equals("profileValidateOTPV3")) {
                        return "https://accounts-staging.paytm.in/v3/user/validate/otp";
                    }
                    break;
                case -430296540:
                    if (str2.equals("profileResendOTPV3")) {
                        return "https://accounts-staging.paytm.in/v3/user/resend/otp";
                    }
                    break;
                case -422762960:
                    if (str2.equals("oauthValidateOtpSv1")) {
                        return "https://accounts-staging.paytm.in/v2/simple/login/validate/otp/sv1";
                    }
                    break;
                case -406557761:
                    if (str2.equals("oauthTokenV3")) {
                        return "https://accounts-staging.paytm.in/oauth2/v3/token/sv1";
                    }
                    break;
                case -391720738:
                    if (str2.equals("oauthValidatePwdSv1")) {
                        return "https://accounts-staging.paytm.in/v2/simple/login/validate/password/sv1";
                    }
                    break;
                case -364641160:
                    if (str2.equals("oauthV2authorizeSv1")) {
                        return "https://accounts-staging.paytm.in/oauth2/v2/authorize/sv1";
                    }
                    break;
                case -333255865:
                    if (str2.equals("oauthDoView")) {
                        return "https://riskengine-staging.paytm.com/risk/identify/nonstandard/doView";
                    }
                    break;
                case -190457565:
                    if (str2.equals("oauthInitV2")) {
                        return "https://accounts-staging.paytm.in/v2/simple/login/init ";
                    }
                    break;
                case -183116971:
                    if (str2.equals("OauthResendOTPSV1")) {
                        return "https://accounts-staging.paytm.in/resend/otp/sv1";
                    }
                    break;
                case -69020816:
                    if (str2.equals("oauthV2UserSv1")) {
                        return "https://accounts-staging.paytm.in/v2/user/sv1";
                    }
                    break;
                case 10476425:
                    if (str2.equals("oauthSendOtpV3")) {
                        return "https://accounts-staging.paytm.in/v3/api/sendOtp";
                    }
                    break;
                case 11948129:
                    if (str2.equals("sendOtpV4")) {
                        return "https://accounts-staging.paytm.in/v4/api/send/otp";
                    }
                    break;
                case 27786834:
                    if (str2.equals("OauthValidateOTPV4SV1")) {
                        return "https://accounts-staging.paytm.in/v4/api/validate/otp/sv1";
                    }
                    break;
                case 78540418:
                    if (str2.equals("oauthVerificationInit")) {
                        return "https://accounts-staging.paytm.in/user/verification/init";
                    }
                    break;
                case 108426606:
                    if (str2.equals("restDoViewLogout")) {
                        return "http://ifcsupergwlite.teststable.dl.alipaydev.com/risk/identify/nonstandard/doView";
                    }
                    break;
                case 201223788:
                    if (str2.equals("oauthDebSenderIdAutoReadOtp")) {
                        return "[paytmi,ipmall,pfgame,gmpind,mpaytm,paytmm,120130,paytmb,vpaytm,ipaytm,bpaytm,197007,paytmh]";
                    }
                    break;
                case 254491910:
                    if (str2.equals("logoutIfRequired")) {
                        return "https://accounts-staging.paytm.in/oauth2/logoutIfRequired";
                    }
                    break;
                case 281610540:
                    if (str2.equals("oauthTokenSv1")) {
                        return "https://accounts-staging.paytm.in/oauth2/token/sv1";
                    }
                    break;
                case 357738884:
                    if (str2.equals("oauthdevicebindinginterveneSv1")) {
                        return "https://accounts-staging.paytm.in/devicebinding/intervene/sv1";
                    }
                    break;
                case 377418271:
                    if (str2.equals("oauthDeviceUpgradeSv1")) {
                        return "https://accounts-staging.paytm.in/device/upgrade/sv1";
                    }
                    break;
                case 449056646:
                    if (str2.equals("userPassword")) {
                        return "https://accounts-staging.paytm.in/password";
                    }
                    break;
                case 595749210:
                    if (str2.equals("logout_all_devices_sso")) {
                        return "https://accounts-staging.paytm.in/oauth2/accessToken/delete/all/sessions";
                    }
                    break;
                case 629577124:
                    if (str2.equals("oauthdevicebindingstatusSv1")) {
                        return "https://accounts-staging.paytm.in/devicebinding/status/sv1";
                    }
                    break;
                case 629923750:
                    if (str2.equals("oauthdevicebindingConfirmSv1")) {
                        return "https://accounts-staging.paytm.in/devicebinding/confirm/sv1";
                    }
                    break;
                case 679765070:
                    if (str2.equals("operator_icons_mapping")) {
                        return "{\"upi_telco_icons\":{\"airtel\":\"https://s3-ap-southeast-1.amazonaws.com/assets.paytm.com/promotion/Prabhu+Sharma/Telecom+Logo/Telecom+Logo/Android/xxhdpi/Airtel.png\", \"vodafone\":\"https://s3-ap-southeast-1.amazonaws.com/assets.paytm.com/promotion/Prabhu+Sharma/Telecom+Logo/Telecom+Logo/Android/xxhdpi/Vodafone.png\", \"jio\":\"https://s3-ap-southeast-1.amazonaws.com/assets.paytm.com/promotion/Prabhu+Sharma/Telecom+Logo/Telecom+Logo/Android/xxhdpi/Jio.png\", \"mtnl\":\"https://s3-ap-southeast-1.amazonaws.com/assets.paytm.com/promotion/Prabhu+Sharma/Telecom/Telecom/Android/xxhdpi/MTNL.png\", \"idea\":\"https://s3-ap-southeast-1.amazonaws.com/assets.paytm.com/promotion/Prabhu+Sharma/Telecom+Logo/Telecom+Logo/Android/xxhdpi/Idea.png\", \"bsnl\":\"https://s3-ap-southeast-1.amazonaws.com/assets.paytm.com/promotion/Prabhu+Sharma/Telecom+Logo/Telecom+Logo/Android/xxhdpi/BSNL.png\", \"rcom\":\"https://s3-ap-southeast-1.amazonaws.com/assets.paytm.com/promotion/Prabhu+Sharma/Telecom/Telecom/Android/xxhdpi/RComm.png\"}}";
                    }
                    break;
                case 692008116:
                    if (str2.equals("deviceBindingVersionName")) {
                        return "1.0";
                    }
                    break;
                case 747466636:
                    if (str2.equals("oauthLoginInitSv1")) {
                        return "https://accounts-staging.paytm.in/v2/simple/login/init/sv1";
                    }
                    break;
                case 875734478:
                    if (str2.equals("oauthVerificationFulfill")) {
                        return "https://accounts-staging.paytm.in/user/verification/fulfill";
                    }
                    break;
                case 883268202:
                    if (str2.equals("simChangePopUpCount")) {
                        return "3";
                    }
                    break;
                case 931431019:
                    if (str2.equals("changePassword")) {
                        return "https://accounts-staging.paytm.in/api/changePassword";
                    }
                    break;
                case 934663560:
                    if (str2.equals("userValidateOtpV4")) {
                        return "https://accounts-staging.paytm.in/v4/user/validate/otp";
                    }
                    break;
                case 1126981863:
                    if (str2.equals("oauthSimpleResendOtpSv1")) {
                        return "https://accounts-staging.paytm.in/v2/simple/login/resend/otp/sv1";
                    }
                    break;
                case 1161001520:
                    if (str2.equals("updateEmailV3")) {
                        return "https://accounts-staging.paytm.in/v3/user/email";
                    }
                    break;
                case 1298539355:
                    if (str2.equals("OauthUserValidateOTPSV1")) {
                        return "https://accounts-staging.paytm.in/v4/user/validate/otp/sv1";
                    }
                    break;
                case 1388970757:
                    if (str2.equals("restDoViewLogin")) {
                        return "http://ifcsupergwlite.teststable.dl.alipaydev.com/risk/identify/doView";
                    }
                    break;
                case 1486683944:
                    if (str2.equals("oauthAccountStatus")) {
                        return "https://accounts-staging.paytm.in/account/status";
                    }
                    break;
                case 1510383162:
                    if (str2.equals("oauthValidateOtpV2")) {
                        return "https://accounts-staging.paytm.in/v2/simple/login/validate/otp ";
                    }
                    break;
                case 1530589301:
                    if (str2.equals("oauthResendOtpV2")) {
                        return "https://accounts-staging.paytm.in/v2/simple/login/resend/otp";
                    }
                    break;
                case 1590744385:
                    if (str2.equals("oauthClaimV2")) {
                        return "https://accounts-staging.paytm.in/v2/simple/claim";
                    }
                    break;
                case 1721176573:
                    if (str2.equals("oauthLocationPermissionVersion")) {
                        return "1.0";
                    }
                    break;
                case 1818701415:
                    if (str2.equals("changePasswordV2Sv1")) {
                        return "https://accounts-staging.paytm.in/v2/api/changePassword/sv1";
                    }
                    break;
                case 1827028015:
                    if (str2.equals("signUpStoreFrontUrl")) {
                        return "https://storefront-staging.paytm.com/v2/h/app-pop-up";
                    }
                    break;
                case 1860343963:
                    if (str2.equals("oauthDoVerify")) {
                        return "https://riskengine-staging.paytm.com/risk/identify/nonstandard/doVerify";
                    }
                    break;
                case 1894297243:
                    if (str2.equals("oauthSimpleClaimSv1")) {
                        return "https://accounts-staging.paytm.in/v2/simple/claim/sv1";
                    }
                    break;
                case 1895325780:
                    if (str2.equals("oauthdevicebindingconfigSv1")) {
                        return "https://accounts-staging.paytm.in/devicebinding/config/sv1";
                    }
                    break;
                case 1992698652:
                    if (str2.equals("simple_auth_validate_otp_url")) {
                        return "https://accounts-staging.paytm.in/simple/login/validate/otp";
                    }
                    break;
                case 1995919459:
                    if (str2.equals(UpiConstantServiceApi.KEY_TOKEN)) {
                        return "https://accounts-staging.paytm.in/oauth2/token";
                    }
                    break;
                case 2017232921:
                    if (str2.equals("oauthResendOtp")) {
                        return "https://accounts-staging.paytm.in/resend/otp";
                    }
                    break;
                case 2088279153:
                    if (str2.equals("signout")) {
                        return "https://accounts-staging.paytm.in/oauth2/accessToken";
                    }
                    break;
                case 2145621934:
                    if (str2.equals("claim_acc_url")) {
                        return "https://accounts-staging.paytm.in/simple/claim";
                    }
                    break;
            }
            return "";
        }
        switch (str.hashCode()) {
            case -2134198467:
                if (str2.equals("oauthDebVmnNumbers")) {
                    return "airtel=9311785151,9311784747,9311785353,9311785252,8826874455,8826955788,8826966411,8826977388,8826955122,8826955133,8826977066#vodafone=7840877779,7840889900,9355085678,9873616161,9990023090,7669300091,7669300093,7669300097,7669300760,7669300763,7669300771";
                }
                break;
            case -2106100499:
                if (str2.equals("oauthUserVerificationInit")) {
                    return "https://accounts.paytm.com/v2/user/verification/init";
                }
                break;
            case -2104286796:
                if (str2.equals("oauthTokenUpgradeSv1")) {
                    return "https://accounts.paytm.com/oauth2/token/upgrade/sv1";
                }
                break;
            case -2091434111:
                if (str2.equals("updatePhoneV2")) {
                    return "https://accounts.paytm.com/v2/user/phone";
                }
                break;
            case -1984296405:
                if (str2.equals("OauthsendOTPUserEmailV4SV1")) {
                    return "https://accounts.paytm.com/v4/user/email/sv1";
                }
                break;
            case -1620930780:
                if (str2.equals("oauthValidatePasswordV2")) {
                    return "https://accounts.paytm.com/v2/simple/login/validate/password";
                }
                break;
            case -1593260998:
                if (str2.equals("signUpPopUpIntervals")) {
                    return "1,3,5";
                }
                break;
            case -1585205622:
                if (str2.equals("oauthdevicebindingclaimSv1")) {
                    return "https://accounts.paytm.com/devicebinding/claim/sv1";
                }
                break;
            case -1505111067:
                if (str2.equals("getalltokens")) {
                    return "https://accounts.paytm.com/oauth2/usertokens";
                }
                break;
            case -1481582551:
                if (str2.equals("simChangePopUpIntervals")) {
                    return "1,3,5";
                }
                break;
            case -1346191622:
                if (str2.equals("simple_auth_init")) {
                    return "https://accounts.paytm.com/simple/login/init";
                }
                break;
            case -1339959762:
                if (str2.equals("simple_auth_validate_pwd_url")) {
                    return "https://accounts.paytm.com/simple/login/validate/password";
                }
                break;
            case -1311435322:
                if (str2.equals("oauthdevicebindinginitSv1")) {
                    return "https://accounts.paytm.com/devicebinding/init/sv1";
                }
                break;
            case -1285833062:
                if (str2.equals("encryptedTokenUrl")) {
                    return "https://paytm.com/v1/user/token/enc/generate";
                }
                break;
            case -1133177443:
                if (str2.equals("oauthLocationRollOutSet")) {
                    return "[7,12]";
                }
                break;
            case -1079153376:
                if (str2.equals("oauthVerifyCard")) {
                    return "https://accounts-pci.paytm.com/user/asset/verify/cardDetails";
                }
                break;
            case -1078240890:
                if (str2.equals("forgetpasswordSv1")) {
                    return "https://accounts.paytm.com/forgetpassword/sv1";
                }
                break;
            case -1077183439:
                if (str2.equals("simple_auth_otp_url")) {
                    return "https://accounts.paytm.com/simple/login/resend/otp";
                }
                break;
            case -1050172292:
                if (str2.equals("oauthDebAutoReadOtpVersion")) {
                    return "8.16.2";
                }
                break;
            case -968476917:
                if (str2.equals("mergeChallenge")) {
                    return "https://accounts.paytm.com/merge/challenge";
                }
                break;
            case -965150836:
                if (str2.equals("oauthauthorizeinitSv1")) {
                    return "https://accounts.paytm.com/oauth2/authorize/init/sv1";
                }
                break;
            case -897350079:
                if (str2.equals("userPhoneV4")) {
                    return "https://accounts.paytm.com/v4/user/phone";
                }
                break;
            case -845623405:
                if (str2.equals("validateOtpV4")) {
                    return "https://accounts.paytm.com/v4/api/validate/otp";
                }
                break;
            case -760533911:
                if (str2.equals("profileValidateOTPV3")) {
                    return "https://accounts.paytm.com/v3/user/validate/otp";
                }
                break;
            case -430296540:
                if (str2.equals("profileResendOTPV3")) {
                    return "https://accounts.paytm.com/v3/user/resend/otp";
                }
                break;
            case -422762960:
                if (str2.equals("oauthValidateOtpSv1")) {
                    return "https://accounts.paytm.com/v2/simple/login/validate/otp/sv1";
                }
                break;
            case -406557761:
                if (str2.equals("oauthTokenV3")) {
                    return "https://accounts.paytm.com/oauth2/v3/token/sv1";
                }
                break;
            case -391720738:
                if (str2.equals("oauthValidatePwdSv1")) {
                    return "https://accounts.paytm.com/v2/simple/login/validate/password/sv1";
                }
                break;
            case -364641160:
                if (str2.equals("oauthV2authorizeSv1")) {
                    return "https://accounts.paytm.com/oauth2/v2/authorize/sv1";
                }
                break;
            case -333255865:
                if (str2.equals("oauthDoView")) {
                    return "https://riskengine.paytm.com/risk/identify/nonstandard/doView";
                }
                break;
            case -190457565:
                if (str2.equals("oauthInitV2")) {
                    return "https://accounts.paytm.com/v2/simple/login/init";
                }
                break;
            case -183116971:
                if (str2.equals("OauthResendOTPSV1")) {
                    return "https://accounts.paytm.com/resend/otp/sv1";
                }
                break;
            case -69020816:
                if (str2.equals("oauthV2UserSv1")) {
                    return "https://accounts.paytm.com/v2/user/sv1";
                }
                break;
            case 10476425:
                if (str2.equals("oauthSendOtpV3")) {
                    return "https://accounts.paytm.com/v3/api/sendOtp";
                }
                break;
            case 11948129:
                if (str2.equals("sendOtpV4")) {
                    return "https://accounts.paytm.com/v4/api/send/otp";
                }
                break;
            case 27786834:
                if (str2.equals("OauthValidateOTPV4SV1")) {
                    return "https://accounts.paytm.com/v4/api/validate/otp/sv1";
                }
                break;
            case 78540418:
                if (str2.equals("oauthVerificationInit")) {
                    return "https://accounts.paytm.com/user/verification/init";
                }
                break;
            case 108426606:
                if (str2.equals("restDoViewLogout")) {
                    return "https://accounts.paytm.com/risk/identify/nonstandard/doView";
                }
                break;
            case 201223788:
                if (str2.equals("oauthDebSenderIdAutoReadOtp")) {
                    return "[paytmi,ipmall,pfgame,gmpind,mpaytm,paytmm,120130,paytmb,vpaytm,ipaytm,bpaytm,197007,paytmh]";
                }
                break;
            case 254491910:
                if (str2.equals("logoutIfRequired")) {
                    return "https://accounts.paytm.com/oauth2/logoutIfRequired";
                }
                break;
            case 281610540:
                if (str2.equals("oauthTokenSv1")) {
                    return "https://accounts.paytm.com/oauth2/token/sv1";
                }
                break;
            case 357738884:
                if (str2.equals("oauthdevicebindinginterveneSv1")) {
                    return "https://accounts.paytm.com/devicebinding/intervene/sv1";
                }
                break;
            case 377418271:
                if (str2.equals("oauthDeviceUpgradeSv1")) {
                    return "https://accounts.paytm.com/device/upgrade/sv1";
                }
                break;
            case 449056646:
                if (str2.equals("userPassword")) {
                    return "https://accounts.paytm.com/password";
                }
                break;
            case 595749210:
                if (str2.equals("logout_all_devices_sso")) {
                    return "https://accounts.paytm.com/oauth2/accessToken/delete/all/sessions";
                }
                break;
            case 629577124:
                if (str2.equals("oauthdevicebindingstatusSv1")) {
                    return "https://accounts.paytm.com/devicebinding/status/sv1";
                }
                break;
            case 629923750:
                if (str2.equals("oauthdevicebindingConfirmSv1")) {
                    return "https://accounts.paytm.com/devicebinding/confirm/sv1";
                }
                break;
            case 679765070:
                if (str2.equals("operator_icons_mapping")) {
                    return "{\"upi_telco_icons\":{\"airtel\":\"https://s3-ap-southeast-1.amazonaws.com/assets.paytm.com/promotion/Prabhu+Sharma/Telecom+Logo/Telecom+Logo/Android/xxhdpi/Airtel.png\", \"vodafone\":\"https://s3-ap-southeast-1.amazonaws.com/assets.paytm.com/promotion/Prabhu+Sharma/Telecom+Logo/Telecom+Logo/Android/xxhdpi/Vodafone.png\", \"jio\":\"https://s3-ap-southeast-1.amazonaws.com/assets.paytm.com/promotion/Prabhu+Sharma/Telecom+Logo/Telecom+Logo/Android/xxhdpi/Jio.png\", \"mtnl\":\"https://s3-ap-southeast-1.amazonaws.com/assets.paytm.com/promotion/Prabhu+Sharma/Telecom/Telecom/Android/xxhdpi/MTNL.png\", \"idea\":\"https://s3-ap-southeast-1.amazonaws.com/assets.paytm.com/promotion/Prabhu+Sharma/Telecom+Logo/Telecom+Logo/Android/xxhdpi/Idea.png\", \"bsnl\":\"https://s3-ap-southeast-1.amazonaws.com/assets.paytm.com/promotion/Prabhu+Sharma/Telecom+Logo/Telecom+Logo/Android/xxhdpi/BSNL.png\", \"rcom\":\"https://s3-ap-southeast-1.amazonaws.com/assets.paytm.com/promotion/Prabhu+Sharma/Telecom/Telecom/Android/xxhdpi/RComm.png\"}}";
                }
                break;
            case 692008116:
                if (str2.equals("deviceBindingVersionName")) {
                    return "1.0";
                }
                break;
            case 747466636:
                if (str2.equals("oauthLoginInitSv1")) {
                    return "https://accounts.paytm.com/v2/simple/login/init/sv1";
                }
                break;
            case 875734478:
                if (str2.equals("oauthVerificationFulfill")) {
                    return "https://accounts.paytm.com/user/verification/fulfill";
                }
                break;
            case 883268202:
                if (str2.equals("simChangePopUpCount")) {
                    return "3";
                }
                break;
            case 931431019:
                if (str2.equals("changePassword")) {
                    return "https://accounts.paytm.com/api/changePassword";
                }
                break;
            case 934663560:
                if (str2.equals("userValidateOtpV4")) {
                    return "https://accounts.paytm.com/v4/user/validate/otp";
                }
                break;
            case 1126981863:
                if (str2.equals("oauthSimpleResendOtpSv1")) {
                    return "https://accounts.paytm.com/v2/simple/login/resend/otp/sv1";
                }
                break;
            case 1161001520:
                if (str2.equals("updateEmailV3")) {
                    return "https://accounts.paytm.com/v3/user/email";
                }
                break;
            case 1298539355:
                if (str2.equals("OauthUserValidateOTPSV1")) {
                    return "https://accounts.paytm.com/v4/user/validate/otp/sv1";
                }
                break;
            case 1388970757:
                if (str2.equals("restDoViewLogin")) {
                    return "https://accounts.paytm.com/risk/identify/doView";
                }
                break;
            case 1486683944:
                if (str2.equals("oauthAccountStatus")) {
                    return "https://accounts.paytm.com/account/status";
                }
                break;
            case 1510383162:
                if (str2.equals("oauthValidateOtpV2")) {
                    return "https://accounts.paytm.com/v2/simple/login/validate/otp";
                }
                break;
            case 1530589301:
                if (str2.equals("oauthResendOtpV2")) {
                    return "https://accounts.paytm.com/v2/simple/login/resend/otp";
                }
                break;
            case 1590744385:
                if (str2.equals("oauthClaimV2")) {
                    return "https://accounts.paytm.com/v2/simple/claim";
                }
                break;
            case 1721176573:
                if (str2.equals("oauthLocationPermissionVersion")) {
                    return "1.0";
                }
                break;
            case 1818701415:
                if (str2.equals("changePasswordV2Sv1")) {
                    return "https://accounts.paytm.com/v2/api/changePassword/sv1";
                }
                break;
            case 1827028015:
                if (str2.equals("signUpStoreFrontUrl")) {
                    return "https://storefront.paytm.com/v2/h/app-pop-up";
                }
                break;
            case 1860343963:
                if (str2.equals("oauthDoVerify")) {
                    return "https://riskengine.paytm.com/risk/identify/nonstandard/doVerify";
                }
                break;
            case 1894297243:
                if (str2.equals("oauthSimpleClaimSv1")) {
                    return "https://accounts.paytm.com/v2/simple/claim/sv1";
                }
                break;
            case 1895325780:
                if (str2.equals("oauthdevicebindingconfigSv1")) {
                    return "https://accounts.paytm.com/devicebinding/config/sv1";
                }
                break;
            case 1992698652:
                if (str2.equals("simple_auth_validate_otp_url")) {
                    return "https://accounts.paytm.com/simple/login/validate/otp";
                }
                break;
            case 1995919459:
                if (str2.equals(UpiConstantServiceApi.KEY_TOKEN)) {
                    return "https://accounts.paytm.com/oauth2/token";
                }
                break;
            case 2017232921:
                if (str2.equals("oauthResendOtp")) {
                    return "https://accounts.paytm.com/resend/otp";
                }
                break;
            case 2088279153:
                if (str2.equals("signout")) {
                    return "https://accounts.paytm.com/oauth2/accessToken";
                }
                break;
            case 2145621934:
                if (str2.equals("claim_acc_url")) {
                    return "https://accounts.paytm.com/simple/claim";
                }
                break;
        }
        return "";
    }

    public static int a(String str, int i2) {
        k.c(str, "key");
        int hashCode = str.hashCode();
        if (hashCode != -1763789306) {
            if (hashCode != -1364638558) {
                if (hashCode == -1219252636 && str.equals("authOtpCallTimer")) {
                    return 30;
                }
            } else if (str.equals("authOtpTimer")) {
                return 20;
            }
        } else if (str.equals("oauthSetAppLockInterval")) {
            return 90;
        }
        return i2;
    }
}
