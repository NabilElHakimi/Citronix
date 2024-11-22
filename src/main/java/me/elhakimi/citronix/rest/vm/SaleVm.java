    package me.elhakimi.citronix.rest.vm;

    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.NotNull;
    import lombok.Getter;
    import lombok.Setter;

    import java.time.LocalDate;

    @Getter
    @Setter
    public class SaleVm {


        private Long id;

        @NotNull
        @NotBlank
        private LocalDate saleDate;

        @NotNull
        @NotBlank
        private double unitPrice;

        @NotNull
        @NotBlank
        private double quantity;

        @NotNull
        @NotBlank
        private String client;

        private Long harvestId;
        private  double revenue ;

    }
