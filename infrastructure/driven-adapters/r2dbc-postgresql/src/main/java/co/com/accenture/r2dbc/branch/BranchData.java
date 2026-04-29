package co.com.accenture.r2dbc.branch;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Builder(toBuilder = true)
@Table("branches")
public class BranchData {

    @Id
    private String id;
    private String name;
    private String franchiseId;
}