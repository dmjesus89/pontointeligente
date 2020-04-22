package br.com.dmtech.pontointeligente.service

import br.com.dmtech.pontointeligente.model.Empresa
import br.com.dmtech.pontointeligente.model.Funcionario
import br.com.dmtech.pontointeligente.repository.EmpresaRepository
import br.com.dmtech.pontointeligente.repository.FuncionarioRepository
import org.springframework.stereotype.Service

@Service
class FuncionarioServiceImpl(private val funcionarioRepository: FuncionarioRepository) : FuncionarioService {


    override fun buscarPorEmail(email: String) : Funcionario =  funcionarioRepository.findByEmail(email);

    override fun buscarPorCpf(cpf: String) : Funcionario? =  funcionarioRepository.findByCpf(cpf);

    override fun buscarPorId(id: String) : Funcionario =  funcionarioRepository.findById(id).get();

    override fun salvar(funcionario: Funcionario): Funcionario =  funcionarioRepository.save(funcionario);
}