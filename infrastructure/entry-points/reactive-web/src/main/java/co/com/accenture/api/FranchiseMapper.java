package co.com.accenture.api;

import co.com.accenture.api.dto.FranchiseRequestDTO;
import co.com.accenture.api.dto.FranchiseResponseDTO;
import co.com.accenture.model.franchise.Franchise;
import org.springframework.stereotype.Component;

@Component
public class FranchiseMapper {

    public Franchise toModel(FranchiseRequestDTO dto) {
        return Franchise
                .builder()
                .name(dto.name())
                .build();
    }

    public FranchiseResponseDTO toDTO(Franchise franchise) {
        return new FranchiseResponseDTO(franchise.getId(), franchise.getName());
    }
}
