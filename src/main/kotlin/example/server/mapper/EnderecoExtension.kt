package example.server.mapper

import example.server.client.dto.EnderecoDTO
import example.server.model.Endereco

fun EnderecoDTO.toEndereco() =
    Endereco(
        cep = this.cep,
        logradouro = this.logradouro,
        complemento = this.complemento,
        bairro = this.bairro,
        localidade = this.localidade,
        uf = this.uf,
        ibge = this.ibge,
        ddd = this.ddd
    )
