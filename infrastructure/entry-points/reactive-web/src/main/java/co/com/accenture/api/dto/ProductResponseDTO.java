package co.com.accenture.api.dto;

public record ProductResponseDTO(
        String id,
        String name,
        Integer Stock,
        String branchId
) {
}
