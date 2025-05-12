package com.vexora.xui.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "watch_logs")
data class WatchLog(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var type: Int = 0,
    @Column(name = "server_id")
    var serverId: Int = 0,
    var filename: String? = null,
    var status: Int = 0,
    @Column(name = "stream_id")
    var streamId: Int = 0,

    @Column(name = "dateadded")
    var dateAdded: java.sql.Timestamp? = null
)
