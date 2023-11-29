package com.poo.trilateracion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MensajeRequest {
    private List<String> m1;
    private List<String> m2;
    private List<String> m3;
}
