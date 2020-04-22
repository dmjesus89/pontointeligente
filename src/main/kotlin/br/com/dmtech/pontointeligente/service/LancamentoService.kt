package br.com.dmtech.pontointeligente.service

import br.com.dmtech.pontointeligente.model.Lancamento
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface LancamentoService {

     fun buscarPorFuncionarioId(email: String, pageable: Pageable) :  Page<Lancamento>?;

     fun buscarPorId(id: String) :  Lancamento;

     fun remover(id: String);

     fun salvar(lancamento: Lancamento): Lancamento?;
}