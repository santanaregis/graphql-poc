package example.server.model

data class Endereco(
    val cep: String?,
    val logradouro: String?,
    val complemento: String?,
    val bairro: String?,
    val localidade: String?,
    val uf: String?,
    val ibge: String?,
    val ddd: String?
){
    lateinit var distritos: List<Distrito>
}
