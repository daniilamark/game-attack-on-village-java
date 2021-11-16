package com.daniilamark;
import java.util.Arrays;

 /*
    Условная компьютерная игра.
        Есть поселения, в которых есть ресурсы (железо, глина, зерно - не важно какие).
        Прибегает армия пограбить данное поселение.
        У армии есть грузоподъемность (не может миллион ресурсов унести).
        Армия должна награбить ресурсов пропорционально.
        Например, деревне ресусов [100, 300, 200]
        грузоподъемность армии 120 - армия тогда унесет [20, 60, 40].

        Задача - написать метод, который определяет сколько каких ресурсов унесет армия
        На вход массив произвольной длины с текущими ресурсами в поселении и грузоподъемность армии.
        На выходе массив той же длины с информацией, что украли.
        Важно учитывать (в порядке понижения приоритетностфи):
        1. Ресурсы могут исчисляться только целыми числами
        2. Армия должна уйти максимально возможно загруженной
        3. Пропорция ресурсов должна быть максимально точной.
     */

public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Village village = new Village(100, 200, 300, 400);
        Army army = new Army(village,120);

        System.out.print("------------------------------------");
        System.out.print("\nРесурсы деревни: ");
        printMass(village.getCurrentResourcesInVillage());
        System.out.print("\n------------------------------------");
        System.out.println(ANSI_RED + "\nДеревня атакована "+ ANSI_RESET);
        System.out.print("Потеряны ресурсы: ");
        printMass(army.takeAwayResourcesFromVillage(village.getCurrentResourcesInVillage(), army.getLiftingCapacity()));
        System.out.print("\n------------------------------------");
        System.out.print("\nРесурсы деревни: ");
        printMass(village.getCurrentResourcesInVillage());
        System.out.print("------------------------------------");
    }

    public static void printMass(int array[]){
        String intArrayString = Arrays.toString(array);
        System.out.print("\n"+intArrayString);
    }
}
