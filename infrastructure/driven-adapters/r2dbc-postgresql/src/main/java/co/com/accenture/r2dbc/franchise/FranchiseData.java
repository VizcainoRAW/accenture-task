package co.com.accenture.r2dbc.franchise;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Builder(toBuilder = true)
@Table("franchises")
public class FranchiseData {

    @Id
    private String id;
    private String name;
}