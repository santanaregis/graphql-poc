package example.server.query

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.generator.annotations.GraphQLIgnore
import com.expediagroup.graphql.server.operations.Query
import org.springframework.stereotype.Component

@Component
class SimpleQuery : Query {

    @GraphQLDescription("Sempre true")
    fun isGoodCode(): Boolean = true

    @GraphQLIgnore
    fun notPartOfSchema() = "ignore me!"

    @GraphQLDescription("Verifica se número é par")
    fun verifyNumber(
        @GraphQLDescription("Número a ser verificado")
        value: Int
    ): Boolean = value % 2 == 0

}

