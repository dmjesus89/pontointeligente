package br.com.dmtech.pontointeligente.service

import br.com.dmtech.pontointeligente.model.Empresa
import br.com.dmtech.pontointeligente.model.Funcionario
import br.com.dmtech.pontointeligente.repository.EmpresaRepository
import org.springframework.stereotype.Service


interface FuncionarioService {

     fun buscarPorEmail(email: String) : Funcionario;

     fun buscarPorCpf(cpf: String) : Funcionario? ;

    fun buscarPorId(id: String) : Funcionario?;

     fun salvar(funcionario: Funcionario): Funcionario?;
}