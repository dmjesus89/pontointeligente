package br.com.dmtech.pontointeligente.service

import br.com.dmtech.pontointeligente.model.Empresa
import br.com.dmtech.pontointeligente.repository.EmpresaRepository
import org.springframework.stereotype.Service


interface EmpresaService {

    fun buscarPorCnpj(cnpj: String) : Empresa?;

    fun salvar(empresa: Empresa): Empresa ;
}