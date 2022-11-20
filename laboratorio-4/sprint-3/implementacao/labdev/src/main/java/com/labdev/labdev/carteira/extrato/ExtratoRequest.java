package com.labdev.labdev.carteira.extrato;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtratoRequest {
    Long carteira_id;
    Long usuario_id;
}
