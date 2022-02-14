package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();
        Function<Person, PersonDTO> personPersonDTOFunction = person ->
            new PersonDTO(person.getId(), person.getFirstName(), person.getAge());

        //Call method reference, for more info go to map static method
        Function<Person, PersonDTO> mapper = PersonDTO::map;
        List<PersonDTO> personDTOS = people.stream().map(mapper).collect(Collectors.toList());
        personDTOS.forEach(System.out::println);
    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();

        double v = cars.stream()
                .mapToDouble(car -> car.getPrice())
                .average().orElse(0);
        System.out.println(v);
    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
    }
}

