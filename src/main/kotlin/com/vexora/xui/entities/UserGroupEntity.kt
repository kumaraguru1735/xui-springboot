package com.vexora.xui.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name = "users_groups")
data class UserGroupEntity(
    @Id
    @Column(name = "group_id")
    val id: Int,

    @Column(name = "group_name", unique = true)
    val groupName: String,

    @Column(name = "is_admin")
    val isAdmin: Boolean,

    @Column(name = "is_reseller")
    val isReseller: Boolean,

    @Column(name = "total_allowed_gen_trials")
    val totalAllowedGenTrials: Int,

    @Column(name = "total_allowed_gen_in")
    val totalAllowedGenIn: String,

    @Column(name = "delete_users")
    val deleteUsers: Boolean,

    @Column(name = "allowed_pages", columnDefinition = "TEXT")
    val allowedPages: String,

    @Column(name = "can_delete")
    val canDelete: Boolean,

    @Column(name = "create_sub_resellers")
    val createSubResellers: Boolean,

    @Column(name = "create_sub_resellers_price")
    val createSubResellersPrice: Int,

    @Column(name = "reseller_client_connection_logs")
    val resellerClientConnectionLogs: Boolean,

    @Column(name = "can_view_vod")
    val canViewVod: Boolean,

    @Column(name = "allow_download")
    val allowDownload: Boolean,

    @Column(name = "minimum_trial_credits")
    val minimumTrialCredits: Int,

    @Column(name = "allow_restrictions")
    val allowRestrictions: Boolean,

    @Column(name = "allow_change_username")
    val allowChangeUsername: Boolean,

    @Column(name = "allow_change_password")
    val allowChangePassword: Boolean,

    @Column(name = "minimum_username_length")
    val minimumUsernameLength: Int,

    @Column(name = "minimum_password_length")
    val minimumPasswordLength: Int,

    @Column(name = "allow_change_bouquets")
    val allowChangeBouquets: Boolean = true,
)  : Serializable
