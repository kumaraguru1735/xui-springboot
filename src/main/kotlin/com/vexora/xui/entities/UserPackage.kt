package com.vexora.xui.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Lob
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name = "users_packages")
open class UserPackage(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    open val id: Long = 0,

    @Column(name = "package_name")
    open var packageName: String? = null,

    @Column(name = "is_addon")
    open var isAddon: Boolean = false,

    @Column(name = "is_trial")
    open var isTrial: Boolean = false,

    @Column(name = "is_official")
    open var isOfficial: Boolean = false,

    @Column(name = "trial_credits")
    open var trialCredits: Float = 0f,

    @Column(name = "official_credits")
    open var officialCredits: Float = 0f,

    @Column(name = "trial_duration")
    open var trialDuration: Int = 0,

    @Column(name = "trial_duration_in")
    open var trialDurationIn: String? = null,

    @Column(name = "official_duration")
    open var officialDuration: Int = 0,

    @Column(name = "official_duration_in")
    open var officialDurationIn: String? = null,

    @Lob
    @Column(name = "groups")
    open var groups: String? = null,

    @Lob
    @Column(name = "bouquets")
    open var bouquets: String? = null,

    @Lob
    @Column(name = "addon_packages")
    open var addonPackages: String? = null,

    @Column(name = "is_line")
    open var isLine: Boolean = false,

    @Column(name = "is_mag")
    open var isMag: Boolean = false,

    @Column(name = "is_e2")
    open var isE2: Boolean = false,

    @Column(name = "is_restreamer")
    open var isRestreamer: Boolean = false,

    @Column(name = "is_isplock")
    open var isIsplock: Boolean = false,

    @Lob
    @Column(name = "output_formats")
    open var outputFormats: String? = null,

    @Column(name = "max_connections")
    open var maxConnections: Int = 1,

    @Column(name = "force_server_id")
    open var forceServerId: Int = 0,

    @Column(name = "forced_country")
    open var forcedCountry: String? = null,

    @Column(name = "lock_device")
    open var lockDevice: Boolean = true,

    @Column(name = "check_compatible")
    open var checkCompatible: Boolean = true

) : Serializable
