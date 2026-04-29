package co.com.accenture.api;

import co.com.accenture.api.dto.BranchRequestDTO;
import co.com.accenture.api.dto.BranchResponseDTO;
import co.com.accenture.model.branch.Branch;
import org.springframework.stereotype.Component;

@Component
public class BranchMapper {

    public Branch toModel(BranchRequestDTO dto) {
        return Branch.builder()
                .name(dto.name())
                .FranchiseId(dto.franchiseId())
                .build();
    }

    public BranchResponseDTO toDTO(Branch branch) {
        return new BranchResponseDTO(branch.getId(), branch.getName(), branch.getFranchiseId());
    }
}
