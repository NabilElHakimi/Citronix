package me.elhakimi.citronix.serviceTest;

import me.elhakimi.citronix.Repository.FieldRepository;
import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.domain.Field;
import me.elhakimi.citronix.rest.exception.exceptions.DontHaveAreaException;
import me.elhakimi.citronix.service.impl.FieldServiceImpl;
import me.elhakimi.citronix.service.impl.FarmServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class FieldServiceImplTest {

    @Mock
    private FieldRepository fieldRepository;

    @Mock
    private FarmServiceImpl farmService;

    @InjectMocks
    private FieldServiceImpl fieldService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save_ShouldSaveField_WhenFarmExistsAndAreaIsValid() {
        Farm farm = new Farm();
        farm.setId(1L);
        farm.setArea(100.0);
        farm.setFields(Collections.emptyList());

        Field field = new Field();
        field.setFarm(farm);
        field.setArea(20.0);

        when(farmService.findById(farm.getId())).thenReturn(farm);
        when(fieldRepository.searchAllByFarm(farm)).thenReturn(Collections.emptyList());
        when(fieldRepository.save(field)).thenReturn(field);

        Field result = fieldService.save(field);

        assertNotNull(result, "The saved field should not be null.");
        verify(fieldRepository, times(1)).save(field);
    }

    @Test
    void save_ShouldThrowException_WhenFieldAreaExceedsFarmCapacity() {
        Farm farm = new Farm();
        farm.setId(1L);
        farm.setArea(100.0);

        Field existingField = new Field();
        existingField.setArea(80.0);

        Field newField = new Field();
        newField.setFarm(farm);
        newField.setArea(30.0);

        when(farmService.findById(farm.getId())).thenReturn(farm);
        when(fieldRepository.searchAllByFarm(farm)).thenReturn(Collections.singletonList(existingField));

        assertThrows(DontHaveAreaException.class, () -> fieldService.save(newField),
                "Expected DontHaveAreaException when total field area exceeds farm capacity.");

        verify(fieldRepository, never()).save(newField);
    }


}
