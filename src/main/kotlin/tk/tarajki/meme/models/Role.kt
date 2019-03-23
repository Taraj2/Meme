package tk.tarajki.meme.models


import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Role(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,


        @Enumerated(EnumType.STRING)
        @Column(nullable = false, length = 60)
        val name: RoleName,


        @JoinColumn(name = "id")
        @OneToMany(fetch = FetchType.LAZY)
        val users: List<User>? = null,


        @Column(nullable = false)
        val createdAt: LocalDateTime = LocalDateTime.now()
)