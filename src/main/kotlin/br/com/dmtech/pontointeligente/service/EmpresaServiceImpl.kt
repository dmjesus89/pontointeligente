package br.com.dmtech.pontointeligente.service

import br.com.dmtech.pontointeligente.model.Empresa
import br.com.dmtech.pontointeligente.repository.EmpresaRepository
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl(private val empresaRepository: EmpresaRepository) : EmpresaService {


    override fun buscarPorCnpj(cnpj: String) : Empresa? =  empresaRepository.findByCnpj(cnpj);

    override fun salvar(empresa: Empresa): Empresa =  empresaRepository.save(empresa);
}