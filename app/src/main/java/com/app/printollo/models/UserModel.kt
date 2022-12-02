package com.app.printollo.models

import android.os.Parcel
import android.os.Parcelable

data class UserModel(
    val id: String?,
    val userName: String?,
    val firstName: String?,
    val lastName: String?,
    val password: String?,
    val role: String?,
    val email: String?,
    val phoneNumber: String?,
    val lastLoginDate: String?,
    val timeZone: String?,
    val lang: String?,
    val isDeleted: Boolean?,
    val deletedDate: String?,
    val deletedbyUserId: String?,
    //val companies	List<CompanyModel>,
    //abstract var roles	List<E>
    //abstract var deviceRoles	List<E>
    //abstract var claims	List<UserClaimModel>
    val templateId: Int?,
    val accessToClientsView: Boolean?,
    val canAddClients: Boolean?,
    val canEditClients: Boolean?,
    val canDeleteClients: Boolean?,
    val accessToTokensView: Boolean?,
    val canGenerateTokens: Boolean?,
    val accessToAlarmsView: Boolean?,
    val accessToUsersView: Boolean?,
    val canAddUsers: Boolean?,
    val canEditUsers: Boolean?,
    val canDeleteUsers: Boolean?,
    val accessToInstallersView: Boolean?,
    val canAddInstallers: Boolean?,
    val canEditInstallers: Boolean?,
    val canDeleteInstallers: Boolean?,
    val canLockInstallers: Boolean?,
    val accessToDevicesView: Boolean?,
    val canAddDevices: Boolean?,
    val canEditDevices: Boolean?,
    val canDeleteDevices: Boolean?,
    val accessToCalendarView: Boolean?,
    val canAddEvents: Boolean?,
    val canDeleteEvents: Boolean?,
    val rodo: Boolean?,
    val accessNotifications: Boolean?,
    val canAddSIMCard: Boolean?,
    val canImportSIMCards: Boolean?,
    val accessSIMCards: Boolean?,
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(userName)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(password)
        parcel.writeString(role)
        parcel.writeString(email)
        parcel.writeString(phoneNumber)
        parcel.writeString(lastLoginDate)
        parcel.writeString(timeZone)
        parcel.writeString(lang)
        parcel.writeValue(isDeleted)
        parcel.writeString(deletedDate)
        parcel.writeString(deletedbyUserId)
        parcel.writeValue(templateId)
        parcel.writeValue(accessToClientsView)
        parcel.writeValue(canAddClients)
        parcel.writeValue(canEditClients)
        parcel.writeValue(canDeleteClients)
        parcel.writeValue(accessToTokensView)
        parcel.writeValue(canGenerateTokens)
        parcel.writeValue(accessToAlarmsView)
        parcel.writeValue(accessToUsersView)
        parcel.writeValue(canAddUsers)
        parcel.writeValue(canEditUsers)
        parcel.writeValue(canDeleteUsers)
        parcel.writeValue(accessToInstallersView)
        parcel.writeValue(canAddInstallers)
        parcel.writeValue(canEditInstallers)
        parcel.writeValue(canDeleteInstallers)
        parcel.writeValue(canLockInstallers)
        parcel.writeValue(accessToDevicesView)
        parcel.writeValue(canAddDevices)
        parcel.writeValue(canEditDevices)
        parcel.writeValue(canDeleteDevices)
        parcel.writeValue(accessToCalendarView)
        parcel.writeValue(canAddEvents)
        parcel.writeValue(canDeleteEvents)
        parcel.writeValue(rodo)
        parcel.writeValue(accessNotifications)
        parcel.writeValue(canAddSIMCard)
        parcel.writeValue(canImportSIMCards)
        parcel.writeValue(accessSIMCards)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserModel> {
        override fun createFromParcel(parcel: Parcel): UserModel {
            return UserModel(parcel)
        }

        override fun newArray(size: Int): Array<UserModel?> {
            return arrayOfNulls(size)
        }
    }
}