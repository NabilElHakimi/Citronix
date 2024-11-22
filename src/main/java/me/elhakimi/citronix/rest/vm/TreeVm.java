    package me.elhakimi.citronix.rest.vm;

    import lombok.Getter;
    import lombok.Setter;

    import java.time.LocalDate;

    @Getter
    @Setter
    public class TreeVm {

        private Long id;
        private FieldVm field;
        private LocalDate plantingDate;
        private int age;
        private double productivity ;

    }
