package co.com.accenture.r2dbc.product;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Builder(toBuilder = true)
@Table("products")
public class ProductData {

    @Id
    private String id;
    private String name;
    private Integer stock;
    private String branchId;
}