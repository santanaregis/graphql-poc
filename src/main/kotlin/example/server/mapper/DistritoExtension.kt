package example.server.mapper

import example.server.client.dto.DistritoDTO
import example.server.model.Distrito

fun DistritoDTO.toDistrito() =
    Distrito(
        id = this.id,
        nome = this.nome
    )
