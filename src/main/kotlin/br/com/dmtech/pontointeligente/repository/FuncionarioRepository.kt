package br.com.dmtech.pontointeligente.repository

import br.com.dmtech.pontointeligente.model.Funcionario
import org.springframework.data.mongodb.repository.MongoRepository

interface FuncionarioRepository : MongoRepository<Funcionario, String> {

    fun findByEmail(email: String) : Funcionario;

    fun findByCpf(cpf: String) : Funcionario?;

}