package example.server.service

import example.server.client.IBGEClient
import example.server.client.dto.DistritoDTO
import example.server.mapper.toDistrito
import example.server.model.Distrito
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class DistritoService(
    private val ibgeClient: IBGEClient
) {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    fun findDistritoByIBGE(ibge: String): Flux<DistritoDTO> {
        logger.info("DistritoService - consultando distrito para ibge $ibge")
        return ibgeClient.findByIBGE(ibge)
    }

}
