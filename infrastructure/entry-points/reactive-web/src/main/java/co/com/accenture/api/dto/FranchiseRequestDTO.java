package co.com.accenture.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FranchiseRequestDTO(
        String name
) {

    @Override
    public String toString() {
        return name;
    }
}
