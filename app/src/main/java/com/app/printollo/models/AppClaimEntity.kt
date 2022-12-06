package com.app.printollo.models

import android.os.Parcel
import android.os.Parcelable

data class AppClaimEntity (
    val id: Int?,
    val name: String?,
    val name_EN: String?,
    val value: String?,
    val isDeleted:  Boolean?,
    val dateDeleted: String?,
    val userId: String?,
    val dateAdded: String?,
    val dateModified: String?,
    val deletedbyUserId: String?,
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
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
        parcel.writeString(name)
        parcel.writeString(name_EN)
        parcel.writeString(value)
        parcel.writeValue(isDeleted)
        parcel.writeString(dateDeleted)
        parcel.writeString(userId)
        parcel.writeString(dateAdded)
        parcel.writeString(dateModified)
        parcel.writeString(deletedbyUserId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AppClaimEntity> {
        override fun createFromParcel(parcel: Parcel): AppClaimEntity {
            return AppClaimEntity(parcel)
        }

        override fun newArray(size: Int): Array<AppClaimEntity?> {
            return arrayOfNulls(size)
        }
    }
}