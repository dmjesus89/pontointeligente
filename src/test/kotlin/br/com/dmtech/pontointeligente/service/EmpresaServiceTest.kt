package br.com.dmtech.pontointeligente.util

import br.com.dmtech.pontointeligente.model.Empresa
import br.com.dmtech.pontointeligente.repository.EmpresaRepository
import org.springframework.boot.test.context.SpringBootTest

import br.com.dmtech.pontointeligente.service.EmpresaService
import org.junit.jupiter.api.Assertions


import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import java.lang.Exception


@SpringBootTest
class EmpresaServiceTest {

    @Autowired
    private val empresaService: EmpresaService? = null;

    @MockBean
    private val empresaRepository: EmpresaRepository? = null;

    private val CNPJ = "1234567890";

    @BeforeEach
    @Throws(Exception::class)
    fun setUp(){
        BDDMockito.given(empresaRepository?.findByCnpj(CNPJ)).willReturn(empresa())
        BDDMockito.given(empresaRepository?.save(empresa())).willReturn(empresa())
    }


    @Test
    fun testBuscarPorCnpj(){
        val empresa: Empresa? = empresaService?.buscarPorCnpj(CNPJ);
        Assertions.assertNotNull(empresa);
    }


    @Test
    fun testSalvar(){
        val empresa: Empresa? = empresaService?.salvar(empresa());
        Assertions.assertNotNull(empresa);
    }

    private fun empresa(): Empresa = Empresa("DM TECH", CNPJ, "1234567890");
}