
package util;

import model.CHaracter;
import model.Element;
import model.Obstacule;
import model.Position;
import model.bonus.*;
import model.enemy.*;
import model.puzzle.Puzzle;

import java.util.List;
import java.util.Random;


public class Generate {

    public static ListArray<Element> generateelement(List<CHaracter> players){

        Random rand = new Random();
        ListArray<Element> elements = new ListArray<>();
        for(CHaracter p : players){

            int row = rand.nextInt(15);
            int column =  rand.nextInt(20);
            Position pos = new Position(row,column);
            System.out.println(pos.getRow()+" "+pos.getColumn());
            System.out.println(elements.length());
            while(busyCell(pos,elements) == true){
                row = rand.nextInt(15);
                column =  rand.nextInt(20);
                pos = new Position(row,column);
            }

            p.setPosition(pos);
            p.setParametersInitialDefault();

            elements.add(p);
        }

        int enemys_create= 13;
        int puzzle_create = 1;
        int bonus_create = 13;
        int obstacule_create = 13;

        while(enemys_create > 0){
            int type_enemy = rand.nextInt(5);
            Enemy enemy = factoryEnemy(type_enemy);

            if(enemy != null){
                int row = rand.nextInt(15);
                int column =  rand.nextInt(20);
                Position pos = new Position(row,column);
                while(busyCell(pos,elements)){
                    row = rand.nextInt(15);
                    column =  rand.nextInt(20);
                    pos = new Position(row,column);
                }

                enemy.setPosition(pos);
                elements.add(enemy);
                enemys_create --;
            }
        }

//        while( puzzle_create > 0){
//            int type_puzzle = rand.nextInt(3);
//            Puzzle puzzle = factoryPuzzle(type_puzzle);
//
//            if(puzzle != null){
//                int row = rand.nextInt(15);
//                int column =  rand.nextInt(20);
//                Position pos = new Position(row,column);
//                while(busyCell(pos,elements)){
//                    row =  (int) Math.abs(Math.random())%15;
//                    column =  (int) Math.abs(Math.random())%20;
//                    pos = new Position(row,column);
//                }
//
//                puzzle.setPosition(pos);
//                elements.add(puzzle);
//                puzzle_create --;
//            }
//        }


//        while(bonus_create > 0){
//            int type_bonus = rand.nextInt(4);
//            Bonus bonus = factoryBonus(type_bonus);
//
//            if(bonus != null){
//                int row = rand.nextInt(15);
//                int column =  rand.nextInt(20);
//                Position pos = new Position(row,column);
//                while(busyCell(pos,elements)){
//                    row =  (int) Math.abs(Math.random())%15;
//                    column =  (int) Math.abs(Math.random())%20;
//                    pos = new Position(row,column);
//                }
//
//                bonus.setPosition(pos);
//                elements.add(bonus);
//                bonus_create --;
//            }
//        }

//        while(obstacule_create > 0){;
//            Obstacule obstacule = new Obstacule();
//
//            if(obstacule != null){
//                int row = rand.nextInt(15);
//                int column =  rand.nextInt(20);
//               Position pos = new Position(row,column);
//                while(busyCell(pos,elements)){
//                    row =  (int) Math.abs(Math.random())%15;
//                    column =  (int) Math.abs(Math.random())%20;
//                    pos = new Position(row,column);
//                }
//
//                obstacule.setPosition(pos);
//                elements.add(obstacule);
//                obstacule_create --;
//            }
//        }

        return elements;

    }

    private static Bonus factoryBonus(int typeBonus) {
        Bonus bonus = null;
        switch (typeBonus){
            case 0:
                bonus = new Fertilizer();
                break;
            case 1:
                bonus = new InfestedSoil();
                break;
            case 2:
                bonus = new PurifiedWater();
                break;
            case 3:
                bonus = new DeadlyDrougth();
                break;

        }
        if(bonus != null)
            bonus.setParametersInitialDefault();

        return bonus;
    }

    private static Puzzle factoryPuzzle(int typePuzzle) {
        Puzzle puzle = null;
        return puzle;
    }

    private static Enemy factoryEnemy(int typeEnemy) {

        Enemy enemy = null ;
        switch (typeEnemy){
            case 0:
                enemy = new GiantSlug();
                break;
            case 1:
                enemy = new MoleDigger();
                break;
            case 2:
                enemy = new KillerBee();
                break;
            case 3:
                enemy = new ToxicMushroom();
                break;
            case 4:
                enemy = new MutantLettuce();
                break;
        }
        if(enemy != null)
            enemy.setParametersInitialDefault();
        return enemy;

    }

    private static boolean busyCell(Position pos, ListArray<Element> elements) {
        for(Element e : elements){
            if(pos.equals(e.getPosition()))
                return true;
        }
        return false;
    }




}
