package Targoński_3P_Praktyka;

import Targoński_3P_Praktyka.ShapeAndSubclasses.Rectangle;
import Targoński_3P_Praktyka.ShapeAndSubclasses.Square;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Square> squares = new ArrayList<>();

        Random randomizer = new Random();

        for (int i = 0; i < 10 + randomizer.nextInt(30); i++){
            squares.add(new Square( randomizer.nextDouble()*10));
        }


        //ZAD 1
        List<Square> biggerPerimeter = squares.stream()
                .filter(s -> s.getArea() < s.getPerimeter())
                .collect(Collectors.toList());


        //ZAD 2
        List<Square> bigToBigArea= squares.stream()
                .sorted(Comparator.comparingDouble(Rectangle::getArea))
                .collect(Collectors.toList());
        //ZAD 3
        List<Square> bigToSmallPerimeter = squares.stream()
                .sorted(Comparator.comparingDouble(Rectangle::getPerimeter)
                    .reversed())
                .collect(Collectors.toList());

        //ZAD 4
        double avragePerimeter = squares.stream()
                .mapToDouble(s -> s.getPerimeter())
                .summaryStatistics().getAverage();

        //ZAD 5
        double sumAll = squares.stream()
                .mapToDouble(s -> s.getArea())
                .summaryStatistics().getSum();

        //do mapy
        Map<Double, Square> mapa = squares.stream()
                .collect(Collectors.toMap(s -> s.getArea(), square -> square));


    }
}
