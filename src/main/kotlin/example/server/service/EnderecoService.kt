package example.server.service

import example.server.client.ViacepClient
import example.server.client.dto.EnderecoDTO
import example.server.mapper.toEndereco
import example.server.model.Endereco
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class EnderecoService (
    private val viacepClient: ViacepClient
) {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    fun findEnderecoByCEP(cep: String): Mono<EnderecoDTO> {
        logger.info("EnderecoService - consultando endereco para cep $cep")
        return viacepClient.findByZipCode(cep)
    }

}
