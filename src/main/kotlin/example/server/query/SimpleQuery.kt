package example.server.query

import example.server.mapper.toEndereco
import example.server.model.Endereco
import example.server.service.EnderecoService
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.generator.annotations.GraphQLIgnore
import com.expediagroup.graphql.server.operations.Query
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
/**
 * Example queries.
 */
@Component
class SimpleQuery : Query {

    @GraphQLDescription("new query that always returns true")
    fun isGoodCode(): Boolean = true

    @GraphQLIgnore
    fun notPartOfSchema() = "ignore me!"

    @GraphQLDescription("performs even/odd check")
    fun doSomething(
        @GraphQLDescription("super important value")
        value: Int
    ): Boolean = value % 2 == 0

}

