package br.edu.ifsp.prw3.p3.controller;

import br.edu.ifsp.prw3.p3.dtos.ListagemConsertoDTO;
import br.edu.ifsp.prw3.p3.models.Conserto;
import br.edu.ifsp.prw3.p3.repositories.ConsertoRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import br.edu.ifsp.prw3.p3.dtos.ConsertoRecordDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {
    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid ConsertoRecordDTO dados){
        System.out.println(dados);
        repository.save(new Conserto(dados));
    }

    @GetMapping
    public Page<Conserto> listarConsertos(@PageableDefault(
            size = 2,
            page = 0,
            sort = {},
            direction = Sort.Direction.DESC) Pageable paginacao) {
        return repository.findAll(paginacao);
    }

    @GetMapping("/algunsdados")
    public List<ListagemConsertoDTO> listarAlgunsDados(){
        return repository.findAll().stream().map(ListagemConsertoDTO::new).toList();
    }
}