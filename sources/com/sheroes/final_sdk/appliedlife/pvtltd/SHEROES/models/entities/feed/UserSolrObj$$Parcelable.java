package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed;

import android.os.Parcel;
import android.os.Parcelable;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.Comment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.Comment$$Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.parceler.a;
import org.parceler.b;
import org.parceler.e;
import org.parceler.f;

public class UserSolrObj$$Parcelable implements Parcelable, e<UserSolrObj> {
    public static final Parcelable.Creator<UserSolrObj$$Parcelable> CREATOR = new Parcelable.Creator<UserSolrObj$$Parcelable>() {
        public final UserSolrObj$$Parcelable createFromParcel(Parcel parcel) {
            return new UserSolrObj$$Parcelable(UserSolrObj$$Parcelable.read(parcel, new a()));
        }

        public final UserSolrObj$$Parcelable[] newArray(int i2) {
            return new UserSolrObj$$Parcelable[i2];
        }
    };
    private UserSolrObj userSolrObj$$0;

    public int describeContents() {
        return 0;
    }

    public UserSolrObj$$Parcelable(UserSolrObj userSolrObj) {
        this.userSolrObj$$0 = userSolrObj;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.userSolrObj$$0, parcel, i2, new a());
    }

    public static void write(UserSolrObj userSolrObj, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) userSolrObj);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) userSolrObj));
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "currExperienceTitles") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "currExperienceTitles")).size());
            new b.C0602b();
            for (String writeString : (List) b.a(UserSolrObj.class, userSolrObj, "currExperienceTitles")) {
                parcel.writeString(writeString);
            }
        }
        Class<String> cls = String.class;
        parcel.writeString((String) b.a(UserSolrObj.class, userSolrObj, "emailId"));
        Class cls2 = Long.TYPE;
        parcel.writeLong(((Long) b.a(UserSolrObj.class, userSolrObj, "cityId")).longValue());
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "experienceTitles") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "experienceTitles")).size());
            new b.C0602b();
            for (String writeString2 : (List) b.a(UserSolrObj.class, userSolrObj, "experienceTitles")) {
                parcel.writeString(writeString2);
            }
        }
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "experienceCompanyIds") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "experienceCompanyIds")).size());
            new b.C0602b();
            for (Long l : (List) b.a(UserSolrObj.class, userSolrObj, "experienceCompanyIds")) {
                if (l == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l.longValue());
                }
            }
        }
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "currExperienceCompanyNames") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "currExperienceCompanyNames")).size());
            new b.C0602b();
            for (String writeString3 : (List) b.a(UserSolrObj.class, userSolrObj, "currExperienceCompanyNames")) {
                parcel.writeString(writeString3);
            }
        }
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "skills") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "skills")).size());
            new b.C0602b();
            for (String writeString4 : (List) b.a(UserSolrObj.class, userSolrObj, "skills")) {
                parcel.writeString(writeString4);
            }
        }
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "fieldOfStudyMasterIds") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "fieldOfStudyMasterIds")).size());
            new b.C0602b();
            for (Long l2 : (List) b.a(UserSolrObj.class, userSolrObj, "fieldOfStudyMasterIds")) {
                if (l2 == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l2.longValue());
                }
            }
        }
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "skillIds") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "skillIds")).size());
            new b.C0602b();
            for (Long l3 : (List) b.a(UserSolrObj.class, userSolrObj, "skillIds")) {
                if (l3 == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l3.longValue());
                }
            }
        }
        Class<Date> cls3 = Date.class;
        parcel.writeSerializable((Serializable) b.a(UserSolrObj.class, userSolrObj, "lastActivityDate"));
        Class cls4 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(UserSolrObj.class, userSolrObj, "isSuggested")).booleanValue() ? 1 : 0);
        Class cls5 = Long.TYPE;
        parcel.writeLong(((Long) b.a(UserSolrObj.class, userSolrObj, "solrIgnoreMentorCommunityId")).longValue());
        Class cls6 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(UserSolrObj.class, userSolrObj, "marsUserCurrentSalary")).intValue());
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "searchIdCommunities") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "searchIdCommunities")).size());
            new b.C0602b();
            for (Long l4 : (List) b.a(UserSolrObj.class, userSolrObj, "searchIdCommunities")) {
                if (l4 == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l4.longValue());
                }
            }
        }
        Class cls7 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(UserSolrObj.class, userSolrObj, "solrIgnoreNoOfMentorPosts")).intValue());
        Class cls8 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(UserSolrObj.class, userSolrObj, "noOfChildren")).intValue());
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "canHelpIns") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "canHelpIns")).size());
            new b.C0602b();
            for (String writeString5 : (List) b.a(UserSolrObj.class, userSolrObj, "canHelpIns")) {
                parcel.writeString(writeString5);
            }
        }
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "experienceCompanyNames") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "experienceCompanyNames")).size());
            new b.C0602b();
            for (String writeString6 : (List) b.a(UserSolrObj.class, userSolrObj, "experienceCompanyNames")) {
                parcel.writeString(writeString6);
            }
        }
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "opportunityTypes") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "opportunityTypes")).size());
            new b.C0602b();
            for (String writeString7 : (List) b.a(UserSolrObj.class, userSolrObj, "opportunityTypes")) {
                parcel.writeString(writeString7);
            }
        }
        Class cls9 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(UserSolrObj.class, userSolrObj, "solrIgnoreNoOfMentorAnswers")).intValue());
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "currExperienceIds") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "currExperienceIds")).size());
            new b.C0602b();
            for (Long l5 : (List) b.a(UserSolrObj.class, userSolrObj, "currExperienceIds")) {
                if (l5 == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l5.longValue());
                }
            }
        }
        Class cls10 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(UserSolrObj.class, userSolrObj, "userFollowing")).intValue());
        Class cls11 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(UserSolrObj.class, userSolrObj, "isCompanyAdmin")).booleanValue() ? 1 : 0);
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "educationSchoolIds") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "educationSchoolIds")).size());
            new b.C0602b();
            for (Long l6 : (List) b.a(UserSolrObj.class, userSolrObj, "educationSchoolIds")) {
                if (l6 == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l6.longValue());
                }
            }
        }
        Class cls12 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(UserSolrObj.class, userSolrObj, "totalExperience")).intValue());
        Class cls13 = Long.TYPE;
        parcel.writeLong(((Long) b.a(UserSolrObj.class, userSolrObj, "profileId")).longValue());
        Class cls14 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(UserSolrObj.class, userSolrObj, "solrIgnoreIsMentorFollowed")).booleanValue() ? 1 : 0);
        Class cls15 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(UserSolrObj.class, userSolrObj, "isCompactView")).booleanValue() ? 1 : 0);
        Class<String> cls16 = String.class;
        parcel.writeString((String) b.a(UserSolrObj.class, userSolrObj, "gender"));
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "opportunityTypeIds") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "opportunityTypeIds")).size());
            new b.C0602b();
            for (Long l7 : (List) b.a(UserSolrObj.class, userSolrObj, "opportunityTypeIds")) {
                if (l7 == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l7.longValue());
                }
            }
        }
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "educationSchoolNames") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "educationSchoolNames")).size());
            new b.C0602b();
            for (String writeString8 : (List) b.a(UserSolrObj.class, userSolrObj, "educationSchoolNames")) {
                parcel.writeString(writeString8);
            }
        }
        parcel.writeInt(userSolrObj.currentItemPosition);
        Class cls17 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(UserSolrObj.class, userSolrObj, "solrIgnoreIsUserFollowed")).booleanValue() ? 1 : 0);
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "educationDegreeIds") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "educationDegreeIds")).size());
            new b.C0602b();
            for (Long l8 : (List) b.a(UserSolrObj.class, userSolrObj, "educationDegreeIds")) {
                if (l8 == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l8.longValue());
                }
            }
        }
        Class<String> cls18 = String.class;
        parcel.writeString((String) b.a(UserSolrObj.class, userSolrObj, "cityName"));
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "canHelpInIds") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "canHelpInIds")).size());
            new b.C0602b();
            for (Long l9 : (List) b.a(UserSolrObj.class, userSolrObj, "canHelpInIds")) {
                if (l9 == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l9.longValue());
                }
            }
        }
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "educationDegreeNames") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "educationDegreeNames")).size());
            new b.C0602b();
            for (String writeString9 : (List) b.a(UserSolrObj.class, userSolrObj, "educationDegreeNames")) {
                parcel.writeString(writeString9);
            }
        }
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "interestId") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "interestId")).size());
            new b.C0602b();
            for (Long l10 : (List) b.a(UserSolrObj.class, userSolrObj, "interestId")) {
                if (l10 == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l10.longValue());
                }
            }
        }
        Class cls19 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(UserSolrObj.class, userSolrObj, "solrIgnoreNoOfMentorFollowers")).intValue());
        Class cls20 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(UserSolrObj.class, userSolrObj, "userCommentsCount")).intValue());
        Class cls21 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(UserSolrObj.class, userSolrObj, "solrIgnoreHasUserAskedQuestion")).booleanValue() ? 1 : 0);
        Class<String> cls22 = String.class;
        parcel.writeString((String) b.a(UserSolrObj.class, userSolrObj, "solrIgnoreMentorStatus"));
        Class cls23 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(UserSolrObj.class, userSolrObj, "userFollowersCount")).intValue());
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "educationIds") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "educationIds")).size());
            new b.C0602b();
            for (Long l11 : (List) b.a(UserSolrObj.class, userSolrObj, "educationIds")) {
                if (l11 == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l11.longValue());
                }
            }
        }
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "functionalAreaNames") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "functionalAreaNames")).size());
            new b.C0602b();
            for (String writeString10 : (List) b.a(UserSolrObj.class, userSolrObj, "functionalAreaNames")) {
                parcel.writeString(writeString10);
            }
        }
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "functionalAreaIds") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "functionalAreaIds")).size());
            new b.C0602b();
            for (Long l12 : (List) b.a(UserSolrObj.class, userSolrObj, "functionalAreaIds")) {
                if (l12 == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l12.longValue());
                }
            }
        }
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "currExperienceCompanyIds") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "currExperienceCompanyIds")).size());
            new b.C0602b();
            for (Long l13 : (List) b.a(UserSolrObj.class, userSolrObj, "currExperienceCompanyIds")) {
                if (l13 == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l13.longValue());
                }
            }
        }
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "interestNames") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "interestNames")).size());
            new b.C0602b();
            for (String writeString11 : (List) b.a(UserSolrObj.class, userSolrObj, "interestNames")) {
                parcel.writeString(writeString11);
            }
        }
        Class<String> cls24 = String.class;
        parcel.writeString((String) b.a(UserSolrObj.class, userSolrObj, "mobileNo"));
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "experienceIds") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "experienceIds")).size());
            new b.C0602b();
            for (Long l14 : (List) b.a(UserSolrObj.class, userSolrObj, "experienceIds")) {
                if (l14 == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l14.longValue());
                }
            }
        }
        Class<Long> cls25 = Long.class;
        if (b.a(UserSolrObj.class, userSolrObj, "currently_id") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Long> cls26 = Long.class;
            parcel.writeLong(((Long) b.a(UserSolrObj.class, userSolrObj, "currently_id")).longValue());
        }
        Class<String> cls27 = String.class;
        parcel.writeString((String) b.a(UserSolrObj.class, userSolrObj, "currently"));
        Class<String> cls28 = String.class;
        parcel.writeString((String) b.a(UserSolrObj.class, userSolrObj, "marsUserPreferredTime"));
        new b.C0602b();
        if (b.a(UserSolrObj.class, userSolrObj, "fieldOfStudyMasterNames") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserSolrObj.class, userSolrObj, "fieldOfStudyMasterNames")).size());
            new b.C0602b();
            for (String writeString12 : (List) b.a(UserSolrObj.class, userSolrObj, "fieldOfStudyMasterNames")) {
                parcel.writeString(writeString12);
            }
        }
        Class<String> cls29 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "authorCityName"));
        Class<String> cls30 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "blogLinkUrl"));
        Class cls31 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userSolrObj, "isBookmarked")).booleanValue() ? 1 : 0);
        Class cls32 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, userSolrObj, "noOfApplied")).intValue());
        Class<Integer> cls33 = Integer.class;
        if (b.a(FeedDetail.class, userSolrObj, "entityOrParticipantTypeId") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Integer> cls34 = Integer.class;
            parcel.writeInt(((Integer) b.a(FeedDetail.class, userSolrObj, "entityOrParticipantTypeId")).intValue());
        }
        Class<String> cls35 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "postingDate"));
        Class<String> cls36 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "type"));
        Class cls37 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userSolrObj, "isActive")).booleanValue() ? 1 : 0);
        Class cls38 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, userSolrObj, "noOfChallengeAccepted")).intValue());
        Class<String> cls39 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "callFromName"));
        Class<String> cls40 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "deepLinkUrl"));
        Class<String> cls41 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "thumbnailImageUrl"));
        Class<String> cls42 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "authorLastName"));
        Class<String> cls43 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "streamType"));
        Class<String> cls44 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "ogImageUrlS"));
        Class cls45 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userSolrObj, "isLongPress")).booleanValue() ? 1 : 0);
        Class cls46 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userSolrObj, "isSpamPost")).booleanValue() ? 1 : 0);
        Class cls47 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, userSolrObj, "authorParticipantId")).longValue());
        Class<String> cls48 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "id"));
        Class cls49 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userSolrObj, "isFeatured")).booleanValue() ? 1 : 0);
        Class<String> cls50 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "authorShortDescription"));
        Class<String> cls51 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "mentorDeepLinkUrl"));
        Class cls52 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, userSolrObj, "noOfLikes")).intValue());
        new b.C0602b();
        if (b.a(FeedDetail.class, userSolrObj, "lastComments") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedDetail.class, userSolrObj, "lastComments")).size());
            new b.C0602b();
            for (Comment write : (List) b.a(FeedDetail.class, userSolrObj, "lastComments")) {
                Comment$$Parcelable.write(write, parcel, i2, aVar);
            }
        }
        new b.C0602b();
        if (b.a(FeedDetail.class, userSolrObj, "tag_ids") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedDetail.class, userSolrObj, "tag_ids")).size());
            new b.C0602b();
            for (Long l15 : (List) b.a(FeedDetail.class, userSolrObj, "tag_ids")) {
                if (l15 == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l15.longValue());
                }
            }
        }
        Class<String> cls53 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "listShortDescription"));
        Class<String> cls54 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "shortDescription"));
        Class cls55 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userSolrObj, "isAuthorImagePublic")).booleanValue() ? 1 : 0);
        Class<String> cls56 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "participantDeepLinkingUrl"));
        new b.C0602b();
        if (b.a(FeedDetail.class, userSolrObj, "tags") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedDetail.class, userSolrObj, "tags")).size());
            new b.C0602b();
            for (String writeString13 : (List) b.a(FeedDetail.class, userSolrObj, "tags")) {
                parcel.writeString(writeString13);
            }
        }
        Class cls57 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userSolrObj, "isAuthorMentor")).booleanValue() ? 1 : 0);
        Class cls58 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userSolrObj, "isTrending")).booleanValue() ? 1 : 0);
        Class<String> cls59 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "authorCityId"));
        Class cls60 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, userSolrObj, "profileId")).longValue());
        Class<String> cls61 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "authorName"));
        Class<String> cls62 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "ogRequestedUrlS"));
        Class cls63 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, userSolrObj, "lastReactionValue")).intValue());
        parcel.writeString(userSolrObj.subType);
        Class<String> cls64 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "authorParticipantType"));
        Class cls65 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, userSolrObj, "reactedValue")).intValue());
        Class cls66 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userSolrObj, "isAuthorConfidential")).booleanValue() ? 1 : 0);
        Class cls67 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, userSolrObj, "entityOrParticipantId")).longValue());
        Class<Date> cls68 = Date.class;
        parcel.writeSerializable((Serializable) b.a(FeedDetail.class, userSolrObj, "postingDateOnly"));
        Class cls69 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, userSolrObj, "noOfViews")).intValue());
        Class<String> cls70 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, RequestConfirmationDialogFragment.KEY_DESCRIPTION));
        Class cls71 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userSolrObj, "isChallengeAccepted")).booleanValue() ? 1 : 0);
        Class cls72 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userSolrObj, "isViewed")).booleanValue() ? 1 : 0);
        Class<String> cls73 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "nameOrTitle"));
        Class cls74 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, userSolrObj, "noOfComments")).intValue());
        Class cls75 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userSolrObj, "isDeleted")).booleanValue() ? 1 : 0);
        Class<String> cls76 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "authorFirstName"));
        Class<String> cls77 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "imageUrl"));
        Class cls78 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userSolrObj, "isApplied")).booleanValue() ? 1 : 0);
        Class cls79 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, userSolrObj, "itemPosition")).intValue());
        Class<String> cls80 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "entityDeepLinkingUrl"));
        Class cls81 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, userSolrObj, "idOfEntityOrParticipant")).longValue());
        Class<Date> cls82 = Date.class;
        parcel.writeSerializable((Serializable) b.a(FeedDetail.class, userSolrObj, "lastModifiedDate"));
        Class<String> cls83 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "ogDescriptionS"));
        Class<String> cls84 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "ogTitleS"));
        Class cls85 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, userSolrObj, "authorId")).longValue());
        Class cls86 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, userSolrObj, "noOfBookmarks")).intValue());
        Class<String> cls87 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "userSubType"));
        Class cls88 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userSolrObj, "isFromHome")).booleanValue() ? 1 : 0);
        Class<String> cls89 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "createdDate"));
        Class cls90 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userSolrObj, "isOgVideoLinkB")).booleanValue() ? 1 : 0);
        Class<String> cls91 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "postShortBranchUrls"));
        Class cls92 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, userSolrObj, "createdBy")).longValue());
        Class<String> cls93 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "listDescription"));
        Class cls94 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userSolrObj, "isExpired")).booleanValue() ? 1 : 0);
        Class<String> cls95 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userSolrObj, "authorImageUrl"));
    }

    public UserSolrObj getParcel() {
        return this.userSolrObj$$0;
    }

    public static UserSolrObj read(Parcel parcel, a aVar) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        ArrayList arrayList8;
        ArrayList arrayList9;
        ArrayList arrayList10;
        ArrayList arrayList11;
        ArrayList arrayList12;
        ArrayList arrayList13;
        ArrayList arrayList14;
        ArrayList arrayList15;
        ArrayList arrayList16;
        ArrayList arrayList17;
        ArrayList arrayList18;
        ArrayList arrayList19;
        ArrayList arrayList20;
        ArrayList arrayList21;
        ArrayList arrayList22;
        ArrayList arrayList23;
        ArrayList arrayList24;
        ArrayList arrayList25;
        Long l;
        ArrayList arrayList26;
        Integer num;
        ArrayList arrayList27;
        ArrayList arrayList28;
        Long l2;
        Long l3;
        Long l4;
        Long l5;
        Long l6;
        Long l7;
        Long l8;
        Long l9;
        Long l10;
        Long l11;
        Long l12;
        Long l13;
        Long l14;
        Long l15;
        Long l16;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            UserSolrObj userSolrObj = new UserSolrObj();
            aVar.a(a2, userSolrObj);
            int readInt2 = parcel.readInt();
            ArrayList arrayList29 = null;
            boolean z = false;
            if (readInt2 < 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(readInt2);
                for (int i2 = 0; i2 < readInt2; i2++) {
                    arrayList.add(parcel.readString());
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "currExperienceTitles", arrayList);
            b.a(UserSolrObj.class, userSolrObj, "emailId", parcel.readString());
            b.a(UserSolrObj.class, userSolrObj, "cityId", Long.valueOf(parcel.readLong()));
            int readInt3 = parcel.readInt();
            if (readInt3 < 0) {
                arrayList2 = null;
            } else {
                arrayList2 = new ArrayList(readInt3);
                for (int i3 = 0; i3 < readInt3; i3++) {
                    arrayList2.add(parcel.readString());
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "experienceTitles", arrayList2);
            int readInt4 = parcel.readInt();
            if (readInt4 < 0) {
                arrayList3 = null;
            } else {
                arrayList3 = new ArrayList(readInt4);
                for (int i4 = 0; i4 < readInt4; i4++) {
                    if (parcel.readInt() < 0) {
                        l16 = null;
                    } else {
                        l16 = Long.valueOf(parcel.readLong());
                    }
                    arrayList3.add(l16);
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "experienceCompanyIds", arrayList3);
            int readInt5 = parcel.readInt();
            if (readInt5 < 0) {
                arrayList4 = null;
            } else {
                arrayList4 = new ArrayList(readInt5);
                for (int i5 = 0; i5 < readInt5; i5++) {
                    arrayList4.add(parcel.readString());
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "currExperienceCompanyNames", arrayList4);
            int readInt6 = parcel.readInt();
            if (readInt6 < 0) {
                arrayList5 = null;
            } else {
                arrayList5 = new ArrayList(readInt6);
                for (int i6 = 0; i6 < readInt6; i6++) {
                    arrayList5.add(parcel.readString());
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "skills", arrayList5);
            int readInt7 = parcel.readInt();
            if (readInt7 < 0) {
                arrayList6 = null;
            } else {
                arrayList6 = new ArrayList(readInt7);
                for (int i7 = 0; i7 < readInt7; i7++) {
                    if (parcel.readInt() < 0) {
                        l15 = null;
                    } else {
                        l15 = Long.valueOf(parcel.readLong());
                    }
                    arrayList6.add(l15);
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "fieldOfStudyMasterIds", arrayList6);
            int readInt8 = parcel.readInt();
            if (readInt8 < 0) {
                arrayList7 = null;
            } else {
                arrayList7 = new ArrayList(readInt8);
                for (int i8 = 0; i8 < readInt8; i8++) {
                    if (parcel.readInt() < 0) {
                        l14 = null;
                    } else {
                        l14 = Long.valueOf(parcel.readLong());
                    }
                    arrayList7.add(l14);
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "skillIds", arrayList7);
            b.a(UserSolrObj.class, userSolrObj, "lastActivityDate", (Date) parcel.readSerializable());
            b.a(UserSolrObj.class, userSolrObj, "isSuggested", Boolean.valueOf(parcel.readInt() == 1));
            b.a(UserSolrObj.class, userSolrObj, "solrIgnoreMentorCommunityId", Long.valueOf(parcel.readLong()));
            b.a(UserSolrObj.class, userSolrObj, "marsUserCurrentSalary", Integer.valueOf(parcel.readInt()));
            int readInt9 = parcel.readInt();
            if (readInt9 < 0) {
                arrayList8 = null;
            } else {
                arrayList8 = new ArrayList(readInt9);
                for (int i9 = 0; i9 < readInt9; i9++) {
                    if (parcel.readInt() < 0) {
                        l13 = null;
                    } else {
                        l13 = Long.valueOf(parcel.readLong());
                    }
                    arrayList8.add(l13);
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "searchIdCommunities", arrayList8);
            b.a(UserSolrObj.class, userSolrObj, "solrIgnoreNoOfMentorPosts", Integer.valueOf(parcel.readInt()));
            b.a(UserSolrObj.class, userSolrObj, "noOfChildren", Integer.valueOf(parcel.readInt()));
            int readInt10 = parcel.readInt();
            if (readInt10 < 0) {
                arrayList9 = null;
            } else {
                arrayList9 = new ArrayList(readInt10);
                for (int i10 = 0; i10 < readInt10; i10++) {
                    arrayList9.add(parcel.readString());
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "canHelpIns", arrayList9);
            int readInt11 = parcel.readInt();
            if (readInt11 < 0) {
                arrayList10 = null;
            } else {
                arrayList10 = new ArrayList(readInt11);
                for (int i11 = 0; i11 < readInt11; i11++) {
                    arrayList10.add(parcel.readString());
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "experienceCompanyNames", arrayList10);
            int readInt12 = parcel.readInt();
            if (readInt12 < 0) {
                arrayList11 = null;
            } else {
                arrayList11 = new ArrayList(readInt12);
                for (int i12 = 0; i12 < readInt12; i12++) {
                    arrayList11.add(parcel.readString());
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "opportunityTypes", arrayList11);
            b.a(UserSolrObj.class, userSolrObj, "solrIgnoreNoOfMentorAnswers", Integer.valueOf(parcel.readInt()));
            int readInt13 = parcel.readInt();
            if (readInt13 < 0) {
                arrayList12 = null;
            } else {
                arrayList12 = new ArrayList(readInt13);
                for (int i13 = 0; i13 < readInt13; i13++) {
                    if (parcel.readInt() < 0) {
                        l12 = null;
                    } else {
                        l12 = Long.valueOf(parcel.readLong());
                    }
                    arrayList12.add(l12);
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "currExperienceIds", arrayList12);
            b.a(UserSolrObj.class, userSolrObj, "userFollowing", Integer.valueOf(parcel.readInt()));
            b.a(UserSolrObj.class, userSolrObj, "isCompanyAdmin", Boolean.valueOf(parcel.readInt() == 1));
            int readInt14 = parcel.readInt();
            if (readInt14 < 0) {
                arrayList13 = null;
            } else {
                arrayList13 = new ArrayList(readInt14);
                for (int i14 = 0; i14 < readInt14; i14++) {
                    if (parcel.readInt() < 0) {
                        l11 = null;
                    } else {
                        l11 = Long.valueOf(parcel.readLong());
                    }
                    arrayList13.add(l11);
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "educationSchoolIds", arrayList13);
            b.a(UserSolrObj.class, userSolrObj, "totalExperience", Integer.valueOf(parcel.readInt()));
            b.a(UserSolrObj.class, userSolrObj, "profileId", Long.valueOf(parcel.readLong()));
            b.a(UserSolrObj.class, userSolrObj, "solrIgnoreIsMentorFollowed", Boolean.valueOf(parcel.readInt() == 1));
            b.a(UserSolrObj.class, userSolrObj, "isCompactView", Boolean.valueOf(parcel.readInt() == 1));
            b.a(UserSolrObj.class, userSolrObj, "gender", parcel.readString());
            int readInt15 = parcel.readInt();
            if (readInt15 < 0) {
                arrayList14 = null;
            } else {
                arrayList14 = new ArrayList(readInt15);
                for (int i15 = 0; i15 < readInt15; i15++) {
                    if (parcel.readInt() < 0) {
                        l10 = null;
                    } else {
                        l10 = Long.valueOf(parcel.readLong());
                    }
                    arrayList14.add(l10);
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "opportunityTypeIds", arrayList14);
            int readInt16 = parcel.readInt();
            if (readInt16 < 0) {
                arrayList15 = null;
            } else {
                arrayList15 = new ArrayList(readInt16);
                for (int i16 = 0; i16 < readInt16; i16++) {
                    arrayList15.add(parcel.readString());
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "educationSchoolNames", arrayList15);
            userSolrObj.currentItemPosition = parcel.readInt();
            b.a(UserSolrObj.class, userSolrObj, "solrIgnoreIsUserFollowed", Boolean.valueOf(parcel.readInt() == 1));
            int readInt17 = parcel.readInt();
            if (readInt17 < 0) {
                arrayList16 = null;
            } else {
                arrayList16 = new ArrayList(readInt17);
                for (int i17 = 0; i17 < readInt17; i17++) {
                    if (parcel.readInt() < 0) {
                        l9 = null;
                    } else {
                        l9 = Long.valueOf(parcel.readLong());
                    }
                    arrayList16.add(l9);
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "educationDegreeIds", arrayList16);
            b.a(UserSolrObj.class, userSolrObj, "cityName", parcel.readString());
            int readInt18 = parcel.readInt();
            if (readInt18 < 0) {
                arrayList17 = null;
            } else {
                arrayList17 = new ArrayList(readInt18);
                for (int i18 = 0; i18 < readInt18; i18++) {
                    if (parcel.readInt() < 0) {
                        l8 = null;
                    } else {
                        l8 = Long.valueOf(parcel.readLong());
                    }
                    arrayList17.add(l8);
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "canHelpInIds", arrayList17);
            int readInt19 = parcel.readInt();
            if (readInt19 < 0) {
                arrayList18 = null;
            } else {
                arrayList18 = new ArrayList(readInt19);
                for (int i19 = 0; i19 < readInt19; i19++) {
                    arrayList18.add(parcel.readString());
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "educationDegreeNames", arrayList18);
            int readInt20 = parcel.readInt();
            if (readInt20 < 0) {
                arrayList19 = null;
            } else {
                arrayList19 = new ArrayList(readInt20);
                for (int i20 = 0; i20 < readInt20; i20++) {
                    if (parcel.readInt() < 0) {
                        l7 = null;
                    } else {
                        l7 = Long.valueOf(parcel.readLong());
                    }
                    arrayList19.add(l7);
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "interestId", arrayList19);
            b.a(UserSolrObj.class, userSolrObj, "solrIgnoreNoOfMentorFollowers", Integer.valueOf(parcel.readInt()));
            b.a(UserSolrObj.class, userSolrObj, "userCommentsCount", Integer.valueOf(parcel.readInt()));
            b.a(UserSolrObj.class, userSolrObj, "solrIgnoreHasUserAskedQuestion", Boolean.valueOf(parcel.readInt() == 1));
            b.a(UserSolrObj.class, userSolrObj, "solrIgnoreMentorStatus", parcel.readString());
            b.a(UserSolrObj.class, userSolrObj, "userFollowersCount", Integer.valueOf(parcel.readInt()));
            int readInt21 = parcel.readInt();
            if (readInt21 < 0) {
                arrayList20 = null;
            } else {
                arrayList20 = new ArrayList(readInt21);
                for (int i21 = 0; i21 < readInt21; i21++) {
                    if (parcel.readInt() < 0) {
                        l6 = null;
                    } else {
                        l6 = Long.valueOf(parcel.readLong());
                    }
                    arrayList20.add(l6);
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "educationIds", arrayList20);
            int readInt22 = parcel.readInt();
            if (readInt22 < 0) {
                arrayList21 = null;
            } else {
                arrayList21 = new ArrayList(readInt22);
                for (int i22 = 0; i22 < readInt22; i22++) {
                    arrayList21.add(parcel.readString());
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "functionalAreaNames", arrayList21);
            int readInt23 = parcel.readInt();
            if (readInt23 < 0) {
                arrayList22 = null;
            } else {
                arrayList22 = new ArrayList(readInt23);
                for (int i23 = 0; i23 < readInt23; i23++) {
                    if (parcel.readInt() < 0) {
                        l5 = null;
                    } else {
                        l5 = Long.valueOf(parcel.readLong());
                    }
                    arrayList22.add(l5);
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "functionalAreaIds", arrayList22);
            int readInt24 = parcel.readInt();
            if (readInt24 < 0) {
                arrayList23 = null;
            } else {
                arrayList23 = new ArrayList(readInt24);
                for (int i24 = 0; i24 < readInt24; i24++) {
                    if (parcel.readInt() < 0) {
                        l4 = null;
                    } else {
                        l4 = Long.valueOf(parcel.readLong());
                    }
                    arrayList23.add(l4);
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "currExperienceCompanyIds", arrayList23);
            int readInt25 = parcel.readInt();
            if (readInt25 < 0) {
                arrayList24 = null;
            } else {
                arrayList24 = new ArrayList(readInt25);
                for (int i25 = 0; i25 < readInt25; i25++) {
                    arrayList24.add(parcel.readString());
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "interestNames", arrayList24);
            b.a(UserSolrObj.class, userSolrObj, "mobileNo", parcel.readString());
            int readInt26 = parcel.readInt();
            if (readInt26 < 0) {
                arrayList25 = null;
            } else {
                arrayList25 = new ArrayList(readInt26);
                for (int i26 = 0; i26 < readInt26; i26++) {
                    if (parcel.readInt() < 0) {
                        l3 = null;
                    } else {
                        l3 = Long.valueOf(parcel.readLong());
                    }
                    arrayList25.add(l3);
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "experienceIds", arrayList25);
            if (parcel.readInt() < 0) {
                l = null;
            } else {
                l = Long.valueOf(parcel.readLong());
            }
            b.a(UserSolrObj.class, userSolrObj, "currently_id", l);
            b.a(UserSolrObj.class, userSolrObj, "currently", parcel.readString());
            b.a(UserSolrObj.class, userSolrObj, "marsUserPreferredTime", parcel.readString());
            int readInt27 = parcel.readInt();
            if (readInt27 < 0) {
                arrayList26 = null;
            } else {
                arrayList26 = new ArrayList(readInt27);
                for (int i27 = 0; i27 < readInt27; i27++) {
                    arrayList26.add(parcel.readString());
                }
            }
            b.a(UserSolrObj.class, userSolrObj, "fieldOfStudyMasterNames", arrayList26);
            b.a(FeedDetail.class, userSolrObj, "authorCityName", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "blogLinkUrl", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "isBookmarked", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userSolrObj, "noOfApplied", Integer.valueOf(parcel.readInt()));
            if (parcel.readInt() < 0) {
                num = null;
            } else {
                num = Integer.valueOf(parcel.readInt());
            }
            b.a(FeedDetail.class, userSolrObj, "entityOrParticipantTypeId", num);
            b.a(FeedDetail.class, userSolrObj, "postingDate", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "type", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "isActive", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userSolrObj, "noOfChallengeAccepted", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, userSolrObj, "callFromName", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "deepLinkUrl", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "thumbnailImageUrl", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "authorLastName", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "streamType", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "ogImageUrlS", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "isLongPress", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userSolrObj, "isSpamPost", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userSolrObj, "authorParticipantId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, userSolrObj, "id", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "isFeatured", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userSolrObj, "authorShortDescription", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "mentorDeepLinkUrl", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "noOfLikes", Integer.valueOf(parcel.readInt()));
            int readInt28 = parcel.readInt();
            if (readInt28 < 0) {
                arrayList27 = null;
            } else {
                arrayList27 = new ArrayList(readInt28);
                for (int i28 = 0; i28 < readInt28; i28++) {
                    arrayList27.add(Comment$$Parcelable.read(parcel, aVar));
                }
            }
            b.a(FeedDetail.class, userSolrObj, "lastComments", arrayList27);
            int readInt29 = parcel.readInt();
            if (readInt29 < 0) {
                arrayList28 = null;
            } else {
                arrayList28 = new ArrayList(readInt29);
                for (int i29 = 0; i29 < readInt29; i29++) {
                    if (parcel.readInt() < 0) {
                        l2 = null;
                    } else {
                        l2 = Long.valueOf(parcel.readLong());
                    }
                    arrayList28.add(l2);
                }
            }
            b.a(FeedDetail.class, userSolrObj, "tag_ids", arrayList28);
            b.a(FeedDetail.class, userSolrObj, "listShortDescription", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "shortDescription", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "isAuthorImagePublic", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userSolrObj, "participantDeepLinkingUrl", parcel.readString());
            int readInt30 = parcel.readInt();
            if (readInt30 >= 0) {
                arrayList29 = new ArrayList(readInt30);
                for (int i30 = 0; i30 < readInt30; i30++) {
                    arrayList29.add(parcel.readString());
                }
            }
            b.a(FeedDetail.class, userSolrObj, "tags", arrayList29);
            b.a(FeedDetail.class, userSolrObj, "isAuthorMentor", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userSolrObj, "isTrending", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userSolrObj, "authorCityId", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "profileId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, userSolrObj, "authorName", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "ogRequestedUrlS", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "lastReactionValue", Integer.valueOf(parcel.readInt()));
            userSolrObj.subType = parcel.readString();
            b.a(FeedDetail.class, userSolrObj, "authorParticipantType", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "reactedValue", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, userSolrObj, "isAuthorConfidential", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userSolrObj, "entityOrParticipantId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, userSolrObj, "postingDateOnly", (Date) parcel.readSerializable());
            b.a(FeedDetail.class, userSolrObj, "noOfViews", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, userSolrObj, RequestConfirmationDialogFragment.KEY_DESCRIPTION, parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "isChallengeAccepted", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userSolrObj, "isViewed", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userSolrObj, "nameOrTitle", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "noOfComments", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, userSolrObj, "isDeleted", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userSolrObj, "authorFirstName", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "imageUrl", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "isApplied", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userSolrObj, "itemPosition", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, userSolrObj, "entityDeepLinkingUrl", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "idOfEntityOrParticipant", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, userSolrObj, "lastModifiedDate", (Date) parcel.readSerializable());
            b.a(FeedDetail.class, userSolrObj, "ogDescriptionS", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "ogTitleS", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "authorId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, userSolrObj, "noOfBookmarks", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, userSolrObj, "userSubType", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "isFromHome", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userSolrObj, "createdDate", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "isOgVideoLinkB", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userSolrObj, "postShortBranchUrls", parcel.readString());
            b.a(FeedDetail.class, userSolrObj, "createdBy", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, userSolrObj, "listDescription", parcel.readString());
            Class<FeedDetail> cls = FeedDetail.class;
            if (parcel.readInt() == 1) {
                z = true;
            }
            b.a(cls, userSolrObj, "isExpired", Boolean.valueOf(z));
            b.a(FeedDetail.class, userSolrObj, "authorImageUrl", parcel.readString());
            aVar.a(readInt, userSolrObj);
            return userSolrObj;
        } else if (!aVar.b(readInt)) {
            return (UserSolrObj) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
