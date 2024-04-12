package CiroVitiello.U5W2D5.dto;

import jakarta.validation.constraints.NotEmpty;

public record NewDeviceDTO(@NotEmpty(message = "Typology is required!")
                           String typology) {
}
