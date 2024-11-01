package br.edu.ifsp.prw3.p3.controller;

import br.edu.ifsp.prw3.p3.dtos.AtualizacaoConsertoDTO;
import br.edu.ifsp.prw3.p3.dtos.DetalhamentoConsertoDTO;
import br.edu.ifsp.prw3.p3.dtos.ListagemConsertoDTO;
import br.edu.ifsp.prw3.p3.models.Conserto;
import br.edu.ifsp.prw3.p3.repositories.ConsertoRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.edu.ifsp.prw3.p3.dtos.ConsertoRecordDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {
    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhamentoConsertoDTO> cadastrar(@RequestBody @Valid ConsertoRecordDTO dados,
                                                             UriComponentsBuilder uriBuilder) {
        var conserto = new Conserto(dados);
        repository.save(conserto);
        var uri = uriBuilder.path("/consertos/{id}").buildAndExpand(conserto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhamentoConsertoDTO(conserto));
    }

    @GetMapping
    public ResponseEntity<Page<Conserto>> listarConsertos(
            @PageableDefault(size = 2, page = 0, sort = {}, direction = Sort.Direction.DESC) Pageable paginacao) {
        Page<Conserto> consertos = repository.findAll(paginacao);
        return ResponseEntity.ok(consertos);
    }

    @GetMapping("/algunsdados")
    public ResponseEntity<Page<ListagemConsertoDTO>> listarAlgunsDados(
            @PageableDefault(size = 2, page = 0, sort = {}, direction = Sort.Direction.DESC) Pageable paginacao) {
        Page<ListagemConsertoDTO> dados = repository.findAllByAtivoTrue(paginacao).map(ListagemConsertoDTO::new);
        return ResponseEntity.ok(dados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhamentoConsertoDTO> getConsertoById(@PathVariable Long id) {
        return repository.findById(id).map(conserto -> ResponseEntity.ok(new DetalhamentoConsertoDTO(conserto))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetalhamentoConsertoDTO> atualizar(@RequestBody @Valid AtualizacaoConsertoDTO dados) {
        if (!repository.existsById(dados.id())) {
            return ResponseEntity.notFound().build();
        }

        Conserto conserto = repository.getReferenceById(dados.id());
        conserto.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DetalhamentoConsertoDTO(conserto));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Conserto conserto = repository.getReferenceById(id);
        conserto.excluir();

        return ResponseEntity.noContent().build();
    }
}
