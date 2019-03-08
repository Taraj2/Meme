package tk.tarajki.meme.models

import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.Future
import javax.validation.constraints.NotBlank

@Entity
data class Ban(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @field:Future
        @DateTimeFormat
        @Column(nullable = false)
        val expireAt: LocalDateTime,

        @field:NotBlank
        @Column(nullable = false)
        val reason: String,

        @ManyToOne(fetch = FetchType.LAZY)
        val target: User,

        @ManyToOne(fetch = FetchType.LAZY)
        val invoker: User,

        @DateTimeFormat
        @Column(nullable = false)
        val createdAt: LocalDateTime = LocalDateTime.now()
)