package br.com.dmtech.pontointeligente.util


import org.junit.jupiter.api.Assertions
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class SenhaUtilTest{

    val SENHA = "123456"
    val bCrypt = BCryptPasswordEncoder();

    fun testCriptarSenha(){
        val hash = SenhaUtil().gerarBycrpt(SENHA)
        Assertions.assertTrue(bCrypt.matches(SENHA,hash))
    }
}