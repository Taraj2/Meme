package tk.tarajki.meme.models


import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
data class Post(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column(nullable = false)
        val title: String,

        @Column(nullable = false)
        val url: String,

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(name = "post_tags",
                joinColumns = [JoinColumn(name = "post_id")],
                inverseJoinColumns = [JoinColumn(name = "tag_id")])
        val tags: List<Tag>,

        @JoinColumn
        @ManyToOne(fetch = FetchType.LAZY)
        val author: User,

        @JoinColumn
        @ManyToOne(fetch = FetchType.LAZY)
        val confirmedBy: User? = null,

        @JoinColumn
        @ManyToOne(fetch = FetchType.LAZY)
        val deletedBy: User? = null,


        @JoinColumn(name = "post_id")
        @OneToMany(fetch = FetchType.LAZY)
        val comments: List<Comment>? = null,

        @Column(nullable = false)
        val createdAt: LocalDateTime = LocalDateTime.now()
)