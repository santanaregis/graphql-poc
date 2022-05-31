package example.server.client

import example.server.client.dto.DistritoDTO
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux

@Component
class IBGEClient(
    @Value("\${client.ibge.url}") val url: String,
    @Autowired val webClient: WebClient
) {

    fun findByIBGE(ibge: String): Flux<DistritoDTO> {
        return this.webClient
            .get()
            .uri("$url/localidades/municipios/{ibge}/distritos", ibge)
            .retrieve()
            .bodyToFlux(DistritoDTO::class.java)
    }

}
