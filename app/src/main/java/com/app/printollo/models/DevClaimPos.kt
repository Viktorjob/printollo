package com.app.printollo.models

data class DevClaimPos (
    val id: Int?,
    val devUserClaimsTemplateId: Int?,
    //val devUserClaimsTemplate
    //val devClaim
    val devClaimId: Int?,
    val isDeleted: Boolean?,
    val dateDeleted: String?,
    val deletedByUserId: String?,
    val userId: String?,
    val dateAdded: String?,
    val dateModified: String?,
)