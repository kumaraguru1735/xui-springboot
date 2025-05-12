package com.vexora.xui.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Lob
import jakarta.persistence.Table

@Entity
@Table(name = "users_packages")
data class UserPackage(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "package_name")
    var packageName: String? = null,

    var isAddon: Boolean = false,
    var isTrial: Boolean = false,
    var isOfficial: Boolean = false,

    var trialCredits: Float = 0f,
    var officialCredits: Float = 0f,

    var trialDuration: Int = 0,

    var trialDurationIn: String? = null,

    var officialDuration: Int = 0,

    var officialDurationIn: String? = null,

    @Lob
    var groups: String? = null,

    @Lob
    var bouquets: String? = null,

    @Lob
    @Column(name = "addon_packages")
    var addonPackages: String? = null,

    var isLine: Boolean = false,
    var isMag: Boolean = false,
    var isE2: Boolean = false,
    var isRestreamer: Boolean = false,
    var isIsplock: Boolean = false,

    @Lob
    @Column(name = "output_formats")
    var outputFormats: String? = null,

    var maxConnections: Int = 1,

    var forceServerId: Int = 0,

    var forcedCountry: String? = null,

    var lockDevice: Boolean = true,
    var checkCompatible: Boolean = true
)
