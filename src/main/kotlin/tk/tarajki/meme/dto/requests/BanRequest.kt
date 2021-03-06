package tk.tarajki.meme.dto.requests

import javax.validation.constraints.NotBlank

data class BanRequest(

        @field:NotBlank
        val reason: String,

        val durationInHours: Long
)
