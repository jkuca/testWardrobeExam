package hanger;

import pieceOfClothing.PieceOfCLothing;
import pieceOfClothing.PieceOfClothingType;

import java.util.HashMap;
import java.util.Map;

public class Hanger {
    private final boolean  isDouble;



    private Map<PieceOfClothingType, PieceOfCLothing> clothes = new HashMap();

    public Hanger(boolean isDouble) {
        this.isDouble = isDouble;
        whatCanHangOn();
    }

    public void whatCanHangOn(){
        clothes.put(PieceOfClothingType.SHIRT, null);
        clothes.put(PieceOfClothingType.BLOUSE, null);
        if (isDouble){
            clothes.put(PieceOfClothingType.TROUSERS, null);
        }
    }

    public void takeAllClothesOff() {
        for (var element : clothes.entrySet()) {
            element.setValue(null);
        }
    }

    public Map<PieceOfClothingType, PieceOfCLothing> getClothes() {
        return clothes;
    }

}
