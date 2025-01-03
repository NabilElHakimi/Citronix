package me.elhakimi.citronix.serviceTest;

import me.elhakimi.citronix.Repository.FieldRepository;
import me.elhakimi.citronix.domain.Farm;
import me.elhakimi.citronix.domain.Field;
import me.elhakimi.citronix.rest.exception.exceptions.DontHaveAreaException;
import me.elhakimi.citronix.rest.exception.exceptions.mustBeNullException;
import me.elhakimi.citronix.service.impl.FieldServiceImpl;
import me.elhakimi.citronix.service.impl.FarmServiceImpl;
import org.hibernate.validator.internal.engine.messageinterpolation.parser.MessageDescriptorFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
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
    void saveValidField_test() {
        Farm farm = new Farm();
        farm.setId(1L);
        farm.setArea(2000.0);
        farm.setFields(Collections.emptyList());

        Field field = new Field();
        field.setFarm(farm);
        field.setArea(1000.0);

        when(farmService.findById(farm.getId())).thenReturn(farm);
        when(fieldRepository.searchAllByFarm(farm)).thenReturn(Collections.emptyList());
        when(fieldRepository.save(field)).thenReturn(field);

        Field result = fieldService.save(field);

        assertNotNull(result, "The saved field should not be null.");
    }

    @Test
    void throwWhenFieldIdNotNull_test() {
        Field field = new Field();
        field.setId(1L);

        assertThrows(mustBeNullException.class, () -> fieldService.save(field));
        verify(fieldRepository, never()).save(any());
    }

    @Test
    void returnNullWhenFarmNotFound_test() {
        Field field = new Field();
        Farm farm = new Farm();
        farm.setId(1L);
        field.setFarm(farm);

        when(farmService.findById(farm.getId())).thenReturn(null);

        Field result = fieldService.save(field);

        assertNull(result);
    }

    @Test
    void throwWhenFieldAreaExceedsLimit_test() {
        Farm farm = new Farm();
        farm.setId(1L);
        farm.setArea(5000.0);

        Field field = new Field();
        field.setFarm(farm);
        field.setArea(3000.0);

        when(farmService.findById(farm.getId())).thenReturn(farm);

        assertThrows(DontHaveAreaException.class, () -> fieldService.save(field));
    }

    @Test
    void throwWhenTotalFieldAreaExceedsCapacity_test() {
        Farm farm = new Farm();
        farm.setId(1L);
        farm.setArea(5000.0);

        Field existingField = new Field();
        existingField.setArea(4000.0);

        Field newField = new Field();
        newField.setFarm(farm);
        newField.setArea(2000.0);

        when(farmService.findById(farm.getId())).thenReturn(farm);
        when(fieldRepository.searchAllByFarm(farm)).thenReturn(Collections.singletonList(existingField));

        assertThrows(DontHaveAreaException.class, () -> fieldService.save(newField));
    }

    @Test
    void throwWhenFieldAreaTooSmall_test() {
        Farm farm = new Farm();
        farm.setId(1L);
        farm.setArea(5000.0);

        Field field = new Field();
        field.setFarm(farm);
        field.setArea(500.0);

        when(farmService.findById(farm.getId())).thenReturn(farm);

        assertThrows(MessageDescriptorFormatException.class, () -> fieldService.save(field));
    }

    @Test
    void throwWhenMaxFieldsReached_test() {
        Farm farm = new Farm();
        farm.setId(1L);
        farm.setArea(5000.0);

        List<Field> existingFields = IntStream.range(0, 10)
                .mapToObj(i -> new Field())
                .collect(Collectors.toList());

        Field field = new Field();
        field.setFarm(farm);
        field.setArea(5000.0);

        when(farmService.findById(farm.getId())).thenReturn(farm);
        when(fieldRepository.searchAllByFarm(farm)).thenReturn(existingFields);

        assertThrows(DontHaveAreaException.class, () -> fieldService.save(field));
    }

    @Test
    void throwWhenFieldIdNotNullAgain_test() {
        Farm farm = new Farm();
        farm.setId(1L);
        farm.setArea(5000.0);

        Field existingField = new Field();
        existingField.setArea(4000.0);

        Field newField = new Field();
        newField.setFarm(farm);
        newField.setArea(2000.0);
        newField.setId(1L);

        assertThrows(mustBeNullException.class, () -> fieldService.save(newField));
    }


}
