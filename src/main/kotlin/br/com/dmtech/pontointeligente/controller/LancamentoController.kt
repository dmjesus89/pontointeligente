package br.com.dmtech.pontointeligente.controller

import br.com.dmtech.pontointeligente.model.Lancamento
import br.com.dmtech.pontointeligente.model.LancamentoDTO
import br.com.dmtech.pontointeligente.response.Response
import br.com.dmtech.pontointeligente.service.LancamentoService
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder.*
import java.net.URI
import javax.validation.Valid


@RestController
@RequestMapping("/api/lancamentos")
class LancamentoController(private val lancamentoService: LancamentoService, private @Value("\${quantidade_por_pagima}") val qtdPagina: Int) {

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    fun salvar(@Valid @RequestBody lancamentoDTO: LancamentoDTO) : ResponseEntity<Response<LancamentoDTO>>{
        val lancamento: Lancamento = converterDtoParaLancamento(lancamentoDTO);
        lancamentoService.salvar(lancamento);
        var location: URI = fromCurrentRequest().path("/{id}")
                .buildAndExpand(lancamento.id).toUri()
        return ResponseEntity.created(location).build()
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    fun salvar(@PathVariable("id") id: String,  @Valid @RequestBody lancamentoDTO: LancamentoDTO) : ResponseEntity<Response<LancamentoDTO>>{

        val lancamentoRetornado: Lancamento = lancamentoService.buscarPorId(id);
        lancamentoRetornado?.id = id;
        lancamentoService.salvar(lancamentoRetornado);
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable("id") id: String) : ResponseEntity<LancamentoDTO>{
        val lancamento: Lancamento? = lancamentoService?.buscarPorId(id);
        val lancamentoDTO: LancamentoDTO =  converterLancamentoParaDto(lancamento);
        return ResponseEntity.ok().body(lancamentoDTO);
    }

    @GetMapping("/funcionario/{idFuncionario}")
    fun salvar(@PathVariable("idFuncionario") idFuncionario: String,
               @RequestParam(value = "pag", defaultValue = "0") pag: Int,
               @RequestParam(value = "ord", defaultValue = "id") ord: String,
               @RequestParam(value = "dir", defaultValue = "DESC") dir: String): ResponseEntity<Page<Lancamento>> {
        val lancamentos: Page<Lancamento>? = lancamentoService?.buscarPorFuncionarioId(idFuncionario, PageRequest.of(pag, qtdPagina, Sort.Direction.valueOf(dir), ord))
        val lancamentosDTO: Page<LancamentoDTO>? = lancamentos?.map { lancamento -> converterLancamentoParaDto(lancamento) }
        return ResponseEntity.ok().body(lancamentos);
    }

    @DeleteMapping
    fun remover(@PathVariable id: String) : ResponseEntity<Page<Lancamento>>{
        lancamentoService?.remover(id);
        return ResponseEntity.noContent().build();
    }

    fun converterDtoParaLancamento(lancamentoDTO: LancamentoDTO?) : Lancamento = Lancamento(lancamentoDTO?.data!!,lancamentoDTO.tipo, lancamentoDTO.funcionarioId)

    fun converterLancamentoParaDto(lancamento: Lancamento?) : LancamentoDTO = LancamentoDTO(lancamento?.data!!,lancamento.tipo, lancamento.funcionarioId)


}