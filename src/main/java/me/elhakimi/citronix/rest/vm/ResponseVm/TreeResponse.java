    package me.elhakimi.citronix.rest.vm.ResponseVm;

    import lombok.Getter;
    import lombok.Setter;

    import java.time.LocalDate;

    @Getter
    @Setter
    public class TreeResponse {

        private Long id;
        private String fieldName;
        private LocalDate plantingDate;
        private int age;
        private double productivity ;

    }
