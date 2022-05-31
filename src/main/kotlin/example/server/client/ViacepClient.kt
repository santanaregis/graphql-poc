package example.server.client

import example.server.client.dto.EnderecoDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class ViacepClient(
    @Value("\${client.viacep.url}") val url: String,
    @Autowired val webClient: WebClient
) {

    fun findByZipCode(zipcode: String): Mono<EnderecoDTO> {
        return this.webClient
            .get()
            .uri("$url/{zipcode}/json", zipcode)
            .retrieve()
            .bodyToMono(EnderecoDTO::class.java)
    }

}
