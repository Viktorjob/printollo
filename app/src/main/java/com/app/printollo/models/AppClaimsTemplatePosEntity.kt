package com.app.printollo.models

import android.os.Parcel
import android.os.Parcelable

data class AppClaimsTemplatePosEntity (
    val id: Int?,
    val appUserClaimsTemplateId: Int?,
    val appUserClaimsTemplate: AppUserClaimsTemplateEntity,
    val appClaim: AppClaimEntity,
    val appClaimId: Int?,
    val isDeleted: Boolean?,
    val dateDeleted: String?,
    val deletedByUserId: String?,
    val userId: String?,
    val dateAdded: String?,
    val dateModified: String?,
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        TODO("appUserClaimsTemplate"),
        TODO("appClaim"),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeValue(appUserClaimsTemplateId)
        parcel.writeValue(appClaimId)
        parcel.writeValue(isDeleted)
        parcel.writeString(dateDeleted)
        parcel.writeString(deletedByUserId)
        parcel.writeString(userId)
        parcel.writeString(dateAdded)
        parcel.writeString(dateModified)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AppClaimsTemplatePosEntity> {
        override fun createFromParcel(parcel: Parcel): AppClaimsTemplatePosEntity {
            return AppClaimsTemplatePosEntity(parcel)
        }

        override fun newArray(size: Int): Array<AppClaimsTemplatePosEntity?> {
            return arrayOfNulls(size)
        }
    }
}