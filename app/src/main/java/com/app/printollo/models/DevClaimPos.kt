package com.app.printollo.models

import android.os.Parcel
import android.os.Parcelable

data class DevClaimPos(
    val id: Int?,
    val devUserClaimsTemplateId: Int?,
    val devUserClaimsTemplate: DevUserClaimsTemplateEntity?,
    val devClaim: DevClaimEntity?,
    val devClaimId: Int?,
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
        TODO("devUserClaimsTemplate"),
        parcel.readParcelable(DevClaimEntity::class.java.classLoader),
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
        parcel.writeValue(devUserClaimsTemplateId)
        parcel.writeParcelable(devClaim, flags)
        parcel.writeValue(devClaimId)
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

    companion object CREATOR : Parcelable.Creator<DevClaimPos> {
        override fun createFromParcel(parcel: Parcel): DevClaimPos {
            return DevClaimPos(parcel)
        }

        override fun newArray(size: Int): Array<DevClaimPos?> {
            return arrayOfNulls(size)
        }
    }
}