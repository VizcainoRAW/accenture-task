package co.com.accenture.api.dto;

public record ProductRequestDTO(
        String name,
        Integer stock,
        String branchId
) {}
