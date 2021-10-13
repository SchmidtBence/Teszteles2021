package org.core.exceptions;

import java.time.LocalDate;

public class GyartasiIdoNemMegfelelo extends Throwable {
    public GyartasiIdoNemMegfelelo(LocalDate gyartasido) {
        super(gyartasido.toString());
    }
}
