package com.vexora.xui.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serializable
@Entity
@Table(name = "users_groups")
open class UserGroupEntity(

    @Id
    @Column(name = "group_id")
    open val id: Int,

    @Column(name = "group_name", unique = true)
    open val groupName: String,

    @Column(name = "is_admin")
    open val isAdmin: Boolean,

    @Column(name = "is_reseller")
    open val isReseller: Boolean,

    @Column(name = "total_allowed_gen_trials")
    open val totalAllowedGenTrials: Int,

    @Column(name = "total_allowed_gen_in")
    open val totalAllowedGenIn: String,

    @Column(name = "delete_users")
    open val deleteUsers: Boolean,

    @Column(name = "allowed_pages", columnDefinition = "TEXT")
    open val allowedPages: String,

    @Column(name = "can_delete")
    open val canDelete: Boolean,

    @Column(name = "create_sub_resellers")
    open val createSubResellers: Boolean,

    @Column(name = "create_sub_resellers_price")
    open val createSubResellersPrice: Int,

    @Column(name = "reseller_client_connection_logs")
    open val resellerClientConnectionLogs: Boolean,

    @Column(name = "can_view_vod")
    open val canViewVod: Boolean,

    @Column(name = "allow_download")
    open val allowDownload: Boolean,

    @Column(name = "minimum_trial_credits")
    open val minimumTrialCredits: Int,

    @Column(name = "allow_restrictions")
    open val allowRestrictions: Boolean,

    @Column(name = "allow_change_username")
    open val allowChangeUsername: Boolean,

    @Column(name = "allow_change_password")
    open val allowChangePassword: Boolean,

    @Column(name = "minimum_username_length")
    open val minimumUsernameLength: Int,

    @Column(name = "minimum_password_length")
    open val minimumPasswordLength: Int,

    @Column(name = "allow_change_bouquets")
    open val allowChangeBouquets: Boolean = true

) : Serializable