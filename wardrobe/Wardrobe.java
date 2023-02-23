package wardrobe;

import hanger.Hanger;
import pieceOfClothing.PieceOfCLothing;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Wardrobe {

    private final int limitOfHangers;

    public Wardrobe(int limitOfHangers) {
        this.limitOfHangers = limitOfHangers;
    }

    private ArrayList<Hanger> hangers = new ArrayList<>();

    public void addHangers(Hanger hanger){
        if (hangers.size() < limitOfHangers)
            hangers.add(hanger);
        else throw new IllegalStateException("wardrobe.Wardrobe is full.");
    }

    public AtomicBoolean addPieceOfClothes(PieceOfCLothing pieceOfCLothing){
        AtomicBoolean result = new AtomicBoolean(false);
        if (checkIfFreeSpace(pieceOfCLothing).get()){
            hangers.stream().forEach(hanger ->{
                for (var piece: hanger.getClothes().entrySet()) {
                    if (pieceOfCLothing.getPieceOfClothingType().equals(piece.getKey()) && piece.getValue() == null){
                        piece.setValue(pieceOfCLothing);
                        result.set(true);
                    }
                }
            });
        }
        return result;
    }

    public void removePieceOfClothes(int id){
        hangers.stream().forEach(hanger ->{
            for (var piece: hanger.getClothes().entrySet()) {
                if (piece.getValue() != null){
                    if (piece.getValue().getId() == id){
                        piece.setValue(null);
                    }}
            }});
        }


    public AtomicBoolean checkIfFreeSpace(PieceOfCLothing pieceOfCLothing){
        AtomicBoolean result = new AtomicBoolean(false);
       hangers.stream().forEach(hanger -> {
            for (var piece: hanger.getClothes().entrySet()){
                if (piece.getKey().equals(pieceOfCLothing.getPieceOfClothingType()) && piece.getValue() == null){
                    System.out.println("there is free space for " + pieceOfCLothing.getBrandName());
                    result.set(true);
                }
            }
    });
        System.out.println("there is not enough free space for " + pieceOfCLothing.getBrandName());
        return result;
    }
    public void showAllClothes(){
        hangers.stream().forEach(hanger ->{
            for (var piece: hanger.getClothes().entrySet()) {
                if (piece.getValue() != null) {
                    System.out.println(piece.getValue().getBrandName());
                }
            }
        });
    }
}

