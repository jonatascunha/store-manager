package br.com.aula.storemanager.ws.v1;

import br.com.aula.storemanager.model.request.ProductRequestDTO;
import br.com.aula.storemanager.model.response.ProductResponseDTO;
import br.com.aula.storemanager.service.mapper.ProductService;
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

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductRequestDTO productRequestDTO) {
        LOGGER.info("Requisição recebida");
        return ResponseEntity.ok(productService.create(productRequestDTO));
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponseDTO>> getAll(Pageable pageable) {
        LOGGER.info("Buscando os registros");
        Page<ProductResponseDTO> productResponses = productService.getAll(pageable);
        return ResponseEntity.ok(productResponses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> update(@PathVariable("id") Long id, @RequestBody ProductRequestDTO productRequestDTO) {
        LOGGER.info("Iniciando a atualização");
        Optional<ProductResponseDTO> update = productService.update(id, productRequestDTO);
        if (!update.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(update.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> get(@PathVariable("id") Long id) {
        LOGGER.info("Iniciando a busca pelo registro");
        Optional<ProductResponseDTO> productResponseDTO = productService.get(id);
        if (!productResponseDTO.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productResponseDTO.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        LOGGER.info("Iniciando a remoção do registro");
        if (productService.delete(id)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}