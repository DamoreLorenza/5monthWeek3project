package lorenza.week3project.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewUserDTO(
        @NotEmpty(message = "Il nome è obbligatorio")
        @Size(min = 4, max = 30, message = "Caratteri dai 4 ai 30 ")
        String name,
        @Email(message = "L'indirizzo inserito non è valido")
        @NotEmpty(message = "Email obbligatoria")
        String email,
        @NotEmpty(message = "Password obbligatoria")
        @Size(min = 6, message = "La password deve avere minimo 6 caratteri")
        String password) {
}
