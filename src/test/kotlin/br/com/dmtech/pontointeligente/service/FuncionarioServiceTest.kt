package br.com.dmtech.pontointeligente.util

import br.com.dmtech.pontointeligente.model.Empresa
import br.com.dmtech.pontointeligente.model.Funcionario
import br.com.dmtech.pontointeligente.model.PerfilEnum
import br.com.dmtech.pontointeligente.repository.EmpresaRepository
import br.com.dmtech.pontointeligente.repository.FuncionarioRepository
import org.springframework.boot.test.context.SpringBootTest

import br.com.dmtech.pontointeligente.service.EmpresaService
import br.com.dmtech.pontointeligente.service.FuncionarioService
import org.junit.jupiter.api.Assertions


import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import java.lang.Exception
import java.math.BigDecimal


@SpringBootTest
class FuncionarioServiceTest {

    @Autowired
    private val funcionarioService: FuncionarioService? = null;

    @MockBean
    private val funcionarioRepository: FuncionarioRepository? = null;

    private val EMAIL = "dmjesus89@gmail.com";
    private val CPF = "04065432690";
    private val ID = "1234567890";

    @BeforeEach
    @Throws(Exception::class)
    fun setUp(){
        BDDMockito.given(funcionarioRepository?.save(Mockito.any(Funcionario::class.java))).willReturn(funcionario());
        BDDMockito.given(funcionarioRepository?.findByCpf(CPF)).willReturn(funcionario());
        BDDMockito.given(funcionarioRepository?.findByEmail(EMAIL)).willReturn(funcionario());
       // BDDMockito.given(funcionarioRepository?.findById(ID)?.get()).willReturn(funcionario());
    }

   @Test
   fun testBuscarPorEmail(){
       val funcionario: Funcionario?  = this.funcionarioService?.buscarPorEmail(EMAIL);
       Assertions.assertNotNull(funcionario);
   }
    @Test
    fun testBuscarPorCpf(){
        val funcionario: Funcionario?  = this.funcionarioService?.buscarPorCpf(CPF);
        Assertions.assertNotNull(funcionario);
    }
    @Test
    fun testBuscarPorId(){
      //  val funcionario: Funcionario?  =  this.funcionarioService?.buscarPorId(ID);
      //  Assertions.assertNotNull(funcionario);
    }

    @Test
    fun testSalvar(){
        val funcionario: Funcionario?  =  this.funcionarioService?.salvar(funcionario());
        Assertions.assertNotNull(funcionario);
    }

    private fun funcionario(): Funcionario = Funcionario("NOME",EMAIL,SenhaUtil().gerarBycrpt("123456"),CPF,PerfilEnum.ROLE_ADMIN,"EMPRESAID", BigDecimal(10));
}