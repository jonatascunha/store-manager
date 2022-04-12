package br.com.youtube.customer.ws.v1;

import br.com.youtube.customer.model.request.ProductRequestDTO;
import br.com.youtube.customer.model.response.ProductResponseDTO;
import br.com.youtube.customer.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @ApiOperation("API responsável por criar os clientes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cria um cliente"),
            @ApiResponse(code = 500, message = "Foi gerado um erro ao criar o cliente")
    })
    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductRequestDTO productRequestDTO) {
        LOGGER.info("Requisição recebida");
        return ResponseEntity.ok(productService.create(productRequestDTO));
    }

    @ApiOperation("API responsável por listar os clientes")
    @GetMapping
    public ResponseEntity<Page<ProductResponseDTO>> getAll(Pageable pageable) {
        LOGGER.info("Buscando os registros");
        Page<ProductResponseDTO> productResponses = productService.getAll(pageable);
        return ResponseEntity.ok(productResponses);
    }

    @ApiOperation("API responsável por atualizar os produtos")
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> update(@PathVariable("id") Long id, @RequestBody ProductRequestDTO productRequestDTO) {
        LOGGER.info("Iniciando a atualização");
        Optional<ProductResponseDTO> update = productService.update(id, productRequestDTO);
        if (!update.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(update.get());
    }

    @ApiOperation("API responsável por buscar um único cliente")
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> get(@PathVariable("id") Long id) {
        LOGGER.info("Iniciando a busca pelo registro");
        Optional<ProductResponseDTO> productResponseDTO = productService.get(id);
        if (!productResponseDTO.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productResponseDTO.get());
    }

    @ApiOperation("API responsável por remover um único cliente por vez")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        LOGGER.info("Iniciando a remoção do registro");
        if (productService.delete(id)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}