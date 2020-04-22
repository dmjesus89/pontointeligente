package br.com.dmtech.pontointeligente.service

import br.com.dmtech.pontointeligente.model.Empresa
import br.com.dmtech.pontointeligente.model.Funcionario
import br.com.dmtech.pontointeligente.model.Lancamento
import br.com.dmtech.pontointeligente.repository.EmpresaRepository
import br.com.dmtech.pontointeligente.repository.FuncionarioRepository
import br.com.dmtech.pontointeligente.repository.LancamentoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service
class LancamentoServiceImpl(private val lancamentoRepository: LancamentoRepository) : LancamentoService {


    override fun buscarPorFuncionarioId(funcionarioId: String, pageable: Pageable) :  Page<Lancamento>? =  lancamentoRepository.findByFuncionarioId(funcionarioId,pageable);

    override fun buscarPorId(id: String) :  Lancamento =  lancamentoRepository.findById(id).get();

    override fun remover(id: String) =  lancamentoRepository.deleteById(id);

    override fun salvar(lancamento: Lancamento): Lancamento? =  lancamentoRepository.save(lancamento);
}