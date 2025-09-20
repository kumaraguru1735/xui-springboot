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
@Table(name = "watch_folders")
open class WatchFolder(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open val id: Long = 0,

    @Column(name = "type")
    open var type: String? = null,

    @Column(name = "directory")
    open var directory: String? = null,

    @Column(name = "rclone_dir")
    open var rcloneDir: String? = null,

    @Column(name = "server_id")
    open var serverId: Int = 0,

    @Column(name = "category_id")
    open var categoryId: Int = 0,

    @Column(name = "bouquets")
    open var bouquets: String? = "[]",

    @Column(name = "last_run")
    open var lastRun: Long = 0,

    @Column(name = "active")
    open var active: Boolean = true,

    @Column(name = "disable_tmdb")
    open var disableTmdb: Boolean = false,

    @Column(name = "ignore_no_match")
    open var ignoreNoMatch: Boolean = false,

    @Column(name = "auto_subtitles")
    open var autoSubtitles: Boolean = false,

    @Column(name = "fb_bouquets")
    open var fbBouquets: String? = "[]",

    @Column(name = "fb_category_id")
    open var fbCategoryId: Int = 0,

    @Column(name = "allowed_extensions")
    open var allowedExtensions: String? = "[]",

    @Column(name = "language")
    open var language: String? = null,

    @Column(name = "read_native")
    open var readNative: Boolean = false,

    @Column(name = "movie_symlink")
    open var movieSymlink: Boolean = false,

    @Column(name = "auto_encode")
    open var autoEncode: Boolean = true,

    @Column(name = "ffprobe_input")
    open var ffprobeInput: Boolean = true,

    @Column(name = "transcode_profile_id")
    open var transcodeProfileId: Int = 0,

    @Column(name = "auto_upgrade")
    open var autoUpgrade: Boolean = false,

    @Column(name = "fallback_title")
    open var fallbackTitle: Boolean = false,

    @Column(name = "plex_ip")
    open var plexIp: String? = null,

    @Column(name = "plex_port")
    open var plexPort: Int = 0,

    @Column(name = "plex_username")
    open var plexUsername: String? = null,

    @Column(name = "plex_password")
    open var plexPassword: String? = null,

    @Lob
    @Column(name = "plex_libraries")
    open var plexLibraries: String? = null,

    @Column(name = "scan_missing")
    open var scanMissing: Boolean = false,

    @Column(name = "extract_metadata")
    open var extractMetadata: Boolean = false,

    @Column(name = "store_categories")
    open var storeCategories: Boolean = false,

    @Column(name = "duplicate_tmdb")
    open var duplicateTmdb: Boolean = false,

    @Column(name = "check_tmdb")
    open var checkTmdb: Boolean = true,

    @Column(name = "remove_subtitles")
    open var removeSubtitles: Boolean = false,

    @Column(name = "target_container")
    open var targetContainer: String? = null,

    @Column(name = "server_add")
    open var serverAdd: String? = null,

    @Column(name = "direct_proxy")
    open var directProxy: Boolean = false,

    @Column(name = "plex_token")
    open var plexToken: String? = null

) : Serializable