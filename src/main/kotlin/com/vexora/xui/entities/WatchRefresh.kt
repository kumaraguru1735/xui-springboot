import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serializable
import java.sql.Timestamp

@Entity
@Table(name = "watch_refresh")
open class WatchRefresh(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    open val id: Long = 0,

    @Column(name = "type")
    open var type: Int = 0,

    @Column(name = "stream_id")
    open var streamId: Int = 0,

    @Column(name = "status")
    open var status: Int = 0,

    @Column(name = "dateadded")
    open var dateAdded: Timestamp? = null

) : Serializable