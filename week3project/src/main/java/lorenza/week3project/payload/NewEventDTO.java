package lorenza.week3project.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewEventDTO(
        @NotEmpty(message = "evento")
        String title,
        @NotEmpty(message = "data")
        String date,
        @NotEmpty(message = "Lcation")
        String location) {
}
