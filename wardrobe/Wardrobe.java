package wardrobe;

import hanger.Hanger;
import pieceOfClothing.PieceOfCLothing;

import java.util.ArrayList;

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

    public boolean addPieceOfClothes(PieceOfCLothing pieceOfCLothing){
        if (checkIfFreeSpace(pieceOfCLothing)){
            for (Hanger hanger: hangers) {
                for (var piece: hanger.getClothes().entrySet()) {
                    if (pieceOfCLothing.getPieceOfClothingType().equals(piece.getKey()) && piece.getValue() == null){
                        piece.setValue(pieceOfCLothing);
                        return true;
                    }
                }
            }}
        return false;
    }

    public void removePieceOfClothes(int id){
        for (Hanger hanger: hangers) {
            for (var piece: hanger.getClothes().entrySet()) {
                if (piece.getValue() != null){
                    if (piece.getValue().getId() == id){
                        piece.setValue(null);
                    }}
            }
        }
    }

    public boolean checkIfFreeSpace(PieceOfCLothing pieceOfCLothing){
        for (Hanger hanger: hangers){
            for (var piece: hanger.getClothes().entrySet()){
                if (piece.getKey().equals(pieceOfCLothing.getPieceOfClothingType()) && piece.getValue() == null){
                    System.out.println("there is free space for " + pieceOfCLothing.getBrandName());
                    return true;
                }
            }
        }
        System.out.println("there is not enough free space for " + pieceOfCLothing.getBrandName());
        return false;
    }
    public void showAllClothes(){
        for (Hanger hanger: hangers){
            for (var piece: hanger.getClothes().entrySet()) {
                if (piece.getValue() != null) {
                    System.out.println(piece.getValue().getBrandName());
                }
            }
        }
    }
}

