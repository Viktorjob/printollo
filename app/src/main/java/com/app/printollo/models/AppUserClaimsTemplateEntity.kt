package com.app.printollo.models

import android.os.Parcel
import android.os.Parcelable

data class AppUserClaimsTemplateEntity (
    val id: Int?,
    val name: String?,
    val isDeleted: Boolean?,
    val dateDeleted: String?,
    val userId: String?,
    val dateAdded: String?,
    val dateModified: String?,
    val role: String?,
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
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
        parcel.writeValue(isDeleted)
        parcel.writeString(dateDeleted)
        parcel.writeString(userId)
        parcel.writeString(dateAdded)
        parcel.writeString(dateModified)
        parcel.writeString(role)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AppUserClaimsTemplateEntity> {
        override fun createFromParcel(parcel: Parcel): AppUserClaimsTemplateEntity {
            return AppUserClaimsTemplateEntity(parcel)
        }

        override fun newArray(size: Int): Array<AppUserClaimsTemplateEntity?> {
            return arrayOfNulls(size)
        }
    }
}