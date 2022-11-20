package com.labdev.labdev.vantagem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VantagemRequest {
    private Long usuario_id;
    private Long vantagem_id;
    private Long empresa_id; 
}
