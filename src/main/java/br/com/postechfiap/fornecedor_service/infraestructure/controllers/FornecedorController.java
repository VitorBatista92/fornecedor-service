package br.com.postechfiap.fornecedor_service.infraestructure.controllers;

import br.com.postechfiap.fornecedor_service.application.interfaces.usecases.fornecedor.*;
import br.com.postechfiap.fornecedor_service.domain.entities.Fornecedor;
import br.com.postechfiap.fornecedor_service.infraestructure.dto.fornecedor.request.AtualizarFornecedorRequest;
import br.com.postechfiap.fornecedor_service.infraestructure.dto.fornecedor.request.FornecedorRequest;
import br.com.postechfiap.fornecedor_service.infraestructure.dto.fornecedor.response.FornecedorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.yaml.snakeyaml.util.Tuple;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/fornecedores")
@RequiredArgsConstructor
@Validated
@Tag(name = "Fornecedor", description = "API para gerenciamento de Fornecedores")
public class FornecedorController {

    private final CadastrarFornecedorUseCase cadastrarFornecedorUseCase;
    private final BuscarFornecedorUseCase buscarFornecedorUseCase;
    private final BuscarFornecedorPorIdUseCase buscarFornecedorPorIdUseCase;
    private final AtualizarFornecedorUseCase atualizarFornecedorUseCase;
    private final DeletarFornecedorUseCase deletarFornecedorUseCase;

    @PostMapping
    @Operation(summary = "Cadastrar Fornecedor", description = "Cadastrar novo fornecedor.")
    public ResponseEntity<FornecedorResponse> cadastrar(@RequestBody @Valid FornecedorRequest request) {
        FornecedorResponse novoFornecedor = cadastrarFornecedorUseCase.execute(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novoFornecedor.id())
                .toUri();

        return ResponseEntity.created(location).body(novoFornecedor);
    }

    @GetMapping
    @Operation(summary = "Buscar Fornecedor", description = "Buscar Fornecedor por nome.")
    public ResponseEntity<List<FornecedorResponse>> buscar(@RequestParam(required = false) String nome) {
        return ResponseEntity.ok(buscarFornecedorUseCase.execute(nome));
    }

    @Operation(summary = "Buscar Fornecedor pelo ID", description = "Retorna um Fornecedor filtrado por ID")
    @GetMapping("/buscar/{id}")
    public ResponseEntity<FornecedorResponse> buscarFornecedorPorId(@PathVariable Long id) {
        return ResponseEntity.ok(buscarFornecedorPorIdUseCase.execute(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar Fornecedor", description = "Atualizar um Fornecedor")
    public ResponseEntity<FornecedorResponse> atualizarMedicamento(@PathVariable Long id,
                                                                    @Valid @RequestBody AtualizarFornecedorRequest request) {

        var fornecedor = atualizarFornecedorUseCase.execute(new Tuple<>(request, id));

        return ResponseEntity.ok(fornecedor);
    }

    @Operation(summary = "Deletar Fornecedor", description = "Deletar um Fornecedor deixando ele inativo")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        deletarFornecedorUseCase.execute(id);
        return ResponseEntity.ok("FORNECEDOR - " + id + " - REMOVIDO");
    }
}
