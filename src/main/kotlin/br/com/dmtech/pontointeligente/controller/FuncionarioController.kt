package br.com.dmtech.pontointeligente.controller

import br.com.dmtech.pontointeligente.model.Funcionario
import br.com.dmtech.pontointeligente.model.FuncionarioDTO
import br.com.dmtech.pontointeligente.response.Response
import br.com.dmtech.pontointeligente.service.FuncionarioService
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import org.springframework.web.servlet.support.ServletUriComponentsBuilder.*
import java.lang.RuntimeException
import java.net.URI
import javax.validation.Valid


@RestController
@RequestMapping("/api/funcionarios")
class FuncionarioController(private val funcionarioService: FuncionarioService, private @Value("\${quantidade_por_pagima}") val qtdPagina: Int) {


    @PostMapping
    fun salvar(@Valid @RequestBody funcionarioDTO: FuncionarioDTO): ResponseEntity<Response<FuncionarioDTO>> {
        val funcionario: Funcionario = converterDtoParaFuncionario(funcionarioDTO);

        if(funcionarioService?.buscarPorCpf(funcionario.cpf) == null){
            ResponseEntity.badRequest().body("erro: Funcionario não encontrado com cpf: ${funcionario.cpf}");
        }

        funcionarioService.salvar(funcionario);
        var location: URI = fromCurrentRequest().path("/{id}")
                .buildAndExpand(funcionario.id).toUri()
        return ResponseEntity.created(location).build()
    }



    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: String): ResponseEntity<FuncionarioDTO> {
        val funcionario: Funcionario? = funcionarioService?.buscarPorId(id);
        if(funcionario == null){
            ResponseEntity.badRequest().body("erro: Funcionario não encontrado com id: $id");
        }
        val funcionarioDTO: FuncionarioDTO = converterFuncionarioParaDto(funcionario);
        return ResponseEntity.ok().body(funcionarioDTO);
    }


    fun converterDtoParaFuncionario(funcionarioDTO: FuncionarioDTO?): Funcionario = Funcionario(funcionarioDTO?.nome!!, funcionarioDTO.email, funcionarioDTO.senha,funcionarioDTO.cpf,funcionarioDTO.perfil,funcionarioDTO.empresaId!!)

    fun converterFuncionarioParaDto(funcionario: Funcionario?): FuncionarioDTO = FuncionarioDTO(funcionario?.nome!!, funcionario.email, funcionario.senha,funcionario.cpf,funcionario.perfil,funcionario.empresaId!!)


}