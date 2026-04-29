package co.com.accenture.api;

import co.com.accenture.api.dto.ProductRequestDTO;
import co.com.accenture.api.dto.ProductResponseDTO;
import co.com.accenture.model.product.Product;
import org.springframework.stereotype.Component;


@Component
public class ProductMapper {

    public Product toModel(ProductRequestDTO productRequestDTO) {
        return Product.builder()
                .name(productRequestDTO.name())
                .branchId(productRequestDTO.branchId())
                .stock(productRequestDTO.stock())
                .build();
    }

    public ProductResponseDTO toDTO(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getStock(),
                product.getBranchId()
        );
    }
}
