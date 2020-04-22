package br.com.dmtech.pontointeligente.util

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class SenhaUtil {

    fun gerarBycrpt(senha: String): String = BCryptPasswordEncoder().encode(senha)
}