package CiroVitiello.U5W2D5.dto;

import jakarta.validation.constraints.NotEmpty;

public record UploadDeviceDTO(@NotEmpty(message = " Status is required!")
                              String status) {
}
