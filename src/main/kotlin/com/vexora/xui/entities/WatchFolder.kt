package com.vexora.xui.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Lob
import jakarta.persistence.Table

@Entity
@Table(name = "watch_folders")
data class WatchFolder(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var type: String? = null,
    var directory: String? = null,
    @Column(name = "rclone_dir")
    var rcloneDir: String? = null,
    @Column(name = "server_id")
    var serverId: Int = 0,
    @Column(name = "category_id")
    var categoryId: Int = 0,
    var bouquets: String? = "[]",
    @Column(name = "last_run")
    var lastRun: Long = 0,
    var active: Boolean = true,
    @Column(name = "disable_tmdb")
    var disableTmdb: Boolean = false,
    @Column(name = "ignore_no_match")
    var ignoreNoMatch: Boolean = false,
    @Column(name = "auto_subtitles")
    var autoSubtitles: Boolean = false,
    @Column(name = "fb_bouquets")
    var fbBouquets: String? = "[]",
    @Column(name = "fb_category_id")
    var fbCategoryId: Int = 0,
    @Column(name = "allowed_extensions")
    var allowedExtensions: String? = "[]",
    var language: String? = null,
    @Column(name = "read_native")
    var readNative: Boolean = false,
    @Column(name = "movie_symlink")
    var movieSymlink: Boolean = false,
    @Column(name = "auto_encode")
    var autoEncode: Boolean = true,
    @Column(name = "ffprobe_input")
    var ffprobeInput: Boolean = true,
    @Column(name = "transcode_profile_id")
    var transcodeProfileId: Int = 0,
    @Column(name = "auto_upgrade")
    var autoUpgrade: Boolean = false,
    @Column(name = "fallback_title")
    var fallbackTitle: Boolean = false,
    @Column(name = "plex_ip")
    var plexIp: String? = null,
    @Column(name = "plex_port")
    var plexPort: Int = 0,
    @Column(name = "plex_username")
    var plexUsername: String? = null,
    @Column(name = "plex_password")
    var plexPassword: String? = null,

    @Lob
    @Column(name = "plex_libraries")
    var plexLibraries: String? = null,

    @Column(name = "scan_missing")
    var scanMissing: Boolean = false,
    @Column(name = "extract_metadata")
    var extractMetadata: Boolean = false,
    @Column(name = "store_categories")
    var storeCategories: Boolean = false,
    @Column(name = "duplicate_tmdb")
    var duplicateTmdb: Boolean = false,
    @Column(name = "check_tmdb")
    var checkTmdb: Boolean = true,
    @Column(name = "remove_subtitles")
    var removeSubtitles: Boolean = false,
    @Column(name = "target_container")
    var targetContainer: String? = null,
    @Column(name = "server_add")
    var serverAdd: String? = null,
    @Column(name = "direct_proxy")
    var directProxy: Boolean = false,
    @Column(name = "plex_token")
    var plexToken: String? = null
)
