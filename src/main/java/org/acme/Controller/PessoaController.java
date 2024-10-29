package org.acme.Controller;

import java.util.List;

import org.acme.Model.Departamento.DepartamentoDTO;
import org.acme.Model.Pessoa.Pessoa;
import org.acme.Model.Pessoa.PessoaRepository;
import org.acme.Model.Pessoa.PessoaRequestDTO;
import org.acme.Model.Pessoa.PessoaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.ws.rs.Consumes;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRep;

    @GetMapping
    public List<PessoaResponseDTO> tempMedTarefa() {
        return pessoaRep.listPessoaHoraTarefa();
    }

    @GetMapping("/gastos")
    public List<PessoaResponseDTO> listPessoa(@RequestBody String nome, @RequestBody Long inicio, @RequestBody Long fim) {
        return pessoaRep.getMediaTarefa(nome, inicio, fim);
    }

    @PostMapping
    @Consumes("Application.Json")
    public void addPessoa(@RequestBody PessoaRequestDTO data) {
        Pessoa pessoaData = new Pessoa(data);
        pessoaRep.save(pessoaData);
    }

    @PutMapping("/{id}")
    @Consumes("Application.Json")
    public void updatePessoa(@PathVariable("id") Long id, @RequestBody PessoaRequestDTO data) {
        Pessoa pessoaData = new Pessoa(data);
        pessoaRep.deleteById(data.id());
        pessoaRep.save(pessoaData);
    }

    @DeleteMapping("/{id}")
    public void removePessoa(@PathVariable("id") Long id) {
        pessoaRep.deleteById(id);
    }

    @GetMapping("/departamentos")
    public List<DepartamentoDTO> listarDepartamentosComQuantidade() {
        return pessoaRep.listarDepartamentos();
    }
}
