package me.elhakimi.citronix.rest.vm;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SaleVm {

    private Long id;

    @NotNull(message = "Sale date must not be null")
    private LocalDate saleDate;

    @Min(value = 0, message = "Unit price must be at least 0")
    private double unitPrice;

    @Min(value = 0, message = "Quantity must be at least 0")
    private double quantity;

    @NotBlank(message = "Client name must not be blank")
    private String client;

    private Long harvestId;

    private double revenue;
}
