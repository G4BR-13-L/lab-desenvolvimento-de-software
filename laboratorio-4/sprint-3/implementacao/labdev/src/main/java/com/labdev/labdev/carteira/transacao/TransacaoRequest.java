package com.labdev.labdev.carteira.transacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoRequest {
    int valor;
    Long remetente_id;
    Long destinatario_id;
    String justificativa;
}
