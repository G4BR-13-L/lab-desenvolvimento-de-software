package com.labdev.labdev.usuario;

import lombok.Data;

@Data
public class UserCreateRequest {
    private String email;
    private String senha;
}
