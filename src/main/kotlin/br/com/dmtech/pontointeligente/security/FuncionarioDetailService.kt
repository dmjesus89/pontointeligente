package br.com.dmtech.pontointeligente.security

import br.com.dmtech.pontointeligente.model.Funcionario
import br.com.dmtech.pontointeligente.service.FuncionarioService
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class FuncionarioDetailService(val funcionarioService: FuncionarioService) : UserDetailsService{

    override fun loadUserByUsername(username: String): UserDetails {
        val funcionario: Funcionario  = funcionarioService.buscarPorEmail(username);
        return FuncionarioPrincipal(funcionario);
    }


}