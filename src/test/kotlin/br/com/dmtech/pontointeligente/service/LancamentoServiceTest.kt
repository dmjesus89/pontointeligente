package br.com.dmtech.pontointeligente.util

import br.com.dmtech.pontointeligente.model.*
import br.com.dmtech.pontointeligente.repository.EmpresaRepository
import br.com.dmtech.pontointeligente.repository.FuncionarioRepository
import br.com.dmtech.pontointeligente.repository.LancamentoRepository
import org.springframework.boot.test.context.SpringBootTest

import br.com.dmtech.pontointeligente.service.EmpresaService
import br.com.dmtech.pontointeligente.service.FuncionarioService
import br.com.dmtech.pontointeligente.service.LancamentoService
import org.junit.jupiter.api.Assertions


import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

import java.lang.Exception
import java.math.BigDecimal


@SpringBootTest
class LancamentoServiceTest {

    @Autowired
    private val lancamentoService: LancamentoService? = null

    @MockBean
    private val lancamentoRepository: LancamentoRepository? = null

    private val ID_FUNCIONARIO = "123456789"

    private val ID_LANCAMENTO = "123456789"

    @BeforeEach
    @Throws(Exception::class)
    fun setUp() {
        BDDMockito.given<Page<Lancamento>>(lancamentoRepository?.findByFuncionarioId(ID_FUNCIONARIO,PageRequest.of(0, 10))).willReturn(PageImpl(ArrayList<Lancamento>()));
        BDDMockito.given(lancamentoRepository?.save(lancamento())).willReturn(lancamento());
        BDDMockito.given(lancamentoRepository?.findById(ID_LANCAMENTO)?.get()).willReturn(lancamento());
    }


    @Test
    fun testBuscarPorFuncionarioId() {
        val lancamentos: Page<Lancamento>? = lancamentoService?.buscarPorFuncionarioId(ID_FUNCIONARIO, PageRequest.of(0, 10));
        Assertions.assertNotNull(lancamentos);

    }

    @Test
    fun testSalvar() {
        val lancamento: Lancamento? = lancamentoService?.salvar(lancamento());
        Assertions.assertNotNull(lancamento);

    }

    @Test
    fun testRemover() {
        var lancamento: Lancamento? = lancamentoService?.buscarPorId(ID_LANCAMENTO);
        Assertions.assertNotNull(lancamento);
        lancamentoService?.remover(ID_LANCAMENTO);
         lancamento = lancamentoService?.buscarPorId(ID_LANCAMENTO);
        Assertions.assertNull(lancamento);

    }

   private fun lancamento(): Lancamento = Lancamento("20/01/2019",TipoEnum.INICIO,"1234567890","desc","lat2123")
}
