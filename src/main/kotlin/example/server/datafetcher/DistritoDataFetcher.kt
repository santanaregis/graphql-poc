package example.server.datafetcher

import example.server.mapper.toDistrito
import example.server.model.Distrito
import example.server.model.Endereco
import example.server.service.DistritoService
import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.BeanFactoryAware
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture

@Component("[Distrito]DataFetcher")
class DistritoDataFetcher(val distritoService: DistritoService) : DataFetcher<CompletableFuture<List<Distrito>>>, BeanFactoryAware {
    private lateinit var beanFactory: BeanFactory

    override fun setBeanFactory(beanFactory: BeanFactory) {
        this.beanFactory = beanFactory
    }

    override fun get(environment: DataFetchingEnvironment): CompletableFuture<List<Distrito>> {
        val ibge = environment.getSource<Endereco>().ibge
        return distritoService.findDistritoByIBGE(ibge!!)
            .map { it.toDistrito() }
            .collectList()
            .toFuture()
    }

}
