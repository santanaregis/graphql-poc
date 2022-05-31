package example.server.query

import example.server.mapper.toEndereco
import example.server.model.Endereco
import example.server.service.EnderecoService
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Query
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
/**
 * Example queries.
 */
@Component
class EnderecoQuery(
    private val enderecoService: EnderecoService
) : Query {

    @GraphQLDescription("busca endereço a partir do cep")
    fun findEnderecoByCEP(cep: String): Mono<Endereco>{
        return enderecoService.findEnderecoByCEP(cep)
            .map { it.toEndereco() }
    }

}

