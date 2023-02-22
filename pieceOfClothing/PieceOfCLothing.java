package pieceOfClothing;

public class PieceOfCLothing {

    private final int id;

    private final String brandName;

    private final PieceOfClothingType pieceOfClothingType;

    public PieceOfCLothing(int id, String brandName, PieceOfClothingType pieceOfClothingType) {
        this.id = id;
        this.brandName = brandName;
        this.pieceOfClothingType = pieceOfClothingType;
    }

    public PieceOfClothingType getPieceOfClothingType() {
        return pieceOfClothingType;
    }

    public int getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }
}
