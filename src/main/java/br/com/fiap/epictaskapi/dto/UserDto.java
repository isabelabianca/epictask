package br.com.fiap.epictaskapi.dto;

public record UserDto (
        Long id,
        String nome,
        String email,
        String password
) {
    public UserDto(String nome, String email, String password) {
        this(0l, nome, email, password);
    }

}
