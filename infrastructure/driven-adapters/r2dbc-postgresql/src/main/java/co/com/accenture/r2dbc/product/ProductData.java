package co.com.accenture.r2dbc.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table("products")
public class ProductData {

    @Id
    private UUID id;
    private String name;
    private Integer stock;
    private UUID branchId;
}