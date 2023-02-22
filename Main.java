
import hanger.Hanger;
import pieceOfClothing.PieceOfCLothing;
import pieceOfClothing.PieceOfClothingType;
import wardrobe.Wardrobe;

public class Main {

    public static void main(String[] args) {

        Wardrobe wardrobe = new Wardrobe(13);
        Hanger hanger = new Hanger(true);
        Hanger hanger2 = new Hanger(false);
        wardrobe.addHangers(hanger);
        wardrobe.addHangers(hanger2);
        PieceOfCLothing blouse = new PieceOfCLothing(1, "Blouse 1", PieceOfClothingType.BLOUSE);
        PieceOfCLothing trousers =new PieceOfCLothing(3, "Trousers 1", PieceOfClothingType.TROUSERS);
        PieceOfCLothing blouse2 = new PieceOfCLothing(2, "Blouse 2", PieceOfClothingType.BLOUSE);
        PieceOfCLothing blouse3 = new PieceOfCLothing(3, "Blouse 3", PieceOfClothingType.BLOUSE);
        wardrobe.addPieceOfClothes(blouse);
        wardrobe.addPieceOfClothes(blouse2);
        wardrobe.addPieceOfClothes(blouse3);
        wardrobe.checkIfFreeSpace(trousers);
        wardrobe.showAllClothes();
        wardrobe.removePieceOfClothes(1);
        wardrobe.addPieceOfClothes(blouse3);
        System.out.println("after remove of Blouse 1: ");
        wardrobe.showAllClothes();
        hanger2.takeAllClothesOff();
        System.out.println("after remove clothes of hanger 2: ");
        wardrobe.showAllClothes();


    }

}